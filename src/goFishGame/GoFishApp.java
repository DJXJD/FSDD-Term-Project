package goFishGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author Nick De Luca
 * @date june 14th 2020
 */
public class GoFishApp {

    public static void main(String[] args) {

        //testing deck building
        Deck testDeck = new Deck();
        testDeck.buildDeck();
        testDeck.shuffle();
        System.out.println(testDeck.showCards());
        System.out.println();
        
        //testing card draws
//        System.out.println(testDeck.getCardList().get(0));
//        System.out.println(testDeck.drawCard());
//        System.out.println(testDeck.getCardList().get(0));
        
        //testing the shuffle method
//        testDeck.shuffle();
//        System.out.println(testDeck);
        
        
         //make a player Hand
        PlayerHand nicksHand = new PlayerHand(12);//5 is the number of cards u want
        //make a player 
        Player p1 = new Player("Nick",nicksHand);
        
        for (int i = 0; i < nicksHand.getCardListSize(); i++) {
            nicksHand.AddCard(testDeck.drawCard());
        }
        System.out.println(nicksHand.showCards());
        
    }

}
