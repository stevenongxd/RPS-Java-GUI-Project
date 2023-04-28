package main;

public class Controller {

    private Controller.Move computerMove;

    public enum Move {
        ROCK,
        PAPER,
        SCISSORS
    }

    public enum Result {
        WIN,
        LOSS,
        TIE
    }

    public Result play(Move playerMove) {
        computerMove = generateComputerMove();
        if (playerMove == computerMove) {
            return Result.TIE;
        } else if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS)
                || (playerMove == Move.PAPER && computerMove == Move.ROCK)
                || (playerMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            return Result.WIN;
        } else {
            return Result.LOSS;
        }
    }

    private Move generateComputerMove() {
        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                return Move.ROCK;
            case 1:
                return Move.PAPER;
            default:
                return Move.SCISSORS;
        }
    }

    public Move getComputerMove() {
        return computerMove;
    }
}
