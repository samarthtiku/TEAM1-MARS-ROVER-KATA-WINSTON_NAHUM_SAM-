package com.marsrover;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class Main { // Changed to final class
    // ANSI color codes
    private static final String ANSI_RESET = "\u001B[0m";  // Changed to private
    private static final String ANSI_RED = "\u001B[31m";   // Changed to private
    private static final String ANSI_GREEN = "\u001B[32m"; // Changed to private
    private static final String ANSI_YELLOW = "\u001B[33m";// Changed to private
    private static final String ANSI_BLUE = "\u001B[34m";  // Changed to private

    private Main() {} // Added private constructor to prevent instantiation

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "Welcome to the Mars Rover Simulation!" + ANSI_RESET);
        try {
            teamOneRoverSimulation();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "An error occurred while reading input: " + e.getMessage() + ANSI_RESET);
        }
    }

    /*
     * Adding an Interactive simulation of Mars Rover( will update it )
     * This method prompts the user to input : the plateau and rovers,
     * and would generate output based on the commands
     * */
    private static void teamOneRoverSimulation() throws IOException { // Changed to private
        // BufferedReader to read input lines, then split and parse them as needed.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { // Added try-with-resources
            System.out.println(ANSI_YELLOW + "Enter plateau size (width height):" + ANSI_RESET);
            String[] plateauSize = reader.readLine().split(" ");
            int width = Integer.parseInt(plateauSize[0]);
            int height = Integer.parseInt(plateauSize[1]);
            // A new Plateau object with the input dimensions(width, height)
            final Plateau plateau = new Plateau(width, height); // Added final

            // Loop to handle two rovers
            for (int i = 1; i <= 2; i++) {
                // This is a prompt for and read the initial position and orientation of the rover
                System.out.println(ANSI_YELLOW + "Enter Rover " + i + " initial position and orientation (x y N/E/S/W):" + ANSI_RESET);
                String[] roverInput = reader.readLine().split(" ");
                int x = Integer.parseInt(roverInput[0]);
                int y = Integer.parseInt(roverInput[1]);
                Orientation orientation = Orientation.valueOf(roverInput[2]);
                // Creating a new Rover object with the input position and orientation
                final Rover rover = new Rover(x, y, orientation, plateau); // Added final

                // This is a prompt for and to read the commands for the rover
                System.out.println(ANSI_YELLOW + "Enter commands for Rover " + i + ":" + ANSI_RESET);
                String commands = reader.readLine();
                // Displaying the initial position of the rover
                System.out.println(ANSI_GREEN + "Rover " + i + " initial position: " + rover.getPosition() + ANSI_RESET);
                // It will process the commands and move the rover
                rover.processCommands(commands);
                // Finally , it will display the final position of the rover after executing the commands
                System.out.println(ANSI_GREEN + "Rover " + i + " final position: " + rover.getPosition() + ANSI_RESET);
            }
        }
        // Distance calculation
        RoverUtilities.distanceCalculation();
    }
