package at.fhv.puzzle2.logging.Exception;


public class LogFormatterUnknownException extends LogException {
    public LogFormatterUnknownException(String formatterName) {
        super("Logformatter '" + formatterName + "' unknown");
    }
}
