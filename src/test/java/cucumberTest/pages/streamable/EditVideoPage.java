package cucumberTest.pages.streamable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class EditVideoPage extends HomePage {

    @FindBy(xpath = "//button[contains(text(),'Upload video')]")
    private WebElementFacade uploadVideoButton;
    @FindBy(xpath = "//input[@placeholder='Paste a video URL']")
    private WebElementFacade videoUrlInput;




    public boolean isVideoUrlInputVisible() {
        return videoUrlInput.waitUntilVisible().isVisible();
    }


}
