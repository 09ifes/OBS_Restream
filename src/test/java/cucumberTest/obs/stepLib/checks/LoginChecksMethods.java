package cucumberTest.obs.stepLib.checks;

import cucumberTest.obs.pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginChecksMethods {

    private LoginPage loginPage;

    public void checkLoginPageIsDisplayed() {
        assertTrue("Expected login page to display", loginPage.isLoginPageVisible());
    }
}
