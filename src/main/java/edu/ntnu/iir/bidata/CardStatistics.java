package edu.ntnu.iir.bidata;

import java.util.List;

public class CardStatistics {
  static int sumOfCards(List<PlayingCard> cards) {
    return cards.stream().mapToInt(PlayingCard::getFace).sum();
  }

  static List<PlayingCard> getAllOfType(List<PlayingCard> cards, char type) {
    return cards.stream().filter(card -> card.getSuit() == type).toList();
  }

  static boolean cardExistsAmongCards(List<PlayingCard> cards, PlayingCard card) {
    return cards.stream().anyMatch(c -> c.equals(card));
  }

  static boolean isFlush(List<PlayingCard> cards) {
    return cards.stream().allMatch(card -> card.getSuit() == cards.getFirst().getSuit());
  }
}
