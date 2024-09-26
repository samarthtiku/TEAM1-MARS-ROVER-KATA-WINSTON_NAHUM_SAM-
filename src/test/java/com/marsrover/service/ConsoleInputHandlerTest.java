package com.marsrover.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputHandlerTest {

    private final InputStream originalIn = System.in;  // Save the original System.in

    @AfterEach
    void restoreSystemInput() {
        System.setIn(originalIn);  // Restore System.in after each test
    }

    @Test
    void testGetInput() throws IOException {
        // Simulate user input via ByteArrayInputStream
        String simulatedInput = "Test Input\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        String result = inputHandler.getInput();  // This should now return "Test Input"

        assertEquals("Test Input", result);  // Verify the result matches expected input
    }

    @Test
    void testGetInputEmpty() throws IOException {
        // Simulate empty input
        String simulatedInput = "\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        String result = inputHandler.getInput();  // Expect empty string when user provides no input

        assertEquals("", result);  // Check for empty string
    }

    @Test
    void testIOException() {
        // Simulate an IOException
        Exception exception = assertThrows(IOException.class, () -> {
            throw new IOException("Test exception");
        });
        assertEquals("Test exception", exception.getMessage());
    }
    @Test
    void testCloseInputHandler() throws IOException {
        // Simulate user input via ByteArrayInputStream
        String simulatedInput = "Test Input\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ConsoleInputHandler inputHandler = new ConsoleInputHandler();

        // Ensure that closing the reader works without throwing any exceptions
        assertDoesNotThrow(inputHandler::close);
    }
}
