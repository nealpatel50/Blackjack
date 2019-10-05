import java.util.*;

/**
 * The Dealer in the game of Blackjack
 * @author nealpatel
 */

public class Dealer extends Person {
	
	Random rand = new Random();
	public static final int THRESHOLD = 16; // Defines the threshold at which the dealer will decide to either hit or stay
	
	/**
	 * Constructor assigns name to dealer
	 */
    public Dealer() {
        super();
        name = "The dealer";
    }
    
    /**
     * Prints the values of the cards currently held by the dealer. Only shows one card while the rest remain hidden
     */
    @Override
    public void printCards() {
        Card card = cards.get(0);
        System.out.print("\n" + name + " has a" + (card.getValue() == 8 || card.getValue() == 11 ? "n " : " ") + card.toString());
        System.out.println(" and a hidden card.");
    }

    /**
     * Determines whether or not the dealer wants to hit
     */
    public boolean wantToHit() {
    	if (total == THRESHOLD) {
    		return rand.nextBoolean();
    	}
        return total < THRESHOLD;
    }
}