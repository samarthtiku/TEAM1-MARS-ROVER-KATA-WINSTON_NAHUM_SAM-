import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MarsRoverProgramTest {

    @Mock
    private Plateau plateau;
    @Mock
    private RoverFactory roverFactory;
    @Mock
    private InputHandler inputHandler;
    @Mock
    private AbstractRover mockRover;

    private MarsRoverProgram program;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        program = new MarsRoverProgram(plateau, roverFactory, inputHandler);
    }

    @Test
    void testRun() throws IOException {
        // Mock user inputs
        when(inputHandler.getInput())
                .thenReturn("standard 1 2 N")
                .thenReturn("done")
                .thenReturn("LMLMLMLMM")
                .thenReturn("q");

        // Mock rover creation and set ID
        when(roverFactory.createRover(anyString(), anyInt(), anyInt(), any(), any(), anyString()))
                .thenReturn(mockRover);
        when(mockRover.getId()).thenReturn("ROVER1");

        program.run();

        // Verify that the rover was created and commands were processed
        verify(roverFactory).createRover(eq("ROVER1"), eq(1), eq(2), eq(Orientation.N), eq(plateau), eq("standard"));
        verify(mockRover).processCommands("LMLMLMLMM");
    }
}
