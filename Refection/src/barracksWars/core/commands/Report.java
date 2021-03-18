package barracksWars.core.commands;

import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public
class Report extends Command{
    @Inject
    private Repository repository;

    public
    Report (String[] data, String commandName) {
        super (data, commandName);
    }


    @Override
    public
    String execute () {
        return this.repository.getStatistics ();
    }
}
