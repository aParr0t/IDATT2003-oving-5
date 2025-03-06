package edu.ntnu.iir.bidata;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayingCardView extends StackPane {
  public PlayingCardView(PlayingCard card) {
    // Card dimensions
    double width = 100;
    double height = 150;

    // Card background
    Rectangle background = new Rectangle(width, height);
    background.setArcWidth(15);
    background.setArcHeight(15);
    background.setFill(Color.WHITE);
    background.setStroke(Color.BLACK);

    // Card label "<type><value>"
    Text text = new Text(card.getAsString());
    text.setFont(Font.font(20));
    text.setFill(Color.BLACK);

    // Add elements to the card view
    this.getChildren().addAll(background, text);
  }
}
