@API-History @API-Latam-Columbia @API-Latam-Brazil @API-Latam-Spain @API-Latam-Dominic
Feature: Send request for History Details API

  @API-GetFavorite-01
  Scenario Outline: Verify Get Favorite Products API
    Given send get request to latam "Favorite" for "<testcase>"
    Then  verify "Favorite" details  api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |
      | Blank-storeId |
#      | Blank-okta-accesstoken |

  @API-SuggestedSKU-02
  Scenario Outline: Verify Get Suggested SKU API
    Given send get request to latam "SuggestedSKU" for "<testcase>"
    Then  verify "SuggestedSKU" details  api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |
      | Blank-okta-accesstoken |

  @API-BalancePoints-03
  Scenario Outline: Verify BalancePoints API
    Given send get request to latam "BalancePoints" for "<testcase>"
    Then  verify "BalancePoints" sales target api details response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-ActivityList-04
  Scenario Outline: Verify ActivityList API
    Given send get request to latam "ActivityList" for "<testcase>"
    Then  verify "ActivityList" sales target api details response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-orderHistory-05
  Scenario Outline: Verify OrderHistory Details API
    Given send get request to latam "OrderHistory" for "<testcase>"
    Then  verify "OrderHistory"  api details response for "<testcase>"
    Examples:
      | testcase                 |
      | Valid-okta-accesstoken   |
      | InValid-orderType        |
      | InValid-storeId          |
      | Blank-okta-accesstoken   |
      | InValid-okta-accesstoken |

