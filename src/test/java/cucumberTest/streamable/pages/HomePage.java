package cucumberTest.streamable.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class HomePage extends PageObject {

    @FindBy(xpath = "//h1[text()='Video hosting made easy']")
    private WebElementFacade homepageHeader;
    @FindBy(xpath = "//a[text()='Log In']")
    private WebElementFacade loginButton;
    @FindBy(xpath = "//a[contains(text()='Sign up')]")
    private WebElementFacade signUpButton;
    @FindBy(xpath = "//button[text()='Tools']")
    private WebElementFacade toolsButton;

    @FindBy(xpath = "//a[text()='Upload video']")
    private WebElementFacade uploadVideoButton;


    public boolean isHomepageOpen() {
        return homepageHeader.waitUntilVisible().isVisible() && getDriver().getCurrentUrl().
                equalsIgnoreCase("https://streamable.com/");
    }

    public void clickLoginButton() {
        loginButton.waitUntilClickable().click();
    }

    public void clickSignupButton() {
        signUpButton.waitUntilClickable().click();
    }

    public void clickToolsButton() {toolsButton.waitUntilVisible().click();}

    public void clickUploadVideoButton() {
        uploadVideoButton.waitUntilVisible().click();
    }

    public void openUploadVideoSection() {
        if (!uploadVideoButton.isVisible()) {
            clickToolsButton();
        }
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(uploadVideoButton).waitUntilVisible().click();
    }

}
