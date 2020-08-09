/*
    Rank.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    This enumeration file holds the different values of all the card ranks in
    a standard deck of cards to be used in the Card class file
*/

package goFishGame;

/**
 *
 * @author Daniel Crawford
 * @author Nick De Luca
 * @author David Vejgman
 */
public enum Rank {
    
    // these are the values of the enumeration file
    ACE(1, "Ace", "A"),
    TWO(2, "Two", "2"),
    THREE(3, "Three", "3"),
    FOUR(4, "Four", "4"),
    FIVE(5, "Five", "5"),
    SIX(6, "Six", "6"),
    SEVEN(7, "Seven", "7"),
    EIGHT(8, "Eight", "8"),
    NINE(9, "Nine", "9"),
    TEN(10, "Ten", "10"),
    JACK(11, "Jack", "J"),
    QUEEN(12, "Queen", "Q"),
    KING(13, "King", "K");
    
    // the properties of each individual enumeration value
    private int num;
    private String name;
    private String shortName;
    
    /**
     * This is the private constructor for this enumeration file
     * @param num the numeric value for the card rank
     * @param name the full name of the rank
     * @param shortName the shortest possible name for the rank
     */
    private Rank(int num, String name, String shortName) {
        this.num = num;
        this.name = name;
        this.shortName = shortName;
    }

    /**
     * This method returns the numeric value of the rank
     * @return the numeric value of the rank
     */
    public int getNum() {
        return num;
    }

    /**
     * This method returns the full name of the rank
     * @return the full name of the rank
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the shortest possible name of the rank
     * @return the short name of the rank
     */
    public String getShortName() {
        return shortName;
    }
    
    
}