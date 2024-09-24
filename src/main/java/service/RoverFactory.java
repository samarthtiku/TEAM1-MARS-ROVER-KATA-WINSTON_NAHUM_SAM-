public interface RoverFactory {
    AbstractRover createRover(String id, int x, int y, Orientation orientation, Plateau plateau, String type);
}
