package cucumberTest.steps;
import cucumberTest.stepLib.checks.HomepageCheckMethods;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cucumberTest.stepLib.actions.LoginActionMethods;
import cucumberTest.stepLib.checks.LoginChecksMethods;

public class LoginSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginSteps.class);
    private final LoginActionMethods loginActionMethods = new LoginActionMethods();
    private final LoginChecksMethods loginChecksMethods = new LoginChecksMethods();
    private final HomepageCheckMethods homepageCheckMethods = new HomepageCheckMethods();


    @Given("Login to restream")
    public void loginToRestream() {
        String email = System.getenv("EMAIL");
        String password = System.getenv("PASSWORD");
        loginActionMethods.loginToRestream(email, password);
        homepageCheckMethods.checkHomePageIsDisplayed();
    }


}
