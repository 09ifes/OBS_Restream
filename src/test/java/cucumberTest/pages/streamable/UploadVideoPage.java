package cucumberTest.pages.streamable;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import java.nio.file.Paths;
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

    private static String FILE_INPUT_LOCATOR = "//input[@type='file']";

    public Boolean isOpen() {
        return uploadVideoHeader.waitUntilVisible().isVisible();
    }

    public void uploadFile() {
        String videoPath = Paths.get("src/test/resources/testdata/videos/test_video_1.mp4").toAbsolutePath().toString();
        find(FILE_INPUT_LOCATOR).sendKeys(videoPath);
    }

    public Boolean isVideoUploadInProgress() {
        List<String> statuses = Arrays.asList("Uploading", "Processing");
        return statuses.stream().anyMatch(uploadVideoThumbnailBox.getText()::contains);
    }

    public Boolean isUploadVideoCheckboxVisible() {
        return uploadVideoCheckbox.waitUntilPresent().isPresent();
    }
}
