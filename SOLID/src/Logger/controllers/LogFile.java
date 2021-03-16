package Logger.controllers;

import Logger.Interfaces.File;

public
class LogFile implements File {
    private int size;
    private StringBuilder content;

    public
    LogFile () {
        this.content = new StringBuilder ();
    }

    @Override
    public
    int getSize () {
        return this.size;
    }

    @Override
    public
    void write (String message) {
            content.append (message);
            this.size += thisMessageSize(message);
    }

    private
    int thisMessageSize (String message) {
        return message.chars ().filter (Character::isAlphabetic).sum ();
    }
}
