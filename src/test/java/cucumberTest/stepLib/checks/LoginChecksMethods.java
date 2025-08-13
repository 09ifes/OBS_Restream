package cucumberTest.stepLib.checks;

import cucumberTest.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginChecksMethods {

    private LoginPage loginPage;

    public void checkLoginPageIsDisplayed() {
        assertTrue("Expected login page to display", loginPage.isLoginPageVisible());
    }
}
