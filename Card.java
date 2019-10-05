/**
 * Creates cards that hold specific Blackjack values
 * @author nealpatel
 */

public class Card {
	private int value;
	
	/**
	 * @param value the value of the card in Blackjack
	 */
	public Card(int value) {
		this.value = value;
	}
	
	/**
	 * prints the value of the card
	 */
	public String toString() {
		return "" + value;
	}
	
	/**
	 * @return the value of the card
	 */
	public int getValue() {
		return value;
	}
}
