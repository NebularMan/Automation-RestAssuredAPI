@API-Joy-Loyalty
Feature: Validating KSA Joy API's and Integration API's

#  @API-Joy-Loyalty-AccessToken-01
#  Scenario Outline: Verify  AccessToken  API
#    Given post  latam "Okta" request for "<testcase>"
#    Given send get request to latam "Okta" for "<testcase>"
#    Examples:
#      | testcase     |
#      | Valid-UserId |

  @Regression @Feature
  Scenario Outline: Verify Get Features API
    Given send get request of joy loyalty "Features" for "<testcase>"
    Then verify joy loyalty account "Features" details api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @Regression
  Scenario Outline: Verify Get MyRewardsList API
    Given send get request of joy loyalty "MyRewardsList" for "<testcase>"
    Then verify joy loyalty "MyRewardsList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |
#
#  @API-Joy-Loyalty-ContactUsInquiry-20
#  Scenario Outline: Verify Get ContactUsInquiry API
#    Given send get request of joy loyalty "ContactUsInquiry" for "<testcase>"
#    Then verify joy loyalty "ContactUsInquiry" details api response for "<testcase>"
#    Examples:
#      | testcase          |
#      | Valid-Content     |
#
  @Brands
  Scenario Outline: Verify GetBrands API
    Given send get request of joy loyalty "GetBrands" for "<testcase>"
    Then verify joy loyalty "GetBrands" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Regression @CompletedCHLNGS
  Scenario Outline: Verify Get CompletedChallenges Details API
    Given send get request of joy loyalty "CompletedChallenges" for "<testcase>"
    Then verify joy loyalty "CompletedChallenges" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Regression @Accounts
  Scenario Outline: Verify the Customer Signup functionality.
    When post "signUP" API request for "<testcase>" with.
    Then verify joy loyalty account "signUP" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @Regression @Accounts
  Scenario Outline: Verify Customer Details after successfully registration.
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Regression @Accounts
  Scenario Outline: Verify that customer is able to update "Email" Address in the Application.
    Given HTTP PUT request of "email_Update" API for "<testcase>".
    Then verify joy loyalty account "email_Update" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @DeleteUser
  Scenario Outline: Verify that customer is able to update "Mobile Number" in the Application.
    Given HTTP PUT request of "update_Mobile" API for "<testcase>".
    Then verify joy loyalty account "update_Mobile" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Regression @Accounts
  Scenario Outline: Verify that customer is able to validate , once updation.
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Regression @Accounts
  Scenario Outline: Verify that customer is able to delete his/her account.
    When del "delCustomer" API request for "<testcase>" with.
    Then verify joy loyalty account "delCustomer" details api response for "<testcase>"
#    Then verify "active" customer status using "GetCustomerStatus" API.
#    Then verify joy loyalty account "GetCustomerStatus" details api response for "activeUser"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Regression @Accounts
  Scenario Outline: Verify that customer is able to re-activate his/her account after deletion.
    When post "reactivateCustomer" API request for "<testcase>" with.
    Then verify joy loyalty account "reactivateCustomer" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @Regression @Accounts
  Scenario Outline:  Verify customer details in Joy Application after update.
    Given HTTP PUT request of "account_Update" API for "<testcase>".
    Then verify joy loyalty account "account_Update" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Regression @Accounts @Smoke
  Scenario Outline: Verify customer status in Joy Application after deletion.
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @OKTAIntegration @Regression @Sanity @OKTAStatus
  Scenario Outline: Verify customer status in OKTA.
    Given send get request of joy loyalty "GetOKTAUserStatus" for "<testcase>"
    Then verify Okta account "GetOKTAUserStatus" details api response for "<testcase>"
    Examples:
      | testcase        |
      | Valid-AuthToken |
#      | Blank-AuthToken |
#      | Wrong-AuthToken |

  @OKTAIntegration @Regression
  Scenario Outline: Validate customer deactivation from OKTA end.
    When post  OKTA "UserDeactivate" request for "<testcase>"
    Then send get request of joy loyalty "GetOKTAUserStatusAfterDeactive" for "<testcase>"
    Then verify Okta account "GetOKTAUserStatusAfterDeactive" details api response for "<testcase>"

    Examples:
      | testcase        |
      | Valid-AuthToken |
      | Blank-AuthToken |
      | Wrong-AuthToken |

  @OKTAIntegration @Regression
  Scenario Outline: Validate customer re-activation from OKTA end.
    When post  OKTA "UserReactivate" request for "<testcase>"
    Then send get request of joy loyalty "UserReactivate" for "<testcase>"
    Then verify Okta account "UserReactivate" details api response for "<testcase>"

    Examples:
      | testcase        |
      | Valid-AuthToken |
      | Blank-AuthToken |
      | Wrong-AuthToken |

  @OKTAIntegration
  Scenario Outline: Validate customer deletion at OKTA end.
    When post  OKTA "UserDeactivate" request for "<testcase>"
    When post  OKTA "UserDeletion" request for "<testcase>"
    Then send get request of joy loyalty "UserDeletion" for "<testcase>"
    Then verify Okta account "UserDeletion" details api response for "<testcase>"

    Examples:
      | testcase          |
      | Valid-AuthToken-1 |
      | Blank-AuthToken   |
      | Wrong-AuthToken   |

  @OKTAIntegration
  Scenario Outline: Validate customer creation at OKTA end.
    When post  OKTA "UserCreation" request for "<testcase>"
    Then send get request of joy loyalty "UserCreation" for "<testcase>"
    Then verify Okta account "UserCreation" details api response for "<testcase>"

    Examples:
      | testcase        |
      | Valid-AuthToken |
      | Blank-AuthToken |
      | Wrong-AuthToken |


  @Regression @Sanity @Documentation
  Scenario Outline: Verify Get Account Details API.
    Given send get request of joy loyalty "Translation" for "<testcase>"
    Then verify joy Translation loyalty "Translation" details api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @Regression @Sanity @Documentation
  Scenario Outline: Verify that customer is able to see "Terms and Condition" Page.
    Given send get request of joy loyalty "Terms&Conditions" for "<testcase>"
    Then verify joy loyalty "Terms&Conditions" details api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @Regression @Sanity @Documentation
  Scenario Outline: Verify that customer is able to see "Privacy & Policy" Page.
    Given send get request of joy loyalty "Privacy&Policy" for "<testcase>"
    Then verify joy loyalty "Privacy&Policy" details api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @Regression @Sanity
  Scenario Outline: Verify that customer is able to see "FAQs" Page.
    Given send get request of joy loyalty "GetFaq" for "<testcase>"
    Then verify joy loyalty faq "GetFaq" details api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @Regression @Contact-Us_Feature
  Scenario Outline: Check whether customer is able to get all the raised inquiries
    Given send get request of joy loyalty "ContactUsInquiry" for "<testcase>"
    Then verify joy loyalty "ContactUsInquiry" details api response for "<testcase>"
    Examples:
      | testcase      |
      | Valid-Content |

  @Regression @Contact-Us_Feature
  Scenario Outline: Verify that customer is able to raise contact us queries with KSA Joy.
    When post  loyalty Contact US "RaiseContactUsRequest" request for "<testcase>"
    Then verify joy loyalty account "RaiseContactUsRequest" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

   @Regression
  Scenario Outline: Verify list of challenges with customer.
    Given send get request of joy loyalty "GetChallenges" for "<testcase>"
    Then verify joy loyalty "GetChallenges" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Regression
  Scenario Outline: Verify Get Account Details API
    Given send get request of joy loyalty "GetChallengeDetails" for "<testcase>"
    Then verify joy loyalty "GetChallengeDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

   @Regression
  Scenario Outline: Verify Ending Soon offer list available for customer
    Given send get request of joy loyalty "GetEndingSoon" for "<testcase>"
    Then verify joy loyalty "GetEndingSoon" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

   @Regression
  Scenario Outline:  Verify Just In offers list available for customer.
    Given send get request of joy loyalty "GetExclusiveOrJustIn" for "<testcase>"
    Then verify joy loyalty "GetExclusiveOrJustIn" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Survey type challenge where reward type is Points.
    When post "CompleteChallenge01" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge01" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Valid-AccessToken-1             |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Survey type challenge where reward type is Wallpaper.
    When post "CompleteChallenge02" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge02" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Valid-AccessToken                 |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |



  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Survey type challenge where reward type is Reward.
    When post "CompleteChallenge03" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge03" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Valid-AccessToken-1               |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |
      | ChallengewithWrongChallengeType   |



  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Survey type challenge where reward type is Draw.
    When post "CompleteChallenge04" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge04" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Valid-AccessToken-1               |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |



  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Video type challenge where reward type is Points.
    When post "CompleteChallenge05" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge05" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Valid-AccessToken-1             |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Video type challenge where reward type is Wallpaper.
    When post "CompleteChallenge06" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge06" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Valid-AccessToken-1             |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Video type challenge where reward type is Draw.
    When post "CompleteChallenge07" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge07" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Valid-AccessToken-1             |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |



  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Video type challenge where reward type is Reward.
    When post "CompleteChallenge08" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge08" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Valid-AccessToken-1             |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Coupon type challenge where reward type is Point.
    When post "CompleteChallenge09" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge09" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Coupon type challenge where reward type is Reward.
    When post "CompleteChallenge10" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge10" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |


  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Coupon type challenge where reward type is Wallpaper.
    When post "CompleteChallenge11" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge11" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |

  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Coupon type challenge where reward type is Draw.
    When post "CompleteChallenge12" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge12" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |

  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Coupon type challenge under EA Campaign.
    When post "CompleteChallenge13" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge13" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |

  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Survey type challenge under EA Campaign.
    When post "CompleteChallenge14" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge14" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |

  @Challenge @Regression
  Scenario Outline: Test to verify launch and completion of Video type challenge under EA Campaign.
    When post "CompleteChallenge15" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge15" details api response for "<testcase>"
    Examples:
      | testcase                        |
      | Valid-AccessToken               |
      | Blank-AccessToken               |
      | ChallengewithWrongChallengeID   |
      | ChallengewithWrongChallengeType |

#  @Challenge1 @Regression
#  Scenario Outline: Test to verify update in points after completion of Video type challenge where reward type is Points.
#    Given send get request of joy loyalty "Points" for "<testcase>"
#    Then verify joy loyalty account "Points" details api response for "<testcase>"
#    When post "CompleteChallenge16" API request for "<testcase>"
#    Then verify joy loyalty account "CompleteChallenge16" details api response for "<testcase>"
#    Given send get request of joy loyalty "Points" for "<testcase>"
#    Then verify joy loyalty account "Points" details api response for "<testcase>"
#    Examples:
#      | testcase            |
#      | Valid-AccessToken   |

  @Survey @Regression
  Scenario Outline: Verify Get SurveyList API
    Given send get request of joy loyalty "SurveyList" for "<testcase>"
    Then verify joy loyalty "SurveyList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Survey @Regression
  Scenario Outline: Verify Get SurveyList API
    Given send get request of joy loyalty "SurveyDetails" for "<testcase>"
    Then verify joy loyalty "SurveyDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |
      | Blank-ID          |
      | invalid-ID        |

  @Rewards @Regression
  Scenario Outline: Verify offer list available for customer.
    Given send get request of joy loyalty "OffersList" for "<testcase>"
    Then verify joy loyalty "OffersList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Rewards @Regression
  Scenario Outline: Verify Hot offer list available for customer.
    Given send get request of joy loyalty "HotOfferList" for "<testcase>"
    Then verify joy loyalty "HotOfferList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Rewards
  Scenario Outline: Verify Get OffersDetails API
    Given send get request of joy loyalty "OffersDetails" for "<testcase>"
    Then verify joy loyalty "OffersDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Rewards @Regression
  Scenario Outline: Validate reward category.
    Given send get request of joy loyalty "GetRewardCategoryList" for "<testcase>"
    Then verify joy loyalty account "GetRewardCategoryList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Verify customer is able to redeem rewards.
    When post "RewardRedemption" API request for "<testcase>"
    Then verify joy loyalty account "RewardRedemption" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Validate list of redeemed rewards by customer.
    Given send get request of joy loyalty "GetRedeemedRewardList" for "<testcase>"
    Then verify joy loyalty account "GetRedeemedRewardList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Verify customer is able to get the welcome gift.
    Given send get request of joy loyalty "GetWelcomeGiftDetails" for "<testcase>"
    Then verify joy loyalty account "GetWelcomeGiftDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Validate customer has already redeemed the welcome gift.
    When post "WelcomeGiftCompletion" API request for "<testcase>"
    Then verify joy loyalty account "WelcomeGiftCompletion" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Spin @Regression
  Scenario Outline: Verify list of Spin available for the Customer.
    Given send get request of joy loyalty "GetSpin" for "<testcase>"
    Then verify joy loyalty "GetSpin" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Spin @Regression
  Scenario Outline: Verify the Spin details.
    Given send get request of joy loyalty "SpinDetails" for "<testcase>"
    Then verify joy loyalty "SpinDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Spin @Regression
  Scenario Outline: Verify customer is able to run the spin and successfully generate the wedge.
    When post "Spin_Wedge_Generate" API request for "<testcase>"
    Then verify joy loyalty account "Spin_Wedge_Generate" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Draw1 @Regression
  Scenario Outline: Verify Get DrawList API
    Given send get request of joy loyalty "DrawList" for "<testcase>"
    Then verify joy loyalty "DrawList" details api response for "<testcase>"
    Examples:
      | testcase          |
#      | Blank-AccessToken |
      | Valid-AccessToken |

  @Draw @Regression
  Scenario Outline: Verify Get DrawDetail API
    Given send get request of joy loyalty "DrawDetail" for "<testcase>"
    Then verify joy loyalty "DrawDetail" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
#  | Valid-AccessToken |

  @Draw @Regression
  Scenario Outline: Verify customer is able to participate in Draw.
    When post "Draw-Participation" API request for "<testcase>"
    Then verify joy loyalty account "Draw-Participation" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Wallpaper @Regression
  Scenario Outline: Verify Get WallpaperList API
    Given send get request of joy loyalty "WallpaperList" for "<testcase>"
    Then verify joy loyalty "WallpaperList" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Wallpaper @Regression
  Scenario Outline: Verify Get WallpaperDetails API
    Given send get request of joy loyalty "WallpaperDetails" for "<testcase>"
    Then verify joy loyalty "WallpaperDetails" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Blank-AccessToken |
      | Valid-AccessToken |

  @Points @Regression
  Scenario Outline: Verify Get points API
    Given send get request of joy loyalty "Points" for "<testcase>"
    Then verify joy loyalty account "Points" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @Points @Regression
  Scenario Outline: Verify updation in total points when customer play the spin.
    Given HTTP PUT request of "UpdatePnt_ThrProfileUpdt" API for "<testcase>".
    Then verify joy loyalty account "UpdatePnt_ThrProfileUpdt" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Points @Regression
  Scenario Outline: Verify updation in total points when customer update his/her accounts.
    Given HTTP PUT request of "Updatepoint_throughSpinPlay" API for "<testcase>".
    Then verify joy loyalty account "Updatepoint_throughSpinPlay" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Points @Regression
  Scenario Outline: Verify updation in total points when customer buys a spin.
    Given HTTP PUT request of "Updatepoint_throughSpinBuy" API for "<testcase>".
    Then verify joy loyalty account "Updatepoint_throughSpinBuy" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @SFMC_Integration
  Scenario: Test to verify successful SFMC token generation.
    When post SFMC "TokenGenerate" API request for ValidClientID

  @SFMC_Integration
  Scenario Outline: Verify SFMC status once the customer consume the challenge.
    When post SFMC "TokenGenerate" API request for ValidClientID
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    When post "CompleteChallenge12" API request for "<testcase>"
    Then verify joy loyalty account "CompleteChallenge12" details api response for "<testcase>"
    When put SFMC "KSALoyaltyChallenge_Consumption" API request for ValidClientID
    When get Response from SFMC "RequestID_Result" API
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SFMC_Integration
  Scenario Outline: Test to verify status in SFMC after profile update.
    When post SFMC "TokenGenerate" API request for ValidClientID
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    When put SFMC "KSALoyaltyProfileUpdate" API request for ValidClientID
#    When put SFMC "KSALoyaltyChallenge_Consumption" API request for ValidClientID
    When get Response from SFMC "RequestID_Result" API
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SFMC_Integration
  Scenario Outline: Verify SFMC status after update in the challenge details.
    When post SFMC "TokenGenerate" API request for ValidClientID
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    When put SFMC "KSALoyaltyChallenge_DE" API request for ValidClientID
    When get Response from SFMC "RequestID_Result" API
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SFMC_Integration
  Scenario Outline: Verify SFMC status after update in the Voucher details.
    When post SFMC "TokenGenerate" API request for ValidClientID
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    When put SFMC "KSALoyaltyVoucher_DE" API request for ValidClientID
    When get Response from SFMC "RequestID_Result" API
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @SFMC_Integration
  Scenario Outline: Verify SFMC status after update in the Raffle details.
    When post SFMC "TokenGenerate" API request for ValidClientID
    Given send get request of joy loyalty "GetAccountDetails" for "<testcase>"
    Then verify joy loyalty account "GetAccountDetails" details api response for "<testcase>"
    When put SFMC "KSALoyaltyRaffle_DE" API request for ValidClientID
    When get Response from SFMC "RequestID_Result" API
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @Challenge @ScanChallenge @Regression
  Scenario Outline: Test to verify launch and completion of Scan challenge where reward is Points.
    When post "ScanChallenge_Points" API request for "<testcase>"
    Then verify joy loyalty account "ScanChallenge_Points" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |


  @Challenge @ScanChallenge @Regression
  Scenario Outline: Test to verify launch and completion of Scan challenge where reward is Pepsico voucher.
    When post "ScanChallenge_Rewards" API request for "<testcase>"
    Then verify joy loyalty account "ScanChallenge_Rewards" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Challenge @ScanChallenge @Regression
  Scenario Outline: Test to verify launch and completion of Scan challenge where reward is raffle.
    When post "ScanChallenge_Raffle" API request for "<testcase>"
    Then verify joy loyalty account "ScanChallenge_Raffle" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Challenge @ScanChallenge @Regression
  Scenario Outline: Test to verify launch and completion of Scan challenge where reward is Wallpaper.
    When post "ScanChallenge_Wallpaper" API request for "<testcase>"
    Then verify joy loyalty account "ScanChallenge_Wallpaper" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Challenge @ScanChallenge @Regression
  Scenario Outline: Test to verify launch and completion of Scan challenge where multiple reward is attached.
    When post "ScanChallenge_MultiReward" API request for "<testcase>"
    Then verify joy loyalty account "ScanChallenge_MultiReward" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Challenge @ScanChallenge @Regression
  Scenario Outline: Test to verify duplicate reciept error message during scan challenge.
    When post "ScanChallenge_Dispute" API request for "<testcase>"
    Then verify joy loyalty account "ScanChallenge_Dispute" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @ScanHomeFooter @Regression
  Scenario Outline: Test to verify Homefooter Scan feature.
    When post "HomeFooter" API request for "<testcase>"
    Then verify joy loyalty account "HomeFooter" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @ScanHomeFooter @Regression
  Scenario Outline: Test to verify Homefooter dispute Scan feature.
    When post "HomeFooter_Dispute" API request for "<testcase>"
    Then verify joy loyalty account "HomeFooter_Dispute" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Verify customer is able to redeem Pepsico's In-house rewards, linked to Challenge.
    When post "Pep_RewardRdmtn_Chlng" API request for "<testcase>"
    Then verify joy loyalty account "Pep_RewardRdmtn_Chlng" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Verify customer is able to redeem Pepsico's In-house rewards, linked to spin.
    When post "Pep_RewardRdmtn_Spin" API request for "<testcase>"
    Then verify joy loyalty account "Pep_RewardRdmtn_Spin" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @Rewards @Regression
  Scenario Outline: Verify customer is able to redeem Pepsico's In-house rewards, through Points.
    When post "Pep_RewardRdmtn_Points" API request for "<testcase>"
    Then verify joy loyalty account "Pep_RewardRdmtn_Points" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |


  @SegmentChallenge @Regression
  Scenario Outline: Verify availability of Segmented challenge for Male customer.
    Given HTTP PUT request of "account_Update_Seg_MaleOnly" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_MaleOnly" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegMaleOnly" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegMaleOnly" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SegmentChallenge @Regression
  Scenario Outline: Verify un-availability of Segmented challenge for Male customer. - Negative TestCase
    Given HTTP PUT request of "account_Update_Seg_MaleOnly" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_MaleOnly" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegMaleFemaleNeg" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegMaleFemaleNeg" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SegmentChallenge @Regression
  Scenario Outline: Verify availability of Segmented challenge for Female customer.
    Given HTTP PUT request of "account_Update_Seg_FemaleOnly" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_FemaleOnly" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegFemaleOnly" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegFemaleOnly" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SegmentChallenge @Regression
  Scenario Outline: Verify un-availability of Segmented challenge for Female customer. - Negative TestCase
    Given HTTP PUT request of "account_Update_Seg_FemaleOnly" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_FemaleOnly" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegFemaleOnlyNeg" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegFemaleOnlyNeg" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @SegmentChallenge @Regression
  Scenario Outline: Verify availability of Segmented challenge for specific DOB users.
    Given HTTP PUT request of "account_Update_Seg_DOB" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_DOB" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegDOB" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegDOB" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SegmentChallenge @Regression
  Scenario Outline: Verify un-availability of Segmented challenge for specific DOB users - Negative Testcase
    Given HTTP PUT request of "account_Update_Seg_DOB" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_DOB" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegDOB-Neg" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegDOB-Neg" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @SegmentChallenge @Regression
  Scenario Outline: Verify availability of Segmented challenge for specific City users.
    Given HTTP PUT request of "account_Update_Seg_City" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_City" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegCity" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegCity" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SegmentChallenge @Regression
  Scenario Outline: Verify un-availability of Segmented challenge for specific City users - Negative TestCase.
    Given HTTP PUT request of "account_Update_Seg_City" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_City" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegCity-Neg" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegCity-Neg" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |

  @SegmentChallenge @Regression
  Scenario Outline: Verify availability of Segmented challenge for specific Gender, DOB and City users.
    Given HTTP PUT request of "account_Update_Seg_Combination" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_Combination" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegComb" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegComb" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @SegmentChallenge @Regression
  Scenario Outline: Verify un-availability of Segmented challenge for specific Gender, DOB and City users-Negative TestCase.
    Given HTTP PUT request of "account_Update_Seg_Combination" API for "<testcase>".
    Then verify joy loyalty account "account_Update_Seg_Combination" details api response for "<testcase>"
    Given send get request of joy loyalty "GetChallenges_SegComb-Neg" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegComb-Neg" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @SegmentChallenge @Regression
  Scenario Outline: Verify availability of Segmented challenge for specific User.
    Given send get request of joy loyalty "GetChallenges_SegImport" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegImport" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @SegmentChallenge @Regression
  Scenario Outline: Verify un-availability of Segmented challenge for specific User-Negative Testcase.
    Given send get request of joy loyalty "GetChallenges_SegImport-Neg" for "<testcase>"
    Then verify joy loyalty "GetChallenges_SegImport-Neg" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |


  @Long_Format_Survey @Regression @Challenge
  Scenario Outline: Verify Long Format Survey challenge completion, where reward is attached as rewards.
    When post "LongFormatSurvey_Rewards" API request for "<testcase>"
    Then verify joy loyalty account "LongFormatSurvey_Rewards" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |
      | ChallengewithWrongChallengeType   |
      | ChallengewithWrongChallengeTypeID |

  @Long_Format_Survey @Regression @Challenge
  Scenario Outline: Verify Long Format Survey challenge completion, where reward is attached as rewards.
    When post "LongFormatSurvey_Points" API request for "<testcase>"
    Then verify joy loyalty account "LongFormatSurvey_Points" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |
      | ChallengewithWrongChallengeType   |
      | ChallengewithWrongChallengeTypeID |

  @Long_Format_Survey @Regression @Challenge
  Scenario Outline: Verify Long Format Survey challenge completion, where reward is attached as rewards.
    When post "LongFormatSurvey_Wallpaper" API request for "<testcase>"
    Then verify joy loyalty account "LongFormatSurvey_Wallpaper" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |
      | ChallengewithWrongChallengeType   |
      | ChallengewithWrongChallengeTypeID |

  @Long_Format_Survey @Regression @Challenge
  Scenario Outline: Verify Long Format Survey challenge completion, where reward is attached as rewards.
    When post "LongFormatSurvey_Raffle" API request for "<testcase>"
    Then verify joy loyalty account "LongFormatSurvey_Raffle" details api response for "<testcase>"
    Examples:
      | testcase                          |
      | Valid-AccessToken                 |
      | Blank-AccessToken                 |
      | ChallengewithWrongChallengeID     |
      | ChallengewithWrongChallengeType   |
      | ChallengewithWrongChallengeTypeID |


  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only Star Rating) where rewards is attached as points.
    When post "Video_Feedback_StarOnly_Points" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_StarOnly_Points" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User answered feedback question only) where rewards is attached as points.
    When post "Video_Feedback_QstnOnly_Point" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_QstnOnly_Point" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only text feedback) where rewards is attached as points.
    When post "Video_Feedback_TextOnly_Points" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_TextOnly_Points" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided all three types feedback) where rewards is attached as points.
    When post "Video_Feedback_AllFdback_Point" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_AllFdback_Point" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfull completion of Video challenge with feedback (User provided only Star Rating ) where rewards is attached as voucher.
    When post "Video_Feedback_StarOnly_Vochr" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_StarOnly_Vochr" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User answered feedback question only) where rewards is attached as voucher.
    When post "Video_Feedback_QstnOnly_Voucher" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_QstnOnly_Voucher" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only text feedback) where rewards is attached as voucher.
    When post "Video_Feedback_TextOnly_Voucher" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_TextOnly_Voucher" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided all three types feedback) where rewards is attached as voucher.
    When post "Video_Feedback_AllFdback_Vouche" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_AllFdback_Vouche" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only Star Rating) where rewards is attached as raffle.
    When post "Video_Feedback_StarOnly_Raffle" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_StarOnly_Raffle" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User answered feedback question only) where rewards is attached as raffle.
    When post "Video_Feedback_QstnOnly_Raffle" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_QstnOnly_Raffle" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only text feedback) where rewards is attached as raffle.
    When post "Video_Feedback_TextOnly_Raffle" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_TextOnly_Raffle" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided all three types feedback) where rewards is attached as raffle.
    When post "Video_Feedback_AllFdback_Raffle" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_AllFdback_Raffle" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only Star Rating) where rewards is attached as wallpaper.
    When post "Video_Feedback_StarOnly_Wallppr" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_StarOnly_Wallppr" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User answered feedback question only) where rewards is attached as wallpaper.
    When post "Video_Feedback_QstnOnly_Wallppr" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_QstnOnly_Wallppr" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided only text feedback) where rewards is attached as wallpaper.
    When post "Video_Feedback_TextOnly_Wallppr" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_TextOnly_Wallppr" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |

  @VideoFeedbackChallenge @Challenge
  Scenario Outline: Test to verify successfully completion of Video challenge with feedback (User provided all three types feedback) where rewards is attached as wallpaper.
    When post "Video_Feedback_AllFdback_Wallpp" API request for "<testcase>"
    Then verify joy loyalty account "Video_Feedback_AllFdback_Wallpp" details api response for "<testcase>"
    Examples:
      | testcase          |
      | Valid-AccessToken |
      | Blank-AccessToken |