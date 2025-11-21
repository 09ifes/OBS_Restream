package cucumberTest.stepLib.obs.actions;

import java.io.File;


import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.serenitybdd.core.Serenity;


public class GlobalActionMethods {
    public void editOBSJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> userData = null;
        File jsonFile = new File("C:/Users/samue/AppData/Roaming/obs-studio/basic/profiles/Untitled/service.json");
        try {
             userData = mapper.readValue(
                    jsonFile, new TypeReference<Map<String, Object>>() {
                    });
             Map<String, Object> settings = (Map<String, Object>) userData.get("settings");
             settings.replace("key",Serenity.sessionVariableCalled("streamKey"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(new File("C:/Users/samue/AppData/Roaming/obs-studio/basic/profiles/Untitled/service.json"), userData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
