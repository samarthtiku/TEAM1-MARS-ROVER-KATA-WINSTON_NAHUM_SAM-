package com.marsrover.util;

import com.marsrover.model.AbstractRover;
import com.marsrover.model.Orientation;
import com.marsrover.model.Plateau;
import com.marsrover.model.StandardRover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlateauVisualizerTest {

    private Plateau plateau;
    private AbstractRover rover1;
    private AbstractRover rover2;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        plateau = new Plateau(5, 5);  // Create a 5x5 plateau
        rover1 = new StandardRover("R1", 1, 1, Orientation.N, plateau);  // Place rover at valid position
        rover2 = new StandardRover("R2", 2, 2, Orientation.E, plateau);  // Another rover at a valid position

        // Capture the output from the visualizer
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testVisualize() {
        PlateauVisualizer.visualize(plateau, Arrays.asList(rover1, rover2));

        String output = outContent.toString();

        // Ensure that arrow visualizations are present for correct directions
        assertTrue(output.contains("↑"), "Rover1 (N) should display ↑");
        assertTrue(output.contains("→"), "Rover2 (E) should display →");

        // Ensure proper rover IDs and coordinates are displayed
        assertTrue(output.contains("R1"), "Rover1 should be displayed with ID R1");
        assertTrue(output.contains("R2"), "Rover2 should be displayed with ID R2");
        assertTrue(output.contains("1 1"), "Rover1 should be at (1,1)");
        assertTrue(output.contains("2 2"), "Rover2 should be at (2,2)");
    }

    @Test
    void testAvoidNegativeCoordinates() {
        // Create a rover with negative coordinates, which should be disallowed
        try {
            rover1 = new StandardRover("R1", -1, -1, Orientation.N, plateau);
            fail("Rover should not be allowed to have negative coordinates.");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid rover position: -1, -1", e.getMessage(), "Expected exception for invalid position.");
        }
    }
}
