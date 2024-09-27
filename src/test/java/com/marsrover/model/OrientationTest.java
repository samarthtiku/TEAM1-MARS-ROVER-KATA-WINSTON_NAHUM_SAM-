package com.marsrover.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testLeftTurn() {
        assertEquals(Orientation.W, Orientation.N.left());
        assertEquals(Orientation.S, Orientation.W.left());
        assertEquals(Orientation.E, Orientation.S.left());
        assertEquals(Orientation.N, Orientation.E.left());
    }

    @Test
    void testRightTurn() {
        assertEquals(Orientation.E, Orientation.N.right());
        assertEquals(Orientation.S, Orientation.E.right());
        assertEquals(Orientation.W, Orientation.S.right());
        assertEquals(Orientation.N, Orientation.W.right());
    }

    @Test
    void testFromString() {
        // Tests for fromString method
        assertEquals(Orientation.N, Orientation.fromString("N"));
        assertEquals(Orientation.E, Orientation.fromString("e"));
        assertEquals(Orientation.S, Orientation.fromString("S"));
        assertEquals(Orientation.W, Orientation.fromString("w"));
        assertThrows(IllegalArgumentException.class, () -> Orientation.fromString("X"));
    }
}
//..