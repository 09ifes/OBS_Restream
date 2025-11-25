package cucumberTest.steps.obs;
import cucumberTest.stepLib.obs.checks.HomepageCheckMethods;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumberTest.stepLib.obs.actions.LoginActionMethods;
import cucumberTest.stepLib.obs.checks.LoginChecksMethods;

public class LoginSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);

    private LoginActionMethods loginActionMethods = new LoginActionMethods();

    private LoginChecksMethods loginChecksMethods = new LoginChecksMethods();

    private HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();


    @Given("Login to restream")
    public void loginToRestream() {
        String email = System.getenv("EMAIL");
        String password = System.getenv("PASSWORD");
        loginActionMethods.loginToRestream(email, password);
        homepageCheckMethods.checkHomePageIsDisplayed();
    }

}
