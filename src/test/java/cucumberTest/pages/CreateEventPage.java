package cucumberTest.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateEventPage extends PageObject {

    @FindBy(xpath = "//div[text()='Create event']")
    WebElementFacade createEventPageTitle;
    @FindBy(xpath = "//input[@name='title']")
    WebElementFacade eventTitle;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElementFacade eventDescription;
    @FindBy(xpath = "//span[text()='Next']")
    WebElementFacade nextButton;
    @FindBy(xpath = "//div[text()='Create Event']")
    WebElementFacade createEventButton;
    @FindBy(xpath = "//div[text()='Yes']")
    WebElementFacade yesButton;


    public  boolean isCreateEventPageVisible() {
        createEventPageTitle.waitUntilVisible();
        return createEventPageTitle.isVisible();
    }

    public void insertEventTitle(String title) {
        eventTitle.waitUntilVisible();
        eventTitle.sendKeys(title);
    }

    public void insertEventDescription(String description) {
        eventDescription.waitUntilVisible();
        eventDescription.sendKeys(description);
    }

    public void clickNext() {
        nextButton.waitUntilClickable();
        nextButton.click();
    }

    public void clickYes() {
        yesButton.waitUntilClickable();
        yesButton.click();
    }

    public void clickCreateEventButton() {
        createEventButton.waitUntilVisible();
        createEventButton.waitUntilClickable();
        createEventButton.click();
    }

    public void createEvent() {
        String eventTitle = "Test stream - " +  RandomStringUtils.random(6, true, true);
        Serenity.setSessionVariable("eventTitle").to(eventTitle);
        insertEventTitle(eventTitle);
        insertEventDescription("Test description");
        clickNext();
        clickCreateEventButton();
    }

}
