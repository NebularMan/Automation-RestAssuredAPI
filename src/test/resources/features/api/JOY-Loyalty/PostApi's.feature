#@API-Joy-Loyalty
#Feature: Send request for Spin API
#
#@API-Joy-Loyalty-SpinWedges-01
#Scenario Outline: Verify SpinWedges API
#When post  loyalty "SpinWedges" request for "<testcase>"
#Then verify joy loyalty SpinWedge "SpinWedges" details api response for "<testcase>"
#Examples:
#| testcase          |
#| Blank-AccessToken |
#| Valid-AccessToken |