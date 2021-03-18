package barracksWars.core.factories;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public
class CommandInterpretImpl implements CommandInterpreter {
    private
    Repository repository;
    private
    UnitFactory unitFactory;


    public
    CommandInterpretImpl (Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public
    Executable interpretCommand (String[] data, String string) {

        String commandName = data[0];
        commandName = Character.toUpperCase (commandName.charAt (0)) + commandName.substring (1);

        try {
            Class<?>       command = Class.forName ("barracksWars.core.commands." + commandName);
            Constructor<?> constructor = command.getDeclaredConstructor(String[].class, String.class);
            Executable     executable  = (Executable) constructor.newInstance (data,string);
            Field[]        commonFields      = this.getClass ().getDeclaredFields ();
            Field[]        toBeInjectedFields = executable.getClass ().getDeclaredFields ();
            for (Field toBeInjected : toBeInjectedFields) {
                toBeInjected.setAccessible (true);
                if (toBeInjected.isAnnotationPresent (Inject.class)) {
                    for (Field commonField : commonFields) {
                        commonField.setAccessible (true);
                        if (toBeInjected.getName ().equals (commonField.getName ())){
                            toBeInjected.set (executable,commonField.get (this));
                        }
                    }
                }
            }
            return executable;
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException ("Invalid command!");
        }
    }
}
