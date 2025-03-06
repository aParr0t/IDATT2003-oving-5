package edu.ntnu.iir.bidata;

public class DeckOfCards {
  private PlayingCard[] deck = null;

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
   * Deal a random hand of n cards from the deck.
   */
  public HandOfCards dealHand(int n) {
    if (n > deck.length) {
      throw new IllegalArgumentException("Cannot deal more cards than are in the deck.");
    }

    // Shuffle the deck
    for (int i = 0; i < deck.length; i++) {
      int j = (int) (Math.random() * deck.length);
      PlayingCard temp = deck[i];
      deck[i] = deck[j];
      deck[j] = temp;
    }

    // Copy the first n cards from the shuffled deck
    PlayingCard[] hand = new PlayingCard[n];
    System.arraycopy(deck, 0, hand, 0, n);

    return new HandOfCards(hand);
  }
}
