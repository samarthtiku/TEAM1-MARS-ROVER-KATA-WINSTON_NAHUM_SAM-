package com.marsrover.application;

import com.marsrover.model.Plateau;
import com.marsrover.model.AbstractRover;
import com.marsrover.model.Orientation;
import com.marsrover.service.InputHandler;
import com.marsrover.service.RoverFactory;
import com.marsrover.util.PlateauVisualizer;
import com.marsrover.util.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarsRoverProgram {
    private final Plateau plateau;
    private final RoverFactory roverFactory;
    private final InputHandler inputHandler;
    private final List<AbstractRover> rovers = new ArrayList<>();

    public MarsRoverProgram(Plateau plateau, RoverFactory roverFactory, InputHandler inputHandler) {
        this.plateau = plateau;
        this.roverFactory = roverFactory;
        this.inputHandler = inputHandler;
    }

    public void run() throws IOException {
        deployRovers();
        controlRovers();
        PlateauVisualizer.visualize(plateau, rovers);
    }

    private void deployRovers() throws IOException {
        int roverCount = 0;
        while (roverCount < Configuration.MAX_ROVERS) {
            System.out.println("Enter rover type (standard/jumping), position and orientation (type x y N/E/S/W) or 'done' to finish:");
            String input = inputHandler.getInput().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                String[] parts = input.split("\\s+");
                String type = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                Orientation orientation = Orientation.valueOf(parts[3].toUpperCase());

                // Ensure no negative coordinates
                if (x < 0 || y < 0) {
                    System.out.println("Invalid coordinates. Please enter non-negative values.");
                    continue;
                }

                String roverId = "R" + (roverCount + 1);
                AbstractRover rover = roverFactory.createRover(roverId, x, y, orientation, plateau, type);
                rovers.add(rover);
                roverCount++;
                System.out.println(roverId + " (" + type + ") deployed successfully.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void controlRovers() throws IOException {
        System.out.println("Use L (left), R (right), M (move) to control rovers. Press 'q' to finish a rover's commands.");
        for (AbstractRover rover : rovers) {
            System.out.println("Controlling " + rover.getId() + ":");
            int attempts = 0;
            while (attempts < Configuration.MAX_ATTEMPTS) {
                try {
                    String commands = inputHandler.getInput().toUpperCase().replaceAll("\\s", "");
                    if (commands.equalsIgnoreCase("q")) {
                        break;
                    }
                    rover.processCommands(commands);

                    // Visualize rover's movements
                    PlateauVisualizer.visualize(plateau, rovers);
                    attempts = 0; // Reset attempts on successful command
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid command. " + e.getMessage());
                    attempts++;
                    int remainingAttempts = Configuration.MAX_ATTEMPTS - attempts;
                    if (remainingAttempts > 0) {
                        System.out.println("You have " + remainingAttempts + " attempts remaining.");
                    } else {
                        System.out.println("Final warning: This is your last attempt before moving to the next rover.");
                    }
                }
            }
        }
    }
}