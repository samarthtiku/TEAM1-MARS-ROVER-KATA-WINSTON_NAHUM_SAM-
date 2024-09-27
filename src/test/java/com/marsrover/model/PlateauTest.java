package com.marsrover.model;

import com.marsrover.service.RoverFactory;
import com.marsrover.service.RoverFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    private RoverFactory roverFactory;

    @BeforeEach
    void setUp() {
        roverFactory = new RoverFactoryImpl();
    }

    @Test
    void testValidPlateauCreation() {
        Plateau plateau = new Plateau(5, 5);
        assertEquals(5, plateau.getWidth());
        assertEquals(5, plateau.getHeight());
    }

    @Test
    void testInvalidPlateauCreation() {
        // Check for invalid width and height
        assertThrows(IllegalArgumentException.class, () -> new Plateau(0, 5)); // Width is 0
        assertThrows(IllegalArgumentException.class, () -> new Plateau(5, 0)); // Height is 0
        assertThrows(IllegalArgumentException.class, () -> new Plateau(-1, 5)); // Negative width
        assertThrows(IllegalArgumentException.class, () -> new Plateau(5, -1)); // Negative height
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

    @Test
    void testCollisionAvoidance() {
        Plateau plateau = new Plateau(5, 5);
        plateau.placeRover(2, 2, "R1");
        plateau.placeRover(2, 3, "R2");

        AbstractRover rover1 = roverFactory.createRover("R1", 2, 2, Orientation.N, plateau, "standard");
        AbstractRover rover2 = roverFactory.createRover("R2", 2, 3, Orientation.S, plateau, "standard");

        rover1.processCommands("M"); // This move should be blocked by R2
        rover2.processCommands("M"); // This move should be blocked by R1

        assertEquals("2 2 N", rover1.getPosition());
        assertEquals("2 3 S", rover2.getPosition());
    }
     @Test
     void testMultipleRovers() {
         // Set up the plateau
         Plateau plateau = new Plateau(5, 5);

         // Place two rovers on the plateau
         plateau.placeRover(1, 1, "ROVER1");
         plateau.placeRover(2, 2, "ROVER2");

         // Check if the positions are correctly occupied
         assertTrue(plateau.isOccupied(1, 1), "ROVER1 should occupy position (1, 1)");
         assertTrue(plateau.isOccupied(2, 2), "ROVER2 should occupy position (2, 2)");

         // Ensure the third position (3, 3) is not occupied
         assertFalse(plateau.isOccupied(3, 3), "No rover should occupy position (3, 3)");
     }

}

