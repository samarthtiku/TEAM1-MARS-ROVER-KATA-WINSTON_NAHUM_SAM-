package com.marsrover.util;

import com.marsrover.model.AbstractRover;
import com.marsrover.model.Plateau;

import java.util.List;
import java.util.Map;

public class PlateauVisualizer {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public static void visualize(Plateau plateau, List<AbstractRover> rovers) {
        int width = plateau.getWidth();
        int height = plateau.getHeight();
        Map<String, String> grid = plateau.getGrid();

        System.out.println("\nPlateau Visualization:");
        for (int y = height; y >= 0; y--) {
            for (int x = 0; x <= width; x++) {
                String key = x + "," + y;
                if (grid.containsKey(key)) {
                    String roverId = grid.get(key);
                    if (roverId != null) {
                        System.out.print(getColorCode(roverId) + getArrow(roverId, rovers) + "   " + ANSI_RESET);  // Visualize arrows
                    } else {
                        System.out.print(".   ");  // More space between grids
                    }
                } else {
                    System.out.print(".   ");  // More space between grids
                }
            }
            System.out.println();
        }
        System.out.println();

        for (AbstractRover rover : rovers) {
            if (rover.getId() != null) {
                System.out.println(getColorCode(rover.getId()) + rover.getId() + ": " + rover.getPosition() +
                        ", Distance: " + rover.getDistanceTraveled() + ANSI_RESET);
            } else {
                System.out.println("Unknown Rover: " + rover.getPosition() +
                        ", Distance: " + rover.getDistanceTraveled());
            }
        }
    }

    private static String getArrow(String roverId, List<AbstractRover> rovers) {
        for (AbstractRover rover : rovers) {
            if (rover.getId().equals(roverId)) {
                switch (rover.getOrientation()) {
                    case N: return "↑";
                    case S: return "↓";
                    case E: return "→";
                    case W: return "←";
                }
            }
        }
        return " ";  // Default if no match found
    }

    private static String getColorCode(String roverId) {
        if (roverId == null || roverId.isEmpty()) {
            return ANSI_CYAN; // Default color for unknown or null roverId
        }
        switch (roverId.charAt(roverId.length() - 1)) {
            case '1': return ANSI_RED;
            case '2': return ANSI_GREEN;
            case '3': return ANSI_YELLOW;
            case '4': return ANSI_BLUE;
            case '5': return ANSI_PURPLE;
            default: return ANSI_CYAN;
        }
    }
}