@API-GenericAPI @API-Latam-Columbia @API-Latam-Brazil @API-Latam-Spain @API-Latam-Dominic
Feature: Send request for Generic API Details

  @API-Content-01
  Scenario Outline: Verify Content Details API
    Given send get request to latam "Content" for "<testcase>"
    Then  verify "Content"  api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-Translation-02
  Scenario Outline: Verify Translation API
    Given send get request to latam "Translation" for "<testcase>"
    Then  verify "Translation" Translation api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-Holidays-03
  Scenario Outline: Verify Holidays API
    Given send get request to latam "Holidays" for "<testcase>"
    Then  verify "Holidays"  api details response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-Faq-04
  Scenario Outline: Verify Faq API
    Given send get request to latam "Faq" for "<testcase>"
    Then  verify "Faq" sales target api details response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @API-StoreImage-05
  Scenario Outline: Verify Validate StoreImage API
    Given post  latam "Storeimage" request for "<testcase>"
    Then verify latam "Storeimage"  image api response output fields for "<testcase>"
    Examples:
      | testcase               |
      | Valid-content          |
      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |

  @API-CustomerImage-06
  Scenario Outline: Verify CustomerImage  API
    Given post  latam "CustomerImage" request for "<testcase>"
    Then verify latam "CustomerImage"  image api response output fields for "<testcase>"
    Examples:
      | testcase               |
      | Valid-content          |
      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |
