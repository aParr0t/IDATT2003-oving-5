package edu.ntnu.iir.bidata;

public class HandOfCards {
  private PlayingCard[] cards = null;

  public HandOfCards(PlayingCard[] cards) {
    this.cards = cards;
  }

  public PlayingCard[] getCards() {
    return cards;
  }
}
