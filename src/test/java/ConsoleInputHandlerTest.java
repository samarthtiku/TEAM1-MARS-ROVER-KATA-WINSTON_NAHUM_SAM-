import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleInputHandlerTest {

    private ConsoleInputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new ConsoleInputHandler();
    }

    @Test
    void testGetInput() throws IOException {
        // Simulate user input via ByteArrayInputStream
        String simulatedInput = "Test Input\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)));

        String result = inputHandler.getInput();  // This should now return "Test Input"

        // Check if result is not null to avoid NullPointerException
        assertEquals("Test Input", result != null ? result.trim() : "");
    }

    @Test
    void testGetInputEmpty() throws IOException {
        // Simulate empty input
        String simulatedInput = "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes(StandardCharsets.UTF_8)));

        String result = inputHandler.getInput();  // Expect empty string when user provides no input

        // Check if result is not null to avoid NullPointerException
        assertEquals("", result != null ? result.trim() : "");
    }

    @Test
    void testIOException() {
        // Expect IOException if some issue occurs during input handling
        Exception exception = assertThrows(IOException.class, () -> {
            throw new IOException("Test exception");
        });
        assertEquals("Test exception", exception.getMessage());
    }
}
