package cucumberTest.obs.steps;
import cucumberTest.obs.stepLib.checks.HomepageCheckMethods;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumberTest.obs.stepLib.actions.LoginActionMethods;
import cucumberTest.obs.stepLib.checks.LoginChecksMethods;
import utils.Configuration;

public class LoginSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginActionMethods loginActionMethods = new LoginActionMethods();

    private LoginChecksMethods loginChecksMethods = new LoginChecksMethods();

    private HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();


    @Given("Login to restream")
    public void loginToRestream() {
        String email = Configuration.get("email");
        String password = Configuration.get("password");
        loginActionMethods.loginToRestream(email, password);
        homepageCheckMethods.checkHomePageIsDisplayed();
    }

}
