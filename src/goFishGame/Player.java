package goFishGame;

import goFishGame.Card;
import java.util.ArrayList;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class Player {

    private String name;
    private PlayerHand hand; //delegation
    private int score;

    public Player(String name,PlayerHand hand) {
        this.name = name;
        this.hand = hand;
    }

    public void setHand(PlayerHand hand) {
        this.hand = hand;
    }
   
    public ArrayList<Card> getHand() {
        return hand.getHand(); //delegation
    }

    public String getName(){
        return name;
    }

    public int getScore() {
        return score;
    }
    //adds one to score
    public void addToScore(){
        this.score += 1;
    }
    
    public void checkScore(Card card){
        int cardCount = 0;
        for (Card c : this.getHand()) {
            if(c.getValue().getNum()==card.getValue().getNum()){
                    cardCount++;
            }
        }
        if(cardCount == 4){
            hand.removeFromHand(card);
            score++;
        }
    }
    //adds a card to the player's hand instance var object
    public boolean addToHand(Card card){ //delegation
        
        return hand.addToHand(card);
    }   
    public boolean removeFromHand(Card card){ //delegation
        
        return hand.removeFromHand(card);
    } 
    public boolean checkHand(Card card){ //delegation
        
        return hand.checkHand(card);
    } 
    
    @Override
    public String toString() {
        return "Player: " + "name=" + name + "'s score=" + score +"\n"+hand.toString();
    }
    
}
