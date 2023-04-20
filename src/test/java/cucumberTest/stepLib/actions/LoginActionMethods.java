package cucumberTest.stepLib.actions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

import cucumberTest.pages.LoginPage;
import net.serenitybdd.core.Serenity;

public class LoginActionMethods {

    LoginPage loginPage = getPages().get(LoginPage.class);

    public void loginToRestream(String email, String password) {
        String url = "https://restream.io/login";
        loginPage.launch(url);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.submit();
    }



}
