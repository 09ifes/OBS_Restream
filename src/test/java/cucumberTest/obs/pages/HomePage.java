package cucumberTest.obs.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static java.time.Duration.ofSeconds;
import java.util.List;

public class HomePage extends PageObject {

    @FindBy(className = "product-menu-desktop_productMenuDesktopLogo__Al1iV")
    private WebElementFacade homepageLogo;
    @FindBy(xpath = ".//span[contains(text(),'RTMP Settings')]")
    private WebElementFacade rtmpSettingsButton;
    @FindBy(xpath = "//div[text()='RTMP settings']")
    private WebElementFacade rtmpSettingsTitle;
    @FindBy(xpath = "//div[3]/div/div/div[2]/button")
    private WebElementFacade copyStreamKeyButton;
    @FindBy(xpath = "//div[3]/div/div/div[1]/input")
    private WebElementFacade streamKey;
    @FindBy(xpath = "//button[@aria-label='Schedule Event']")
    private WebElementFacade scheduleEventButton;
    @FindBy(xpath = "//ul[@class='ConcurrentEventsList_listWrapper__10U97']")
    private WebElementFacade scheduledEvents;
    @FindBy(xpath = "//div[contains(text(),'Encoder | RTMP')]")
    private WebElementFacade encoderRTMPButton;
    @FindBy(xpath = "//div[text()='Done']")
    private WebElementFacade doneButton;

    public boolean isHomePageVisible() {
       return homepageLogo.withTimeoutOf(ofSeconds(30)).waitUntilVisible().isVisible();
    }

    public boolean isRTMPSettingsTitleVisible() {
        return rtmpSettingsTitle.waitUntilVisible().isVisible();
    }

    public void getStreamKey() {
        rtmpSettingsButton.waitUntilClickable().click();
        Serenity.setSessionVariable("streamKey").to(streamKey.getAttribute("value"));
    }

    public void selectScheduleEvent() {
        scheduleEventButton.waitUntilClickable().click();
    }

    public void selectEncoderRTMP() {
        encoderRTMPButton.waitUntilVisible().waitUntilClickable().click();
    }

    public void clickDone() {
        doneButton.waitUntilClickable().click();
    }

    public List<WebElementFacade> getScheduledEvents() {
        return scheduledEvents.waitUntilVisible().thenFindAll("li");
    }

}
