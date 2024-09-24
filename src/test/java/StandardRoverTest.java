import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StandardRoverTest {

    private Plateau plateau;
    private StandardRover rover;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);
        rover = new StandardRover("ROVER1", 1, 2, Orientation.N, plateau);
    }

    @Test
    void testInitialPosition() {
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    void testMoveNorth() {
        rover.processCommands("M");
        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    void testMoveSouth() {
        rover.setOrientation(Orientation.S);
        rover.processCommands("M");
        assertEquals("1 1 S", rover.getPosition());
    }

    @Test
    void testMoveEast() {
        rover.setOrientation(Orientation.E);
        rover.processCommands("M");
        assertEquals("2 2 E", rover.getPosition());
    }

    @Test
    void testMoveWest() {
        rover.setOrientation(Orientation.W);
        rover.processCommands("M");
        assertEquals("0 2 W", rover.getPosition());
    }

    @Test
    void testTurnLeft() {
        rover.processCommands("L");
        assertEquals("1 2 W", rover.getPosition());
    }

    @Test
    void testTurnRight() {
        rover.processCommands("R");
        assertEquals("1 2 E", rover.getPosition());
    }

    @Test
    void testComplexMovement() {
        rover.processCommands("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    void testMoveOutOfBoundsNorth() {
        rover = new StandardRover("ROVER1", 1, 5, Orientation.N, plateau);
        rover.processCommands("M");
        assertEquals("1 5 N", rover.getPosition());
    }

    @Test
    void testMoveOutOfBoundsSouth() {
        rover = new StandardRover("ROVER1", 1, 0, Orientation.S, plateau);
        rover.processCommands("M");
        assertEquals("1 0 S", rover.getPosition());
    }

    @Test
    void testMoveOutOfBoundsEast() {
        rover = new StandardRover("ROVER1", 5, 1, Orientation.E, plateau);
        rover.processCommands("M");
        assertEquals("5 1 E", rover.getPosition());
    }

    @Test
    void testMoveOutOfBoundsWest() {
        rover = new StandardRover("ROVER1", 0, 1, Orientation.W, plateau);
        rover.processCommands("M");
        assertEquals("0 1 W", rover.getPosition());
    }

    @Test
    void testInvalidCommand() {
        assertThrows(IllegalArgumentException.class, () -> rover.processCommands("X"));
    }

    @Test
    void testGetDistanceTraveled() {
        rover.processCommands("MMRMMM");
        assertEquals(5, rover.getDistanceTraveled());
    }

    @Test
    void testCollisionAvoidance() {
        StandardRover obstacle = new StandardRover("ROVER2", 1, 3, Orientation.S, plateau);
        rover.processCommands("M");
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    void testSetOrientation() {
        rover.setOrientation(Orientation.S);
        assertEquals(Orientation.S, rover.getOrientation());
    }
}
