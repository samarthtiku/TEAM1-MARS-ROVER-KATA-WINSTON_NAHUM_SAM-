package com.marsrover.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import static org.mockito.Mockito.*;
import com.marsrover.model.Plateau;
import com.marsrover.service.RoverFactory;
import com.marsrover.service.InputHandler;
import com.marsrover.model.AbstractRover;
import com.marsrover.model.StandardRover;
import com.marsrover.model.Orientation;


class MarsRoverProgramTest {

    @Mock
    private Plateau plateau;
    @Mock
    private RoverFactory roverFactory;
    @Mock
    private InputHandler inputHandler;

    private MarsRoverProgram program;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        program = new MarsRoverProgram(plateau, roverFactory, inputHandler);
    }

    @Test
    void testRun() throws IOException {
        // Mock the user input sequence
        when(inputHandler.getInput())
                .thenReturn("standard 1 2 N")
                .thenReturn("done")
                .thenReturn("LMLMLMLMM")
                .thenReturn("q");

        // Mock rover creation
        AbstractRover mockRover = mock(StandardRover.class);
        when(roverFactory.createRover(anyString(), anyInt(), anyInt(), any(), any(), anyString()))
                .thenReturn(mockRover);

        // Run the program
        program.run();

        // Verify that the rover was created and processed the commands
        verify(roverFactory).createRover(eq("ROVER1"), eq(1), eq(2), eq(Orientation.N), eq(plateau), eq("standard"));
        verify(mockRover).processCommands("LMLMLMLMM");
    }
}
