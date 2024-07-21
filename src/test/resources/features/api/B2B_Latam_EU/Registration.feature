@API-Latam-Registration @API-Latam-Columbia @API-Latam-Brazil @API-Latam-Spain @API-Latam-Dominic
Feature: Send request for registration API

  @API-Registration-01
  Scenario Outline: Verify Registration API
    Given post  latam "Registration" request for "<testcase>"
    Then verify latam "Registration" api response output fields for "<testcase>"
    Examples:
      | testcase               |
      | Blank-UserId           |
      | Blank-UserId-Firstname |
      | Existing-UserId        |

  @API-ForgotPassword-02
  Scenario Outline: Verify Forgot Password API
    Given post  latam "ForgotPassword" request for "<testcase>"
    Then verify latam "ForgotPassword" api response output fields for "<testcase>"
    Examples:
      | testcase       |
      | Valid-UserName |
      | Blank-UserName |

  @API-VerifyRecovery-03
  Scenario Outline: Verify Recovery Password API
    Given post  latam "ForgotPassword" request for "Valid-UserName"
    When post  latam "VerifyRecovery" request for "<testcase>"
    Then verify latam "VerifyRecovery" api response output fields for "<testcase>"
    Examples:
      | testcase                  |
      | Valid-UserName-Token-Code |
      | Valid-UserName-Token-BlankCode |

  @API-ResetPassword-04
  Scenario Outline: Verify Reset Password API
    Given post  latam "ForgotPassword" request for "Valid-UserName"
    When post  latam "VerifyRecovery" request for "Valid-UserName-Token-Code"
    When post  latam "ResetPassword" request for "<testcase>"
    Then verify latam "ResetPassword" api response output fields for "<testcase>"
    Examples:
      | testcase                  |
      | Valid-Token-Password      |
      | Valid-Token-BlankPassword |

  @API-ValidateTaxID-05
  Scenario Outline: Verify Validate TaxID API
    Given post  latam "ValidateTaxID" request for "<testcase>"
    Then verify latam "ValidateTaxID" api response output fields for "<testcase>"
    Examples:
      | testcase              |
      | Blank-TaxID           |
      | Blank-erpId           |
      | Existing-erpIDAndTaxID|
      | Invalid-erpID         |

  @API-ValidateProfile-06
  Scenario Outline: Verify Validate Profile API
    Given post  latam "ValidateProfile" request for "<testcase>"
    Then verify latam "ValidateProfile" api response output fields for "<testcase>"
    Examples:
      | testcase              |
#      | Blank-userIdType      |
      | Blank-erpId           |
#      | Blank-userId          |
      | Existing-data          |


  @API-Deliveryestimate-07
  Scenario Outline: Verify  Delivery Estimate API
    Given send get request to latam "DeliveryEstimate" for "<testcase>"
    Then verify latam "DeliveryEstimate" api response output fields for "<testcase>"
    Examples:
      | testcase               |
      | Valid-okta-accesstoken |
      | Blank-okta-accesstoken |

  @API-DeleteUser-08
  Scenario Outline: Verify Delete User  API
    Given post  latam "DeleteUser" request for "<testcase>"
    Then verify latam "DeleteUser" addcart api response output fields for "<testcase>"
    Examples:
      | testcase            |
      | inValid-user        |
      | Blank-UserID        |

#  @API-ResendEmail-02
#  Scenario Outline: Verify Resend Email API
#    Given post "ResendEmail" request for "<testcase>"
#    Then verify "ResendEmail" api response output fields for "<testcase>"
#    Examples:
#      | testcase     |
#      | Valid-UserId |
#
#  @API-Latam-Columbia-ChangePassword-05
#  Scenario Outline: Verify Change Password API
#    Given post  latam "ChangePassword" request for "<testcase>"
#    Then verify latam "ChangePassword" api response output fields for "<testcase>"
#    Examples:
#      | testcase                          |
#      | Valid-Userid-Oldpwd-Newpwd        |
#      | Valid-Userid-InvalidOldpwd-Newpwd |
#  @API-Latam-Columbia-ClearCart-9
#  Scenario Outline: Verify clear cart  API
#    Given post  latam "ClearCart" request for "<testcase>"
#    Then verify latam "ClearCart" addcart api response output fields for "<testcase>"
#    Examples:
#      | testcase               |
#      | Valid-content          |
#      | InValid-storeId        |
#      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |
#      | Valid-ContentRewards     |
#
#  @API-Latam-Columbia-AddCart-10
#  Scenario Outline: Verify  Add cart  API
#    Given send get request to latam "Product" for "Valid-Content"
#    When post  latam "AddCart" request for "<testcase>"
#    Then verify latam "AddCart" addcart api response output fields for "<testcase>"
#    Examples:
#      | testcase               |
#      | Valid-content          |
#      | InValid-orderType      |
#      | InValid-storeId        |
#      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |
#
#  @API-Latam-Columbia-AddRewardsToCart-11
#  Scenario Outline: Verify  Add Rewards To Cart API
#    Given send get request to latam "RewardList" for "Valid-content"
#    When post  latam "AddRewardsToCart" request for "<testcase>"
#    Then verify latam "AddRewardsToCart" addcart api response output fields for "<testcase>"
#    Examples:
#      | testcase               |
#      | Valid-content          |
#      | InValid-orderType      |
##      | InValid-storeId        |
#      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |
#
#  @API-Latam-Columbia-OrderCreate-12
#  Scenario Outline: Verify  Add cart  API
#    When post  latam "OrderCreate" request for "<testcase>"
#    Then  verify "OrderCreate"  api details response for "<testcase>"
#    Examples:
#      | testcase               |
#      | Valid-content          |
#      | InValid-storeId        |
#      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |
#      | OrderCreate-Rewards    |
#
#
#  @API-Latam-Columbia-OrderCreate-13
#  Scenario Outline: Verify  Add cart without Products in cart  API
#    Given post  latam "ClearCart" request for "Valid-content"
#    Given post  latam "ClearCart" request for "Valid-ContentRewards"
#    When post  latam "OrderCreate" request for "<testcase>"
#    Then  verify "OrderCreate"  api details response for "<testcase>"
#    Examples:
#      | testcase               |
#      | OrderCreate-withoutproducts  |
#      | OrderCreate-withoutRewards  |
#
#  @API-Latam-Columbia-UpdateCart-14
#  Scenario Outline: Verify  update cart  API
#    Given send get request to latam "Product" for "Valid-Content"
#    When post  latam "UpdateCart" request for "<testcase>"
#    Then verify latam "UpdateCart" addcart api response output fields for "<testcase>"
#    Examples:
#      | testcase               |
#      | Valid-content          |
#      | InValid-orderType      |
#      | InValid-storeId        |
#      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |
#
#
#  @API-Latam-Columbia-UpdateRewards-15
#  Scenario Outline: Verify  update Rewards   API
#    Given send get request to latam "RewardList" for "Valid-content"
#    When post  latam "UpdateCart" request for "<testcase>"
#    Then verify latam "UpdateCart" addcart api response output fields for "<testcase>"
#    Examples:
#      | testcase               |
#      | Update-Rewards         |
#
#
#  @API-Latam-Columbia-GetCart-16
#  Scenario Outline: Verify GetCart  API
#    Given post  latam "GetCart" request for "<testcase>"
#    Then verify latam "GetCart" addcart api response output fields for "<testcase>"
#    Examples:
#      | testcase               |
#      | Valid-content          |
#      | Valid-Reward-content   |
#      | InValid-storeId        |
#      | Blank-okta-accesstoken |
#      | InValid-okta-accesstoken |



