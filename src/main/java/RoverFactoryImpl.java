
import com.google.inject.Inject;

/**
 * Implementation of the RoverFactory interface.
 * This class is responsible for creating different types of Rover objects.
 */
public class RoverFactoryImpl implements RoverFactory {

    /**
     * Creates a new Rover based on the specified parameters.
     *
     * @param id           The unique identifier for the rover.
     * @param x            The initial x-coordinate of the rover.
     * @param y            The initial y-coordinate of the rover.
     * @param orientation  The initial orientation of the rover.
     * @param plateau      The plateau on which the rover will operate.
     * @param type         The type of rover to create ("standard" or "jumping").
     * @return             A new AbstractRover object of the specified type.
     * @throws IllegalArgumentException if an unknown rover type is specified.
     */
    @Override
    public AbstractRover createRover(String id, int x, int y, Orientation orientation, Plateau plateau, String type) {
        switch (type.toLowerCase()) {
            case "standard":
                return new StandardRover(id, x, y, orientation, plateau);
            case "jumping":
                return new JumpingRover(id, x, y, orientation, plateau);
            default:
                throw new IllegalArgumentException("Unknown rover type: " + type);
        }
    }
}