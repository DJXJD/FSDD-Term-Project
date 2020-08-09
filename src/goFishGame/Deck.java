/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goFishGame;

import goFishGame.Card;
import java.util.ArrayList;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class Deck extends GroupOfCards{

    public Deck() {
    }

    public Deck(int handSize) {
        super(handSize);
    }

    //possible methods to add
    //shuffle
    //deal 
    
    public void buildDeck() {
        super.setHandSizeLimit(52);
        ArrayList<Card> deck = new ArrayList();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
            
                deck.add(new Card(r, s));
            }
        }
        this.setHand(deck);
    }
    
    public void shuffle() {
            
        Card card = this.getHand().get(0);
        for (int i = 0; i < this.getHand().size(); i++) {

            for (int j = 1; j < this.getHand().size(); j++) {
                int x = (int)(Math.random() * i);
                    card = this.getHand().get(j);
                    this.getHand().remove(j);
                    this.getHand().add(x,card);
            }
        }
    }
    
    //returns the first card in the list and removes it from the deck
    public Card drawCard() {
        Card draw = this.getHand().get(0);
        this.removeFromHand(this.getHand().get(0));
        return draw;
    }

    @Override
    public String showHand() {
        String showHand = "";
        this.sortHand();
        int count = 0;
        int lineSize = 13;
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < this.getHand().size(); j+=4) {
            
            showHand += this.getHand().get(j).toString() + " "; 
            count++;
            if(count == lineSize){
                showHand += "\n";
                lineSize += 13;
                }
            }
        }
        return showHand;
    }
    
    public boolean checkHand(Card card){
        for (Card c : this.getHand()) {
           
            if(c.getSuit().getName().equalsIgnoreCase(card.getSuit().getName()) 
                    && c.getValue().getNum() == card.getValue().getNum()){
                this.getHand().remove(c);
                return true;
            }
        }
        return false;
    }
    
    
    //toString used mostly for testing funcionality
    @Override
    public String toString() {
        String s = "";
        for (Card c : this.getHand()) {
            s += c.toString() + "\n";
        }
        return s;
    }
    
}
