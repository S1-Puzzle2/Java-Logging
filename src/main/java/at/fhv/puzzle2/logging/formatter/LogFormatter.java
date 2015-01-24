package at.fhv.puzzle2.logging.formatter;

import at.fhv.puzzle2.logging.LogLevel;

import java.util.Date;

public interface LogFormatter {
    /**
     * Will be invoked by the Logger to format the message and write it into the sink
     * @param logLevel LogLevel
     * @param tag String
     * @param message String
     * @return String
     */
    public String formatLogMessage(LogLevel logLevel, String tag, String message, Date date);
}
