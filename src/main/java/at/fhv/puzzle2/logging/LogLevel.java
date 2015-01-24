package at.fhv.puzzle2.logging;


public enum LogLevel {
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4);

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
            default:
                return null;
        }
    }

    public static LogLevel stringToLevel(String level) {
        switch (level) {
            case DEBUG_STRING:
                return DEBUG;
            case INFO_STRING:
                return INFO;
            case WARN_STRING:
                return WARN;
            case ERROR_STRING:
                return ERROR;
        }

        return null;
    }
}
