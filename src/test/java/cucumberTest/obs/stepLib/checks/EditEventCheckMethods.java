package cucumberTest.obs.stepLib.checks;

import cucumberTest.obs.pages.EditEventPage;
import static org.junit.Assert.assertTrue;

public class EditEventCheckMethods {

    private EditEventPage editEventPage;

    public void checkEditEventPageIsOpen() {
        assertTrue("Edit event page not open", editEventPage.isEditEventPageOpen());
    }

}
