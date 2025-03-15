package cucumberTest.stepLib.checks;

import cucumberTest.pages.EditEventPage;
import static org.junit.Assert.*;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class EditEventCheckMethods {

    EditEventPage editEventPage = getPages().get(EditEventPage.class);

    public void checkEditEventPageIsOpen() {
        assertTrue("Edit event page not open", editEventPage.isEditEventPageOpen());
    }

}
