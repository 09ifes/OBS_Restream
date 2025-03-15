package utils;

import cucumberTest.steps.LoginSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {

    private static Properties config = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);


    public static String get(String string) {
        try {
            config.load(new FileInputStream("C:/OBS_Restream/src/test/resources/credentials/login.properties"));
        }
        catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        return config.getProperty(string);
    }

}
