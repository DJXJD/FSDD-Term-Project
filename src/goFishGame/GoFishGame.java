/*
    GoFishGame.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    This file creates game objects that model the function
    of a game within our app
 */

package goFishGame;

import java.util.ArrayList;

/**
 *
 * @author David Vejgman
 */
public class GoFishGame {

    private boolean finished = false;
    private int numPlayers;
    private Player activePlayer;
    private ArrayList<Player> players;
    private Deck deck;

    /**
     * Game constructor that creates a game object with a set number of players
     * @param numPlayers number of players for the game
     * @throws IllegalArgumentException if attempting to create a game object
     * with an unsupported amount of players
     */
    public GoFishGame(int numPlayers) {
        if (numPlayers >= 2 && numPlayers <= 5) {
            this.numPlayers = numPlayers;
        } else {
            throw new IllegalArgumentException("A game must have 2-5 players");
        }
    }
    
    /**
     * Gets a boolean representing whether or not the game is finished
     * @return boolean representing whether or not the game is finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * Marks the game as finished
     */
    public void setFinished() {
        finished = true;
    }

    /**
     * Gets the number of players in the game
     * @return the number of players in the game
     */
    public int getNumPlayers() {
        return numPlayers;
    }

    /**
     * Gets the player who's turn it is
     * @return the object of the player who's turn it is
     */
    public Player getActivePlayer() {
        return activePlayer;
    }
    
    /**
     * Sets which player's turn it is
     * @param player a player in the game who should become the active player
     */
    public void setActivePlayer(Player player) {
        activePlayer = player;
    }

    /**
     * Gets an ArrayList of all players in the game
     * @return an ArrayList of all players in the game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Gets the deck associated with the game
     * @return the deck associated with the game
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Initializes the game by creating and naming players, creating and
     * building a deck, setting the active player as Player1 and dealing
     * the correct amount of cards to each player
     */
    public void init() {
        players = new ArrayList(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player("Player" + (i +1), new PlayerHand()));
        }
        deck = new Deck();
        deck.buildDeck();
        //deck.shuffle();
        setActivePlayer(getTargetPlayer("Player1"));
        if (numPlayers == 2) {
            initialDeal(7);
        } else {
            initialDeal(5);
        }
    }

    /**
     * Gets a specific player object within the game based on the player's name
     * @param name the name field of the player to get
     * @return the player with the specified name
     */
    public Player getTargetPlayer(String name) {

        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    /**
     * Asks a player with a given name if it has a card with a specified rank.
     * Each card the asked player has with the specified rank will be given
     * to the active player, who is asking
     * @param name name of the player to ask form
     * @param rank rank of the card to ask for
     * @return the number of cards that match the specified rank
     * @throws IllegalArgumentException if the asking player does not have a
     * card of the rank they're asking for
     */
    public int askForCard(String name, Rank rank) {
        int cardNum = 0;
        if (getActivePlayer().hasCard(rank) != -1) {

            if (getTargetPlayer(name) != null) {
                if (getTargetPlayer(name).hasCard(rank) != -1) {
                    while(getTargetPlayer(name).hasCard(rank) != -1){
                        moveCard(getTargetPlayer(name).getHand(), 
                                getTargetPlayer(name).hasCard(rank), 
                                getActivePlayer().getHand());
                                cardNum++;
                    }
                    return cardNum;
                }else{
                    return cardNum;
                }
            }
        }else{
            throw new IllegalArgumentException("You cannot ask for a card you dont have");
        }
        return cardNum;
    }

    /**
     * Gives the active player the top card in the deck and returns the
     * toString of said card
     * @return the toString of the card that's given to the active player
     */
    public String goFish() {
        Card card = deck.getCard(0);
	moveCard(deck, 0, getActivePlayer().getHand());
        return card.toString();
    }

    /**
     * Deals cards to players at the start of a game, mimicking the style of a
     * proper deal, based of the number of cards to be dealt to each player
     * @param numCardsPerPlayer the number of cards to be dealt to each player
     */
    public void initialDeal(int numCardsPerPlayer) {
	for (int i = 0; i < numCardsPerPlayer; i++) {
	    for (int j = 0; j < numPlayers; j++) {
		moveCard(deck, 0, players.get(j).getHand());
	    }
	}
    }

    /**
     * Moves a card form a source group of cards at a specific intex to a
     * destination group of cards
     * @param src source group of cards
     * @param index index to take from in the source group of cards
     * @param dest destination group of cards
     */
    public void moveCard(GroupOfCards src, int index, GroupOfCards dest) {
	Card card = src.getCard(index);
	src.removeCard(index);
	dest.AddCard(card);
    }

}
