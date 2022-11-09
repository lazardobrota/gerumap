package raf.dsw.gerumap.gui.swing.error;

import raf.dsw.gerumap.core.ErrorLogger;

public class LoggerFactory {

    public LoggerFactory() {
    }

    public static ErrorLogger createLogger (LoggerType loggerType) {
        if (loggerType.equals(LoggerType.FILE_LOGGER))
            return new FileLogger();
        else if (loggerType.equals(LoggerType.CONSOLE_LOGGER))
            return new ConsoleLogger();

        return null;
    }
}
