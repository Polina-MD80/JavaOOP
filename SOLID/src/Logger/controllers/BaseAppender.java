package Logger.controllers;

import Logger.Interfaces.Appender;
import Logger.Interfaces.File;
import Logger.Interfaces.Layout;
import Logger.enums.ReportLevel;

public abstract
class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    protected
    BaseAppender (Layout layout) {
        this.layout = layout;
    }

    public
    ReportLevel getReportLevel () {
        return reportLevel;
    }

    public
    void append (String data, ReportLevel reportLevel, String message) {
        System.out.println (this.layout.format (data, reportLevel, message));
    }
    public void setReportLevel(ReportLevel reportLevel){
        this.reportLevel = reportLevel;
    }



}
