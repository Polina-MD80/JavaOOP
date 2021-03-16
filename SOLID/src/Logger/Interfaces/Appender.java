package Logger.Interfaces;

import Logger.enums.ReportLevel;

public
interface Appender {
  void appendMessage(String datetime, ReportLevel reportLevel, String message);



  void setReportLevel (ReportLevel error);
}
