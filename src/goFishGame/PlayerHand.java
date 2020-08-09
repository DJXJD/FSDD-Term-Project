/*
    PlayerHand.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    This file creates objects that represent the hand of a player in a card
    game, it extends the GroupOfCards abstract class and uses card objects to
    create the hand. It allows for all the functionality of the GroupOfCards
    class as well as a few additional functions
*/

package goFishGame;

/**
 * 
 * @author Daniel Crawford
 * @author David Vejgman
 * @author Nick De Luca
 */
public class PlayerHand extends GroupOfCards {
    
    /**
     * A default constructor to make a PlayerHand with null values
     */
    public PlayerHand() {
    }

    /**
     * This constructor calls the super constructor to create a PlayerHand with
     * the given number of cards
     * @param handSize the number of cards in the hand
     */
    public PlayerHand(int handSize) {
        super(handSize);
    }

    /**
     * This method is used to hide a players hand from other players by
     * creating a large buffer of lines in the command line
     * @return 30 line breaks in a String
     */
    public String hideHand() {
        String hideHand = " ";
        for (int i = 0; i < 30; i++) {
            hideHand += "" + "\n";
        }
        return hideHand;
    }

    /**
     * This method shows all the cards in the PlayerHand sorted by rank
     * @return a String of all the cards sorted by rank
     */
    @Override
    public String showCards() {
        String showHand = "| ";
        int count = 0;
        int lineSize = 5;
        
        // sorts the cards before displaying them
        sortCardList();
        
        // adds all cards to a string to be displayed
        for (Card card : getCardList()) {
            showHand += card.toString() + " | ";
            count++;
            
            // if line exceeds a certain length, adds a line break
            if (count == lineSize) {
                lineSize += 5;
                showHand += "\n\n| ";
            }
        }
        
        return showHand;
    }

    /**
     * This method checks if a card is in the PlayerHand and returns true if it
     * is or false if it is not
     * @param card the card to look for
     * @return true if the card is in the hand, otherwise false
     */
    public boolean checkCards(Card card) {
        
        for (Card c : getCardList()) {

            if (c.getRankNum() == card.getRankNum()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method searches the hand for a specific card and returns the index
     * of that card in the PlayerHand or -1 if it does not exist
     * @param card the card to search for
     * @return the indec of the card, -1 if it is not in the PlayerHand
     */
    public int indexOf(Card card) {
        for (int i = 0; i < getCardList().size(); i++) {
            if (card == getCardList().get(i)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * This method searches the PlayerHand for any card of a specified rank and
     * returns the index of the first iteration of that rank or -1 if no card
     * with that rank is in the PlayerHand
     * @param rank the rank to be searched for
     * @return the index of the first card of that rank or -1
     */
    public int indexOf(Rank rank) {
        for (int i = 0; i < getCardList().size(); i++) {
            if (getCardList().get(i).getRankNum() == rank.getNum()) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * This method returns a string of all the cards in the PlayerHand in an
     * easy to read format
     * @return a formatted string of all the cards in the PlayerHand
     */
    @Override
    public String toString() {
        String s = "";
        
        for (Card card : getCardList()) {
            s += card.toString() + "\n";
        }
        
        return s;
    }
    
}
