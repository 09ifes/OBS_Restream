package cucumberTest.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import java.awt.Toolkit;

public class HomePage extends PageObject {

    @FindBy(className = "product-menu-desktop_productMenuDesktopLogo__Al1iV")
    WebElementFacade homepageLogo;
    @FindBy(xpath = ".//span[contains(text(),'RTMP Settings')]")
    WebElementFacade rtmpSettingsButton;
    @FindBy(xpath = "//div[3]/div/div/div[2]/button")
    WebElementFacade copyStreamKeyButton;
    @FindBy(xpath = "//div[3]/div/div/div[1]/input")
    WebElementFacade streamKey;

    public boolean isHomePageVisible() {
        homepageLogo.waitUntilVisible();
        return homepageLogo.isVisible();
    }

    public void getStreamKey() {
        rtmpSettingsButton.waitUntilClickable();
        rtmpSettingsButton.click();
        Serenity.setSessionVariable("streamKey").to(streamKey.getAttribute("value"));
    }



}
