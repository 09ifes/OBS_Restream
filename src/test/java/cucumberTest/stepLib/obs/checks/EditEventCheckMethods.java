package cucumberTest.stepLib.obs.checks;

import cucumberTest.pages.obs.EditEventPage;
import static org.junit.Assert.assertTrue;

public class EditEventCheckMethods {

    private EditEventPage editEventPage;

    public void checkEditEventPageIsOpen() {
        assertTrue("Edit event page not open", editEventPage.isEditEventPageOpen());
    }

}
