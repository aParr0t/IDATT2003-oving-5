package edu.ntnu.iir.bidata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.HashSet;
import java.util.Set;

class DeckOfCardsTest {

  private DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    deckOfCards = new DeckOfCards();
  }

  @Test
  void testDealHand_WithValidNumberOfCards_ReturnsDealHand() {
    // Arrange
    int numberOfCards = 5;

    // Act
    HandOfCards hand = deckOfCards.dealHand(numberOfCards);

    // Assert
    assertNotNull(hand, "The dealt hand should not be null");
    assertEquals(numberOfCards, hand.getCards().size(), "The hand should contain exactly " + numberOfCards + " cards");
  }

  @Test
  void testDealHand_WithZeroCards_ReturnsEmptyHand() {
    // Arrange
    int numberOfCards = 0;

    // Act
    HandOfCards hand = deckOfCards.dealHand(numberOfCards);

    // Assert
    assertNotNull(hand, "The dealt hand should not be null");
    assertEquals(0, hand.getCards().size(), "The hand should be empty");
  }

  @Test
  void testDealHand_WithMaximumCards_ReturnsFullDeck() {
    // Arrange
    int numberOfCards = 52;

    // Act
    HandOfCards hand = deckOfCards.dealHand(numberOfCards);

    // Assert
    assertNotNull(hand, "The dealt hand should not be null");
    assertEquals(numberOfCards, hand.getCards().size(), "The hand should contain all 52 cards");
  }

  @Test
  void testDealHand_WithInvalidNumberOfCards_ThrowsException() {
    // Arrange
    int numberOfCards = 53;

    // Act & Assert
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      deckOfCards.dealHand(numberOfCards);
    });

    String expectedMessage = "Cannot deal more cards than are in the deck.";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage),
            "Exception message should contain '" + expectedMessage + "'");
  }

  @Test
  void testDealHand_ReturnsUniqueCards() {
    // Arrange
    int numberOfCards = 52; // Test with full deck to check all cards

    // Act
    HandOfCards hand = deckOfCards.dealHand(numberOfCards);

    // Assert
    Set<PlayingCard> uniqueCards = new HashSet<>(hand.getCards());
    assertEquals(numberOfCards, uniqueCards.size(),
            "All cards in the hand should be unique");
  }

  @Test
  void testDealHand_ShuffleDeck_ReturnsDifferentHands() {
    // Arrange
    int numberOfCards = 5;

    // Act
    HandOfCards firstHand = deckOfCards.dealHand(numberOfCards);
    HandOfCards secondHand = deckOfCards.dealHand(numberOfCards);

    // Assert
    // Note: There's a very small probability this could fail randomly
    // if the shuffle happens to produce the same 5 cards, but it's extremely unlikely
    assertNotEquals(firstHand.getCards(), secondHand.getCards(),
            "Two consecutive hands should be different due to shuffling");
  }
}