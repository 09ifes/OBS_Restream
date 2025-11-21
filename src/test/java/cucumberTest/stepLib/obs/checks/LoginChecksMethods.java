package cucumberTest.stepLib.obs.checks;

import cucumberTest.pages.obs.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginChecksMethods {

    private LoginPage loginPage;

    public void checkLoginPageIsDisplayed() {
        assertTrue("Expected login page to display", loginPage.isLoginPageVisible());
    }
}
