package Logger.controllers;

import Logger.Interfaces.File;
import Logger.Interfaces.Layout;
import Logger.logger.LogFile;
import Logger.enums.ReportLevel;

public
class FileAppender extends BaseAppender{
    private File file;

    public
    FileAppender (Layout layout) {
        super (layout);
        this.setFile (new LogFile ());
    }


    public
    void setFile (File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message){
        this.file.write (String.format ("%s - %s - %s", date, reportLevel, message));
    }
}
