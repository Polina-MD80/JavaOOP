package barracksWars.core.commands;

import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public
class Add extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public
    Add (String[] data, String commandName) {
        super (data, commandName);
    }




    @Override
    public
    String execute () {
        String unitType  = getData ()[1];
        Unit   unitToAdd = null;
        unitToAdd = this.unitFactory.createUnit (unitType);
        this.repository.addUnit (unitToAdd);
        return unitType + " added!";
    }
}
