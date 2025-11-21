package cucumberTest.stepLib.streamable.checks;

import cucumberTest.pages.streamable.UploadVideoPage;
import lombok.SneakyThrows;

import java.time.Duration;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UploadVideoPageCheckMethods {

    UploadVideoPage uploadVideoPage = getPages().get(UploadVideoPage.class);

    public void checkUploadPageIsOpen() {
        assertTrue(uploadVideoPage.isOpen());
    }


    public void checkVideoUploadIsComplete() {
        await().atMost(Duration.ofSeconds(60)).pollInterval(Duration.ofMillis(500)).until(() ->
                !uploadVideoPage.isVideoUploadInProgress());
        assertFalse(uploadVideoPage.isVideoUploadInProgress(), "Video upload still ongoing");
        assertTrue(uploadVideoPage.isUploadVideoCheckboxVisible(), "Video checkbox not visible");
    }

}
