package edu.ntnu.iir.bidata;

import java.util.List;

/**
 * Represents a hand of playing cards in a card game.
 */
public class HandOfCards {
  private List<PlayingCard> cards = null;

  /**
   * Creates a new hand with the specified list of cards.
   * @param cards The list of playing cards to add to this hand
   */
  public HandOfCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  /**
   * Returns the list of cards in this hand.
   * @return The list of PlayingCard objects in this hand
   */
  public List<PlayingCard> getCards() {
    return cards;
  }
}