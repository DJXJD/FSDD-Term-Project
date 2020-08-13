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

    public void setFinished() {
        finished = true;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }
    public void setActivePlayer(Player player) {
        activePlayer = player;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Deck getDeck() {
        return deck;
    }

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

    public Player getTargetPlayer(String name) {

        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

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

    public String goFish() {
        Card card = deck.getCard(0);
	moveCard(deck, 0, getActivePlayer().getHand());
        return card.toString();
    }

    public void initialDeal(int numCardsPerPlayer) {
	for (int i = 0; i < numCardsPerPlayer; i++) {
	    for (int j = 0; j < numPlayers; j++) {
		moveCard(deck, 0, players.get(j).getHand());
	    }
	}
    }

    public void moveCard(GroupOfCards src, int index, GroupOfCards dest) {
	Card card = src.getCard(index);
	src.removeCard(index);
	dest.AddCard(card);
    }

}
