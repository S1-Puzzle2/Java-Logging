package at.fhv.puzzle2.logging.formatter;

import at.fhv.puzzle2.logging.LogLevel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleFormatter implements LogFormatter {
    @Override
    public String formatLogMessage(LogLevel logLevel, String tag, String message, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return String.format("%s - %s - %s: %s", sdf.format(date), LogLevel.levelToString(logLevel), tag, message);
    }
}
