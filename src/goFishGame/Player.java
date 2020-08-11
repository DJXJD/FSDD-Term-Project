/*
    Player.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    This class defines the properties and attributes of a player object 
*/

package goFishGame;

import java.util.ArrayList;

/**
 * This class defines the players properties and attributes
 *
 * @author Nick De Luca
 * @author Daniel Crawford
 * @author David Vejgman
 */
public class Player {

    private String name;
    private PlayerHand hand; //delegation
    private int score;
    /**
     * Two argument constructor that sets the player's name and hand
     * @param name the given name to set
     * @param hand the given hand to set
     */
    public Player(String name, PlayerHand hand) {
        this.name = name;
        this.hand = hand;
    }
    /**
     * Sets the player's hand with a given PlayerHand object.
     * @param hand the given hand to set
     */
    public void setHand(PlayerHand hand) {
        this.hand = hand;
    }
    /**
     * gets the player's hand ArrayList field
     * @return an ArrayList of the players hand
     */
    public ArrayList<Card> getHandCardList() {
        return hand.getCardList(); //delegation
    }

    /**
     * This method returns the PlayerHand object of this Player object
     * @return the PlayerHand of this Player
     */
    public PlayerHand getHand() {
	return hand;
    }
    
    /**
     * This method returns the hand size of the Player's hand
     * @return the size of the Player's hand
     */
    public int getHandSize() {
	return hand.getCardListSize();
    }
    
    /**
     * gets the name field of a player object 
     * @return the name of a player
     */
    public String getName(){
        return name;
    }
    /**
     * gets the score field of a player object
     * @return the score of a player
     */
    public int getScore() {
        return score;
    }
    /**
     * This method adds the 1 to a players score field. 
     */
    public void addToScore(){
        score += 1;
    }
    /**
     * This method check if there are any 4 of a kinds in the players hand at 
     * each call. It will not add the score until the card count of a specific 
     * rank is 4. 
     * @param card the card to search 4 of a kind for
     */
    public void checkScore(Card card){
        int cardCount = 0;
        for (Card c : this.getHandCardList()) {
            if(c.getRankNum()==card.getRankNum()){
                    cardCount++;
            }
        }
        if(cardCount == 4){
            addToScore();
            for (int i = 1; i <= 4; i++) {
                    //System.out.println("removed a card at: " + i);
                    hand.removeCard(card);
                }
            } 
    }
    /**
     * This method delegates adding a card from the GroupOfCards class, 
     * to the Player class
     * @param card  the card to add to the hand
     * @return false if adding the card failed
     */
    public boolean addToHand(Card card){ //delegation
        
        return hand.AddCard(card);
    }   
    /**
     * This method delegates removing a card from the GroupOfCards class, 
     * to the Player class
     * @param card  the card to remove from the hand
     * @return false if removing the card failed
     */
    public boolean removeCard(Card card){ //delegation
        return hand.removeCard(card);
    }
    
    /**
     * This method removes a card of a specified index from a Player's hand
     * @param index the index of the card to be removed
     */
    public void removeCard(int index) {
	hand.removeCard(index);
    }
    
    /**
     * This method delegates checking a hand if it contains a card
     * from the GroupOfCards class,to the Player class
     * @param card  the card to add to the hand
     * @return false if checking the hand failed
     */
    public boolean checkHand(Card card){ //delegation
        
        return hand.checkCards(card);
    }
    
    public Card getCard(int index) {
	return hand.getCard(index);
    }
    
    public int hasCard(Rank rank) {
	return hand.indexOf(rank);
    }
    
    public int hasCard(Card card) {
	return hand.indexOf(card);
    }
    
    /**
     * The tostring method of the Player object concatenates a string of all the 
     * Player's fields.
     * @return a concatenated string of the player's fields
     */
    @Override
    public String toString() {
        return "Player: " + "name=" + name + "'s score=" + score +"\n"+hand.toString();
    }
}
