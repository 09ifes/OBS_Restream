package cucumberTest.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void closeDriver() {
        getDriver().quit();
    }
}