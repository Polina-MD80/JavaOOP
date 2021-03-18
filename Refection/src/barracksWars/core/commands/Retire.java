package barracksWars.core.commands;

import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public
class Retire extends Command {
    @Inject
    private Repository repository;

    public
    Retire (String[] data, String commandName) {
        super (data, commandName);
    }


    @Override
    public
    String execute () {
          String result;
        try {
            this.repository.removeUnit (getData ()[1]);
           result = getData ()[1] + " retired!";
        } catch (IllegalStateException e) {
         result =  e.getMessage ();

        }return result;

    }
}
