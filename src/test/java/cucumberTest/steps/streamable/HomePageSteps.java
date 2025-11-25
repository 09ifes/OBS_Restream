package cucumberTest.steps.streamable;

import cucumberTest.stepLib.streamable.actions.HomePageActionMethods;
import cucumberTest.stepLib.streamable.checks.HomePageCheckMethods;
import cucumberTest.stepLib.streamable.checks.UploadVideoPageCheckMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

    private final HomePageActionMethods homePageActionMethods = new HomePageActionMethods();
    private final HomePageCheckMethods homePageCheckMethods = new HomePageCheckMethods();

    @Given("The user navigates to the streamable site")
    public void theUserNavigatesToTheStreamableSite() {
        homePageActionMethods.navigateToStreamableSite();
        homePageCheckMethods.checkHomepageIsOpen();
    }

    @When("The user goes to the upload video page")
    public void theUserGoesTotheUploadVideoPage() {
        homePageActionMethods.openUploadVideoPage();
    }

}
