Feature: Upload, edit and delete videos

  Users carry out various actions related to video uploads, edits and deletions

  Scenario: Users can upload videos to the site
    Given The user navigates to the streamable site
    When The user goes to the upload video page
    And The user uploads a video
    Then The video is available on the site

  Scenario: Users can edit uploaded videos
    Given The user navigates to the streamable site
    When The user goes to the upload video page
    And The user uploads a video
    And The video is available on the site
    Then The user edits the video title with "New_Title"

  Scenario: Users can delete uploaded videos
    Given The user navigates to the streamable site
    When The user goes to the upload video page
    And The user uploads a video
    And The video is available on the site
    Then The user deletes the video