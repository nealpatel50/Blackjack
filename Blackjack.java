import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class of the game of Blackjack
 * @author nealpatel
 */

public class Blackjack {
    private ArrayList<Person> players;
    private Deck deck;

    /**
     * Main method starts and restarts the game
     */
    public static void main(String[] args) {
        do {
            Blackjack game = Blackjack.initializeGame();
            game.play();
        } while (Blackjack.playAgain());
    }

    /**
     * Executes the process of dealing cards, taking turns, and declaring the winner of the game
     */
    public void play() {
        dealCards();
        takeTurns();
        declareWinner();
    }
    
    /**
     * Creates a new game with a new deck and players
     * @return a game object
     */
    private static Blackjack initializeGame() {
    	Blackjack game = new Blackjack();
        game.deck = new Deck();
        game.players = new ArrayList<Person>();
        game.players.add(new Player());
        game.players.add(new Dealer());

        System.out.println("Welcome to the Blackjack game!");
		return game;
    }

    /**
     * Deals cards to the dealer and player
     */
    private void dealCards() {
        for (Person player : players) {
            deck.dealInitialCards(player);
            if (player.getName() == "The dealer") {
                player.printCards();
            }
        }
    }

    /**
     * Determines whether or not each person wishes to hit or stay and switches turns
     */
    private void takeTurns() {
        for (Person player: players) {
            boolean endOfTurn = false;
            while(!endOfTurn) {
                player.printCards();
                boolean hit = player.wantToHit();
                if (hit) {
                    deck.dealCard(player);
                    System.out.println(player.getName() + " drew a card.\n");
                    if (player.getTotal() > 21) {
                        endOfTurn = true;
                        System.out.println(player.getName() + " busted.\n");
                    }
                } else {
                    endOfTurn = true;
                    System.out.println(player.getName() + " stayed.\n");
                }
            }
        }
    }

    /**
     * Determines winner of the game based on Blackjack rules
     */
    private void declareWinner() {
        byte highest = -1;
        byte topPlayer = -1;
        for (byte i = 0; i < players.size(); i++) {
            String name = players.get(i).getName();
            byte total = players.get(i).getTotal();

            System.out.println(name + (name.equals("You") ? " have " : " has ") + "a total of " + total + ".");

            if (total > highest && total <= 21) {
                highest = total;
                topPlayer = i;
            }
            if (total == highest && name.equals("The dealer")) {
                topPlayer = i;
            }
        }
        if (topPlayer == -1) {
            System.out.println("Everyone busted. Nobody wins.");
        } else {
        	if (players.get(topPlayer).getName() == "You") {
                System.out.println(players.get(topPlayer).getName() + " win!");
        	}
        	else {
                System.out.println(players.get(topPlayer).getName() + " wins!");
        	}
        }
    }

    /**
     * Allows player to either restart the game or end the program
     */
    @SuppressWarnings("resource")
	private static boolean playAgain() {
        System.out.print("\nPlay again? \"yes\" / \"no\": ");
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            String input = keyboard.next();
            if (input.equals("yes")) {
            	return true;
            } else if (input.equals("no")) {
            	return false;
            } else {
                System.out.print("Please type \"yes\" or \"no\": ");
            }
        }
    }
}