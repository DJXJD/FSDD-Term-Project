/*
    Card.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    This file creates card objects that use enumeration values from two
    enumerations, one for the rank and one for the suit, and can be used to
    create any card that would normally exist in a standard deck of cards
*/

package goFishGame;

/**
 *
 * @author Daniel Crawford
 * @author Nick De Luca
 * @author David Vejgman
 */
public class Card {

    //these are the properties of the card class
    private Rank rank;
    private Suit suit;
    
    /**
     * The constructor for the card class creates a card with a rank and suit
     * @param value the value of the rank of the card
     * @param suit the suit of the card
     */
    public Card(Rank value, Suit suit) {
        this.rank = value;
        this.suit = suit;
    }

    public Rank getRank() {
	return rank;
    }
    
    /**
     * This method returns the numerical value of the rank of the card
     * @return the numerical value of the rank
     */
    public int getRankNum() {
        return rank.getNum();
    }
    /**
     * This method returns the name of the rank of the card
     * @return the name of the rank
     */
    public String getRankName() {
        return rank.getName();
    }
    /**
     * This method returns the short version of the name of the rank of the card
     * @return the short name of the rank
     */
    public String getRankShortName() {
        return rank.getShortName();
    }
    /**
     * This method returns the numerical value of the suit of the card
     * @return the numerical value of the suit
     */
    
    public Suit getSuit() {
        return suit;
    }

    public int getSuitNum() {
	return suit.getNum();
    }
    /**
     * This method returns the name of the suit of the card
     * @return the name of the suit
     */
    public String getSuitName() {
        return suit.getName();
    }
    /**
     * This method returns the symbol of the suit of the card
     * @return the symbol of the suit
     */
    public char getSuitSymbol() {
        return suit.getSymbol();
    }
    /**
     * This method returns a formatted string of all the values of the card
     * @return a formatted string of the values of the card
     */
    @Override
    public String toString() {
        
        return String.format(""
		+ "%-5s of %-8s [%s]",
		getRankName(),
		getSuitName(),
		getSuitSymbol());
    }

}
