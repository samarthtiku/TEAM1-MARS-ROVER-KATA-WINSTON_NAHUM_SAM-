public enum Orientation {
    N, E, S, W;

    private static final Orientation[] VALUES = values();

    public Orientation left() {
        return VALUES[(this.ordinal() + 3) % 4];
    }

    public Orientation right() {
        return VALUES[(this.ordinal() + 1) % 4];
    }

    public static Orientation fromString(String input) {
        return valueOf(input.toUpperCase());
    }
}