package cucumberTest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateEventPage extends PageObject {

    @FindBy(xpath = "//div[text()='Create event']")
    protected WebElementFacade createEventPageTitle;
    @FindBy(xpath = "//input[@name='title']")
    protected WebElementFacade eventTitle;
    @FindBy(xpath = "//textarea[@name='description']")
    protected WebElementFacade eventDescription;
    @FindBy(xpath = "//span[text()='Next']")
    protected WebElementFacade nextButton;
    @FindBy(xpath = "//div[text()='Create Event']")
    protected WebElementFacade createEventButton;
    @FindBy(xpath = "//div[text()='Yes']")
    protected WebElementFacade yesButton;


    public  boolean isCreateEventPageVisible() {
        return createEventPageTitle.waitUntilVisible().isVisible();
    }

    public void insertEventTitle(String title) {
        eventTitle.waitUntilVisible().sendKeys(title);
    }

    public void insertEventDescription(String description) {
        eventDescription.waitUntilVisible().sendKeys(description);
    }

    public void clickNext() {
        nextButton.waitUntilClickable().click();
    }

    public void clickYes() {
        yesButton.waitUntilClickable().click();
    }

    public void clickCreateEventButton() {
        createEventButton.waitUntilVisible().waitUntilClickable().click();
    }

}
