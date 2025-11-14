package at.edu.c02.puzzleroom;

import at.edu.c02.puzzleroom.commands.CommandLoad;
import at.edu.c02.puzzleroom.fields.FieldOneWay;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FieldOneWayTest {
        @Test
        public void testLeaveFieldPositive() {
            // '^': nur nach oben
            FieldOneWay field = new FieldOneWay(null, '^', 0, 0);

            boolean result = field.leaveField(Direction.Up);

            assertTrue("Bewegung nach oben wird erlaubt",result );
        }

        @Test
        public void testLeaveFieldNegative() {
            // '>': darf nur rechts, absichtlich falsch bzw negativ
            FieldOneWay field = new FieldOneWay(null, '>', 0, 0);

            boolean result = field.leaveField(Direction.Left);

            assertFalse("Bewegung wird blockiert", result);
        }
    }
