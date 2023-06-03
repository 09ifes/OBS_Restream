package cucumberTest.stepLib.actions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

import cucumberTest.pages.HomePage;

public class HomepageActionMethods {

    HomePage homePage = getPages().get(HomePage.class);

    public void getStreamKey() {
        homePage.getStreamKey();
    }

}
