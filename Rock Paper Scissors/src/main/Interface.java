package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Interface extends VBox {

    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    private Label resultLabel;

    public Interface() {
        initUI();
    }

    private void initUI() {
        rockButton = new Button("Rock");
        paperButton = new Button("Paper");
        scissorsButton = new Button("Scissors");

        resultLabel = new Label();
        resultLabel.setAlignment(Pos.CENTER);

        HBox buttonBox = new HBox(10, rockButton, paperButton, scissorsButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        getChildren().addAll(buttonBox, resultLabel);
    }

    public void setRockButtonAction(Runnable action) {
        rockButton.setOnAction(e -> {
            action.run();
        });
    }

    public void setPaperButtonAction(Runnable action) {
        paperButton.setOnAction(e -> {
            action.run();
        });
    }

    public void setScissorsButtonAction(Runnable action) {
        scissorsButton.setOnAction(e -> {
            action.run();
        });
    }

    public void setResultText(String resultText) {
        resultLabel.setText(resultText);
    }
}
