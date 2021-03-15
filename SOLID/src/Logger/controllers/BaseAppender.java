package Logger.controllers;

import Logger.Interfaces.Appender;
import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public abstract
class BaseAppender implements Appender {
    private Layout layout;

    protected
    BaseAppender (Layout layout) {
        this.layout = layout;
    }

    public
    void append (String data, ReportLevel reportLevel, String message) {
        System.out.println (this.layout.format (data, reportLevel, message));
    }
}
