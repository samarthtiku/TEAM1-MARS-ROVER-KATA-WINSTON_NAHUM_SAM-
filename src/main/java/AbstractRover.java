
public abstract class AbstractRover {
    protected int x;
    protected int y;
    protected Orientation orientation;
    protected final Plateau plateau;
    protected int distanceTraveled;
    protected final String id;

    /**
     * Constructor for AbstractRover.
     * @param id Unique identifier for the rover
     * @param x Initial x-coordinate
     * @param y Initial y-coordinate
     * @param orientation Initial orientation
     * @param plateau The plateau on which the rover operates
     */
    public AbstractRover(String id, int x, int y, Orientation orientation, Plateau plateau) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;
        this.distanceTraveled = 0;
        plateau.placeRover(x, y, id);
    }

    /**
     * Process a string of commands to control the rover.
     * @param commands String of commands to process
     */
    public abstract void processCommands(String commands);

    /**
     * Move the rover one step in the current direction.
     */
    protected abstract void move();

    /**
     * Turn the rover 90 degrees to the left.
     */
    protected void turnLeft() {
        orientation = orientation.left();
    }

    /**
     * Turn the rover 90 degrees to the right.
     */
    protected void turnRight() {
        orientation = orientation.right();
    }

    // Getters
    public String getId() { return id; }
    public int getX() { return x; }
    public int getY() { return y; }
    public Orientation getOrientation() { return orientation; }
    public int getDistanceTraveled() { return distanceTraveled; }

    /**
     * Get the current position and orientation of the rover.
     * @return String representation of the rover's position and orientation
     */
    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}