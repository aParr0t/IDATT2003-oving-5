package edu.ntnu.iir.bidata;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class CardStatisticsTest {

  @Test
  public void testSumOfCards_WithValidCards_ReturnsCorrectSum() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('H', 10));
    cards.add(new PlayingCard('D', 13));
    int expectedSum = 24;

    //act
    int actualSum = CardStatistics.sumOfCards(cards);

    //assert
    assertEquals(expectedSum, actualSum, "Sum should be 24 for Ace, 10, and King");
  }

  @Test
  public void testSumOfCards_WithEmptyList_ReturnsZero() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();

    //act
    int sum = CardStatistics.sumOfCards(cards);

    //assert
    assertEquals(0, sum, "Sum should be 0 for an empty list");
  }

  @Test
  public void testGetAllOfType_WithMultipleSuits_ReturnsCorrectCards() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('S', 3));
    cards.add(new PlayingCard('D', 4));
    cards.add(new PlayingCard('S', 5));

    //act
    List<PlayingCard> spades = CardStatistics.getAllOfType(cards, 'S');

    //assert
    assertEquals(3, spades.size(), "Should have 3 spades");
    for (PlayingCard card : spades) {
      assertEquals('S', card.getSuit(), "All cards should be spades");
    }
  }

  @Test
  public void testGetAllOfType_WithNoMatchingSuit_ReturnsEmptyList() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('D', 3));

    //act
    List<PlayingCard> clubs = CardStatistics.getAllOfType(cards, 'C');

    //assert
    assertTrue(clubs.isEmpty(), "Should return empty list when no matching suit exists");
  }

  @Test
  public void testGetAllOfType_WithEmptyList_ReturnsEmptyList() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();

    //act
    List<PlayingCard> hearts = CardStatistics.getAllOfType(cards, 'H');

    //assert
    assertTrue(hearts.isEmpty(), "Should return empty list when input list is empty");
  }

  @Test
  public void testCardExistsAmongCards_WithMatchingCard_ReturnsTrue() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('D', 3));
    PlayingCard cardToFind = new PlayingCard('H', 2);

    //act
    boolean exists = CardStatistics.cardExistsAmongCards(cards, cardToFind);

    //assert
    assertTrue(exists, "Should return true when card exists in the list");
  }

  @Test
  public void testCardExistsAmongCards_WithNonMatchingCard_ReturnsFalse() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('S', 1));
    cards.add(new PlayingCard('H', 2));
    cards.add(new PlayingCard('D', 3));
    PlayingCard cardToFind = new PlayingCard('C', 12);

    //act
    boolean exists = CardStatistics.cardExistsAmongCards(cards, cardToFind);

    //assert
    assertFalse(exists, "Should return false when card doesn't exist in the list");
  }

  @Test
  public void testCardExistsAmongCards_WithEmptyList_ReturnsFalse() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    PlayingCard cardToFind = new PlayingCard('S', 1);

    //act
    boolean exists = CardStatistics.cardExistsAmongCards(cards, cardToFind);

    //assert
    assertFalse(exists, "Should return false when checking against an empty list");
  }

  @Test
  public void testIsFlush_WithAllSameSuit_ReturnsTrue() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('H', 1));
    cards.add(new PlayingCard('H', 5));
    cards.add(new PlayingCard('H', 9));
    cards.add(new PlayingCard('H', 10));
    cards.add(new PlayingCard('H', 13));

    //act
    boolean isFlush = CardStatistics.isFlush(cards);

    //assert
    assertTrue(isFlush, "Should return true when all cards have the same suit");
  }

  @Test
  public void testIsFlush_WithDifferentSuits_ReturnsFalse() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('H', 1));
    cards.add(new PlayingCard('H', 5));
    cards.add(new PlayingCard('S', 9)); // Different suit
    cards.add(new PlayingCard('H', 10));
    cards.add(new PlayingCard('H', 13));

    //act
    boolean isFlush = CardStatistics.isFlush(cards);

    //assert
    assertFalse(isFlush, "Should return false when cards have different suits");
  }

  @Test
  public void testIsFlush_WithSingleCard_ReturnsTrue() {
    //arrange
    List<PlayingCard> cards = new ArrayList<>();
    cards.add(new PlayingCard('D', 7));

    //act
    boolean isFlush = CardStatistics.isFlush(cards);

    //assert
    assertTrue(isFlush, "Should return true for a single card (trivially a flush)");
  }
}