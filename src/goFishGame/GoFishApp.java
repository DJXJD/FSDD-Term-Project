package goFishGame;

import java.util.ArrayList;

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
//
//        //testing deck building
//        Deck testDeck = new Deck();
//        testDeck.buildDeck();
//        testDeck.shuffle();
//        System.out.println(testDeck.showCards());
//        System.out.println();
//        
//        //testing card draws
////        System.out.println(testDeck.getCardList().get(0));
////        System.out.println(testDeck.drawCard());
////        System.out.println(testDeck.getCardList().get(0));
//        
//        //testing the shuffle method
////        testDeck.shuffle();
////        System.out.println(testDeck);
//        
//        
//        //make a player Hand
//        PlayerHand nicksHand = new PlayerHand(4);//5 is the number of cards u want
//        //make a player 
//        Player p1 = new Player("Nick",nicksHand);
//        Rank rank = Rank.ACE;
//        Suit suit = Suit.CLUBS;
//        Card card = new Card(rank,suit);
//         nicksHand.AddCard(card);
//         nicksHand.AddCard(card);
//         nicksHand.AddCard(card);
//         nicksHand.AddCard(card);
//         //nicksHand.AddCard(new Card(Rank.EIGHT,Suit.DIAMONDS));
//        
//        p1.checkScore(card);
//          ArrayList<Card> list = new ArrayList(6);
//          
//          for (int i = 0; i < 5; i++) {
//            list.add(new Card(Rank.EIGHT,Suit.DIAMONDS));
//            System.out.println(list.get(i));
//        }
//        list.remove(0);
//          list.remove(0);
//            list.remove(0);
//              list.remove(0);
//                list.remove(0);
//              for (int i = 0; i < list.size(); i++) {
//    
//            System.out.println(list.get(i));
//        }
//          
////         System.out.println(p1.getScore());
////        for (int i = 0; i < nicksHand.getCardListSize(); i++) {
////            nicksHand.AddCard(testDeck.drawCard());
////        }
//        System.out.println(nicksHand.showCards());
////        
	
	GoFishGame game = new GoFishGame(3);
	game.init();
	System.out.println(game.getDeck());
	for (int i = 0; i < 3; i ++) {
	    System.out.println(game.getPlayers()[i]);
	}
	game.initialDeal(3);
	System.out.println(game.getDeck());
	for (int i = 0; i < 3; i ++) {
	    System.out.println(game.getPlayers()[i]);
	}

    }

}
