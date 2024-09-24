import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JumpingRoverTest {

    private Plateau plateau;
    private JumpingRover jumpingRover;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);  // Create a 5x5 plateau
        jumpingRover = new JumpingRover("JUMP1", 1, 2, Orientation.N, plateau);  // Place rover at (1, 2) facing North
        plateau.placeRover(1, 2, "JUMP1");  // Place rover on plateau grid
    }

    @Test
    void testProcessCommands() {
        // Test processing valid commands "LMLMRJ"
        jumpingRover.processCommands("LMLMRJ");
        assertEquals(1, jumpingRover.getX());
        assertEquals(4, jumpingRover.getY());
        assertEquals(Orientation.N, jumpingRover.getOrientation());
    }

    @Test
    void testMoveWithinBounds() {
        // Rover starts at (1, 2) facing North, after move should be at (1, 3)
        jumpingRover.processCommands("M");
        assertEquals(1, jumpingRover.getX());
        assertEquals(3, jumpingRover.getY());
    }

    @Test
    void testJumpWithinBounds() {
        // Rover starts at (1, 2), jump should land at (1, 4) if no obstacles
        jumpingRover.processCommands("J");
        assertEquals(1, jumpingRover.getX());
        assertEquals(4, jumpingRover.getY());
        assertEquals(Orientation.N, jumpingRover.getOrientation());
    }

    @Test
    void testMoveOutOfBounds() {
        // Place rover at the top of the plateau and attempt to move out of bounds
        jumpingRover = new JumpingRover("JUMP2", 0, 5, Orientation.N, plateau);
        plateau.placeRover(0, 5, "JUMP2");
        jumpingRover.processCommands("M");  // Attempt to move North, which is out of bounds

        // Expect the rover to remain at (0, 5)
        assertEquals(0, jumpingRover.getX());
        assertEquals(5, jumpingRover.getY());
    }

    @Test
    void testJumpOutOfBounds() {
        // Place rover at (0, 5) and attempt to jump North out of bounds
        jumpingRover = new JumpingRover("JUMP2", 0, 5, Orientation.N, plateau);
        plateau.placeRover(0, 5, "JUMP2");
        jumpingRover.processCommands("J");  // Jump North out of bounds

        // Expect the rover to remain at (0, 5)
        assertEquals(0, jumpingRover.getX());
        assertEquals(5, jumpingRover.getY());
    }

    @Test
    void testInvalidCommand() {
        // Expect an IllegalArgumentException for an invalid command
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            jumpingRover.processCommands("X");  // X is an invalid command
        });
        String expectedMessage = "Invalid command: X for Rover JUMP1";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void testMultipleCommands() {
        // Test a series of valid commands
        jumpingRover.processCommands("LMLMRJ");
        assertEquals(1, jumpingRover.getX());
        assertEquals(4, jumpingRover.getY());
        assertEquals(Orientation.N, jumpingRover.getOrientation());
    }
}
