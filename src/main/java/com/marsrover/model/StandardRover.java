package com.marsrover.model;


public class StandardRover extends AbstractRover {
    public StandardRover(String id, int x, int y, Orientation orientation, Plateau plateau) {
        super(id, x, y, orientation, plateau);
    }

    @Override
    public void processCommands(String commands) {
        for (char command : commands.toUpperCase().replaceAll("\\s", "").toCharArray()) {
            switch (command) {
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                case 'M': move(); break;
                default: throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }

    @Override
    protected void move() {
        int newX = x + (orientation == Orientation.E ? 1 : (orientation == Orientation.W ? -1 : 0));
        int newY = y + (orientation == Orientation.N ? 1 : (orientation == Orientation.S ? -1 : 0));

        if (plateau.isValidPosition(newX, newY) && !plateau.isOccupied(newX, newY)) {
            plateau.removeRover(x, y);
            x = newX;
            y = newY;
            plateau.placeRover(x, y, id);
            distanceTraveled++;
        } else {
            System.out.println("Warning: Rover " + id + " cannot move. Position blocked or out of bounds.");
        }
    }

    // Setter for orientation to be used in tests
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
