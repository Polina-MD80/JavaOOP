package Logger;

import Logger.Interfaces.Appender;
import Logger.controllers.ConsoleAppender;
import Logger.controllers.SimpleLayout;
import Logger.Interfaces.Layout;
import Logger.Interfaces.Logger;
import Logger.logger.MessageLogger;

public
class Main {
    public static
    void main (String[] args) {
        Layout   simpleLayout    = new SimpleLayout ();
        Appender consoleAppender = new ConsoleAppender (simpleLayout);
        Logger   logger          = new MessageLogger (consoleAppender);

        logger.logError ("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo ("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");
    }
}
