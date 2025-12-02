Feature: NBA API data retrieval
  
  Scenario: User can verify NBA standings data
    Given A request is made to the nba "standings" endpoint with the following
     | league   | season | team |
     | standard | 2023   | 2    |
    And The NBA api request returns a response code of 200
    Then The NBA api response should contain the following
     | response[0].league | response[0].season | response[0].team.name | response[0].team.code | response[0].team.id |
     | standard           | 2023               | Boston Celtics        | BOS                   | 2                   |

  Scenario: User can verify NBA players data
    Given A request is made to the nba "players" endpoint with the following
      | name  | season | team | country |
      | Brown | 2022   | 2    | USA     |
    And The NBA api request returns a response code of 200
    Then The NBA api response should contain the following
      | response[0].id | response[0].firstname | response[0].birth.country | response[0].nba.start | response[0].height.feets | response[0].college |
      | 75             | Jaylen                | USA                       | 2016                  | 6                        | California          |

