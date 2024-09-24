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

    public String getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getPosition() {
        return x + " " + y + " " + orientation;
    }
}
