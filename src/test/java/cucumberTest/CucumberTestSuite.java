package cucumberTest;

import io.cucumber.java.Before;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
                 plugin = {"pretty"},
                 features="src/test/resources/features",
                 glue = {"cucumberTest.steps"}
)
public class CucumberTestSuite {
    @Before
    public static void config() {
       // System.setProperty("webdriver.chrome.driver", "C:/OBS_Restream/src/test/resources/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }
}

