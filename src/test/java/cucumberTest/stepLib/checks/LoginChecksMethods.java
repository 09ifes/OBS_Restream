package cucumberTest.stepLib.checks;

import cucumberTest.pages.LoginPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.*;

public class LoginChecksMethods {
    LoginPage loginPage = getPages().get(LoginPage.class);

    public void checkLoginPageIsDisplayed() {
        assertTrue("Expected login page to display", loginPage.isLoginPageVisible());
    }
}
