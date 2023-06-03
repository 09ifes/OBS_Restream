package cucumberTest.steps;

import io.cucumber.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumberTest.stepLib.actions.HomepageActionMethods;
import cucumberTest.stepLib.checks.HomepageCheckMethods;

public class HomepageSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    private final HomepageActionMethods homepageActionMethods = new HomepageActionMethods();
    private final HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();

    @And("Get the stream key for the next upcoming stream")
    public void get_the_stream_key_for_the_next_upcoming_stream() {
        homepageCheckMethods.checkHomePageIsDisplayed();
        homepageActionMethods.getStreamKey();

    }

}
