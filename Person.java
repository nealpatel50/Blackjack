import java.util.ArrayList;
import java.util.List;

/**
 * Any player or dealer playing the game of Blackjack
 * @author nealpatel
 */

public abstract class Person {
    protected List<Card> cards;
    protected String name;
    protected byte total;

    /**
     * Constructor creates person and initializes list of cards in their hand
     */
    public Person() {
        cards = new ArrayList<Card>();
        total = 0;
    }

    /**
     * Adds the specified card to the person's hand
     * @param card to be added to the person's hand
     * @return card added to the person's hand
     */
    public Card receiveCard(Card card) {
        cards.add(card);
        total += card.getValue();
        return card;
    }

    public abstract boolean wantToHit();

    /**
     * Obtains total value of the cards in the person's hand
     * @return total value of cards in hand
     */
    public byte getTotal() {
        return total;
    }

    /**
     * Obtains the name of a person
     * @return name of person
     */
    public String getName() {
        return name;
    }

    /**
     * Prints the value of the cards in the person's hand
     */
    public void printAllCards() {
        System.out.print("\n" + name + (name == "You" ? " have a" : " has a") + (cards.get(0).getValue() == 8 || cards.get(0).getValue() == 11 ? "n " : " ") + cards.get(0).toString());
        for (int i = 1; i < cards.size(); i++) {
            System.out.print(" and a" + (cards.get(i).getValue() == 8 || cards.get(i).getValue() == 11 ? "n " : " ") + cards.get(i).toString());
        }

        System.out.println(".\n" + name + (name == "You" ? "r" : "'s") + " total is " + total + ".");
    }

    public abstract void printCards();
}