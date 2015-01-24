package at.fhv.puzzle2.logging.Exception;

public class LogSinkUnknownException extends LogException {
    public LogSinkUnknownException(String sinkName) {
        super("LogSink '" + sinkName + "' unknown");
    }
}
