package edu.ntnu.iir.bidata;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.List;

public class MainScene extends StackPane {
  DeckOfCards deckOfCards;
  HandOfCards hand;
  GridPane cardDisplayArea;
  Label sumValueLabel, heartsValueLabel, flushValueLabel, queenValueLabel;

  public MainScene() {
    deckOfCards = new DeckOfCards();

    // Main layout
    BorderPane mainLayout = new BorderPane();
    this.getChildren().add(mainLayout);

    // Center area for displaying cards
    cardDisplayArea = new GridPane();
    cardDisplayArea.setPrefSize(600, 400);
    cardDisplayArea.setHgap(10);
    cardDisplayArea.setVgap(10);
    cardDisplayArea.setPadding(new Insets(20));
    cardDisplayArea.setStyle("-fx-background-color: lightgrey; -fx-border-color: black;");
    mainLayout.setCenter(cardDisplayArea);

    // Buttons on the right
    VBox buttonBox = new VBox(20);
    buttonBox.setPadding(new Insets(20));
    buttonBox.setAlignment(Pos.CENTER);
    Button dealHandButton = new Button("Deal hand");
    dealHandButton.setOnAction(e -> dealHandHandler());
    Button checkHandButton = new Button("Check hand");
    checkHandButton.setOnAction(e -> checkHandHandler());
    buttonBox.getChildren().addAll(dealHandButton, checkHandButton);
    mainLayout.setRight(buttonBox);

    // Bottom info area
    GridPane infoGrid = new GridPane();
    infoGrid.setPadding(new Insets(10));
    infoGrid.setHgap(10);
    infoGrid.setVgap(10);

    // sum info
    HBox sumContainer = new HBox(10);
    Label sumLabel = new Label("Sum of the faces:");
    sumValueLabel = new Label();
    sumValueLabel.setPrefWidth(50);
    sumContainer.getChildren().addAll(sumLabel, sumValueLabel);

    // hearts info
    HBox heartsContainer = new HBox(10);
    Label heartsLabel = new Label("Cards of hearts:");
    heartsValueLabel = new Label();
    heartsValueLabel.setPrefWidth(150);
    heartsContainer.getChildren().addAll(heartsLabel, heartsValueLabel);

    // flush info
    HBox flushContainer = new HBox(10);
    Label flushLabel = new Label("Flush: ");
    flushValueLabel = new Label();
    flushContainer.getChildren().addAll(flushLabel, flushValueLabel);

    // queen info
    HBox queenContainer = new HBox(10);
    Label queenLabel = new Label("Queen of spades: ");
    queenValueLabel = new Label();
    queenContainer.getChildren().addAll(queenLabel, queenValueLabel);

    infoGrid.add(sumContainer, 0, 0);
    infoGrid.add(heartsContainer, 1, 0);
    infoGrid.add(flushContainer, 0, 1);
    infoGrid.add(queenContainer, 1, 1);

    mainLayout.setBottom(infoGrid);
  }

  /**
   * Event handler for the "Deal hand" button.
   */
  private void dealHandHandler() {
    int numberOfCards = 5;
    hand = deckOfCards.dealHand(numberOfCards);
    cardDisplayArea.getChildren().clear();
    int numberOfRows = 2;
    int cardsInARow = (int) Math.ceil((double) numberOfCards / numberOfRows);
    List<PlayingCard> cards = hand.getCards();
    for (int y=0; y<numberOfRows; y++) {
      for (int x=0; x<cardsInARow; x++) {
        int cardIndex = y * cardsInARow + x;
        if (cardIndex < numberOfCards) {
          PlayingCardView cardView = new PlayingCardView(cards.get(cardIndex));
          cardDisplayArea.add(cardView, x, y);
        }
      }
    }
  }

  /**
   * Event handler for the "Check hand" button.
   */
  private void checkHandHandler() {
    List<PlayingCard> cards = hand.getCards();

    // sum of cards
    int sumOfCards = CardStatistics.sumOfCards(cards);
    sumValueLabel.setText(Integer.toString(sumOfCards));

    // all heart cards
    List<PlayingCard> allHeartCards = CardStatistics.getAllOfType(cards, 'H');
    String heartsText;
    if (allHeartCards.isEmpty()) {
      heartsText = "No hearts";
    } else {
      List<String> heartStrings = allHeartCards.stream().map(PlayingCard::getAsString).toList();
      heartsText = String.join(", ", heartStrings);
    }
    heartsValueLabel.setText(heartsText);

    // flush
    boolean isFlush = CardStatistics.isFlush(cards);
    flushValueLabel.setText(isFlush ? "Yes" : "No");

    // queen of spades
    boolean hasQueenOfSpades = CardStatistics.cardExistsAmongCards(cards, new PlayingCard('S', 13));
    queenValueLabel.setText(hasQueenOfSpades ? "Yes" : "No");
  }
}
