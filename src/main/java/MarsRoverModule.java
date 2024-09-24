import com.google.inject.AbstractModule;

public class MarsRoverModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Plateau.class).toProvider(PlateauProvider.class);
        bind(RoverFactory.class).to(RoverFactoryImpl.class);
        bind(InputHandler.class).to(ConsoleInputHandler.class);
    }
}
