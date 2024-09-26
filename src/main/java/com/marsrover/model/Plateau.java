package com.marsrover.model;

import java.util.HashMap;
import java.util.Map;

public class Plateau {
    private int width;
    private int height;
    private Map<String, String> grid; // Tracks rovers on the plateau

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new HashMap<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<String, String> getGrid() {
        return grid;
    }

    public void setGrid(Map<String, String> grid) {
        this.grid = grid;
    }
}
