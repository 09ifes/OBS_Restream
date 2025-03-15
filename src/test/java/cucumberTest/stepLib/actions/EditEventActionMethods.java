package cucumberTest.stepLib.actions;

import cucumberTest.pages.EditEventPage;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.RandomStringUtils;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class EditEventActionMethods {

    EditEventPage editEventPage = getPages().get(EditEventPage.class);

    public void editEvent() {
        String eventTitle = "Test stream - " +  RandomStringUtils.random(6, true, true);
        Serenity.setSessionVariable("eventTitle").to(eventTitle);
        editEventPage.editEventTitle(eventTitle);
        editEventPage.editEventDescription("Test description");
        editEventPage.clickNext();
        editEventPage.clickCreateEventButton();
    }
}
