package cucumberTest.streamable.stepLib.checks;

import cucumberTest.streamable.pages.UploadVideoPage;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.*;


public class UploadVideoPageCheckMethods {

    UploadVideoPage uploadVideoPage = getPages().get(UploadVideoPage.class);

    public void checkUploadPageIsOpen() {
        assertTrue(uploadVideoPage.isOpen());
    }


    public void checkVideoUploadIsComplete() {
        await().atMost(ofSeconds(120)).pollInterval(ofMillis(500)).until(() -> !uploadVideoPage.isVideoUploadInProgress());
        assertFalse(uploadVideoPage.isVideoUploadInProgress(), "Video upload still ongoing");
        await().atMost(ofSeconds(20)).pollInterval(ofMillis(500)).until(() -> uploadVideoPage.isUploadVideoCheckboxVisible());
        assertThat(uploadVideoPage.uploadedVideoName()).contains("test_video_1");
    }

    public void checkVideoHasNewTitle(String videoTitle) {
        assertTrue(uploadVideoPage.uploadedVideoName().contains(videoTitle));
    }

    public void checkUploadedVideoIsDeleted() {
        await().atMost(ofSeconds(10)).pollInterval(ofMillis(500)).until(() -> !uploadVideoPage.isUploadVideoCheckboxVisible());
    }


}
