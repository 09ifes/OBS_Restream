package utils;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {

    private static final Properties config = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);
    private static final String DEFAULT_PATH = "src/main/resources/credentials/login.properties";

    static {
        File configFile = new File(DEFAULT_PATH);

        if (configFile.exists()) {
            try (FileInputStream input = new FileInputStream(configFile)) {
                config.load(input);
                LOGGER.info("Loaded config from: {}", DEFAULT_PATH);
            } catch (IOException e) {
                LOGGER.error("Failed to load config: {}", e.getMessage());
            }
        } else {
            LOGGER.warn("Config file not found at: {}", DEFAULT_PATH);
        }
    }

    public static String get(String key) {
        return config.getProperty(key);
    }
}