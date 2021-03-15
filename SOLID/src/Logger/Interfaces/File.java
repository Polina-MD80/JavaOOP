package Logger.Interfaces;

import Logger.enums.ReportLevel;

public
interface File {
    int getSize();
    void write(String message);
}
