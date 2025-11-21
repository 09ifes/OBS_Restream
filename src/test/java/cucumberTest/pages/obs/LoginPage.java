package cucumberTest.pages.obs;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@type='email']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@type='password']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade loginbutton;

    public void launch(String url) {

       // getDriver().close();
        getDriver().manage().deleteAllCookies();
        getDriver().get(url);

        getDriver().manage().addCookie(new Cookie("session_id", "7HoRAFCBP43GIQKWKYmO5JbGjxXHB8TXdsqGlPdbCe8%3D"));
        getDriver().navigate().refresh();

        // Wait for page to load fully
        new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));


        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        js.executeScript("window.chrome = { runtime: {} };");
        js.executeScript("Object.defineProperty(navigator, 'languages', {get: () => ['en-US', 'en']});");
        js.executeScript("Object.defineProperty(navigator, 'plugins', {get: () => [1, 2, 3, 4, 5]});");


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
