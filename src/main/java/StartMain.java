import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public final class StartMain {
    // ANSI color codes for better visibility and public access
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    private StartMain() {} // Private constructor to prevent instantiation

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "Welcome and Try out Team One Mars Rover KATA Program!" + ANSI_RESET);
        try {
            teamOneRoverSimulation();
        } catch (IOException e) {
            System.out.println(ANSI_RED + "An error occurred while reading input: " + e.getMessage() + ANSI_RESET);
        }
    }

    //  Rover Simulation method
    private static void teamOneRoverSimulation() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(ANSI_YELLOW + "Enter plateau size (width height):" + ANSI_RESET);
            String[] plateauSize = reader.readLine().split(" ");
            int width = Integer.parseInt(plateauSize[0]);
            int height = Integer.parseInt(plateauSize[1]);
            final Plateau plateau = new Plateau(width, height);

            for (int i = 1; i <= 2; i++) {
                System.out.println(ANSI_YELLOW + "Enter Rover " + i + " initial position and orientation (x y N/E/S/W):" + ANSI_RESET);
                String[] roverInput = reader.readLine().split(" ");
                int x = Integer.parseInt(roverInput[0]);
                int y = Integer.parseInt(roverInput[1]);
                Orientation orientation = Orientation.valueOf(roverInput[2]);
                final Rover rover = new Rover(x, y, orientation, plateau);

                System.out.println(ANSI_YELLOW + "Enter commands for Rover " + i + ":" + ANSI_RESET);
                String commands = reader.readLine();
                System.out.println(ANSI_GREEN + "Rover " + i + " initial position: " + rover.getPosition() + ANSI_RESET);
                rover.processCommands(commands);
                System.out.println(ANSI_GREEN + "Rover " + i + " final position: " + rover.getPosition() + ANSI_RESET);
            }
        }
        RoverUtilities.distanceCalculation();
    }
}
