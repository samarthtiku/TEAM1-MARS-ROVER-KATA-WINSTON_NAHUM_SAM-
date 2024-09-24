import com.google.inject.Provider;

public class PlateauProvider implements Provider<Plateau> {
    @Override
    public Plateau get() {
        // Returning a default plateau with dimensions 5x5
        return new Plateau(5, 5);
    }
}
