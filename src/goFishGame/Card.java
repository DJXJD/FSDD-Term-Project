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
     * 
     * @param value
     * @param suit 
     */
    public Card(Rank value, Suit suit) {
        this.rank = value;
        this.suit = suit;
    }
    /**
     * 
     * @return 
     */
    public int getRankNum() {
        return rank.getNum();
    }
    /**
     * 
     * @return 
     */
    public String getRankName() {
        return rank.getName();
    }
    /**
     * 
     * @return 
     */
    public String getRankShortName() {
        return rank.getShortName();
    }
    /**
     * 
     * @return 
     */
    public int getSuitNum() {
        return suit.getNum();
    }
    /**
     * 
     * @return 
     */
    public String getSuitName() {
        return suit.getName();
    }
    /**
     * 
     * @return 
     */
    public char getSuitSymbol() {
        return suit.getSymbol();
    }
    /**
     * 
     * @return 
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
