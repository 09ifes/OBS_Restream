Feature: Set OBS Stream key
  Gets the stream key for the next upcoming stream shown in Restream.io, and adds it to OBS

  Scenario Outline: Set OBS Stream key
    Given Login to restream
    And Get the stream key for the next upcoming stream
    And Add stream key to OBS
    Then Check it has been added successfully