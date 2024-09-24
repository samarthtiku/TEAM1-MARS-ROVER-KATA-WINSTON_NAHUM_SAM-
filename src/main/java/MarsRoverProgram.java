
import com.google.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRoverProgram {
    private final Plateau plateau;
    private final RoverFactory roverFactory;
    private final InputHandler inputHandler;
    private final List<AbstractRover> rovers = new ArrayList<>();

    @Inject
    public MarsRoverProgram(Plateau plateau, RoverFactory roverFactory, InputHandler inputHandler) {
        this.plateau = plateau;
        this.roverFactory = roverFactory;
        this.inputHandler = inputHandler;
    }

    public void run() throws IOException {
        deployRovers();
        controlRovers();
        PlateauVisualizer.visualize(plateau, rovers);
    }

    private void deployRovers() throws IOException {
        int roverCount = 0;
        while (roverCount < Configuration.MAX_ROVERS) {
            System.out.println("Enter rover type (standard/jumping), position and orientation (type x y N/E/S/W) or 'done' to finish:");
            String input = inputHandler.getInput().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                String[] parts = input.split("\\s+");
                String type = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                Orientation orientation = Orientation.valueOf(parts[3].toUpperCase());
                String roverId = "ROVER" + (roverCount + 1);
                AbstractRover rover = roverFactory.createRover(roverId, x, y, orientation, plateau, type);
                rovers.add(rover);
                roverCount++;
                System.out.println(roverId + " (" + type + ") deployed successfully.");
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private void controlRovers() throws IOException {
        System.out.println("Use N (up), W (left), S (down), E (right), J (jump for jumping rovers) to move rovers. Press 'q' to finish a rover's commands.");
        for (AbstractRover rover : rovers) {
            System.out.println("Controlling " + rover.getId() + ":");
            int attempts = 0;
            while (attempts < Configuration.MAX_ATTEMPTS) {
                try {
                    String commands = inputHandler.getInput();
                    if (commands.equalsIgnoreCase("q")) {
                        break;
                    }
                    rover.processCommands(commands);
                    PlateauVisualizer.visualize(plateau, rovers);
                    attempts = 0; // Reset attempts on successful command
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid command. " + e.getMessage());
                    attempts++;
                    int remainingAttempts = Configuration.MAX_ATTEMPTS - attempts;
                    if (remainingAttempts > 0) {
                        System.out.println("You have " + remainingAttempts + " attempts remaining.");
                    } else {
                        System.out.println("Final warning: This is your last attempt before moving to the next rover.");
                    }
                }
            }
        }
    }
}