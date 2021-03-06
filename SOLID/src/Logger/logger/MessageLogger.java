package Logger.logger;

import Logger.Interfaces.Appender;
import Logger.Interfaces.Logger;
import Logger.enums.ReportLevel;

import java.util.Arrays;
import java.util.List;

public
class MessageLogger implements Logger {
    private
    List<Appender> appenders;

    public
    MessageLogger (Appender... appenders) {
        this.appenders = Arrays.asList (appenders);
    }

    @Override
    public
    void logInfo (String date, String message) {
        callAllAppenders (date, ReportLevel.INFO,message);
    }

    @Override
    public
    void logWarning (String date, String message) {
        callAllAppenders (date, ReportLevel.WARNING,message);
    }

    @Override
    public
    void logError (String date, String message) {
        callAllAppenders (date, ReportLevel.ERROR,message);
    }

    @Override
    public
    void logCritical (String date, String message) {
        callAllAppenders (date, ReportLevel.CRITICAL,message);
    }

    @Override
    public
    void logFatal (String date, String message) {
        callAllAppenders (date, ReportLevel.FATAL,message);
    }

    @Override
    public
    String getLogInfo () {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : this.appenders) {
            sb.append(appender).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private void callAllAppenders(String date, ReportLevel reportLevel, String message){
        for (Appender appender : appenders) {
            appender.appendMessage (date,reportLevel,message);
        }
    }
}
