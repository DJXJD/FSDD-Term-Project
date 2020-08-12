package goFishGame;

import java.util.InputMismatchException;
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

    public void announceTurn() {
	System.out.println("It is now " + game.getActivePlayer().getName() + "'s turn\n"
		+ "Press Enter when ready to pass them the machine");
	waitForEnter();
	clearConsole();
	System.out.println("Hello " + game.getActivePlayer().getName() + "!\n"
		+ "Press Enter when ready to begin your turn");
	waitForEnter();
    }

    public void askForCardInteraction(Scanner scanner) {

    }

    public int getTargetIdFromUser(Scanner scanner) {
	int target;
	String query = "Enter the player you'd like to ask for a card form (";
	int counter = 1;
	for (Player p : game.getPlayers()) {
	    if (p != game.getPlayers()[game.getPlayers().length - 1]) {
		query += counter + ", ";
		counter++;
	    } else {
		query += "or " + counter + "): ";
	    }
	}
	clearScannerInputBuffer(scanner);
	System.out.print(query);
	try {
	    target = scanner.nextInt();
	} catch (InputMismatchException e) {
	    System.out.println("You must reference the player by their number");
	    clearScannerInputBuffer(scanner);
	    target = getTargetIdFromUser(scanner);
	}
	if (!(target >= 1 && target <= counter)) {
	    System.out.println("You must reference one of the specified players");
	    clearScannerInputBuffer(scanner);
	    target = getTargetIdFromUser(scanner);
	}
	return target;
    }

    public void clearScannerInputBuffer(Scanner scanner) {
	//couldn't get a proper implementation of this working
    }

    public void waitForEnter() {
	Scanner emptyScanner = new Scanner(System.in);
	emptyScanner.nextLine();
    }

    public void clearConsole() {
	for (int i = 0; i < 50; i++) {
	    System.out.println("");
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
	} catch (InputMismatchException e) {
	    System.out.println("The number of players must be a whole number");
	    scanner.nextLine();
	    game = createGameObject(scanner);
	}
	return game;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	GoFishApp gameApp = new GoFishApp(createGameObject(scanner));
	gameApp.game.init();
	System.out.println("\nWelcome, the " + gameApp.game.getNumPlayers() + " of you, to our Go Fish game!\n");
	gameApp.announceTurn();
	System.out.println(gameApp.getTargetIdFromUser(scanner));
//	while (!gameApp.game.isFinished()) {
//	    
//	}
    }

}
