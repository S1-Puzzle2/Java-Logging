package at.fhv.puzzle2.logging.Exception;

public class LogFileNotWritableException extends LogException {
    public LogFileNotWritableException(String filePath) {
        super("Logfile '" + filePath + "' is not writable");
    }
}
