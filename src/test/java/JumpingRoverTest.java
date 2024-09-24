import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JumpingRoverTest {

    private JumpingRover jumpingRover;
    private Plateau plateau;

    @BeforeEach
    public void setUp() {
        plateau = new Plateau(5, 5); // Create a 5x5 plateau
        jumpingRover = new JumpingRover("Rover1", 1, 1, Orientation.NORTH, plateau);
    }

    @Test
    public void testProcessCommands() {
        // Define the expected result after processing commands
        jumpingRover.processCommands("LMLMLM"); // Example commands
        assertEquals(new Position(0, 0), jumpingRover.getPosition(), "Rover should process commands correctly.");
    }

    @Test
    public void testJumpOverObstacle() {
        plateau.addObstacle(2, 2); // Add an obstacle at position (2, 2)
        jumpingRover.setPosition(1, 1);
        boolean jumpedOver = jumpingRover.jumpOverObstacle(plateau, "J");
        assertTrue(jumpedOver, "Rover should have jumped over the obstacle.");
        assertEquals(new Position(3, 1), jumpingRover.getPosition(), "Rover should be at position (3, 1) after jumping.");
    }
}
