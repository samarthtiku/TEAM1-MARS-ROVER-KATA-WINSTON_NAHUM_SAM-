import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    private Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);
    }

    @Test
    void testValidRoverCreation() {
        Rover rover = new Rover(1, 2, Orientation.N, plateau);
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    void testInvalidRoverCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Rover(-1, 2, Orientation.N, plateau));
        assertThrows(IllegalArgumentException.class, () -> new Rover(1, -2, Orientation.N, plateau));
        assertThrows(IllegalArgumentException.class, () -> new Rover(6, 6, Orientation.N, plateau));
    }

    @Test
    void testProcessCommands() {
        Rover rover = new Rover(1, 2, Orientation.N, plateau);
        rover.processCommands("LMLMLMLMM");
        assertEquals("1 3 N", rover.getPosition());

        rover = new Rover(3, 3, Orientation.E, plateau);
        rover.processCommands("MMRMMRMRRM");
        assertEquals("5 1 E", rover.getPosition());
    }

    @Test
    void testInvalidCommand() {
        Rover rover = new Rover(1, 2, Orientation.N, plateau);
        assertThrows(IllegalArgumentException.class, () -> rover.processCommands("LMLMLMLMMX"));
    }

    @Test
    void testMoveOutOfBounds() {
        Rover rover = new Rover(5, 5, Orientation.N, plateau);
        assertThrows(IllegalStateException.class, () -> rover.processCommands("M"));
    }
}