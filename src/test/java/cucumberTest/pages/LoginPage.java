package cucumberTest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class LoginPage extends PageObject {

    @FindBy(name = "email")
    private WebElementFacade emailInput;

    @FindBy(name = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "submit")
    private WebElementFacade loginbutton;

    public void launch(String url) {
        getDriver().close();
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
        loginbutton.waitUntilVisible();
    }

    public void enterEmail(String email) {
        emailInput.waitUntilVisible();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.waitUntilVisible();
        passwordInput.sendKeys(password);
    }

    public void submit() {
        loginbutton.waitUntilVisible();
        loginbutton.waitUntilClickable();
        loginbutton.click();
    }

    public boolean isLoginPageVisible() {
        loginbutton.waitUntilVisible();
        return loginbutton.isVisible();
    }

}
