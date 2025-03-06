package edu.ntnu.iir.bidata;
import java.util.List;

/**
 * Utility class providing statistical and utility functions for a collection of playing cards.
 */
public class CardStatistics {
  /**
   * Calculates the sum of face values of all cards in the provided list.
   * @param cards List of playing cards to sum
   * @return The total sum of all card face values
   */
  static int sumOfCards(List<PlayingCard> cards) {
    return cards.stream().mapToInt(PlayingCard::getFace).sum();
  }

  /**
   * Filters the given list of cards and returns only those of the specified suit.
   * @param cards List of playing cards to filter
   * @param type The suit character to filter by (S, H, D, C)
   * @return A new list containing only cards of the specified suit
   */
  static List<PlayingCard> getAllOfType(List<PlayingCard> cards, char type) {
    return cards.stream().filter(card -> card.getSuit() == type).toList();
  }

  /**
   * Checks if a specific card exists in the provided list of cards.
   * @param cards List of playing cards to search within
   * @param card The specific card to look for
   * @return true if the card exists in the list, false otherwise
   */
  static boolean cardExistsAmongCards(List<PlayingCard> cards, PlayingCard card) {
    return cards.stream().anyMatch(c -> c.equals(card));
  }

  /**
   * Determines if all cards in the list have the same suit (a flush).
   * @param cards List of playing cards to check
   * @return true if all cards have the same suit, false otherwise
   */
  static boolean isFlush(List<PlayingCard> cards) {
    return cards.stream().allMatch(card -> card.getSuit() == cards.getFirst().getSuit());
  }
}