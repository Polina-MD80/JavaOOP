package barracksWars;

import barracksWars.core.factories.CommandInterpretImpl;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        Runnable engine = new Engine(new CommandInterpretImpl (repository,unitFactory));
        engine.run();
    }
}
