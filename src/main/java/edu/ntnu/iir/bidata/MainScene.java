package edu.ntnu.iir.bidata;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class MainScene extends StackPane {
  DeckOfCards deckOfCards;
  HandOfCards hand;
  GridPane cardDisplayArea;

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

    Label sumLabel = new Label("Sum of the faces:");
    TextField sumField = new TextField();
    sumField.setPrefWidth(50);

    Label heartsLabel = new Label("Cards of hearts:");
    TextField heartsField = new TextField();
    heartsField.setPrefWidth(150);

    boolean isFlush = false;
    Label flushLabel = new Label("Flush: " + (isFlush ? "Yes" : "No"));

    boolean hasQueenOfSpades = false;
    Label queenLabel = new Label("Queen of spades: " + (hasQueenOfSpades ? "Yes" : "No"));

    infoGrid.add(sumLabel, 0, 0);
    infoGrid.add(sumField, 1, 0);
    infoGrid.add(heartsLabel, 2, 0);
    infoGrid.add(heartsField, 3, 0);
    infoGrid.add(flushLabel, 0, 1);
    infoGrid.add(queenLabel, 1, 1);

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
    PlayingCard[] cards = hand.getCards();
    for (int y=0; y<numberOfRows; y++) {
      for (int x=0; x<cardsInARow; x++) {
        int cardIndex = y * cardsInARow + x;
        if (cardIndex < numberOfCards) {
          PlayingCardView cardView = new PlayingCardView(cards[cardIndex]);
          cardDisplayArea.add(cardView, x, y);
        }
      }
    }
  }

  /**
   * Event handler for the "Check hand" button.
   */
  private void checkHandHandler() {
    System.out.println("Check hand button clicked");
  }
}
