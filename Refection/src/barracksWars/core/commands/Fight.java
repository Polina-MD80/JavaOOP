package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public
class Fight extends Command{


    public
    Fight (String[] data, String commandName) {
        super (data, commandName);
    }

    @Override
    public
    String execute () {
        return "fight";
    }
}
