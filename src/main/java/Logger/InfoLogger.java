package Logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class InfoLogger {
    private Logger logger;
    private FileHandler fileHandler;

    public InfoLogger() {
        logger = Logger.getLogger("InfoLogging");

        try {
            // configure the logger with handler and formatter
            fileHandler = new FileHandler("C:\\temp\\LogFile.log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Log the message.
     *
     * @param message
     */
    public void info(String message) {
        logger.info(message);
    }
}
