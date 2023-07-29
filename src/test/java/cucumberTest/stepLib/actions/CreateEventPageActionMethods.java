package cucumberTest.stepLib.actions;

import cucumberTest.pages.CreateEventPage;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

public class CreateEventPageActionMethods {

    CreateEventPage createEventPage = getPages().get(CreateEventPage.class);

    public void createEvent() {
        createEventPage.createEvent();
        createEventPage.clickYes();
    }

}
