/*
    GroupOfCards.java
    Author: Nick De Luca, David Vejgman, Daniel Crawford
    Date: August 9th 2020
    Description
    This abstract class defines the properties and attributes of a group of cards
*/
package goFishGame;

import java.util.ArrayList;

/**
 * This abstract class defines a group of cards
 * @author Nick De Luca
 */
public abstract class GroupOfCards{

    private ArrayList<Card> cardList = new ArrayList();
    private int cardListSize;
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
                if(cardList.get(j).getRankNum() < cardList.get(j-1).getRankNum()){
                    
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
    public int getCardListSize(){
        return cardListSize;
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
    public boolean removeCard(Card card) {
        
        return cardList.remove(card);
    }
    /**
     * This abstract method that is overrided to show a group of cards 
     * @return a string that organizes a group of cards
     */
    public abstract String showCards();
   
    public abstract boolean checkCards(Card card);
 
}
