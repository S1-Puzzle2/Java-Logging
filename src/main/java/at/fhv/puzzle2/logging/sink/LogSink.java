package at.fhv.puzzle2.logging.sink;

import java.io.IOException;

public interface LogSink {
    public void logMessage(String message) throws IOException;
}
