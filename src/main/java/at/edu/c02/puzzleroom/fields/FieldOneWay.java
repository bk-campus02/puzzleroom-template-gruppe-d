package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

public class FieldOneWay extends BaseField {

    public FieldOneWay(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public boolean enterField(Direction direction) {

        gameBoard.getPlayer().walkStep();
        setPlayerPositionToField();
        return true;
    }
    @Override
    public void initialize() {
    }


    @Override
    public boolean leaveField(Direction direction) {

        return switch (name) {
            case '^' -> direction == Direction.Up;
            case 'v' -> direction == Direction.Down;
            case '<' -> direction == Direction.Left;
            case '>' -> direction == Direction.Right;
            default -> true;
        };
    }
}
