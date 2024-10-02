import models.*;
import strategies.winningStrategy.ColWinningStrategy;
import strategies.winningStrategy.DiagonalWinningStrategy;
import strategies.winningStrategy.RowWinningStrategy;
import strategies.winningStrategy.WinningStrategy;

import Exception.InvalidMoveException;
import Exception.InvalidBotCountException;
import Exception.InvalidPlayerCountException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidBotCountException, InvalidPlayerCountException, InvalidMoveException {
        System.out.println("Hello world!");

        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Sasi", new Symbol('X'), PlayerType.HUMAN));
        players.add(new Bot("Scaler", new Symbol('O'), BotDifficultyLevel.EASY));

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        GameController gameController = new GameController();
        Game game = gameController.startGame(
                dimension,
                players,
                winningStrategies
        );

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            //1. Print the board.
            //2. Ask user to choose where they want to make the move.
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if (game.getGameState().equals(GameState.ENDED)) {
            gameController.printBoard(game);
            System.out.println(gameController.getWinner(game).getName() + " has WON the game");
        } else {
            System.out.println("Game draw");
        }
    }
}