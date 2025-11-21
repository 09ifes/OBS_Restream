package cucumberTest.stepLib.streamable.actions;

import cucumberTest.pages.streamable.UploadVideoPage;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;


public class UploadVideoPageActionMethods {

    UploadVideoPage uploadVideoPage = getPages().get(UploadVideoPage.class);

    public void uploadVideoFile() {
        uploadVideoPage.uploadFile();
    }
}
