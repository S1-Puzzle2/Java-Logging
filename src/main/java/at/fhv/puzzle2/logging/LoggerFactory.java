package at.fhv.puzzle2.logging;

import at.fhv.puzzle2.logging.Exception.LogFileNotWritableException;
import at.fhv.puzzle2.logging.Exception.LogFormatterUnknownException;
import at.fhv.puzzle2.logging.Exception.LogSinkUnknownException;
import at.fhv.puzzle2.logging.formatter.LogFormatter;
import at.fhv.puzzle2.logging.formatter.SimpleFormatter;
import at.fhv.puzzle2.logging.sink.ConsoleSink;
import at.fhv.puzzle2.logging.sink.LogSink;
import at.fhv.puzzle2.logging.sink.SimpleFileSink;

public class LoggerFactory {
    public static LogFormatter createFormatter(String formatterName) throws LogFormatterUnknownException {
        if(formatterName.equals("SimpleFormatter")) {
            return new SimpleFormatter();
        }

        throw new LogFormatterUnknownException(formatterName);
    }

    public static LogSink createSink(String sinkName, String... parameters) throws LogSinkUnknownException, LogFileNotWritableException {
        if(sinkName.equals("SimpleFile")) {
            if(parameters.length > 0) {
                String filePath = parameters[0];

                return new SimpleFileSink(filePath);
            }

            //TODO throw an exception
        } else if (sinkName.equals("Console")) {
            return new ConsoleSink();
        }

        throw new LogSinkUnknownException(sinkName);
    }
}
