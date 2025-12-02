package cucumberTest.obs.stepLib.checks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.core.Serenity;

import java.io.File;
import java.util.Map;
import static org.junit.Assert.*;

public class GlobalCheckMethods {
    public void checkEditedStreamKey() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> userData;
        File jsonFile = new File("C:/Users/samue/AppData/Roaming/obs-studio/basic/profiles/Untitled/service.json");
        try {
            userData = mapper.readValue(
                    jsonFile, new TypeReference<Map<String, Object>>() {
                    });
            Map<String, Object> settings = (Map<String, Object>) userData.get("settings");
            assertEquals("Stream key not saved", settings.get("key").toString(),Serenity.sessionVariableCalled("streamKey"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
