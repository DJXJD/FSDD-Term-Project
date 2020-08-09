/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishGame;

/**
 *
 * @author David Vejgman
 */
public class GoFishGame {
    
    private int numPlayers;
    private Player[] players;
    private Deck deck;

    public GoFishGame(int numPlayers) {
	if (numPlayers >= 2 && numPlayers <= 5) {
	    this.numPlayers = numPlayers;
	} else {
	    throw new IllegalArgumentException("A game must have 2-5 players");
	}
    }

    public int getNumPlayers() {
	return numPlayers;
    }

    public Player[] getPlayers() {
	return players;
    }

    public Deck getDeck() {
	return deck;
    }
    
    public void init() {
	players = new Player[numPlayers];
	for (int i = 0; i < numPlayers; i ++) {
	    players[i] = new Player("player" + i + 1, new PlayerHand());
	}
	deck = new Deck();
	deck.buildDeck();
	deck.shuffle();
	//to add more
    }
    
    public void moveCard(GroupOfCards src, GroupOfCards dest) {
	
    }
    
}
