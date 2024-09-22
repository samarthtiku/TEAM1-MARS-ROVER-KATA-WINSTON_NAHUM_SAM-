public final class Plateau {
    private final int width;
    private final int height;

    public Plateau(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Plateau dimensions must be positive.");
        }
        this.width = width;
        this.height = height;
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x <= width && y >= 0 && y <= height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
