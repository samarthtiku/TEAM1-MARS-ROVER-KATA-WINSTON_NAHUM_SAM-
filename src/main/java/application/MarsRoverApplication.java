import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;

public class MarsRoverApplication {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MarsRoverModule());
        MarsRoverProgram program = injector.getInstance(MarsRoverProgram.class);
        try {
            program.run();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
