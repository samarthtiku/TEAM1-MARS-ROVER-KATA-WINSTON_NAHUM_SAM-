package com.marsrover.model;

public enum Orientation {
    N, E, S, W;

    private static final Orientation[] VALUES = values();

    public Orientation left() {
        return VALUES[(this.ordinal() + 3) % 4];  // Turn 90 degrees left
    }

    public Orientation right() {
        return VALUES[(this.ordinal() + 1) % 4];  // Turn 90 degrees right
    }

    // Add this fromString method to convert string input to an Orientation enum value
    public static Orientation fromString(String input) {
        try {
            return Orientation.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid orientation: " + input);
        }
    }
}
