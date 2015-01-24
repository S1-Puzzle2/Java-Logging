package at.fhv.puzzle2.logging.formatter;

import at.fhv.puzzle2.logging.LogLevel;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class SimpleFormatterTest {
    private LogFormatter formatter;
    private final String tag = "test.SimpleLogFormatter";
    private final String message = "Heyho";

    @Before
    public void setUp() {
        formatter = new SimpleFormatter();
    }

    @Test
    public void testLogLevelStrings() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2014, Calendar.DECEMBER, 3, 10, 22, 15);


        assertEquals(createLogLevelString("Error"), formatter.formatLogMessage(LogLevel.ERROR, tag, message, calendar.getTime()));
        assertEquals(createLogLevelString("Warning"), formatter.formatLogMessage(LogLevel.WARN, tag, message, calendar.getTime()));
        assertEquals(createLogLevelString("Info"), formatter.formatLogMessage(LogLevel.INFO, tag, message, calendar.getTime()));
        assertEquals(createLogLevelString("Debug"), formatter.formatLogMessage(LogLevel.DEBUG, tag, message, calendar.getTime()));
    }

    private String createLogLevelString(String logLevel) {
        String dateTime = "03.12.2014 10:22:15";

        return String.format("%s - %s - %s: %s", dateTime, logLevel, tag, message);
    }
}