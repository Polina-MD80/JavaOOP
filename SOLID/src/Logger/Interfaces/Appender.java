package Logger.Interfaces;

import Logger.enums.ReportLevel;

public
interface Appender {
  void append(String data, ReportLevel reportLevel, String message);
}
