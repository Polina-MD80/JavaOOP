package Logger.controllers;

import Logger.Interfaces.Appender;
import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public
class ConsoleAppender implements Appender {
    private Layout layout;

    public
    ConsoleAppender (Layout layout) {
        this.layout = layout;
    }




    @Override
    public
    void append (String data, ReportLevel reportLevel, String message) {
        System.out.println (this.layout.format (data, reportLevel, message));
    }
}
