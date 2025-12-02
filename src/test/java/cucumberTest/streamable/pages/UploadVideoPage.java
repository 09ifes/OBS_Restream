package cucumberTest.streamable.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.List;

public class UploadVideoPage extends HomePage{

    @FindBy(xpath = "//h1[text()='Upload video']")
    private static WebElementFacade uploadVideoHeader;
    @FindBy(xpath = "//button[text()='Upload video']")
    private static WebElementFacade uploadVideoButton;
    @FindBy(xpath = "//div[@class='video-thumbnail-container']")
    private static WebElementFacade uploadVideoThumbnailBox;
    @FindBy(xpath = "//span[@class='rc-checkbox-inner']")
    private static WebElementFacade uploadVideoCheckbox;
    @FindBy(xpath = "//textarea[@placeholder='Add a title']")
    private static WebElementFacade uploadedVideoTitle;
    @FindBy(xpath = "//button[contains(text(),'More')]")
    private static WebElementFacade moreButton;
    @FindBy(xpath = "//span[text()='Delete']")
    private static WebElementFacade deleteOption;
    @FindBy(xpath = "//button[text()='Delete']")
    private static WebElementFacade deleteButton;

    @FindBy(xpath = "//p[text()='Are you sure you want to delete']/strong")
    private static WebElementFacade deleteModal;

    private static String FILE_INPUT_LOCATOR = "//input[@type='file']";

    public Boolean isOpen() {
        return uploadVideoHeader.waitUntilVisible().isVisible();
    }

    public Boolean isVideoUploadInProgress() {
        List<String> statuses = Arrays.asList("Uploading", "Processing");
        return statuses.stream().anyMatch(uploadVideoThumbnailBox.getText()::contains);
    }

    public Boolean isUploadVideoCheckboxVisible() {
        return uploadVideoCheckbox.isPresent();
    }

    public String uploadedVideoName() {
        return uploadedVideoTitle.waitUntilVisible().getText();
    }

    public void uploadFile(String videoPath) {
         find(FILE_INPUT_LOCATOR).sendKeys(videoPath);
    }

    public void changeVideoTitle(String videoTitle) {
        uploadedVideoTitle.waitUntilVisible().clear();
        uploadedVideoTitle.sendKeys(videoTitle);
        uploadedVideoTitle.sendKeys(Keys.ENTER);
    }

    public void clickMoreButton() {
        moreButton.waitUntilVisible().click();
    }

    public String deleteVideoModalText() {
        return deleteModal.waitUntilVisible().getText();
    }

    public void selectDeleteOption() {
        deleteOption.waitUntilVisible().click();
    }
    public void clickDeleteButton() {
        deleteButton.waitUntilClickable().click();
    }

}
