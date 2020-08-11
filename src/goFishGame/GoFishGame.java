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
    
    private boolean finished = false;
    private int numPlayers;
    private int activePlayerIndex = 0;
    private Player[] players;
    private Deck deck;

    public GoFishGame(int numPlayers) {
	if (numPlayers >= 2 && numPlayers <= 5) {
	    this.numPlayers = numPlayers;
	} else {
	    throw new IllegalArgumentException("A game must have 2-5 players");
	}
    }

    public boolean isFinished() {
	return finished;
    }

    public int getNumPlayers() {
	return numPlayers;
    }

    public int getActivePlayerIndex() {
	return activePlayerIndex;
    }

    public Player[] getPlayers() {
	return players;
    }
    
    public Player getActivePlayer() {
	return players[activePlayerIndex];
    }

    public Deck getDeck() {
	return deck;
    }
    
    public void init() {
	players = new Player[numPlayers];
	for (int i = 0; i < numPlayers; i ++) {
	    players[i] = new Player("Player" + ( i + 1 ), new PlayerHand());
	}
	deck = new Deck();
	deck.buildDeck();
	deck.shuffle();
	if (numPlayers == 2) {
	    initialDeal(7);
	} else {
	    initialDeal(5);
	}
    }
    
    public boolean askForCard(int target, Rank rank) {
	if (players[activePlayerIndex].hasCard(rank) == -1) {
	    throw new IllegalArgumentException("Player must have at least one of the cards they are asking for");
	}
	if (players[target].hasCard(rank) != -1) {
	    while (players[target].hasCard(rank) != -1) {
		moveCard(players[target].getHand(), players[target].hasCard(rank), players[activePlayerIndex].getHand());
	    }
	    return true;
	}
	goFish();
	return false;
    }
    
    public void goFish() {
	moveCard(deck, 0, players[activePlayerIndex].getHand());
    }
    
    public Rank has4Match() {
	for (Card i : players[activePlayerIndex].getHandCardList()) {
	    int matches = 0;
	    for (Card j : players[activePlayerIndex].getHandCardList()) {
		if (i.getRank().equals(j.getRank())) {
		    matches ++;
		}
	    }
	    if (matches >= 4) {
		return i.getRank();
	    }
	}
	return null;
    }
    
    public void tradeMatch4Score(Rank rank) {
	for (int i = 0; i < 4; i ++) {
	    players[activePlayerIndex].removeCard(players[activePlayerIndex].hasCard(rank));
	}
	players[activePlayerIndex].addToScore();
    }
    
    public void endTurn() {
	activePlayerIndex ++;
	if (activePlayerIndex >= numPlayers) {
	    activePlayerIndex = 0;
	}
    }
    
    public void initialDeal(int numCardsPerPlayer) {
	for (int i = 0; i < numCardsPerPlayer; i ++) {
	    for (int j = 0; j < numPlayers; j ++) {
		moveCard(deck, 0, players[j].getHand());
	    }
	}
    }
    
    public void moveCard(GroupOfCards src, int index, GroupOfCards dest) {
	Card card = src.getCard(index);
	src.removeCard(index);
	dest.AddCard(card);
    }
    
}
