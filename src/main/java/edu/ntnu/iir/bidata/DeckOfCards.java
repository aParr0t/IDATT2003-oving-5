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

    // print the deck of cards
    for (PlayingCard card : deck) {
      System.out.println(card.getAsString());
    }
  }
}
