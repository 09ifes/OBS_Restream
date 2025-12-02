package cucumberTest.streamable.stepLib.actions;

import cucumberTest.streamable.pages.UploadVideoPage;
import org.assertj.core.api.Fail;

import java.nio.file.Paths;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;


public class UploadVideoPageActionMethods {

    UploadVideoPage uploadVideoPage = getPages().get(UploadVideoPage.class);

    public void uploadVideoFile() {
        String videoPath = Paths.get("src/test/resources/testdata/videos/test_video_1.mp4").toAbsolutePath().toString();
        uploadVideoPage.uploadFile(videoPath);
    }

    public void editVideoTitle(String newVideoTitle) {
        uploadVideoPage.changeVideoTitle(newVideoTitle);
    }

    public void deleteVideo(String videoTitle) {
        uploadVideoPage.clickMoreButton();
        uploadVideoPage.selectDeleteOption();
        if (uploadVideoPage.deleteVideoModalText().contains(videoTitle)) {
            uploadVideoPage.clickDeleteButton();
        } else {
            Fail.fail("Wrong video name displayed. Expected: %s, Actual: %s", videoTitle,
                    uploadVideoPage.deleteVideoModalText());
        }

    }
}
