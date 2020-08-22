package disney.reservation.notification.infrastructure.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLogger implements disney.reservation.notification.domain.log.Logger {
    private Logger logger;
    private FileHandler fileHandler;

    public FileLogger() {
        logger = Logger.getLogger("InfoLogging");

        try {
            fileHandler = new FileHandler("C:\\temp\\LogFile.log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void info(String message) {
        logger.info(message);
    }
}
