package Logger;

import Logger.Interfaces.Appender;
import Logger.controllers.ConsoleAppender;
import Logger.controllers.FileAppender;
import Logger.controllers.SimpleLayout;
import Logger.Interfaces.Layout;
import Logger.Interfaces.Logger;
import Logger.controllers.XmlLayout;
import Logger.engine.Engine;
import Logger.enums.ReportLevel;
import Logger.logger.LogFile;
import Logger.logger.MessageLogger;
import Logger.Interfaces.File;
public
class Main {
    public static
    void main (String[] args) {
        Engine engine = new Engine ();
        engine.run ();
       /* Layout   simpleLayout    = new SimpleLayout ();
        Appender consoleAppender = new ConsoleAppender (simpleLayout);
        Logger   logger          = new MessageLogger (consoleAppender);

        logger.logError ("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo ("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");*/
       /* Layout xmlLayout = new XmlLayout ();
        Appender consoleAppender = new ConsoleAppender(xmlLayout);
        Logger logger = new MessageLogger(consoleAppender);

        logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
        logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");
*/
      /*  Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile ();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");*/
        /*Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);
        consoleAppender.setReportLevel(ReportLevel.ERROR);

        Logger logger = new MessageLogger(consoleAppender);

        logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
        logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
        logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
        logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");*/
    }
}
