package cucumberTest;

import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
                 plugin = {"pretty"},
                 features="src/test/resources/features",
                 glue = {"cucumberTest"}
)
public class CucumberTestSuite {
    @BeforeClass
    public static void config() {
        System.setProperty("webdriver.chrome.driver", "C:/OBS_Restream/src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }
}

