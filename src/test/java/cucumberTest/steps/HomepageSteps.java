package cucumberTest.steps;

import cucumberTest.stepLib.checks.CreateAnEventPageCheckMethods;
import io.cucumber.java.en.And;
import cucumberTest.stepLib.actions.HomepageActionMethods;
import cucumberTest.stepLib.checks.HomepageCheckMethods;

public class HomepageSteps {

    private final HomepageActionMethods homepageActionMethods = new HomepageActionMethods();
    private final HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();
    private final CreateAnEventPageCheckMethods createAnEventPageCheckMethods = new CreateAnEventPageCheckMethods();

    @And("Get the stream key for the next upcoming stream")
    public void get_the_stream_key_for_the_next_upcoming_stream() {
        homepageCheckMethods.checkHomePageIsDisplayed();
        homepageActionMethods.getStreamKey();
    }

    @And("Navigate to the create an event page")
    public void navigateToTheCreateAnEventPage() {
        homepageActionMethods.openCreateAnEventPage();
        createAnEventPageCheckMethods.checkCreateEventPageIsOpen();
    }

}
