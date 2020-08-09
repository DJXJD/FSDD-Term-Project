/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goFishGame;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class PlayerHand extends GroupOfCards {

    public PlayerHand() {
    }

    public PlayerHand(int handSize) {
        super(handSize);
    }

    //functinality will be implemented in game class
    public String hideHand(){
        String hideHand = " ";
        for (int i = 0; i < 30; i++) {
            hideHand += ""+"\n";
        }
        return hideHand;
    }   

    @Override
    public String showCards() {
        String showHand = "";
        String spaceFormat = "|%s%8s|"; 
        showHand += "\n";
        for (int i = 0; i < this.getCardList().size(); i++) {
           showHand += "___________\n";
            if(this.getCardList().get(i).getRankNum()==10)
                spaceFormat = "|%s%7s|";
            else
                spaceFormat = "|%s%8s|"; 
           showHand += String.format(spaceFormat,this.getCardList().get(i).getRankShortName(),this.getCardList().get(i).getSuitSymbol())+"\n";     
           showHand += "|         |\n";
           showHand += "|         |\n";
           showHand += "|         |\n";
           showHand += "\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\n";
        }  
        
        return showHand;
    }

    //make this better
    @Override
    public String toString() {
        return "hand=" + this.getCardList();
    }

    public boolean checkCards(Card card) {
        for (Card c : this.getCardList()) {
           
            if(c.getRankNum()==card.getRankNum()){
                return true;
            }
        }
        return false;
       }
}
