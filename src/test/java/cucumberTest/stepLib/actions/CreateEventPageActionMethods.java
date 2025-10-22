package cucumberTest.stepLib.actions;

import cucumberTest.pages.CreateEventPage;
import net.serenitybdd.core.Serenity;
import org.apache.commons.lang3.RandomStringUtils;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class CreateEventPageActionMethods {

    CreateEventPage createEventPage = getPages().get(CreateEventPage.class);

    public void createEvent() {
        String eventTitle = "Test stream - " +  RandomStringUtils.random(6, true, true);
        Serenity.setSessionVariable("eventTitle").to(eventTitle);
        createEventPage.insertEventTitle(eventTitle);
        createEventPage.insertEventDescription("Test description");
        createEventPage.clickNext();
        createEventPage.clickCreateEventButton();
        createEventPage.clickYes();
    }

}
