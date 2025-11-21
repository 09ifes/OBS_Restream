package cucumberTest.stepLib.obs.actions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

import cucumberTest.pages.obs.LoginPage;
import utils.Configuration;

public class LoginActionMethods {

    LoginPage loginPage = getPages().get(LoginPage.class);

    public void loginToRestream(String email, String password) {
        String url = "https://restream.io/login";
        loginPage.launch(url);
        loginPage.enterEmail(Configuration.get("email"));
        loginPage.enterPassword(Configuration.get("password"));
        loginPage.submit();
    }

}
