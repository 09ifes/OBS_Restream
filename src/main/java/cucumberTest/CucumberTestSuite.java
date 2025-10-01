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
}

