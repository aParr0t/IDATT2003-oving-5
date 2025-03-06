package edu.ntnu.iir.bidata;
import java.util.List;

/**
 * Represents a standard deck of 52 playing cards.
 * This class provides functionality for creating a deck and dealing hands of cards.
 */
public class DeckOfCards {
  private PlayingCard[] deck = null;

  /**
   * Creates a deck of 52 playing cards.
   * The deck is initialized with cards of all four suits (Hearts, Diamonds, Clubs, Spades)/
   */
  public DeckOfCards() {
    // Create a deck of cards
    deck = new PlayingCard[52];
    int cardIndex = 0;
    for (char suit : new char[]{'H', 'D', 'C', 'S'}) {
      for (int face = 1; face <= 13; face++) {
        deck[cardIndex++] = new PlayingCard(suit, face);
      }
    }
  }

  /**
   * Deals a random hand of n cards from the deck.
   * This method shuffles the deck and then returns the first n cards.
   *
   * @param n The number of cards to deal
   * @return A HandOfCards object containing n random cards
   * @throws IllegalArgumentException If trying to deal more cards than are in the deck
   */
  public HandOfCards dealHand(int n) {
    if (n > deck.length) {
      throw new IllegalArgumentException("Cannot deal more cards than are in the deck.");
    }

    // Fisher-Yates shuffle
    for (int i = deck.length - 1; i > 0; i--) { // Iterate backwards
      int j = (int) (Math.random() * (i + 1)); // j is between 0 and i (inclusive)
      PlayingCard temp = deck[i];
      deck[i] = deck[j];
      deck[j] = temp;
    }

    // Copy the first n cards from the shuffled deck
    List<PlayingCard> hand = List.of(deck).subList(0, n);
    return new HandOfCards(hand);
  }
}