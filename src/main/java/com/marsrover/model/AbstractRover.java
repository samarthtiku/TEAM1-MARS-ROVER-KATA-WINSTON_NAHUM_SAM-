package com.marsrover.model;

public abstract class AbstractRover {
    protected int x;
    protected int y;
    protected Orientation orientation;
    protected final Plateau plateau;
    protected int distanceTraveled;
    protected final String id;

    public AbstractRover(String id, int x, int y, Orientation orientation, Plateau plateau) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;
        this.distanceTraveled = 0;
        plateau.placeRover(x, y, id);
    }

    public abstract void processCommands(String commands);

    protected abstract void move();

    protected void turnLeft() {
        orientation = orientation.left();
    }

    protected void turnRight() {
        orientation = orientation.right();
    }

    // Prevent negative coordinates and handle multiple rovers on the same spot
    protected void moveRover(int newX, int newY) {
        if (newX >= 0 && newY >= 0 && plateau.isValidPosition(newX, newY) && !plateau.isOccupied(newX, newY)) {
            plateau.removeRover(x, y);
            x = newX;
            y = newY;
            plateau.placeRover(x, y, id);
            distanceTraveled++;
        } else {
            System.out.println("Invalid move for rover " + id + ". Position out of bounds or occupied.");
        }
    }

    public String getId() {
        return id;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}