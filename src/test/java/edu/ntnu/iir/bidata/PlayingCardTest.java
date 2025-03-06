package edu.ntnu.iir.bidata;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayingCardTest {

  @Test
  void testConstructor_ValidInputs_CreatesCard() {
    // Arrange
    char suit = 'H';
    int face = 10;

    // Act
    PlayingCard card = new PlayingCard(suit, face);

    // Assert
    assertEquals(suit, card.getSuit());
    assertEquals(face, card.getFace());
  }

  @Test
  void testConstructor_InvalidSuit_ThrowsException() {
    // Arrange
    char invalidSuit = 'X';
    int face = 10;

    // Act & Assert
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new PlayingCard(invalidSuit, face);
    });
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 14})
  void testConstructor_InvalidFace_ThrowsException(int invalidFace) {
    // Arrange
    char suit = 'H';

    // Act & Assert
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new PlayingCard(suit, invalidFace);
    });
  }

  @Test
  void testGetSuit_ValidCard_ReturnsSuit() {
    // Arrange
    PlayingCard card = new PlayingCard('D', 5);
    char expectedSuit = 'D';

    // Act
    char actualSuit = card.getSuit();

    // Assert
    assertEquals(expectedSuit, actualSuit);
  }

  @Test
  void testGetFace_ValidCard_ReturnsFace() {
    // Arrange
    PlayingCard card = new PlayingCard('C', 8);
    int expectedFace = 8;

    // Act
    int actualFace = card.getFace();

    // Assert
    assertEquals(expectedFace, actualFace);
  }

  @ParameterizedTest
  @CsvSource({
          "H, 10, H10",
          "S, 1, S1",
          "D, 13, D13",
          "C, 12, C12"
  })
  void testGetAsString_ValidCard_ReturnsCorrectString(char suit, int face, String expected) {
    // Arrange
    PlayingCard card = new PlayingCard(suit, face);

    // Act
    String actual = card.getAsString();

    // Assert
    assertEquals(expected, actual);
  }

  @Test
  void testEquals_DifferentObjectSameValues_ReturnsTrue() {
    // Arrange
    PlayingCard card1 = new PlayingCard('H', 7);
    PlayingCard card2 = new PlayingCard('H', 7);

    // Act
    boolean result = card1.equals(card2);

    // Assert
    assertTrue(result);
  }

  @Test
  void testEquals_DifferentCard_ReturnsFalse() {
    // Arrange
    PlayingCard card1 = new PlayingCard('H', 7);
    PlayingCard card2 = new PlayingCard('S', 7);

    // Act
    boolean result = card1.equals(card2);

    // Assert
    assertFalse(result);
  }
}