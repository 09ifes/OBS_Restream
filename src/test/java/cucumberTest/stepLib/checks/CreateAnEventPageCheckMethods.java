package cucumberTest.stepLib.checks;

import cucumberTest.pages.CreateEventPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.junit.Assert.*;



public class CreateAnEventPageCheckMethods {
    CreateEventPage createEventPage = getPages().get(CreateEventPage.class);

    public void checkCreateEventPageIsOpen() {
        assertTrue("Create event page heading is not displayed", createEventPage.isCreateEventPageVisible());
    }
}
