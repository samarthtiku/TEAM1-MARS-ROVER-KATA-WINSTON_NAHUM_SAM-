import com.google.inject.Provider;

/**
 * Provider class for creating Plateau instances.
 */
public class PlateauProvider implements Provider<Plateau> {

    @Override
    public Plateau get() {
        // Provide a default plateau of size 5x5, modify as needed
        return new Plateau(5, 5);
    }
}
