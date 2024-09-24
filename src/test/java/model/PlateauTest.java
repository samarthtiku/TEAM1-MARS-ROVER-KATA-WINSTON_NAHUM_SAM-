import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testValidPlateauCreation() {
        Plateau plateau = new Plateau(5, 5);
        assertEquals(5, plateau.getWidth());
        assertEquals(5, plateau.getHeight());
    }

    @Test
    void testInvalidPlateauCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Plateau(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Plateau(5, 0));
        assertThrows(IllegalArgumentException.class, () -> new Plateau(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Plateau(Configuration.MAX_PLATEAU_SIZE + 1, 5));
    }

    @Test
    void testIsValidPosition() {
        Plateau plateau = new Plateau(5, 5);
        assertTrue(plateau.isValidPosition(0, 0));
        assertTrue(plateau.isValidPosition(5, 5));
        assertFalse(plateau.isValidPosition(-1, 3));
        assertFalse(plateau.isValidPosition(6, 3));
    }

    @Test
    void testPlaceAndRemoveRover() {
        Plateau plateau = new Plateau(5, 5);
        plateau.placeRover(1, 1, "ROVER1");
        assertTrue(plateau.isOccupied(1, 1));
        plateau.removeRover(1, 1);
        assertFalse(plateau.isOccupied(1, 1));
    }
}
