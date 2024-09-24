import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverFactoryTest {

    private RoverFactory roverFactory;
    private Plateau plateau;

    @BeforeEach
    void setUp() {
        roverFactory = new RoverFactoryImpl();
        plateau = new Plateau(5, 5);
    }

    @Test
    void testCreateStandardRover() {
        AbstractRover rover = roverFactory.createRover("ROVER1", 1, 2, Orientation.N, plateau, "standard");
        assertTrue(rover instanceof StandardRover);
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    void testCreateJumpingRover() {
        AbstractRover rover = roverFactory.createRover("ROVER1", 1, 2, Orientation.N, plateau, "jumping");
        assertTrue(rover instanceof JumpingRover);
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    void testCreateUnknownRoverType() {
        assertThrows(IllegalArgumentException.class, () ->
                roverFactory.createRover("ROVER1", 1, 2, Orientation.N, plateau, "flying"));
    }
}