public abstract class Rover {
    protected String id;
    protected int x, y;
    protected Orientation orientation;
    protected Plateau plateau;

    public Rover(String id, int x, int y, Orientation orientation, Plateau plateau) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.plateau = plateau;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Orientation getOrientation() { return orientation; }

    public abstract void processCommands(String commands);
}
