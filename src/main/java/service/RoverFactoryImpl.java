import com.google.inject.Inject;

/**
 * Implementation of the RoverFactory interface.
 * This class is responsible for creating different types of Rover objects.
 */
public class RoverFactoryImpl implements RoverFactory {

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
