@API-GetStores @API-Latam-Columbia @API-Latam-Brazil @API-Latam-Spain @API-Latam-Dominic
Feature: Send request for GetStores Details API

  @API-GetStoreDetails-01
  Scenario Outline: Verify GetStores Details API
    Given send get request to latam "GetStoreDetails" for "<testcase>"
    Then verify "GetStoreDetails"  api response for "<testcase>"
    Examples:
      | testcase        |
      | Valid-Content   |
      | InValid-Content |

  @API-Product-02
  Scenario Outline: Verify Product Details API
    Given send get request to latam "Product" for "<testcase>"
    Then  verify "Product" details  api response for "<testcase>"
    Examples:
      | testcase               |
      | Valid-Content          |
      | Blank-storeId          |
      | Blank-okta-accesstoken |

  @API-RewardsList-03
  Scenario Outline: Verify Reward List API
    Given send get request to latam "RewardList" for "<testcase>"
    Then  verify "RewardList" rewards api response for "<testcase>"
    Examples:
      | testcase                 |
      | Valid-Content            |
      | Blank-okta-accesstoken   |
      | InValid-okta-accesstoken |

  @API-Promotion-04
  Scenario Outline: Verify Promotion Details API
    Given send get request to latam "Promotion" for "<testcase>"
    Then  verify "Promotion"  api details response for "<testcase>"
    Examples:
      | testcase                 |
      | Valid-Content            |
      | Blank-storeId            |
      | Blank-SiteId             |
      | Blank-okta-accesstoken   |
      | InValid-okta-accesstoken |

  @API-VendorList-05
  Scenario Outline: Verify VendorList API
    Given send get request to latam "VendorList" for "<testcase>"
    Then  verify "VendorList" vendor list api details response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-DeliveryEstimate-06
  Scenario Outline: Verify  Delivery Estimate  API
    Given send get request to latam "DeliveryEstimate" for "<testcase>"
    Then verify latam "DeliveryEstimate" api response output fields for "<testcase>"
    Examples:
      | testcase               |
      | Valid-okta-accesstoken |
      | Blank-okta-accesstoken |

