package at.fhv.puzzle2.logging.sink;

import java.io.IOException;

public class ConsoleSink implements LogSink {
    @Override
    public void logMessage(String message) throws IOException {
        System.out.println(message);
    }
}
