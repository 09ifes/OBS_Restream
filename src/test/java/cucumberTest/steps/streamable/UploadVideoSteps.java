package cucumberTest.steps.streamable;

import cucumberTest.stepLib.streamable.actions.UploadVideoPageActionMethods;
import cucumberTest.stepLib.streamable.checks.UploadVideoPageCheckMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class UploadVideoSteps {

    private final UploadVideoPageActionMethods uploadVideoPageActionMethods = new UploadVideoPageActionMethods();
    private final UploadVideoPageCheckMethods uploadVideoPageCheckMethods = new UploadVideoPageCheckMethods();

    @And("The user uploads a video")
    public void theUserUploadsVideo() {
        uploadVideoPageCheckMethods.checkUploadPageIsOpen();
        uploadVideoPageActionMethods.uploadVideoFile();
    }

    @And("The video is available on the site")
    public void theVideoIsAvailableOnTheSite() {
        uploadVideoPageCheckMethods.checkVideoUploadIsComplete();
    }

    @And("The user edits the video title with {string}")
    public void theUserEditsTheVideoTitle(String newVideoTitle) {
        uploadVideoPageActionMethods.editVideoTitle(newVideoTitle);
        uploadVideoPageCheckMethods.checkVideoHasNewTitle(newVideoTitle);
    }

    @Then("The user deletes the video")
    public void theUserDeletesTheVideo() {
        uploadVideoPageActionMethods.deleteVideo("test_video_1");
        uploadVideoPageCheckMethods.checkUploadedVideoIsDeleted();
    }
    
}
