package com.marsrover.model;


public class JumpingRover extends AbstractRover {
    public JumpingRover(String id, int x, int y, Orientation orientation, Plateau plateau) {
        super(id, x, y, orientation, plateau);
    }

    @Override
    public void processCommands(String commands) {
        // Check if commands are null or empty to avoid unnecessary processing
        if (commands == null || commands.isEmpty()) {
            System.out.println("No commands to process for Rover " + id);
            return;
        }

        // Log initial position
        System.out.println("Processing commands for Rover " + id + " at initial position (" + x + ", " + y + ")");

        // Process each command after sanitizing the input (removing spaces, converting to upper case)
        for (char command : commands.toUpperCase().replaceAll("\\s", "").toCharArray()) {
            switch (command) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
                case 'J':
                    jump();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + command + " for Rover " + id);
            }
        }
    }

    @Override
    protected void move() {
        int newX = x + (orientation == Orientation.E ? 1 : (orientation == Orientation.W ? -1 : 0));
        int newY = y + (orientation == Orientation.N ? 1 : (orientation == Orientation.S ? -1 : 0));

        // Log move attempt
        System.out.println("Rover " + id + " attempting to move from (" + x + ", " + y + ") to (" + newX + ", " + newY + ")");

        // Check if the new position is valid within the plateau's bounds
        if (plateau.isValidPosition(newX, newY)) {
            plateau.removeRover(x, y);  // Remove rover from the old position
            x = newX;
            y = newY;
            plateau.placeRover(x, y, id);  // Place rover at the new position
            distanceTraveled++;  // Increment the distance traveled

            // Log successful move
            System.out.println("Rover " + id + " successfully moved to (" + x + ", " + y + ")");
        } else {
            System.out.println("Warning: Rover " + id + " cannot move. Position out of bounds.");
        }
    }

    private void jump() {
        // Calculate jump distance based on the orientation (2 units forward)
        int newX = x + (orientation == Orientation.E ? 2 : (orientation == Orientation.W ? -2 : 0));
        int newY = y + (orientation == Orientation.N ? 2 : (orientation == Orientation.S ? -2 : 0));

        // Log jump attempt
        System.out.println("Rover " + id + " attempting to jump from (" + x + ", " + y + ") to (" + newX + ", " + newY + ")");

        // Check if the jump is valid within the plateau's bounds
        if (plateau.isValidPosition(newX, newY)) {
            plateau.removeRover(x, y);  // Remove rover from current position
            x = newX;
            y = newY;
            plateau.placeRover(x, y, id);  // Place rover at the new position
            distanceTraveled += 2;  // Increment distance by 2 units

            // Log successful jump
            System.out.println("Rover " + id + " successfully jumped to (" + x + ", " + y + ")");
        } else {
            System.out.println("Warning: Rover " + id + " cannot jump. Position out of bounds.");
        }
    }
}