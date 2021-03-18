package barracksWars.core.commands;

import barracksWars.interfaces.Executable;



public abstract
class Command implements Executable {
    private String[] data = new String[2];

    public
    Command (String[] data, String commandName) {
        this.data = data;
    }

    public
    String[] getData () {
        return data;
    }
}
