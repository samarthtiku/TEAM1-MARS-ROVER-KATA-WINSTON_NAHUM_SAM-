public final class Rover {
    private int x;
    private int y;
    private Orientation orientation;
    private final Plateau plateau;

    public Rover(int x, int y, Orientation orientation, Plateau plateau) {
        if (!plateau.isValidPosition(x, y)) {
            throw new IllegalArgumentException("Invalid initial position: " + x + ", " + y);
        }
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;
    }

    private void move() {
        final int newX = calculateNewX();
        final int newY = calculateNewY();
        if (plateau.isValidPosition(newX, newY)) {
            x = newX;
            y = newY;
        } else {
            throw new IllegalStateException("Cannot move outside the plateau boundaries.");
        }
    }

    private int calculateNewX() {
        return orientation == Orientation.E ? x + 1 : (orientation == Orientation.W ? x - 1 : x);
    }

    private int calculateNewY() {
        return orientation == Orientation.N ? y + 1 : (orientation == Orientation.S ? y - 1 : y);
    }

    private void turnLeft() {
        orientation = orientation.left();
    }

    private void turnRight() {
        orientation = orientation.right();
    }

    public void processCommands(final String commands) {
        for (final char command : commands.toCharArray()) {
            switch (command) {
                case 'L': turnLeft(); break;
                case 'R': turnRight(); break;
                case 'M': move(); break;
                default: throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}
