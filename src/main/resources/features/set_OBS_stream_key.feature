Feature: Set OBS Stream key
  Gets the stream key for the next upcoming stream shown in Restream.io, and adds it to OBS

  Scenario: Create an event
    Given Login to restream
    And Navigate to the create an event page
    And Create an event
    Then The created event should be displayed on the homepage

  Scenario: Edit an event
    Given Login to restream

  Scenario: Set OBS Stream key
    Given Login to restream
    And Get the stream key for the next upcoming stream
    And Add stream key to OBS
    Then Check it has been added successfully