package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Interface gameBoard = new Interface();
        Controller gameLogic = new Controller();

        gameBoard.setRockButtonAction(() -> {
            Controller.Result result = gameLogic.play(Controller.Move.ROCK);
            displayResult(gameBoard, result, gameLogic.getComputerMove());
        });

        gameBoard.setPaperButtonAction(() -> {
            Controller.Result result = gameLogic.play(Controller.Move.PAPER);
            displayResult(gameBoard, result, gameLogic.getComputerMove());
        });

        gameBoard.setScissorsButtonAction(() -> {
            Controller.Result result = gameLogic.play(Controller.Move.SCISSORS);
            displayResult(gameBoard, result, gameLogic.getComputerMove());
        });

        Scene scene = new Scene(gameBoard, 300, 350);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void displayResult(Interface gameBoard, Controller.Result result, Controller.Move computerMove) {
        String resultText;
        String computerMoveText = computerMove.toString().toLowerCase();
        switch (result) {
            case WIN:
                resultText = "You win! The computer chose " + computerMoveText + ".";
                break;
            case LOSS:
                resultText = "You lose! The computer chose " + computerMoveText + ".";
                break;
            default:
                resultText = "It's a tie! The computer chose " + computerMoveText + ".";
                break;
        }
        gameBoard.setResultText(resultText);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
