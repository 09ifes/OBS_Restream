package cucumberTest.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class EditEventPage extends CreateEventPage {

    @FindBy(xpath = "//span[@class='Switch_lever__DduIU']")
    private WebElementFacade youtubeTogglebutton;
    @FindBy(xpath = "//button[text()='Edit']")
    private WebElementFacade editButton;
    @FindBy(xpath = "//div[text()='Edit event']")
    private WebElementFacade editEventHeading;
    @FindBy(xpath = "//div[text()='Edit destination']")
    private WebElementFacade editDestinationHeading;
    @FindBy(xpath = "//div[text()='Save']")
    private WebElementFacade saveButton;

    public void editEventTitle(String title) {
        eventTitle.waitUntilVisible().clear();
        eventTitle.sendKeys(title);
    }

    public void editEventDescription(String description) {
        eventDescription.waitUntilVisible().clear();
        eventDescription.sendKeys(description);
    }

    public void clickSaveButton() {
        saveButton.waitUntilVisible().waitUntilClickable().click();
    }

    public boolean isEditEventPageOpen() {
        editEventHeading.waitUntilVisible().isVisible();
        return editButton.waitUntilVisible().isVisible();
    }

}
