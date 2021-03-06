package at.fhv.puzzle2.logging.sink;

import at.fhv.puzzle2.logging.Exception.LogFileNotWritableException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class SimpleFileSink implements LogSink {
    private final File _logFile;
    private FileOutputStream _outputStream;

    public SimpleFileSink(String path) throws LogFileNotWritableException {
        _logFile = new File(path);

        if(_logFile.exists()) {
            if(!_logFile.canWrite()) {
                throw new LogFileNotWritableException(path);
            }
        } else {
            File directory = _logFile.getParentFile();
            if(!directory.canWrite()) {
                throw new LogFileNotWritableException(path);
            }
        }
    }

    @Override
    public void logMessage(String message) throws IOException {
        if(_outputStream == null) {
            _outputStream = new FileOutputStream(_logFile, true);
        }

        _outputStream.write((message + "\n").getBytes(Charset.forName("UTF-8")));
    }

    @Override
    public void close() throws IOException {
        _outputStream.close();
    }
}
