package goFishGame;

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
    
    private GoFishGame game;
    
    private GoFishApp(GoFishGame game) {
	if (game != null) {
	    this.game = game;
	} else {
	    throw new IllegalArgumentException("The app's game cannot be null");
	}
    }
    
    public static GoFishGame createGameObject(Scanner scanner) {
	System.out.print("Enter the number of players for the game: ");
	GoFishGame game = null;
	try {
	    game = new GoFishGame(scanner.nextInt());
	} catch (IllegalArgumentException e) {
	    System.out.println(e.getMessage());
	    game = createGameObject(scanner);
	}
	return game;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	GoFishApp gameApp = new GoFishApp(createGameObject(scanner));
    }

}
