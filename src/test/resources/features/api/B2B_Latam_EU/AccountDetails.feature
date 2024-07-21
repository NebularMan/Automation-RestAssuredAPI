@API-AccountDetails @API-Latam-Columbia @API-Latam-Brazil @API-Latam-Spain @API-Latam-Dominic
Feature: Send request for Account Details API

  @API-AccessToken-01
  Scenario Outline: Verify  AccessToken  API
    Given post  latam "Okta" request for "<testcase>"
    Given send get request to latam "Okta" for "<testcase>"
    Examples:
      | testcase     |
      | Valid-UserId |

  @API-GetAccountDetails-02
  Scenario Outline: Verify Get Account Details API
    Given send get request to latam "GetAccountDetails" for "<testcase>"
    Then verify latam "GetAccountDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @API-UpdateAccountDetails-03
  Scenario Outline: Verify Update Account Details API
    Given send put request to latam "UpdateAccountDetails" for "<testcase>"
    Then verify latam "UpdateAccountDetails" details api response for "<testcase>"
    Examples:
      | testcase                      |
      | Update-FirstName-AlphaNumeric |
      | Update-LastName-AlphaNumeric  |

  @API-SalesTarget-04
  Scenario Outline: Verify SalesTarget API
    Given send get request to latam "SalesTarget" for "<testcase>"
    Then  verify "SalesTarget" sales target api details response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |
#      | Blank-storeId |
      | Blank-okta-accesstoken |
