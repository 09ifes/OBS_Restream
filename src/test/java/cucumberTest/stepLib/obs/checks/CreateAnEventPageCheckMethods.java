package cucumberTest.stepLib.obs.checks;

import cucumberTest.pages.obs.CreateEventPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.assertTrue;



public class CreateAnEventPageCheckMethods {
    CreateEventPage createEventPage = getPages().get(CreateEventPage.class);

    public void checkCreateEventPageIsOpen() {
        assertTrue("Create event page heading is not displayed", createEventPage.isCreateEventPageVisible());
    }
}
