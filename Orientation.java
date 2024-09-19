public enum Orientation {
    //Valid orientations
    N, E, S, W;

    /*
    Move left
     */
    public Orientation left() {
        switch (this) {
            case N:
                return W;
            case E:
                return N;
            case S:
                return E;
            case W:
                return S;
            default:
                throw new IllegalStateException("Unknown orientation");
        }
    }

    /*
    Move right
     */
    public Orientation right() {
        switch (this) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new IllegalStateException("Unknown orientation");
        }
    }

}