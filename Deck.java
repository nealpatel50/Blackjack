import java.util.ArrayList;

/**
 * A deck that contains a list of Card objects.
 * Uses a deck library to create and shuffle the deck
 * @author nealpatel
 */

public class Deck {
	
	// Defines the position in deck to draw card from
	public static int POSITION = 0;

	/**
	 * Creates the initial deck and shuffles it
	 * @return a list containing the shuffled deck of cards
	 */
	// Obtained deck library from https://introcs.cs.princeton.edu/java/14array/Deck.java.html
	public static ArrayList<String> createDeck() {
		ArrayList<String> shuffledDeck = new ArrayList<String>();
        String[] SUITS = {
                "Clubs", "Diamonds", "Hearts", "Spades"
            };

            String[] RANKS = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
            };

            // initialize deck
            int n = SUITS.length * RANKS.length;
            String[] deck = new String[n];
            for (int i = 0; i < RANKS.length; i++) {
                for (int j = 0; j < SUITS.length; j++) {
                    deck[SUITS.length*i + j] = RANKS[i] + " of " + SUITS[j];
                }
            }

            // shuffle
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n-i));
                String temp = deck[r];
                deck[r] = deck[i];
                deck[i] = temp;
            }

            // print shuffled deck
            for (int i = 0; i < n; i++) {
            	shuffledDeck.add(deck[i]);
            }
            return shuffledDeck;
        }

	/**
	 * Draws the top card from the deck and determines its value in Blackjack
	 * @return a Card object with the value of the top card in deck
	 */
    public static Card drawNextCard() {
        int value;
    	ArrayList<String> deck = createDeck();
    	String card = deck.get(POSITION);
    	String[] al = card.split(" ");
    	if (al[0].equals("Jack") || al[0].equals("Queen") || al[0].equals("King")) {
    		value = 10;
    	}
    	else if (al[0].equals("Ace")) {
    		value = 11;
    	}
    	else {
    		value = Integer.parseInt(al[0]);
    	}
        POSITION += 1;
        return new Card(value);
    }

    /**
     * Deals a card to specified person
     * @param person who will receive the card
     */
    public void dealCard(Person person) {
        person.receiveCard(drawNextCard());
    }

    /**
     * Deals the initial two cards at the beginning of the game
     * @param person who will receive the initial cards
     */
    public void dealInitialCards(Person person) {
        dealCard(person);
        dealCard(person);
    }
}