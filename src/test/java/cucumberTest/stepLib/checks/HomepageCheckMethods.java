package cucumberTest.stepLib.checks;

import cucumberTest.pages.HomePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.*;

public class HomepageCheckMethods {

    HomePage homePage = getPages().get(HomePage.class);

    public void checkHomePageIsDisplayed() {
        assertTrue("Expected homepage to display", homePage.isHomePageVisible());
    }

    public void checkRTMPSettingsPageTitleIsDisplayed() {
        assertTrue("RTMP settings title not displayed", homePage.isRTMPSettingsTitleVisible());
    }

    public void checkEventsListContainsNewEvent() {
        boolean eventIsDisplayed = false;
        for (WebElementFacade event : homePage.getScheduledEvents()) {
            if (event.getText().contains(Serenity.sessionVariableCalled("eventTitle"))) {
                eventIsDisplayed = true;
            }
        }
        assertTrue("New event is not displayed", eventIsDisplayed);
    }

}
