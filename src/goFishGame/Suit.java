/*
    Suit.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    This enumeration file holds the different values of the four suits that
    are used in a standard sized deck for use in the Card class file
*/

package goFishGame;

/**
 *
 * @author Nick De Luca
 * @author David Vejgman
 * @author Daniel Crawford
 */
public enum Suit {
    
    // these are the values of the enumeration file
    CLUBS(1, "Clubs", '\u2663'),
    DIAMONDS(2, "Diamonds", '\u2666'),
    HEARTS(3, "Hearts", '\u2665'),
    SPADES(4, "Spades", '\u2660');
    
    // the properties of each individual enumeration value
    private int num;
    private String name;
    private char symbol;

    /**
     * This is the private constructor for this enumeration file
     * @param num the numeric value for the suit (sorted alphabetically)
     * @param name the name of the suit
     * @param symbol the symbol for the suit
     */
    private Suit(int num, String name, char symbol) {
        this.num = num;
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * This method returns the numeric value of the suit
     * @return the numeric value of the suit
     */
    public int getNum() {
        return num;
    }

    /**
     * This method returns the name of the suit
     * @return the name of the suit
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the symbol of the suit
     * @return the symbol of the suit
     */
    public char getSymbol() {
        return symbol;
    }
    
}
