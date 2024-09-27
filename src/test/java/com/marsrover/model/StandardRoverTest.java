package com.marsrover.model;

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
    void testSetOrientation() {
        rover.setOrientation(Orientation.E);
        assertEquals(Orientation.E, rover.getOrientation());
    }

    @Test
    void testMoveWest() {
        rover.setOrientation(Orientation.W);
        rover.processCommands("M");
        assertEquals("0 2 W", rover.getPosition());
    }
}
