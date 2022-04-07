import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    public Logger logger;
    FileHandler gg;

    public Log(String file_name) throws SecurityException, IOException {

        gg = new FileHandler(file_name, true);
        logger = Logger.getLogger("probar");
        logger.addHandler(gg);
        SimpleFormatter formatter = new SimpleFormatter();
        gg.setFormatter(formatter);
    }
}