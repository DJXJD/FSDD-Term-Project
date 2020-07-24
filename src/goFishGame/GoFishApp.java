package goFishGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then asks the user to pick a card and
 * searches the array of cards for the match to the user's card. To be used as starting code in ICE 1
 *
 * @author Nick De Luca
 * @date june 14th 2020
 */
public class GoFishApp {

    public static void main(String[] args) {
       
        //testing deck building
        Deck testDeck = new Deck();
        testDeck.buildDeck();
        System.out.println(testDeck.showHand());
        System.out.println();
        
        //testing card draws
        System.out.println(testDeck.getHand().get(0));
        System.out.println(testDeck.drawCard());
        System.out.println(testDeck.getHand().get(0));
        
        //testing the shuffle method
        testDeck.shuffle();
        System.out.println(testDeck);
        
        
         //make a player Hand
        PlayerHand nicksHand = new PlayerHand(5);//5 is the number of cards u want
        //make a player 
        Player p1 = new Player("Nick",nicksHand);
        
        for (int i = 0; i < nicksHand.getHandSizeLimit(); i++) {
            nicksHand.addToHand(testDeck.drawCard());
        }
        System.out.print(nicksHand.showHand());
        
//everything below this line was commented out to test deck building with enums and shuffling
//remove block comment lines on left edge to uncomment
        
/*        System.out.println();
        Random random=new Random();
        
       
        
        //temporary population of nicksHand (david u can implement later) 
        //this needs enums to prevent repeating cards (i.e. making 2 identical cards)
        Card c = new Card();
        do {            
            int value=random.nextInt(13)+1;
            String suit=Card.SUITS[random.nextInt(3)];
            c = new Card(value,suit);
        } while (nicksHand.addToHand(c));
     
        
        //print the player info completely
        System.out.println(nicksHand.showHand());
        
        
        //takes user input of a guess card from class exercise
        Card guessCard = pickCard();
        if(p1.checkHand(guessCard) == false){
            System.out.println("Go fish");
        }
        /*
        *this block of code, checks to add score or not, if the hand has the guesscard, 
        *and removes all cards with the same value as the guesscard. 
        *(go fish is based on values, if u get four cards of the same value, the score increases)
        */
/*        p1.checkScore(guessCard);
        while(p1.checkHand(guessCard)){
            for (int i = 0; i < p1.getHand().size(); i++) {
                if(p1.getHand().get(i).getValue()==guessCard.getValue()){
                    p1.removeFromHand(p1.getHand().get(i));
                }
            }
        }//while the hand still has a card with the same value as guesscard
        
        
        
        //sort nicks hand 
        nicksHand.sortHand();
        System.out.println(nicksHand.showHand());
        
        
        //hide your hand?
        System.out.println("Hide your hand? Y/N");
        Scanner sc = new Scanner(System.in);
        if(sc.nextLine().equalsIgnoreCase("y")){
            
            System.out.println(nicksHand.hideHand());
        }
        //pick again, this is all hardcoded for testing
        guessCard = pickCard();
        
        //make a deck of size 52
        Deck deck = new Deck(52);
        
        do {            
            int value=random.nextInt(13)+1;
            String suit=Card.SUITS[random.nextInt(3)];
            c = new Card(value,suit);
        } while (deck.addToHand(c));
        //showHand sorts the hand and returns a formatted string to print
        //print the deck
        //System.out.println(deck.showHand());
        
       
    }
    //pick card method that gets user input, validating its value as a number
    //does not validate the suit
    //basic method for testing (can change if needed)
    public static Card pickCard(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick a card, any card!");
        Card guessCard = new Card();
        String suit;
        int value;
        
        try {
            /*
            System.out.print("Enter Suit: ");
            suit = sc.nextLine().trim();
            guessCard.setSuit(suit);
            */
/*           System.out.print("Got any?: ");
            value = sc.nextInt();
            if((value<0||value>13)){
                System.out.println("Value must be greater than 0 and less than 14");
                guessCard = pickCard();
            }
            guessCard.setValue(value);
        } catch (InputMismatchException e) {
            System.out.println("The value entered was not a number");
            guessCard = pickCard();
        }
        return guessCard;
*/    }
    

}
