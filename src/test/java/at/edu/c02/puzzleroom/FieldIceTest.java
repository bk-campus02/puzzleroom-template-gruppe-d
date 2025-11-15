package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandLoad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FieldIceTest {

    @Test
    public void testIceSlidesUntilNormalField() throws Exception {
        GameBoardImpl board = new GameBoardImpl();
        CommandLoad load = new CommandLoad(new String[]{"task-b.maze"});
        load.execute(board);

        Player player = board.getPlayer();

        // rutschen über beide @
        boolean firstMove = player.moveRight();
        assertTrue("Erster move rechts sollte erfolgreich sein", firstMove);

        // kontrolle der position
        assertEquals("Spieler sollte in Zeile 1 sein.", 1, player.getRow());
        assertEquals("Spieler sollte in Spalte 4 links vom ziel stehen.", 4, player.getCol());

        // rechts in ziel
        boolean secondMove = player.moveRight();
        assertTrue("Zweiter move rechts sollte erfolgreich sein.", secondMove);

        assertTrue("Spiel sollte nun beendet sein", board.isFinished());
    }

    @Test
    public void testIceMoveBlockedAfterFinish() throws Exception {
        GameBoardImpl board = new GameBoardImpl();

        CommandLoad load = new CommandLoad(new String[]{"task-b.maze"});
        load.execute(board);

        Player player = board.getPlayer();

        // lösung = rr
        assertTrue("moveRight sollte möglich sein.", player.moveRight());
        assertTrue("moveRight sollte möglich sein.", player.moveRight());
        assertTrue("Spiel muss beendet sein.", board.isFinished());

        // negativtest: nach finish darf ein move nicht mehr möglich sein
        boolean moveAfterFinish = player.moveRight();

        assertFalse("Nach Finish darf moveRight keine Bewegung mehr erlauben.", moveAfterFinish);
    }
}
