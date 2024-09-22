import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoverUtilitiesTest {

    @Test
    void testCalculateDistanceTraveled() {
        // Setting up the initial position and orientation
        int initialX = 1;
        int initialY = 2;
        Orientation initialOrientation = Orientation.N; // Import Orientation class
        String commands = "LMLMLMLMM";

        // Expected distance traveled should be 5 based on 5 move commands
        int expectedDistance = 5;

        // Calculate distance
        int actualDistance = RoverUtilities.calculateDistanceTraveled(initialX, initialY, initialOrientation, commands); // Import RoverUtilities class

        // Assert the result
        assertEquals(expectedDistance, actualDistance, "Distance traveled should match expected");
    }
}
