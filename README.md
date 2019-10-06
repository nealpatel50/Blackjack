# Blackjack
Coding Challenge for Kleiner Perkins Engineering Fellows 2020

### How to Run
```
javac Blackjack.java
java Blackjack
```

### How to Play
After running the game, the initial cards dealt are displayed for the player and dealer (one dealer card is hidden). The player is then repeatedly asked whether they want to hit or stay until they either bust or decide to stay. After the player's turn ends, the dealer follows the same process until they either bust or decide to stay. At the end, the results of the game are shown with the final scores of both the player and the dealer. The player is then given the option to play a new game of Blackjack.

### Rules/Improvements
The game does not include some rules of Blackjack such as revealing dealer cards, Aces counting as 1 or 11 points, betting, splitting, doubling, and surrendering. However, the modular nature of the code allows for smooth implementation and integration of these additional features.

### Design Choices
The main data structure used for holding the deck of cards is an ArrayList. A library from [Princeton] (https://introcs.cs.princeton.edu/java/14array/Deck.java.html) was used to initialize and shuffle the deck of cards to maintain randomness. In order to prevent counting cards, the suit and rank of the cards dealt are not displayed. Instead, only the value of the respective card in Blackjack (1-11) is shown to the player.

I decided to use Java to develop the game because Blackjack uses classic features of object-oriented programming such as classes, inheritance, and polymorphism, which can be easily implemented using Java.

### Example Run
```
$ javac Blackjack.java
$ java Blackjack
Welcome to the Blackjack game!

The dealer has a 10 and a hidden card.

You have a 7 and an 8.
Your total is 15.

Would you like to "hit" or "stay"? hit
You drew a card.

You have a 7 and an 8 and a 4.
Your total is 19.

Would you like to "hit" or "stay"? hit
You drew a card.

You busted.

The dealer has a 10 and a hidden card.
The dealer stayed.

You have a total of 29.
The dealer has a total of 20.
The dealer wins!

Play again? "yes" / "no": 
```
