import javax.annotation.processing.RoundEnvironment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Running {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(5, 5);


        Rover rover = new Rover(3, 3, Orientation.E, plateau);


        String commands = "MMRMMRMRRM";n
        rover.processCommands(commands);

        // Output the rover's position after processing the commands
        System.out.println(rover.getPosition());




    }
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

    /**
     * Orientation Class:
     * Valid orientations
     */

        /**
         * Rover Class:
         * Represents the rover on the plateau
         **/


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
   /* public static int CalculateDistanceTraveled(int initialX, int initialY, Orientation initialOrientation, String commands) {
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
   /* public static void DistanceCalculation() {
        String commands = "LMLMLMLMM";
        int distance = CalculateDistanceTraveled(1, 2, Orientation.N, commands);
        System.out.println("Total distance traveled: " + distance + " units");
    }
    /*
     * Adding an Interactive simulation of Mars Rover( will update it )
     * This method prompts the user to input : the plateau and rovers,
     * and would generate output based on the commands
     * */
  /*  public static void TeamOneRoverSimulation() throws IOException {
        // BufferedReader to read input lines, then split and parse them as needed.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter plateau size (width height):");
        String[] plateauSize = reader.readLine().split(" ");
        int width = Integer.parseInt(plateauSize[0]);
        int height = Integer.parseInt(plateauSize[1]);
        // A new Plateau object with the input dimensions(width, height)
        Plateau plateau = new Plateau(width, height);

        // Loop to handle two rovers
        for (int i = 1; i <= 2; i++) {
            // This is a prompt for and read the initial position and orientation of the rover
            System.out.println("Enter Rover " + i + " initial position and orientation (x y N/E/S/W):");
            String[] roverInput = reader.readLine().split(" ");
            int x = Integer.parseInt(roverInput[0]);
            int y = Integer.parseInt(roverInput[1]);
            Orientation orientation = Orientation.valueOf(roverInput[2]);
            // Creating a new Rover object with the input position and orientation
            Orientation.Rover rover = new Orientation.Rover(x, y, orientation, plateau);

            // This is a prompt for and to read the commands for the rover
            System.out.println("Enter commands for Rover " + i + ":");
            String commands = reader.readLine();
            // Displaying the initial position of the rover
            System.out.println("Rover " + i + " initial position: " + rover.getPosition());
            // It will process the commands and move the rover
            rover.processCommands(commands);
            // Finally , it will display the final position of the rover after executing the commands
            System.out.println("Rover " + i + " final position: " + rover.getPosition());
        }
        // Close the BufferedReader
        reader.close();

        // Distance calculation
      //  DistanceCalculation();
}
*/



