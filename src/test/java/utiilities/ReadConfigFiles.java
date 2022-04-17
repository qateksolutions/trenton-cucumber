package utiilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ReadConfigFiles {
    private static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);

    public static String getPropertyValues(String keyName) {
        Properties prop;
        String propValue = null;
        try {
            prop = new LoadConfigFiles().readPropertyValues();
            propValue = prop.getProperty(keyName);
        } catch (Exception e) {
            LOGGER.error("Exception is: " + e.getMessage());
        }
        return propValue;
    }
}
