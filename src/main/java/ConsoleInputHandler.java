import com.google.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputHandler implements InputHandler {
    private final BufferedReader reader;

    @Inject
    public ConsoleInputHandler() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getInput() throws IOException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            throw e;
        }
    }

    // Optionally, you could add this method if you plan to close the reader when done
    public void close() throws IOException {
        reader.close();
    }
}
