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
    public static class Plateau {
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

        /**
         * Rover Class:
         * Represents the rover on the plateau
         **/
        public static class Rover {
            private int x;
            private int y;
            private Orientation orientation;
            private Plateau plateau;

            public Rover(int x, int y, Orientation orientation, Plateau plateau) {
                this.x = x;
                this.y = y;
                this.orientation = orientation;
                this.plateau = plateau;
            }

            public void move() {
                switch (orientation) {
                    case N:
                        if (plateau.isValidPosition(x, y + 1)) y++;
                        break;
                    case E:
                        if (plateau.isValidPosition(x + 1, y)) x++;
                        break;
                    case S:
                        if (plateau.isValidPosition(x, y - 1)) y--;
                        break;
                    case W:
                        if (plateau.isValidPosition(x - 1, y)) x--;
                        break;
                }
            }

            public void turnL() {
                orientation = orientation.left();
            }

            public void turnR() {
                orientation = orientation.right();
            }

            public void processCommands(String commands) {
                for (int i = 0; i < commands.length(); i++) {
                    char command = commands.charAt(i);
                    switch (command) {
                        case 'L':
                            turnL();
                            break;
                        case 'R':
                            turnR();
                            break;
                        case 'M':
                            move();
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid command: " + command);
                    }
                }
            }
            public String getPosition() {
                return x + " " + y + " " + orientation;
            }
        }
    }

    /**
     * Calculates the total distance traveled by a rover given a sequence of commands.
     * This method doesn't modify the rover's actual position, it just calculates
     * the theoretical distance traveled.
     *  Parameters:
     * ===initialX The initial X coordinate of the rover
     * ===initialY The initial Y coordinate of the rover
     * ===initialOrientation The initial orientation of the rover
     * ===commands The sequence of commands (L, R, M) for the rover
     * return : The total distance traveled by the rover
     */
    public static int CalculateDistanceTraveled(int initialX, int initialY, Orientation initialOrientation, String commands) {
        int x = initialX;
        int y = initialY;
        Orientation orientation = initialOrientation;
        int distance = 0;

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                case 'R':
                    orientation = (command == 'L') ? orientation.left() : orientation.right();
                    break;
                case 'M':
                    switch (orientation) {
                        case N: y++; break;
                        case E: x++; break;
                        case S: y--; break;
                        case W: x--; break;
                    }
                    distance++;
                    break;
            }
        }

        return distance;
    }

    /**
     *  usage of the CalculateDistanceTraveled method.
     */
    public static void DemonstrateDistanceCalculation() {
        String commands = "LMLMLMLMM";
        int distance = CalculateDistanceTraveled(1, 2, Orientation.N, commands);
        System.out.println("Total distance traveled: " + distance + " units");
    }
}

