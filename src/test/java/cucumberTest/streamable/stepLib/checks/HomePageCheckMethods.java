package cucumberTest.streamable.stepLib.checks;

import cucumberTest.streamable.pages.HomePage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageCheckMethods {

    HomePage homePage = getPages().get(HomePage.class);

    public void checkHomepageIsOpen() {
        assertTrue(homePage.isHomepageOpen(), "Home page isn't open");
    }
}
