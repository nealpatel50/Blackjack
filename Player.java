import java.util.Scanner;

/**
 * A player in the game of Blackjack
 * @author nealpatel
 */

public class Player extends Person {
    private Scanner keyboard;

    /**
     * Constructor assigns name to player
     */
    public Player() {
        this("You");
    }

    /**
     * Code allows for support of additional players to be added
     * @param name of additional player
     */
    public Player(String name) {
		this.name = name;
	}
    
    /**
     * Prints the values of the cards currently help by the player
     */
    @Override
    public void printCards() {
        printAllCards();
    }

    /**
     * Determines whether or not the player wants to hit or stay depending on user input
     */
	public boolean wantToHit() {
        System.out.print("\nWould you like to \"hit\" or \"stay\"? ");
        keyboard = new Scanner(System.in);
        while (true) {
            String input = keyboard.next();
            if (input.equals("hit")) {
                return true;
            } else if (input.equals("stay")) {
                return false;
            } else {
                System.out.print("Type \"hit\" or \"stay\": ");
            }
        }
    }
}