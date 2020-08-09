/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goFishGame;

import java.util.ArrayList;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public abstract class GroupOfCards{

    private ArrayList<Card> cardList = new ArrayList();
    private int cardListSize;

    public GroupOfCards() {
    }
    
    public GroupOfCards(int cardListSize) {
        setCardListSize(cardListSize);
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }
     public void setCardList(ArrayList<Card> cardList) {
        this.cardList = cardList;
    }
     
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
    
    public void setCardListSize(int cardListSize){
        if(cardListSize>0){
            this.cardListSize = cardListSize;
        }else{
            throw new IllegalArgumentException("Hand Size must be positive");
        }
    }
    
    public int getCardListSize(){
        return cardListSize;
    }
    
    //returns true or false if remove was successful(j.e. if the player has the card or not)
   
    
    //adds a card to the player's cardList instance var object
    //returns true if you can add a card
    //returns false if the cardList is full
    //u can change the return to void if needed, j just thought it might be useful.
    
    //to implement
    public boolean AddCard(Card card){
            return cardList.add(card);
    }
    
     public boolean removeCard(Card card) {
        
        return cardList.remove(card);
    }
    
    public abstract String showCards();
    
    public abstract boolean checkCards(Card card);
 
}
