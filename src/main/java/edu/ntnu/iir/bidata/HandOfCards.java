package edu.ntnu.iir.bidata;

import java.util.List;

public class HandOfCards {
  private List<PlayingCard> cards = null;

  public HandOfCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  public List<PlayingCard> getCards() {
    return cards;
  }
}
