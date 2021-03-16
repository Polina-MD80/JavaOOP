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
    public void append(String message) {
        this.file.write(message);
    }
    @Override
    public
    String toString () {
        return String.format ("%s, File size: %d", super.toString (),this.file.getSize ());
    }
}
