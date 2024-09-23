import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testLeftTurn() {
        // Test turning left from each direction
        assertEquals(Orientation.W, Orientation.N.left(), "N should turn left to W");
        assertEquals(Orientation.S, Orientation.W.left(), "W should turn left to S");
        assertEquals(Orientation.E, Orientation.S.left(), "S should turn left to E");
        assertEquals(Orientation.N, Orientation.E.left(), "E should turn left to N");
    }

    @Test
    void testRightTurn() {
        // Test turning right from each direction
        assertEquals(Orientation.E, Orientation.N.right(), "N should turn right to E");
        assertEquals(Orientation.S, Orientation.E.right(), "E should turn right to S");
        assertEquals(Orientation.W, Orientation.S.right(), "S should turn right to W");
        assertEquals(Orientation.N, Orientation.W.right(), "W should turn right to N");
    }

    @Test
    void testFullRotation() {
        // Test for 360-degree rotation by turning right 4 times
        Orientation orientation = Orientation.N;
        for (int i = 0; i < 4; i++) {
            orientation = orientation.right();
        }
        assertEquals(Orientation.N, orientation, "A full right rotation should return to N");

        // Test for 360-degree rotation by turning left 4 times
        orientation = Orientation.N;
        for (int i = 0; i < 4; i++) {
            orientation = orientation.left();
        }
        assertEquals(Orientation.N, orientation, "A full left rotation should return to N");
    }
}