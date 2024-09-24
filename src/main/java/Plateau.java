public class Plateau {
    private int width;
    private int height;
    private boolean[][] obstacles;

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new boolean[width][height];
    }

    public void addObstacle(int x, int y) {
        obstacles[x][y] = true;
    }

    public boolean hasObstacle(int x, int y) {
        return obstacles[x][y];
    }
}
