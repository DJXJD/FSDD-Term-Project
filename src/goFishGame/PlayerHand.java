/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goFishGame;

import goFishGame.Card;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class PlayerHand extends Hand {

    public PlayerHand() {
    }

    public PlayerHand(int handSize) {
        super(handSize);
    }

    public String hideHand(){
        String hideHand = " ";
        for (int i = 0; i < 30; i++) {
            hideHand += ""+"\n";
        }
        return hideHand;
    }   

    @Override
    public String showHand() {
        String showHand = "";
        String spaceFormat = "|%s%8s|"; 
        showHand += "\n";
        for (int i = 0; i < this.getHand().size(); i++) {
           showHand += "___________\n";
            if(this.getHand().get(i).getValue().getNum()==10)
                spaceFormat = "|%s%7s|";
            else
                spaceFormat = "|%s%8s|"; 
           showHand += String.format(spaceFormat,this.getHand().get(i).getValue().getLetter(),this.getHand().get(i).getSuit().getSymbol())+"\n";     
           showHand += "|         |\n";
           showHand += "|         |\n";
           showHand += "|         |\n";
           showHand += "\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\n";
        }  
        
        return showHand;
    }

    @Override
    public String toString() {
        return "hand=" + this.getHand();
    }

    public boolean checkHand(Card card) {
        for (Card c : this.getHand()) {
           
            if(c.getValue().getNum()==card.getValue().getNum()){
                return true;
            }
        }
        return false;
       }
}
