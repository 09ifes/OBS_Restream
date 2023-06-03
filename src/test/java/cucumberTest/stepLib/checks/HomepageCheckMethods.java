package cucumberTest.stepLib.checks;

import cucumberTest.pages.HomePage;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.*;

public class HomepageCheckMethods {

    HomePage homePage = getPages().get(HomePage.class);

    public void checkHomePageIsDisplayed() {
        assertTrue("Expected homepage to display", homePage.isHomePageVisible());
    }

}
