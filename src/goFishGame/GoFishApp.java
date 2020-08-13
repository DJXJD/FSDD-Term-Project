/*
    GoFishApp.java
    Authors: Nick De Luca, Daniel Crawford, David Vejgman
    Date: August 9 2020
    Description
    Main class, controls the go fish game and implements most of the logic.
    Acts as both the control and view in the MVC
 */

package goFishGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects and then
 * asks the user to pick a card and searches the array of cards for the match to
 * the user's card. To be used as starting code in ICE 1
 *
 * @author Nick De Luca
 * @author David Vejgman
 * @author Daniel Crawford
 * @date june 14th 2020
 */
public class GoFishApp {

    private static GoFishGame game;

    /**
     * GoFishApp constructor that creats a game app object with a specified game
     * @param game the game to use in the game app
     */
    private GoFishApp(GoFishGame game) {
        if (game != null) {
            this.game = game;
        } else {
            throw new IllegalArgumentException("The app's game cannot be null");
        }
    }

    /**
     * Announces who's turn it is, clears the console before the machine is to
     * be passed to the new active player and waits for the player to be ready
     * before beginning their turn
     */
    public void announceTurn() {
        System.out.println("It is now " + game.getActivePlayer().getName() + "'s turn\n"
                + "Press Enter when ready to pass them the machine");
        waitForEnter();
        clearConsole();
        System.out.println("Hello " + game.getActivePlayer().getName() + "!\n"
                + "Press Enter when ready to begin your turn");
        waitForEnter();
    }

    /**
     * Checks is the players and deck still contain cards to determine if the
     * game should be marked as finished, and does so
     */
    public static void checkGameOver() {
        int finishedPlayers = 0;
        if (game.getDeck().getCardList().isEmpty()) {
            for (Player player : game.getPlayers()) {
                if (player.getHandCardList().isEmpty()) {
                    finishedPlayers++;
                }
            }
            if (finishedPlayers == game.getPlayers().size()) {
                game.setFinished();
                getWinner();
            }
        }
    }

    /**
     * Asks the user which player they'd like to target for their turn
     * @return name of the targeted player
     */
    public static String askPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the player name you'd like to ask for a card from: (such as 'Player1') ");
        String name = sc.nextLine();
        if (game.getTargetPlayer(name) == null) {
            System.out.println("The player does not exist, try again:");
            name = askPlayer();
        }
        if (game.getTargetPlayer(name).equals(game.getActivePlayer())) {
            System.out.println("You cannot ask yourself");
            name = askPlayer();
        }
        return name;
    }

    /**
     * Pauses execution of code until the user presses enter
     */
    public void waitForEnter() {
        Scanner emptyScanner = new Scanner(System.in);
        emptyScanner.nextLine();
    }

    public void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    public static String getRank(Scanner sc) {
        System.out.println("Enter the rank of card to ask:  ");
        String rank = sc.nextLine();
        for (Rank value : Rank.values()) {
            try {
                if (Rank.valueOf(rank.toUpperCase()).equals(value)) {
                    return rank;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                rank = getRank(sc);
            }
        }
        return rank;
    }

    public static void drawFiveCards(Player player) {
        int remainder = 5;
        if (game.getDeck().getCardList().size() < remainder) {
            remainder = game.getDeck().getCardList().size();
        }
        for (int i = 0; i < remainder; i++) {
            game.moveCard(game.getDeck(), 0, player.getHand());
        }

        if (game.getActivePlayer().checkScore()) {
            System.out.println(game.getActivePlayer().getName() + " Scored!");
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

    public static void getWinner() {
        Player winner = game.getPlayers().get(0);
        for (int i = 1; i < game.getPlayers().size(); i++) {
            if (winner.getScore() < game.getPlayers().get(i).getScore()) {

                winner = game.getPlayers().get(i);
            }
        }
        System.out.println("The winner is " + winner.getName() + "!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GoFishApp gameApp = new GoFishApp(createGameObject(scanner));
        game.init();
        System.out.println("\nWelcome, the " + game.getNumPlayers() + " of you, to our Go Fish game!\n");

        while (!game.isFinished()) {

            for (Player player : game.getPlayers()) {
                scanner = new Scanner(System.in);
                if (!(player.getHandCardList().isEmpty())) {
                    game.setActivePlayer(player);
                    gameApp.announceTurn();

                } else {//if player empty
                    if (game.getDeck().getCardList().isEmpty()) {
                        continue;
                    } else {
                        drawFiveCards(player);
                        game.setActivePlayer(player);
                        gameApp.announceTurn();

                    }
                }
                if (game.getActivePlayer().checkScore()) {
                    System.out.println(game.getActivePlayer().getName() + " Scored!");
                }
                System.out.println(game.getActivePlayer());
                try {
                    String rank = getRank(scanner);
                    String target = askPlayer();
                    int cardNum = game.askForCard(target, Rank.valueOf(rank.toUpperCase()));
                    if (cardNum == 0) {
                        System.out.println("go Fish\n" + "You drew a " + game.goFish());
                        if (game.getActivePlayer().getHandCardList().isEmpty()) {
                            drawFiveCards(game.getActivePlayer());
                        }
                    } else {
                        System.out.println(target + " gave you " + cardNum + " " + rank);
                        if (game.getTargetPlayer(target).getHandCardList().isEmpty()) {
                            drawFiveCards(game.getTargetPlayer(target));
                        }
                    }
                    if (game.getActivePlayer().checkScore()) {
                        System.out.println(game.getActivePlayer().getName() + " Scored!");
                    }
                    System.out.println(game.getActivePlayer());

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            checkGameOver();
        }

    }
}
