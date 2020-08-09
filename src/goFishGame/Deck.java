/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishGame;

import java.util.ArrayList;

/**
 * This class <enter description>
 *
 * @author Nick De Luca
 */
public class Deck extends GroupOfCards {

    public Deck() {
    }

    public Deck(int handSize) {
        super(handSize);
    }

    //possible methods to add
    //shuffle
    //deal 
    public void buildDeck() {
        super.setCardListSize(52);
        ArrayList<Card> deck = new ArrayList();
        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {

                deck.add(new Card(r, s));
            }
        }
        setCardList(deck);
    }

    public void shuffle() {

        Card card = this.getCardList().get(0);
        for (int i = 0; i < this.getCardList().size(); i++) {

            for (int j = 1; j < this.getCardList().size(); j++) {
                int x = (int) (Math.random() * i);
                card = this.getCardList().get(j);
                this.getCardList().remove(j);
                this.getCardList().add(x, card);
            }
        }
    }

    //returns the first card in the list and removes it from the deck
    public Card drawCard() {
        Card draw = this.getCardList().get(0);
        this.removeCard(this.getCardList().get(0));
        return draw;
    }

    @Override
    public String showCards() {
        String showHand = "";
        int count = 0;
        int lineSize = 6;
        for (int i = 0; i < 4; i++) {
            for (int j = i; j < getCardList().size(); j += 4) {

                showHand += getCardList().get(j).toString() + " ";
                count++;
                if (count == lineSize) {
                    showHand += "\n";
                    lineSize += 6;
                }
            }
        }
        return showHand;
    }

    public boolean checkCards(Card card) {
        for (Card c : this.getCardList()) {

            if (c.getSuitName().equalsIgnoreCase(card.getSuitName())
                    && c.getRankNum() == card.getRankNum()) {
                this.getCardList().remove(c);
                return true;
            }
        }
        return false;
    }

    //toString used mostly for testing funcionality
    @Override
    public String toString() {
        String s = "";
        for (Card c : this.getCardList()) {
            s += c.toString() + "\n";
        }
        return s;
    }

}
