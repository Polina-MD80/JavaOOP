package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public
class Retire extends Command {
    public
    Retire (String[] data, Repository repository, UnitFactory unitFactory) {
        super (data, repository, unitFactory);
    }

    @Override
    public
    String execute () {
          String result;
        try {
            getRepository ().removeUnit (getData ()[1]);
           result = getData ()[1] + " retired!";
        } catch (IllegalStateException e) {
         result =  e.getMessage ();

        }return result;

    }
}
