package at.edu.c02.puzzleroom.commands;

import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.Player;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidArgumentsException;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomInvalidMoveException;

public class CommandFastMove implements Command {
    private final String[] arguments;

    public CommandFastMove(String[] arguments) {
        this.arguments = arguments;
    }

    public void execute(GameBoard gameBoard) throws PuzzleRoomException {
        Player player = gameBoard.getPlayer();
        if (player == null) {
            throw new PuzzleRoomInvalidMoveException();
        }

        for (String argument : arguments) {
            boolean success = switch (argument) {
                case "l", "left" -> player.moveLeft();
                case "r", "right" -> player.moveRight();
                case "u", "up" -> player.moveUp();
                case "d", "down" -> player.moveDown();
                default -> throw new PuzzleRoomInvalidArgumentsException();
            };

            if (!success) {
                throw new PuzzleRoomInvalidMoveException();
            }
        }

        CommandShow showCommand = new CommandShow();
        showCommand.execute(gameBoard);
    }
}