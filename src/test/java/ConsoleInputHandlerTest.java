import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputHandlerTest {

    private ConsoleInputHandler inputHandler;

    @BeforeEach
    void setUp() {
        inputHandler = new ConsoleInputHandler();
        inputHandler.setSimulatedInput("");  // Set an initial value for the input
    }

    @Test
    void testGetInput() {
        String simulatedInput = "Test Input";
        inputHandler.setSimulatedInput(simulatedInput);

        String result = inputHandler.getInput();
        assertNotNull(result, "Input should not be null");
        assertEquals("Test Input", result, "Expected input 'Test Input' but got " + result);
    }

    @Test
    void testGetInputEmpty() {
        inputHandler.setSimulatedInput("");

        String result = inputHandler.getInput();
        assertEquals("", result, "Expected empty string but got " + result);
    }
}
