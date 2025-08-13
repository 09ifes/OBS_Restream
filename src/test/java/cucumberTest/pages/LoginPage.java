package cucumberTest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@type='email']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade loginbutton;

    public void launch(String url) {
        getDriver().close();
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);
        loginbutton.waitUntilVisible();
    }

    public void enterEmail(String email) {
        emailInput.waitUntilVisible().sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.waitUntilVisible().sendKeys(password);
    }

    public void submit() {
        loginbutton.waitUntilVisible().waitUntilClickable().click();
    }

    public boolean isLoginPageVisible() {
        return loginbutton.waitUntilVisible().isVisible();
    }

}
