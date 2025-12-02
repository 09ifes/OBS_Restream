package cucumberTest.obs.steps;

import cucumberTest.obs.stepLib.actions.CreateEventPageActionMethods;
import cucumberTest.obs.stepLib.actions.EditEventActionMethods;
import cucumberTest.obs.stepLib.actions.HomepageActionMethods;
import cucumberTest.obs.stepLib.checks.EditEventCheckMethods;
import cucumberTest.obs.stepLib.checks.HomepageCheckMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CreateEditEventSteps {

    private final CreateEventPageActionMethods createEventPageActionMethods = new CreateEventPageActionMethods();
    private final HomepageActionMethods homepageActionMethods = new HomepageActionMethods();
    private final HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();
    private final EditEventActionMethods editEventActionMethods = new EditEventActionMethods();
    private final EditEventCheckMethods editEventCheckMethods = new EditEventCheckMethods();

    @And("Create an event")
    public void createAnEvent() {
        createEventPageActionMethods.createEvent();
        homepageCheckMethods.checkRTMPSettingsPageTitleIsDisplayed();
        homepageActionMethods.closeRTMPSettingsModal();
    }

    @And("Edit an event")
    public void editAnEvent() {
        editEventCheckMethods.checkEditEventPageIsOpen();
        editEventActionMethods.editEvent();
    }

    @Then("The created event should be displayed on the homepage")
    public void theCreatedEventShouldBeDisplayedOnTheHomepage() {
        homepageCheckMethods.checkEventsListContainsNewEvent();
    }
}
