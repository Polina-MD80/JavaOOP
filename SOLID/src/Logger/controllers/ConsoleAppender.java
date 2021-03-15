package Logger.controllers;

import Logger.Interfaces.Appender;
import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public
class ConsoleAppender extends BaseAppender {

    public
    ConsoleAppender (Layout layout) {
        super (layout);
    }

    @Override
    public
    void append (String data, ReportLevel reportLevel, String message) {
       super.append (data, reportLevel, message);
    }
}
