package at.fhv.puzzle2.logging;

import at.fhv.puzzle2.logging.formatter.LogFormatter;
import at.fhv.puzzle2.logging.sink.LogSink;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Logger {
    private LogFormatter _formatter;
    private static final List<LogSink> _sinkList = new LinkedList<>();
    private final LogLevel _minLogLevel;

    private Logger(LogFormatter formatter, LogLevel minLogLevel) {
        _formatter = formatter;

        this._minLogLevel = minLogLevel;
    }

    public void setFormatter(LogFormatter formatter) {
        _formatter = formatter;
    }

    public synchronized void logMessage(LogLevel level, String tag, String message) {
        if(LogLevel.shouldLog(_minLogLevel, level)) {

            String logMessage = _formatter.formatLogMessage(level, tag, message, new Date());

            try {
                for(LogSink sink: _sinkList) {
                    sink.logMessage(logMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void appendLogSink(LogSink logSink) {
        _sinkList.add(logSink);
    }

    public void debug(String tag, String message) {
        logMessage(LogLevel.DEBUG, tag, message);
    }

    public void info(String tag, String message) {
        logMessage(LogLevel.INFO, tag, message);
    }

    public void warn(String tag, String message) {
        logMessage(LogLevel.WARN, tag, message);
    }

    public void error(String tag, String message) {
        logMessage(LogLevel.ERROR, tag, message);
    }

    public void trace(String tag, String message) {
        logMessage(LogLevel.TRACE, tag, message);
    }

    private static Logger _instance;
    public static void createLogger(LogFormatter formatter, LogLevel minLogLevel) {
        _instance = new Logger(formatter, minLogLevel);
    }

    public static void createLogger(LogFormatter formatter) {
        createLogger(formatter, LogLevel.WARN);
    }

    public static Logger getLogger() {
        return _instance;
    }
}
