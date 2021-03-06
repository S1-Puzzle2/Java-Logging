package at.fhv.puzzle2.logging;


import java.util.Optional;

public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(3),
    WARN(4),
    ERROR(5);

    private static final String TRACE_STRING = "Trace";
    private static final String DEBUG_STRING = "Debug";
    private static final String INFO_STRING = "Info";
    private static final String WARN_STRING = "Warning";
    private static final String ERROR_STRING = "Error";

    private final int _logLevel;

    private LogLevel(int logLevel) {
        _logLevel = logLevel;
    }

    public static boolean shouldLog(LogLevel minLevel, LogLevel level) {
        return minLevel._logLevel <= level._logLevel;
    }

    public static String levelToString(LogLevel level) {
        switch (level) {
            case DEBUG:
                return DEBUG_STRING;
            case INFO:
                return INFO_STRING;
            case WARN:
                return WARN_STRING;
            case ERROR:
                return ERROR_STRING;
            case TRACE:
                return TRACE_STRING;
            default:
                return "Unkown Loglevel";
        }
    }

    public static Optional<LogLevel> stringToLevel(String level) {
        switch (level) {
            case DEBUG_STRING:
                return Optional.of(DEBUG);
            case INFO_STRING:
                return Optional.of(INFO);
            case WARN_STRING:
                return Optional.of(WARN);
            case ERROR_STRING:
                return Optional.of(ERROR);
            case TRACE_STRING:
                return Optional.of(TRACE);
        }

        return Optional.empty();
    }
}
