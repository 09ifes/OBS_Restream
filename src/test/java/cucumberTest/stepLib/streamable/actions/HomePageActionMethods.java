package cucumberTest.stepLib.streamable.actions;

import cucumberTest.pages.streamable.HomePage;

import static net.serenitybdd.core.Serenity.getDriver;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class HomePageActionMethods {

    HomePage homePage = getPages().get(HomePage.class);

    public void navigateToStreamableSite() {
        String url = "https://streamable.com/";
        getDriver().get(url);
    }

    public void openUploadVideoPage() {
        homePage.clickToolsButton();
        homePage.openUploadVideoSection();
    }

}
