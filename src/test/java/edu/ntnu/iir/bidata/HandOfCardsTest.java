package edu.ntnu.iir.bidata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

  @Test
  void testGetCards_WithValidCards_ReturnsCorrectCards() {
    // Arrange
    List<PlayingCard> expectedCards = new ArrayList<>();
    expectedCards.add(new PlayingCard('S', 1));
    expectedCards.add(new PlayingCard('H', 5));
    HandOfCards hand = new HandOfCards(expectedCards);

    // Act
    List<PlayingCard> actualCards = hand.getCards();

    // Assert
    assertEquals(expectedCards, actualCards);
  }

  @Test
  void testGetCards_WithEmptyHand_ReturnsEmptyList() {
    // Arrange
    HandOfCards hand = new HandOfCards(new ArrayList<>());

    // Act
    List<PlayingCard> cards = hand.getCards();

    // Assert
    assertTrue(cards.isEmpty());
  }
}