public class Main {
    public static void main(String[] args) {
        System.out.println("Elloo world! ");
    }

    /*
        Nahum's Approach

        Different Classes:

        Plateau:
            Properties: Size (w & h)
            Methods: Constructor for initialization
                     Method to validate positions

         Rover:
            Properties: Current position (x & y), Orientation (N, S, E, W)
            Methods: Constructor to set initial position and orientation
                     Move - to change the position based on the current orientation
                     turnL & turnR - change orientation
                     StringConverter - to processes multiple commands

         ExecuteCommand:
            Performs the operations given an input

         Orientation:
            Manages orientation
            Values: N, S, E, W
         Position:
            Manages position
            Values: X, Y
     */

    /**
     * Plateau Class:
     * Creates bounds and checks if they are valid
     */
    public class Plateau {
        //Initialization of width and height of board
        private int width;
        private int height;
        public Plateau(int width, int height){
            this.width = width;
            this.height = height;
        }
        /*
        Check validity of positions
         */
        public boolean isValidPosition(int x, int y){
            if (x >= 0 && x <= width && y >= 0 && y <= height) {
                return true;
            }
            else{
                return false;
            }
        }
    }

    /**
     * Orientation Class:
     * Valid orientations
     */
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
}