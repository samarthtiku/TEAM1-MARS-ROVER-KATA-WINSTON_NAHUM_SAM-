package com.marsrover.model;

import com.marsrover.util.Configuration;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
    private final int width;
    private final int height;
    private final Map<String, String> grid = new HashMap<>();

    public Plateau(int width, int height) {
        if (width <= 0 || height <= 0 || width > Configuration.MAX_PLATEAU_SIZE || height > Configuration.MAX_PLATEAU_SIZE) {
            throw new IllegalArgumentException("Invalid plateau dimensions. Must be positive and not exceed " + Configuration.MAX_PLATEAU_SIZE);
        }
        this.width = width;
        this.height = height;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }

    public void placeRover(int x, int y, String roverId) {
        grid.put(x + "," + y, roverId);
    }

    public void removeRover(int x, int y) {
        grid.remove(x + "," + y);
    }

    public boolean isOccupied(int x, int y) {
        return grid.containsKey(x + "," + y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<String, String> getGrid() {
        return new HashMap<>(grid);
    }
}
