package com.marsrover.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractRoverTest {

    private Plateau plateau;
    private TestRover rover;

    private class TestRover extends AbstractRover {
        public TestRover(String id, int x, int y, Orientation orientation, Plateau plateau) {
            super(id, x, y, orientation, plateau);
        }

        @Override
        public void processCommands(String commands) {
            // Implementation not needed for this test
        }

        @Override
        protected void move() {
            // Implementation not needed for this test
        }
    }

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);
        rover = new TestRover("TEST1", 1, 2, Orientation.N, plateau);
    }

    @Test
    void testInitialPosition() {
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    void testTurnLeft() {
        rover.turnLeft();
        assertEquals(Orientation.W, rover.getOrientation());
    }

    @Test
    void testTurnRight() {
        rover.turnRight();
        assertEquals(Orientation.E, rover.getOrientation());
    }

    @Test
    void testGetters() {
        assertEquals("TEST1", rover.getId());
        assertEquals(1, rover.getX());
        assertEquals(2, rover.getY());
        assertEquals(Orientation.N, rover.getOrientation());
        assertEquals(0, rover.getDistanceTraveled());
    }
}
