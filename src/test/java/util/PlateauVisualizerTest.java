import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class PlateauVisualizerTest {

    @Test
    void testVisualize() {
        Plateau plateau = new Plateau(3, 3);
        AbstractRover rover1 = new StandardRover("ROVER1", 1, 1, Orientation.N, plateau);
        AbstractRover rover2 = new JumpingRover("ROVER2", 2, 2, Orientation.E, plateau);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        PlateauVisualizer.visualize(plateau, Arrays.asList(rover1, rover2));

        String output = outContent.toString();
        assertTrue(output.contains("ROVER1"));
        assertTrue(output.contains("ROVER2"));
        assertTrue(output.contains("1 1 N"));
        assertTrue(output.contains("2 2 E"));
    }
}
