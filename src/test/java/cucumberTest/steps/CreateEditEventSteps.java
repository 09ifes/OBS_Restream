package cucumberTest.steps;

import cucumberTest.stepLib.actions.CreateEventPageActionMethods;
import cucumberTest.stepLib.actions.HomepageActionMethods;
import cucumberTest.stepLib.checks.HomepageCheckMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateEditEventSteps {

    private final CreateEventPageActionMethods createEventPageActionMethods = new CreateEventPageActionMethods();
    private final HomepageActionMethods homepageActionMethods = new HomepageActionMethods();
    private final HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();

    @And("Create an event")
    public void createAnEvent() {
        createEventPageActionMethods.createEvent();
        homepageCheckMethods.checkRTMPSettingsPageTitleIsDisplayed();
        homepageActionMethods.closeRTMPSettingsModal();
    }

    @Then("The created event should be displayed on the homepage")
    public void theCreatedEventShouldBeDisplayedOnTheHomepage() {
        homepageCheckMethods.checkEventsListContainsNewEvent();
    }

}
