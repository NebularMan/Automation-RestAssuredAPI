@API-Games @API-Latam-Spain
Feature: Send request for Games API

  @API-GamesList-01
  Scenario Outline: Verify Games List API
    Given send get request to latam "GamesList" for "<testcase>"
    Then verify "GamesList"  api response for "<testcase>"
    Examples:
      | testcase        |
      | Valid-okta-accesstoken   |
      | Blank-accessToken |
      | Blank-storeId |

  @API-GameLeaderboard-02
  Scenario Outline: Verify Games Leaderboard API
    Given send get request to latam "GamesList" for "<testcase>"
    Then verify "GamesList"  api response for "<testcase>"
    Examples:
      | testcase        |
      | Valid-okta-accesstoken   |
      | Blank-accessToken |
      | Blank-storeId |
