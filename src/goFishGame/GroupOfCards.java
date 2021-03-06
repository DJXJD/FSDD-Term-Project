/*
    GroupOfCards.java
    Author: Nick De Luca, David Vejgman, Daniel Crawford
    Date: August 9th 2020
    Description
    This abstract class defines the properties and attributes of a group of 
    cards
*/
package goFishGame;

import java.util.ArrayList;

/**
 * This abstract class defines a group of cards
 * @author Nick De Luca
 * @author Daniel Crawford
 * @author David Vejgman
 */
public abstract class GroupOfCards{

    private ArrayList<Card> cardList = new ArrayList();
    private int cardListSize;
    
    /**
     * The empty abstract constructor for a group of cards
     */
    public GroupOfCards() {
    }
    
    /**
     * The abstract constructor that defines a cardListSize
     * @param cardListSize 
     */
    public GroupOfCards(int cardListSize) {
        setCardListSize(cardListSize);
    }
    /**
     * gets the card list of a group of cards object
     * @return the card list
     */
    public ArrayList<Card> getCardList() {
        return cardList;
    }
    /**
     * This method sets the card list of a group of cards object
     * @param cardList the given ArrayList to set
     */ 
     public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }
    /**
     * This method sorts a card list by rank. Lowest to highest.
     * @return the sorted card list
     */
    public ArrayList<Card> sortCardList(){
        Card lowest = cardList.get(0);
        for (int i = 0; i < cardList.size(); i++) {
            for (int j = 1; j < cardList.size(); j++) {
                if(cardList.get(j).getRankNum() < cardList.get(j-1)
                        .getRankNum()){
                    
                    lowest = cardList.get(j);
                    cardList.remove(j);
                    cardList.add(0,lowest);
                }
            }
        }
        return cardList;
    }
    /**
     * sets the card list size of a group of cards object
     * @param cardListSize the given size to set
     */
    public void setCardListSize(int cardListSize){
        if(cardListSize>0){
            this.cardListSize = cardListSize;
        }else{
            throw new IllegalArgumentException("Hand Size must be positive");
        }
    }
    /**
     * gets the card list size of a group of cards object.
     * @return the card list size 
     */
    public int getCardListSize() {
	return cardList.size();
    }
    
    /**
     * This method adds a card object to the card list of a group of cards
     * @param card the given card to add to the card list
     * @return true if add was successful (ArrayList.add())
     */
    public boolean AddCard(Card card){
            return cardList.add(card);
    }
    /**
     * This method removes a card object to the card list of a group of cards
     * @param card the given card to remove to the card list
     * @return true if remove was successful (ArrayList.add())
     */
    public boolean removeCard(Rank rank) {
        for (Card card : cardList) {
            if(card.getRank()==rank){
                cardList.remove(card);
                return true;
            }
        }
        return false;
    }
    public void removeCard(Card card) {
        
        cardList.remove(card);
    }
    
    /**
     * This method removes a card of a specified index from the GroupOfCards
     * @param index the index of the card to be removed
     */
    public void removeCard(int index) {
	cardList.remove(index);
    }
    
    /**
     * This method returns a card object at a specified index of the 
     * GroupOfCards
     * @param index the index of the card
     * @return the card from the specified index
     */
    public Card getCard(int index) {
	return cardList.get(index);
    }
    
    /**
     * This method searches the hand for a specific card and returns the index
     * of that card in the PlayerHand or -1 if it does not exist
     * @param card the card to search for
     * @return the index of the card, -1 if it is not in the PlayerHand
     */
    public int indexOf(Card card) {
        return cardList.indexOf(card);
    }
    
    /**
     * This method searches the PlayerHand for any card of a specified rank and
     * returns the index of the first iteration of that rank or -1 if no card
     * with that rank is in the PlayerHand
     * @param rank the rank to be searched for
     * @return the index of the first card of that rank or -1
     */
    public int indexOf(Rank rank) {
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getRankNum() == rank.getNum()) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * This abstract method that is overrided to show a group of cards 
     * @return a string that organizes a group of cards
     */
    public abstract String showCards();
   
    /**
     * This method searches for a specific card and returns true if it is in 
     * the group of cards of false otherwise
     * @param card the card to search for
     * @return true if card is in the group, false if not
     */
    public abstract boolean checkCards(Card card);
 
}
