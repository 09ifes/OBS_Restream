package cucumberTest.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class HomePage extends PageObject {

    @FindBy(className = "product-menu-desktop_productMenuDesktopLogo__Al1iV")
    WebElementFacade homepageLogo;
    @FindBy(xpath = ".//span[contains(text(),'RTMP Settings')]")
    WebElementFacade rtmpSettingsButton;
    @FindBy(xpath = "//div[text()='RTMP settings']")
    WebElementFacade rtmpSettingsTitle;
    @FindBy(xpath = "//div[3]/div/div/div[2]/button")
    WebElementFacade copyStreamKeyButton;
    @FindBy(xpath = "//div[3]/div/div/div[1]/input")
    WebElementFacade streamKey;
    @FindBy(xpath = "//button[@aria-label='Schedule Event']")
    WebElementFacade scheduleEventButton;
    @FindBy(xpath = "//ul[@class='ConcurrentEventsList_listWrapper__10U97']")
    WebElementFacade scheduledEvents;
    @FindBy(xpath = "//div[contains(text(),'Encoder | RTMP')]")
    WebElementFacade encoderRTMPButton;
    @FindBy(xpath = "//div[text()='Done']")
    WebElementFacade doneButton;

    public boolean isHomePageVisible() {
        homepageLogo.waitUntilVisible();
        return homepageLogo.isVisible();
    }

    public boolean isRTMPSettingsTitleVisible() {
        rtmpSettingsTitle.waitUntilVisible();
        return rtmpSettingsTitle.isVisible();
    }

    public void getStreamKey() {
        rtmpSettingsButton.waitUntilClickable();
        rtmpSettingsButton.click();
        Serenity.setSessionVariable("streamKey").to(streamKey.getAttribute("value"));
    }

    public void selectScheduleEvent() {
        scheduleEventButton.waitUntilClickable();
        scheduleEventButton.click();
    }

    public void selectEncoderRTMP() {
        encoderRTMPButton.waitUntilVisible();
        encoderRTMPButton.waitUntilClickable();
        encoderRTMPButton.click();
    }

    public void clickDone() {
        doneButton.waitUntilClickable();
        doneButton.click();
    }

    public List<WebElementFacade> getScheduledEvents() {
        scheduledEvents.waitUntilVisible();
        return scheduledEvents.thenFindAll("li");
    }

}
