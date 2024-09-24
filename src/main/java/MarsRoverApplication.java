import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;  // Ensure this is imported

/**
 * Entry point for the Mars Rover Application.
 * This application simulates the deployment and control of rovers on a plateau.
 */
public class MarsRoverApplication {

    public static void main(String[] args) {
        // Create an injector using Guice for dependency injection
        Injector injector = Guice.createInjector(new MarsRoverModule());

        // Get an instance of MarsRoverProgram from the injector
        MarsRoverProgram program = injector.getInstance(MarsRoverProgram.class);

        try {
            // Run the Mars Rover program
            program.run();
        } catch (IOException e) {
            // Handle any I/O exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
