package cucumberTest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
                 plugin = {"pretty"},
                 features="src/main/resources/features",
                 glue = {"cucumberTest.steps"}
)
public class CucumberTestSuite {
//    public static void config() {
//       // System.setProperty("webdriver.chrome.driver", "C:/OBS_Restream/src/main/resources/drivers/chromedriver.exe");
//        WebDriverManager.chromedriver().setup();
//    }
}

