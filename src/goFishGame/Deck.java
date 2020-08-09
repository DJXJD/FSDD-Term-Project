/*
    Deck.java
    Author: Nick De Luca, David Vejgman, Daniel Crawford
    Date: August 9th 2020
    Description
    This class defines the properties and attributes of a deck object
*/
package goFishGame;

import java.util.ArrayList;
/**
 * This class defines the decks properties and attributes
 *
 * @author Nick De Luca
 */
public class Deck extends GroupOfCards {
    /**
     * The empty constructor to instantiate a deck object.
     */
    public Deck() {
    }
    /**
     * A single argument constructor that instantiates a deck 
     * with a given hand size
     * @param handSize the given hand size to define the size of the deck
     */
    public Deck(int handSize) {
        super(handSize);
    }
    /**
     * This void method constructs a deck with 13 cards of each suit. 
     */
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
    /**
     * This method shuffles the deck by putting card objects in random locations
     */
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

    /**
     * This method draws a card from the top of the deck 
     * @return the card object take from the deck's first position
     */
    public Card drawCard() {
        Card draw = this.getCardList().get(0);
        this.removeCard(this.getCardList().get(0));
        return draw;
    }
    /**
     * This method prints the deck to the console organized in lines
     * @return a formatted string that displays the deck
     */
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
    /**
     * This method checks the deck if it contains a given card
     * @param card the card to search for in the deck
     * @return true if the deck has the card, false if it doesn't
     */
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

    /**
     * The to string method of the deck prints each card on a separate line
     * @return 
     */
    @Override
    public String toString() {
        String s = "";
        for (Card c : this.getCardList()) {
            s += c.toString() + "\n";
        }
        return s;
    }

}
