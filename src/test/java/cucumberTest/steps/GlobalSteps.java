package cucumberTest.steps;

import cucumberTest.stepLib.actions.GlobalActionMethods;
import cucumberTest.stepLib.checks.GlobalCheckMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class GlobalSteps {
    private final GlobalActionMethods globalActionMethods = new GlobalActionMethods();
    private final GlobalCheckMethods globalCheckMethods = new GlobalCheckMethods();

    @And("Add stream key to OBS")
    public void addStreamkeyToOBS() {
        globalActionMethods.editOBSJsonFile();
    }

    @Then("Check it has been added successfully")
    public void check_it_has_been_added_successfully() {
        globalCheckMethods.checkEditedStreamKey();
    }

}
