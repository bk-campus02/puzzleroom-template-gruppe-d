package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;


public class FieldIce extends BaseField {

    public FieldIce(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public void initialize() {
    }


    @Override
    public boolean leaveField(Direction direction) {
        return true;
    }

    @Override
    public boolean enterField(Direction direction) {
        BaseField nextField = switch (direction) {
            case Up    -> (BaseField) gameBoard.getField(row - 1, col);
            case Down  -> (BaseField) gameBoard.getField(row + 1, col);
            case Left  -> (BaseField) gameBoard.getField(row, col - 1);
            case Right -> (BaseField) gameBoard.getField(row, col + 1);
        };

        if (nextField == null) {
            gameBoard.getPlayer().walkStep();
            setPlayerPositionToField();
            return true;
        }

        boolean success = nextField.enterField(direction);

        if (success) {

            return true;
        } else {
            gameBoard.getPlayer().walkStep();
            setPlayerPositionToField();
            return true;
        }
    }
}
