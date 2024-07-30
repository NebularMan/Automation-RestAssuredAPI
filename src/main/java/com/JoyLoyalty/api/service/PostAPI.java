package com.JoyLoyalty.api.service;

import com.utils.*;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PostAPI extends Basecode {
    private ScenarioContext context;
    private Sheet sheet;
    private XSSFWorkbook wb;
    private String apiUrl;

    public PostAPI(ScenarioContext context) throws Exception {
        this.context = context;
        apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SpinWedge");
    }

    public Object getSpinBodyFromJson() throws Exception {
        Object SpinJson;
        String usrdir = System.getProperty("user.dir");
        String path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("SpinJson");
        SpinJson = jsonFileReader(path);
        System.out.println("Change Password API request body is - " + SpinJson);
        return SpinJson;
    }

    public Response generateWedge(HashMap<String, Object> dataMap, String endpoint) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();
        bodyMap = (HashMap<String, Object>) getSpinBodyFromJson();
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("x-api-key", getjoyLoyaltyPropertyValue("joy-x-api-key"));
        System.out.println("Updated request body :" + dataMap);
        Response response = BaseApi.postAPI(bodyMap, headerMap, apiUrl);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info("Change password response is :- " + response);
        return response;

    }

    public Object getBodyFromJson(String endPoint) throws Exception {
        Object OktaDeactJson;
        String path = null;
        String usrdir = System.getProperty("user.dir");
        if (endPoint.equalsIgnoreCase("UserDeactivate")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("OktaDeactivate");
        } else if (endPoint.equalsIgnoreCase("UserCreation")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("OktaCreateUser");
        } else if (endPoint.equalsIgnoreCase("UserDeletion")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("OktaDeleteUser");
        } else if (endPoint.equalsIgnoreCase("RaiseContactUsRequest")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("RaiseContactUsEnquiry");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge01")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge01");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge01.1")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge01.1");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge02")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge02");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge03")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge03");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge04")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge04");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge05")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge05");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge06")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge06");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge07")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge07");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge08")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge08");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge09")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge09");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge10")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge10");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge11")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge11");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge12")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge12");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge13")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge13");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge14")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge14");
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge15")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("CompleteChallenge15");
        } else if (endPoint.equalsIgnoreCase("TokenGenerate")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("SFMCTokenGenerate");
        } else if (endPoint.equalsIgnoreCase("KSALoyaltyProfileUpdate")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("SFMCKSALoyaltyProfileUpdate_payload");
        } else if (endPoint.equalsIgnoreCase("KSALoyaltyChallenge_Consumption")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("KSALoyaltyChallenge_Consumption_payload");
        } else if (endPoint.equalsIgnoreCase("RewardRedemption")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("RewardRedemptionPayload");
        } else if (endPoint.equalsIgnoreCase("WelcomeGiftCompletion")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("WelcomeGiftCompletionPayload");
        } else if (endPoint.equalsIgnoreCase("Draw-Participation")) {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("Draw-ParticipationPayload");
        } else {
            path = usrdir + LoadProperties.getjoyLoyaltyPropertyValue("OktaReactivate");
        }
        OktaDeactJson = jsonFileReader(path);
        System.out.println("Request body is - " + OktaDeactJson);
        return OktaDeactJson;
    }

    public static String getBodyFromMethod(String userID, String endPoint) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("System Date is :");
        System.out.println(dtf.format(now));
        String sysDate = dtf.format(now);
        if (endPoint.equalsIgnoreCase("KSALoyaltyChallenge_Consumption")) {
            return "{\n" +
                    "  \"items\": [{\n" +
                    "    \"UID\":\"" + userID + "\",\"ChallengeID\":\"15239\",\"CEPUpdateDate\":\"" + sysDate + "\"\n" +
                    "  }\n" +
                    "  ]\n" +
                    "}\n";
        } else if (endPoint.equalsIgnoreCase("KSALoyaltyChallenge_DE")) {
            return "{\n" +
                    "   \"items\": [{\n" +
                    "     \"ChallengeID\":\"" + userID + "\",\"ChallengeName\":\"New Challenge 2\",\"CEPUpdateDate\":\"" + sysDate + "\"\n" +
                    "   }\n" +
                    "   \n" +
                    "    ]\n" +
                    "}\n";

        } else if (endPoint.equalsIgnoreCase("KSALoyaltyVoucher_DE")) {
            return "{\n" +
                    "   \"items\": [{\n" +
                    "     \"VoucherID\":\"13087\",\"VoucherName\":\"100WRDH-1\",\"CEPUpdateDate\":\"2023-12-14\"\n" +
                    "   }\n" +
                    "    ]\n" +
                    "}\n";

        } else if (endPoint.equalsIgnoreCase("KSALoyaltyRaffle_DE")) {
            return "{\n" +
                    "   \"items\": [{\n" +
                    "     \"RaffleID\":\"000111\",\"RaffleName\":\"New Raffle\",\"CEPUpdateDate\":\"2023-12-14\"\n" +
                    "   }\n" +
                    "    ]\n" +
                    "}\n";

        } else {
            return "{\n" +
                    "  \"items\": [{\n" +
                    "    \"UID\":\"" + userID + "\",\"LoyaltyAppStatus\":\"Active\",\"EmailAddress\":\"singh123\"\n" +
                    "  }]\n" +
                    "}\n" +
                    "\n";
        }

    }

    public static String getBodyFromMethodForChallenge(String endPoint, String testcase) throws Exception {
        //--Start Challenge 01 Payload
        if (endPoint.equalsIgnoreCase("CompleteChallenge01") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 197716,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": null,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType")) {
            return "{\n" +
                    "  \"challengeId\": 197716,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"poincts\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": null,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }
        //--Start Challenge 02 Payload
        else if (endPoint.equalsIgnoreCase("CompleteChallenge02") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 14578,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9213\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge02") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 141578,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9213\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge02") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 14578,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpapqer\": 9213\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }
        //--Start Challenge 03 Payload
        else if (endPoint.equalsIgnoreCase("CompleteChallenge03") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 14626,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 192730\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge03") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 141626,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 192730\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge03") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 14626,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"rewaard\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 192730\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge03") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeTypeID"))) {
            return "{\n" +
                    "  \"challengeId\": 14626,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 1921730\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge04") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 197709,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 8353\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge04") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 1971709,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 8353\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge04") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 197709,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"drqaw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 8353\n" +
                    "  },\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"questionId\": 2,\n" +
                    "      \"answer\": \"Baked and Fried\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }
        else if ((endPoint.equalsIgnoreCase("CompleteChallenge05") || (endPoint.equalsIgnoreCase("CompleteChallenge16"))) && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 15837,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge05") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 152837,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge06") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 15838,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9218\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge06") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 158382,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9218\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge06") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 15838,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpwaper\": 9218\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge07") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 15296,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 8184\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge07") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 151296,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 8184\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge07") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 15296,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"drsaw\": 8184\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge08") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 14436,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 13796\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge08") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 144136,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 13796\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge08") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 14436,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"rewaard\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 13796\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge09") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 15324,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12349\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge09") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 153224,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12349\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge09") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 15324,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"poinwts\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12349\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge10") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 15239,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 9387\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12353\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge10") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 151239,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 9387\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12353\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge10") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 15239,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"rewward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 9387\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12353\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge11") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 16970,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 13564\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12355\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge11") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 161970,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 13564\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12355\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge11") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 16970,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpwaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 13564\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12355\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge12") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 15239,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 9387\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12352\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge12") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 125239,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 9387\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12352\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge12") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 15239,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reweard\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 9387\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"viv12352\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge13") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 14040,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"prize\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14352\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"vs\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge13") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 140140,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"prize\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14352\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"vs\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge13") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 14040,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"pri2ze\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14352\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"vs\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge14") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 197769,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"prize\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14351\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge14") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 1977169,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"prize\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14351\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": [\n" +
                    "    {\n" +
                    "      \"questionId\": 1,\n" +
                    "      \"answer\": \"Corn\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge15") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 197767,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"prize\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14351\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge15") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 1977167,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"prize\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"prize\": 14351\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }  else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Rewards") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 97477,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 22442\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Rewards") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 971477,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 22442\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Rewards") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 97477,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"rewaard\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 22442\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Rewards") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeTypeID"))) {
            return "{\n" +
                    "  \"challengeId\": 97477,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 212442\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Points") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 97218,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Points") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 971218,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Points") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 97218,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"pointss\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Points") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeTypeID"))) {
            return "{\n" +
                    "  \"challengeId\": 97218,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\"reward\": 22442},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Wallpaper") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 95333,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9218\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Wallpaper") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 953331,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9218\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Wallpaper") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 95333,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaperr\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9218\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Wallpaper") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeTypeID"))) {
            return "{\n" +
                    "  \"challengeId\": 95333,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 92118\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Raffle") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 97469,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 72829\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Raffle") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 974699,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 72829\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Raffle") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeType"))) {
            return "{\n" +
                    "  \"challengeId\": 97469,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draww\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 72829\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Raffle") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeTypeID"))) {
            return "{\n" +
                    "  \"challengeId\": 97469,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 728219\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Spin_Wedge_Generate") && ((testcase.equalsIgnoreCase("Valid-AccessToken")) || (testcase.equalsIgnoreCase("Blank-AccessToken")))) {
            return "{\n" +
                    "  \"spinId\": \"13797\",\n" +
                    "  \"activeWedgesId\": [\n" +
                    "    6,\n" +
                    "    5,\n" +
                    "    4,\n" +
                    "    3,\n" +
                    "    1\n" +
                    "  ],\n" +
                    "  \"assignedWedgesId\": [],\n" +
                    "  \"wedgesRwdId\": {\n" +
                    "    \"reward\": {\n" +
                    "      \"4\": 27057\n" +
                    "    },\n" +
                    "    \"wallpaper\": {\n" +
                    "      \"6\": 9213\n" +
                    "    },\n" +
                    "    \"draw\": {\n" +
                    "      \"3\": 8650\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"wedgesFrequency\": {}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("ScanChallenge_Points")) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"71468\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "   \n" +
                    "  },\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-01-22 17:34:54\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 22:24:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650066669\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":180156842,\"img_blur\":false,\"img_file_name\":\"180156842.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"ROCKSTAR CLASSIC 30\\/0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569106,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"ROCKSTAR CLASSIC 30\\/0001\\t5.10 C\",\"total\":5.1,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569108,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS MAXX TEXAS BBQB0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569110,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS MAXX TEXAS BBQB0001\\t7.40 C\",\"total\":7.4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569112,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS POTATO CHIPS CHO001\",\"discount\":null,\"discount_rate\":null,\"id\":794569114,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS POTATO CHIPS CHO001\\t4.30 C\",\"total\":4.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.95}],\"pages\":[{\"is_lcd\":{\"score\":0.95,\"value\":false}}],\"score\":0.12025686246775091,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2691,\"language\":[\"en\",\"ar\"],\"width\":2023}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2691,\"size_kb\":1359,\"width\":2023}],\"total_pages\":1,\"warnings\":[{\"message\":\"Total Items sold doesn't match number of line items\",\"type\":\"item_counts_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0633\\u0648\\u0627\\u0642\\n\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\t\\u0647\\u0647\\u0647\\u0647\\u0647\\n*******\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0641\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0627\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\n\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\\n160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t16.80\\n\\u0646\\u0642\\u062f\\u0623\\nCash\\nSR\\t102.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165\\/006\\/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\n\\u0627\\u064a\\u0635\\u0627\\u0644 \\u0628\\u062f\\u0648\\u0646\\t\\u0627\\u0644\\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0623\\u0648 \\u0627\\u0644\\u0627\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0639\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u0627\\u0644\\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0642\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com\\/tantimimarkets\\n\\tCamSc\\n\\u0644\\u0627\\u063a\\u064a\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBGCB-56842\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"6669\",\"subtotal\":14.61,\"tax\":2.19,\"tax_lines\":[{\"base\":null,\"name\":null,\"order\":0,\"rate\":15,\"total\":2.19}],\"tip\":null,\"total\":16.8,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-01-22 17:35:03\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"tamimi\\nGore 166\\nRIYADH\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/us\\/150113248.png\",\"name\":\"Tamimi Markets\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"tamimi\\nGore 166\\nRIYADH\",\"raw_name\":\"Tamimi Markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimerkete.com\"}}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("ScanChallenge_Rewards")) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"76678\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"rewards\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "   \n" +
                    "  },\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-01-22 17:34:54\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 22:24:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650066669\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":180156842,\"img_blur\":false,\"img_file_name\":\"180156842.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"ROCKSTAR CLASSIC 30\\/0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569106,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"ROCKSTAR CLASSIC 30\\/0001\\t5.10 C\",\"total\":5.1,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569108,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS MAXX TEXAS BBQB0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569110,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS MAXX TEXAS BBQB0001\\t7.40 C\",\"total\":7.4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569112,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS POTATO CHIPS CHO001\",\"discount\":null,\"discount_rate\":null,\"id\":794569114,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS POTATO CHIPS CHO001\\t4.30 C\",\"total\":4.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.95}],\"pages\":[{\"is_lcd\":{\"score\":0.95,\"value\":false}}],\"score\":0.12025686246775091,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2691,\"language\":[\"en\",\"ar\"],\"width\":2023}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2691,\"size_kb\":1359,\"width\":2023}],\"total_pages\":1,\"warnings\":[{\"message\":\"Total Items sold doesn't match number of line items\",\"type\":\"item_counts_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0633\\u0648\\u0627\\u0642\\n\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\t\\u0647\\u0647\\u0647\\u0647\\u0647\\n*******\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0641\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0627\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\n\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\\n160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t16.80\\n\\u0646\\u0642\\u062f\\u0623\\nCash\\nSR\\t102.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165\\/006\\/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\n\\u0627\\u064a\\u0635\\u0627\\u0644 \\u0628\\u062f\\u0648\\u0646\\t\\u0627\\u0644\\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0623\\u0648 \\u0627\\u0644\\u0627\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0639\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u0627\\u0644\\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0642\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com\\/tantimimarkets\\n\\tCamSc\\n\\u0644\\u0627\\u063a\\u064a\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBGCB-56842\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"6669\",\"subtotal\":14.61,\"tax\":2.19,\"tax_lines\":[{\"base\":null,\"name\":null,\"order\":0,\"rate\":15,\"total\":2.19}],\"tip\":null,\"total\":16.8,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-01-22 17:35:03\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"tamimi\\nGore 166\\nRIYADH\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/us\\/150113248.png\",\"name\":\"Tamimi Markets\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"tamimi\\nGore 166\\nRIYADH\",\"raw_name\":\"Tamimi Markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimerkete.com\"}}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("ScanChallenge_Raffle")) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"76679\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "   \"draw\": 72830\n" +
                    "  },\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-01-22 17:34:54\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 22:24:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650066669\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":180156842,\"img_blur\":false,\"img_file_name\":\"180156842.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"ROCKSTAR CLASSIC 30\\/0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569106,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"ROCKSTAR CLASSIC 30\\/0001\\t5.10 C\",\"total\":5.1,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569108,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS MAXX TEXAS BBQB0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569110,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS MAXX TEXAS BBQB0001\\t7.40 C\",\"total\":7.4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569112,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS POTATO CHIPS CHO001\",\"discount\":null,\"discount_rate\":null,\"id\":794569114,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS POTATO CHIPS CHO001\\t4.30 C\",\"total\":4.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.95}],\"pages\":[{\"is_lcd\":{\"score\":0.95,\"value\":false}}],\"score\":0.12025686246775091,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2691,\"language\":[\"en\",\"ar\"],\"width\":2023}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2691,\"size_kb\":1359,\"width\":2023}],\"total_pages\":1,\"warnings\":[{\"message\":\"Total Items sold doesn't match number of line items\",\"type\":\"item_counts_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0633\\u0648\\u0627\\u0642\\n\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\t\\u0647\\u0647\\u0647\\u0647\\u0647\\n*******\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0641\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0627\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\n\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\\n160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t16.80\\n\\u0646\\u0642\\u062f\\u0623\\nCash\\nSR\\t102.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165\\/006\\/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\n\\u0627\\u064a\\u0635\\u0627\\u0644 \\u0628\\u062f\\u0648\\u0646\\t\\u0627\\u0644\\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0623\\u0648 \\u0627\\u0644\\u0627\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0639\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u0627\\u0644\\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0642\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com\\/tantimimarkets\\n\\tCamSc\\n\\u0644\\u0627\\u063a\\u064a\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBGCB-56842\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"6669\",\"subtotal\":14.61,\"tax\":2.19,\"tax_lines\":[{\"base\":null,\"name\":null,\"order\":0,\"rate\":15,\"total\":2.19}],\"tip\":null,\"total\":16.8,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-01-22 17:35:03\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"tamimi\\nGore 166\\nRIYADH\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/us\\/150113248.png\",\"name\":\"Tamimi Markets\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"tamimi\\nGore 166\\nRIYADH\",\"raw_name\":\"Tamimi Markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimerkete.com\"}}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("ScanChallenge_Wallpaper")) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"77016\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "   \"wallpaper\": 9213\n" +
                    "  },\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-01-22 17:34:54\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 22:24:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650066669\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":180156842,\"img_blur\":false,\"img_file_name\":\"180156842.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"ROCKSTAR CLASSIC 30\\/0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569106,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"ROCKSTAR CLASSIC 30\\/0001\\t5.10 C\",\"total\":5.1,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569108,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS MAXX TEXAS BBQB0001\",\"discount\":null,\"discount_rate\":null,\"id\":794569110,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS MAXX TEXAS BBQB0001\\t7.40 C\",\"total\":7.4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":794569112,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS POTATO CHIPS CHO001\",\"discount\":null,\"discount_rate\":null,\"id\":794569114,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS POTATO CHIPS CHO001\\t4.30 C\",\"total\":4.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.95}],\"pages\":[{\"is_lcd\":{\"score\":0.95,\"value\":false}}],\"score\":0.12025686246775091,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2691,\"language\":[\"en\",\"ar\"],\"width\":2023}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2691,\"size_kb\":1359,\"width\":2023}],\"total_pages\":1,\"warnings\":[{\"message\":\"Total Items sold doesn't match number of line items\",\"type\":\"item_counts_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0633\\u0648\\u0627\\u0642\\n\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\t\\u0647\\u0647\\u0647\\u0647\\u0647\\n*******\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0641\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0627\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\n\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\\n160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a\\u0646 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0645\\u0627\\u0643\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u064a\\u0632\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t16.80\\n\\u0646\\u0642\\u062f\\u0623\\nCash\\nSR\\t102.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165\\/006\\/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\n\\u0627\\u064a\\u0635\\u0627\\u0644 \\u0628\\u062f\\u0648\\u0646\\t\\u0627\\u0644\\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0623\\u0648 \\u0627\\u0644\\u0627\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0639\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u0627\\u0644\\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0642\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com\\/tantimimarkets\\n\\tCamSc\\n\\u0644\\u0627\\u063a\\u064a\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd2a4ae6-b793-4a8b-bdfc-9565de57246b\\/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBGCB-56842\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"6669\",\"subtotal\":14.61,\"tax\":2.19,\"tax_lines\":[{\"base\":null,\"name\":null,\"order\":0,\"rate\":15,\"total\":2.19}],\"tip\":null,\"total\":16.8,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-01-22 17:35:03\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"tamimi\\nGore 166\\nRIYADH\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/us\\/150113248.png\",\"name\":\"Tamimi Markets\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"tamimi\\nGore 166\\nRIYADH\",\"raw_name\":\"Tamimi Markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimerkete.com\"}}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("ScanChallenge_MultiReward")) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"77026\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\",\n" +
                    "    \"points\",\n" +
                    "    \"reward\",\n" +
                    "    \"draw\"\n" +
                    "\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "   \"wallpaper\": 9213,\n" +
                    "   \"reward\": 76362,\n" +
                    "   \"draw\":72830\n" +
                    "  },\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":null,\"created_date\":\"2024-03-15 07:19:50\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 22:24:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650066669\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":192214339,\"img_blur\":false,\"img_file_name\":\"192214339.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/3815cbb9-c217-49a9-a756-9ccfd472c28d\\/thumbnail.jpg?Expires=1710488104&Signature=BqclA98NqL81CDo2Gv7OTN1yI8r0vHNcrHRpeIUA~L7zSNTF8QhpVPGkQs~Cae2wdVY8le0w9m6PyIHzqmglEqAzg3J4afwUmqZyqUHwZWi-eABOllqf9uuDXsVcNxprj4khOCFCTqZmtHzTu91n30gIamDmZ7yQXIYq7FBrQpiOtxGyq1l~68I7PF53QxBrs26pPw9ve36bnUwbynN37BRB~6VEK5IWBCOaVXzuw-BlEqDUQ8X0qCzWHvRY0FcIJGxSTd4wvA4HBBqO3LElcb71LWRyIx~aZjAQMWqGWcPyVQ5ymg0HAFyknM-HytpIdhjIy0ZQw5OimwPJfI8F5A__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/3815cbb9-c217-49a9-a756-9ccfd472c28d\\/d455ecb3-d3c7-4ed1-8a8f-d3372a4faab1.jpg?Expires=1710488104&Signature=SyFMnm2OVOj8mYJ69-RzCV3n7yIuXAgGDTkUswFRh4fCS5rXvDF-mEjbvCRjtDEIqiZsY28jyDpnkQ~8BqDoe0Bo3EDFfBTi9sBxVd6TeSFQfIrN2MdTKKMKa67fnTh6XJs5qYay2zHqm9grWCWS0BTdp7WQuvoXXLP8giIKBilydXf6mQ~6bsJzgVhPXS44uww23V6rR4bP9pLgMfjrzFSrppL-VMY6Ik7USpBjIaDEn2sg3SYyup6oSXsBRWdBGyX4yxnVvHyBbLuLO81CpTsFoBZ1igjB24kM3q3fZc8YMw10Otk5t0Ex9mKAIvT1aUKiJfbOcReeHOQDfwxu4g__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":null,\"date\":null,\"description\":\"\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643 ROCKSTAR CLASSIC 30\\/0001\",\"hsn\":null,\"id\":852468701,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\",\"total\":5.1,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":null,\"date\":null,\"description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632 LAYS MAXX TEXAS BBQB0001\",\"hsn\":null,\"id\":852468702,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\",\"total\":7.4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":null,\"date\":null,\"description\":\"80\\u062c \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS POTATO CHIPS CH0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"80\\u062c \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632 LAYS POTATO CHIPS CH0001\",\"hsn\":null,\"id\":852468703,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"80\\u062c\\t\\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS POTATO CHIPS CH0001\\t4.30 C\",\"total\":4.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.94}],\"pages\":[{\"is_lcd\":{\"score\":0.94,\"value\":false}}],\"score\":0.12025686246775091,\"submissions\":{\"last_2_weeks\":0,\"last_day\":0,\"last_minutes\":0,\"last_month\":0,\"last_week\":0},\"version\":null},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2542,\"language\":[\"en\",\"ar\"],\"width\":2009}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2542,\"size_kb\":1567,\"width\":2009}],\"total_pages\":1,\"warnings\":[]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\nS\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE \\/ 800-303-0010\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n\\n\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\\n160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n80\\u062c\\t\\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS POTATO CHIPS CH0001\\t4.30 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t16.80\\n\\u0646\\u0642\\u062f\\u0623\\nCash\\t\\tSR\\t102.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\tSR\\t-85.20\\n\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\t\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165\\/006\\/015\\t05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\tOUT RECCO\\t--\\n- --N \\u0625\\u064a\\u0635\\u0627 \\u0628\\u062f\\u0648\\u0646 \\u0644\\u0627\\u063a\\u0631\\u060c \\u0627\\u0644\\u0625\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639\\n****\\t*******\\t*****\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0645\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n\\nVisit us at:\\nwww.tamlinimarketo.com\\nwwww.facebook.com\\/tanilmimarkets\\n\\tCamScanner \\u0628\\u0640 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/3815cbb9-c217-49a9-a756-9ccfd472c28d\\/9c4ee3fb-0e49-4570-9122-f25d914b0f68.pdf?Expires=1710488104&Signature=gFXWFAaAXBFcG-kLKtxHGNqCQPpBgVm7tl3hXPVD83GwbZL8ZADiVYKFea~i6yvt~1mwimkIaUNTLX6D238Q7khIswEnX831K0jJZahUq4Ft2N6hBGHIsmwbVC65mie6Y~UdoX~jjxxi9EKEYfJWgiB-d~G~dSnirUjI2zRXXujZAV~K3nLUj9OctydVt3pHdj6KVi6mcWrPOy6UNk1vohI6UURZcNoMXxCLfasP5LpT6eFPydMRCoLXU-8Jt-XKaUmF42baSRLaix35U6GLD-5DA0mIghrQqFslKci3AhKpeb8E0y9hEe4iGgnPCdVxBBnSM5Jz42J6xSwwMDRd5A__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBHEC-14339\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"165\",\"subtotal\":14.61,\"tax\":2.19,\"tax_lines\":[{\"base\":14.61,\"name\":\"VAT\",\"order\":0,\"rate\":15,\"total\":2.19}],\"tip\":null,\"total\":16.8,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-03-15 07:20:04\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"\\u0627\\u0644\\u0628\\u062f\\u064a\\u0639\\u0629, Al Riyadh, Riyadh, Saudi Arabia\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":24.610556016,\"lng\":46.675832961,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/3eb16ac2-e05f-4dfe-9664-485ab118b669.png\",\"name\":\"\\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0627\\u0644\\u062d\\u0644\\u0648\\u064a\\u0627\\u062a\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"BADIA ROAD RIYADH\",\"raw_name\":\"tamimi markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamlinimarketo.com\"}}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("ScanChallenge_Dispute")) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 77016,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9213\n" +
                    "  },\n" +
                    "  \"isRejected\": true,\n" +
                    "  \"rejectionReason\": \"Duplicate Receipt\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":null,\"created_date\":\"2024-03-15 07:19:50\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 22:24:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650066669\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":192214339,\"img_blur\":false,\"img_file_name\":\"192214339.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/3815cbb9-c217-49a9-a756-9ccfd472c28d\\/thumbnail.jpg?Expires=1710488104&Signature=BqclA98NqL81CDo2Gv7OTN1yI8r0vHNcrHRpeIUA~L7zSNTF8QhpVPGkQs~Cae2wdVY8le0w9m6PyIHzqmglEqAzg3J4afwUmqZyqUHwZWi-eABOllqf9uuDXsVcNxprj4khOCFCTqZmtHzTu91n30gIamDmZ7yQXIYq7FBrQpiOtxGyq1l~68I7PF53QxBrs26pPw9ve36bnUwbynN37BRB~6VEK5IWBCOaVXzuw-BlEqDUQ8X0qCzWHvRY0FcIJGxSTd4wvA4HBBqO3LElcb71LWRyIx~aZjAQMWqGWcPyVQ5ymg0HAFyknM-HytpIdhjIy0ZQw5OimwPJfI8F5A__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/3815cbb9-c217-49a9-a756-9ccfd472c28d\\/d455ecb3-d3c7-4ed1-8a8f-d3372a4faab1.jpg?Expires=1710488104&Signature=SyFMnm2OVOj8mYJ69-RzCV3n7yIuXAgGDTkUswFRh4fCS5rXvDF-mEjbvCRjtDEIqiZsY28jyDpnkQ~8BqDoe0Bo3EDFfBTi9sBxVd6TeSFQfIrN2MdTKKMKa67fnTh6XJs5qYay2zHqm9grWCWS0BTdp7WQuvoXXLP8giIKBilydXf6mQ~6bsJzgVhPXS44uww23V6rR4bP9pLgMfjrzFSrppL-VMY6Ik7USpBjIaDEn2sg3SYyup6oSXsBRWdBGyX4yxnVvHyBbLuLO81CpTsFoBZ1igjB24kM3q3fZc8YMw10Otk5t0Ex9mKAIvT1aUKiJfbOcReeHOQDfwxu4g__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":null,\"date\":null,\"description\":\"\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643 ROCKSTAR CLASSIC 30\\/0001\",\"hsn\":null,\"id\":852468701,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\",\"total\":5.1,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":null,\"date\":null,\"description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"160\\u062c \\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632 LAYS MAXX TEXAS BBQB0001\",\"hsn\":null,\"id\":852468702,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\",\"total\":7.4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":null,\"date\":null,\"description\":\"80\\u062c \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS POTATO CHIPS CH0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"80\\u062c \\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632 LAYS POTATO CHIPS CH0001\",\"hsn\":null,\"id\":852468703,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"80\\u062c\\t\\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS POTATO CHIPS CH0001\\t4.30 C\",\"total\":4.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.94}],\"pages\":[{\"is_lcd\":{\"score\":0.94,\"value\":false}}],\"score\":0.12025686246775091,\"submissions\":{\"last_2_weeks\":0,\"last_day\":0,\"last_minutes\":0,\"last_month\":0,\"last_week\":0},\"version\":null},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2542,\"language\":[\"en\",\"ar\"],\"width\":2009}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2542,\"size_kb\":1567,\"width\":2009}],\"total_pages\":1,\"warnings\":[]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\nS\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE \\/ 800-303-0010\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n\\n\\u0645\\u0644 250 \\u0627\\u0644\\u0637\\u0627\\u0642\\u0629 \\u0645\\u0634\\u0631\\u0648\\u0628 \\u0633\\u062a\\u0627\\u0631 \\u0631\\u0648\\u0643\\nROCKSTAR CLASSIC 30\\/0001\\t5.10 C\\n160\\u062c\\t\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u062a\\u06a9\\u0633\\u0627\\u0633 \\u0645\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n80\\u062c\\t\\u0627\\u0644\\u062d\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0634\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS POTATO CHIPS CH0001\\t4.30 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t16.80\\n\\u0646\\u0642\\u062f\\u0623\\nCash\\t\\tSR\\t102.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\tSR\\t-85.20\\n\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\t\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165\\/006\\/015\\t05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\tOUT RECCO\\t--\\n- --N \\u0625\\u064a\\u0635\\u0627 \\u0628\\u062f\\u0648\\u0646 \\u0644\\u0627\\u063a\\u0631\\u060c \\u0627\\u0644\\u0625\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639\\n****\\t*******\\t*****\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0645\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n\\nVisit us at:\\nwww.tamlinimarketo.com\\nwwww.facebook.com\\/tanilmimarkets\\n\\tCamScanner \\u0628\\u0640 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/3815cbb9-c217-49a9-a756-9ccfd472c28d\\/9c4ee3fb-0e49-4570-9122-f25d914b0f68.pdf?Expires=1710488104&Signature=gFXWFAaAXBFcG-kLKtxHGNqCQPpBgVm7tl3hXPVD83GwbZL8ZADiVYKFea~i6yvt~1mwimkIaUNTLX6D238Q7khIswEnX831K0jJZahUq4Ft2N6hBGHIsmwbVC65mie6Y~UdoX~jjxxi9EKEYfJWgiB-d~G~dSnirUjI2zRXXujZAV~K3nLUj9OctydVt3pHdj6KVi6mcWrPOy6UNk1vohI6UURZcNoMXxCLfasP5LpT6eFPydMRCoLXU-8Jt-XKaUmF42baSRLaix35U6GLD-5DA0mIghrQqFslKci3AhKpeb8E0y9hEe4iGgnPCdVxBBnSM5Jz42J6xSwwMDRd5A__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBHEC-14339\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"165\",\"subtotal\":14.61,\"tax\":2.19,\"tax_lines\":[{\"base\":14.61,\"name\":\"VAT\",\"order\":0,\"rate\":15,\"total\":2.19}],\"tip\":null,\"total\":16.8,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-03-15 07:20:04\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"\\u0627\\u0644\\u0628\\u062f\\u064a\\u0639\\u0629, Al Riyadh, Riyadh, Saudi Arabia\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":24.610556016,\"lng\":46.675832961,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/3eb16ac2-e05f-4dfe-9664-485ab118b669.png\",\"name\":\"\\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0627\\u0644\\u062d\\u0644\\u0648\\u064a\\u0627\\u062a\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"BADIA ROAD RIYADH\",\"raw_name\":\"tamimi markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamlinimarketo.com\"}}\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("HomeFooter")) {

            return "{\n" +
                    "\t  \"type\": \"direct\",\n" +
                    "\t  \"challengeId\": \"\",\n" +
                    "\t  \"challengeType\": \"\",\n" +
                    "\t  \"challengeTypeId\": \"\",\n" +
                    "\t  \"isRejected\": false,\n" +
                    "\t  \"rejectionReason\": \"\",\n" +
                    "\t  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-03-18 13:18:19\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 21:40:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650041037\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":192764307,\"img_blur\":false,\"img_file_name\":\"192764307.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/4c165e6d-8450-4675-a8c4-4182827869d6\\/thumbnail.jpg?Expires=1710768806&Signature=BIPUtAj9hGiRw4Vgz1GMncI9iYgbRYyhMAlyrJOmHOBS34MKvPOUXJoMnqFlWW9GyEofT3cix71aEsbzvkO-SY8r6x1sv0aUhlxCY55xpeqltC1J4-iNaJTkY-2KAI~uWUcQt34F~6meYIOQ6xfL5utGucDxQESgNJg50McLEXqxU~Ydqn-huAVLkoCnoEnt1-f84l4fgHbpNC7FVfyNy1i14G8bADmnQz1F~17qp7rjq5XOoHNUvzktJPnwyfD6QnMT1VCdSa6S~Nj09hkDpUJ360RDZKc2txZ1keage6993evvj-V5KLJWuPZx2ilmVq0WcPAK-FaO0kSmt6KNCg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/4c165e6d-8450-4675-a8c4-4182827869d6\\/fe94b696-5014-4072-bf0a-4a0ca7f2d12b.jpg?Expires=1710768806&Signature=XXNIlbbFzi~6GOT6737N24akJ~tusN--oxkGQlr3tK79kpV8VY4vgcURml~EUhfjvgACRCSnlBF9cEJG~U~AU4-tDRpG0EmgfkMqA6TLvaztAGUnkEn2qOQNwUhgmwXQN930ShlYlgyIIwsOT7MKU4m-nE7H6J2N-FdNxvf1vUeubEjw~1xj1QGjrg7Oj94wVbIzU5YRDbg98j~Vb51crgiB8t6gGD-PKDTTuME8Rtz52QmSV4Ayjlzr1PBKplQRvml6M~Uoi6cPLZffJh4rVrKWqoaEI8eoBqiuW1GD0cM5i2kGXtprmjI9hxuwfz75DyT~2j76hUoW~Bokfxf9kA__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u062c\\u0631\\u0627\\u0645 170 \\u0627\\u0644\\u0623\\u0633\\u0648\\u062f \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0644\\u0627\\u064a\\u0632 - \\u0647\\u06cc\\u062a\\u0648\\u0632\\nLAYS FORNO BLK PEPER0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u062c\\u0631\\u0627\\u0645 170 \\u0627\\u0644\\u0623\\u0633\\u0648\\u062f \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0644\\u0627\\u064a\\u0632 - \\u0647\\u06cc\\u062a\\u0648\\u0632 LAYS FORNO BLK PEPER0001\",\"hsn\":null,\"id\":855188972,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062c\\u0631\\u0627\\u0645 170 \\u0627\\u0644\\u0623\\u0633\\u0648\\u062f \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0644\\u0627\\u064a\\u0632 - \\u0647\\u06cc\\u062a\\u0648\\u0632\\nLAYS FORNO BLK PEPER0001\\t8.15 C\",\"total\":8.15,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u062d\\u0631\\u0627\\u0645 170 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u0644\\u0627\\u064a\\u0632 - \\u0634\\u064a\\u062a\\u0648\\u0632\\nLAYS FORNO AUTH CHSE0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u062d\\u0631\\u0627\\u0645 170 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u0644\\u0627\\u064a\\u0632 - \\u0634\\u064a\\u062a\\u0648\\u0632 LAYS FORNO AUTH CHSE0001\",\"hsn\":null,\"id\":855188973,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062d\\u0631\\u0627\\u0645\\t170 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u0644\\u0627\\u064a\\u0632 - \\u0634\\u064a\\u062a\\u0648\\u0632\\nLAYS FORNO AUTH CHSE0001\\t8.45 C\",\"total\":8.45,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646\\n7 UP NRB 4\\/6\\/250ML -0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646 7 UP NRB 4\\/6\\/250ML -0001\",\"hsn\":null,\"id\":855188974,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646\\n7 UP NRB 4\\/6\\/250ML -0001\\t2.50 C\",\"total\":2.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"170 \\u062c \\u0648\\u0627\\u0644\\u062e\\u0644 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633\\u0649 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0646\\u06cc\\u0632\\nLAYS NAT POT CHIP SA0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"170 \\u062c \\u0648\\u0627\\u0644\\u062e\\u0644 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633\\u0649 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0646\\u06cc\\u0632 LAYS NAT POT CHIP SA0001\",\"hsn\":null,\"id\":855188975,\"lot\":null,\"normalized_description\":null,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"170\\t\\u062c \\u0648\\u0627\\u0644\\u062e\\u0644 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633\\u0649 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0646\\u06cc\\u0632\\nLAYS NAT POT CHIP SA0001\\t7.30 C\",\"total\":7.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u062c 48 \\u0646\\u0627\\u0631 \\u062d\\u0627\\u0631 \\u0634\\u06cc\\u0628\\u06c1 \\u0628\\u0637\\u0627\\u0637\\u0647 \\u0646\\u06cc\\u0632\\nLAYS FLAMING HOT 20\\/0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u062c 48 \\u0646\\u0627\\u0631 \\u062d\\u0627\\u0631 \\u0634\\u06cc\\u0628\\u06c1 \\u0628\\u0637\\u0627\\u0637\\u0647 \\u0646\\u06cc\\u0632 LAYS FLAMING HOT 20\\/0001\",\"hsn\":null,\"id\":855188976,\"lot\":null,\"normalized_description\":null,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062c 48 \\u0646\\u0627\\u0631 \\u062d\\u0627\\u0631 \\u0634\\u06cc\\u0628\\u06c1 \\u0628\\u0637\\u0627\\u0637\\u0647 \\u0646\\u06cc\\u0632\\nLAYS FLAMING HOT 20\\/0001\\t2.50 C\",\"total\":2.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"48 \\u062c \\u0628\\u0627\\u0644\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u06cc\\u0632\\nLAYS SALT POTATO CHI0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"48 \\u062c \\u0628\\u0627\\u0644\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u06cc\\u0632 LAYS SALT POTATO CHI0001\",\"hsn\":null,\"id\":855188977,\"lot\":null,\"normalized_description\":null,\"order\":5,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"48\\t\\u062c \\u0628\\u0627\\u0644\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u06cc\\u0632\\nLAYS SALT POTATO CHI0001\\t2.50 C\",\"total\":2.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"23\\u062c \\u0648\\u0627\\u0644\\u0644\\u064a\\u0645\\u0648\\u0646 \\u0627\\u0644\\u0634\\u0637\\u0629 \\u0628\\u0637\\u0639\\u0645 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS CHILI LIME DUPL0001\\nItem Voids (01)\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"23\\u062c \\u0648\\u0627\\u0644\\u0644\\u064a\\u0645\\u0648\\u0646 \\u0627\\u0644\\u0634\\u0637\\u0629 \\u0628\\u0637\\u0639\\u0645 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632 LAYS CHILI LIME DUPL0001\\nItem Voids (01)\",\"hsn\":null,\"id\":855188978,\"lot\":null,\"normalized_description\":null,\"order\":6,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"23\\u062c\\t\\u0648\\u0627\\u0644\\u0644\\u064a\\u0645\\u0648\\u0646 \\u0627\\u0644\\u0634\\u0637\\u0629 \\u0628\\u0637\\u0639\\u0645 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS CHILI LIME DUPL0001\\t1.15 C\\nItem Voids (01)\",\"total\":1.15,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646\\n7 UP NRB 4\\/6\\/250ML\\nItem Voids [01]\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646 7 UP NRB 4\\/6\\/250ML\\nItem Voids [01]\",\"hsn\":null,\"id\":855188979,\"lot\":null,\"normalized_description\":null,\"order\":7,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646\\n7 UP NRB 4\\/6\\/250ML -0001\\t-2.50 C\\nItem Voids [01]\",\"total\":-2.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"48 \\u062c \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0647 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u064a\\u0632\\nLAYS SALT POTATO CHI0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"48 \\u062c \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0647 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u064a\\u0632 LAYS SALT POTATO CHI0001\",\"hsn\":null,\"id\":855188980,\"lot\":null,\"normalized_description\":null,\"order\":8,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"48\\t\\u062c \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0647 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u064a\\u0632\\nLAYS SALT POTATO CHI0001\\t-2.50 C\",\"total\":-2.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.93}],\"pages\":[{\"is_lcd\":{\"score\":0.93,\"value\":false}}],\"score\":0.12025686246775091,\"submissions\":{\"last_2_weeks\":1,\"last_day\":1,\"last_minutes\":1,\"last_month\":1,\"last_week\":1},\"version\":null},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2274,\"language\":[\"en\",\"ar\"],\"width\":1771}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2274,\"size_kb\":1568,\"width\":1771}],\"total_pages\":1,\"warnings\":[{\"message\":\"Total Items sold doesn't match number of line items\",\"type\":\"item_counts_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE A 800-303-0010\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n\\u062c\\u0631\\u0627\\u0645 170 \\u0627\\u0644\\u0623\\u0633\\u0648\\u062f \\u0628\\u0627\\u0644\\u0641\\u0644\\u0641\\u0644 \\u0644\\u0627\\u064a\\u0632 - \\u0647\\u06cc\\u062a\\u0648\\u0632\\nLAYS FORNO BLK PEPER0001\\t8.15 C\\n\\u062d\\u0631\\u0627\\u0645\\t170 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u0644\\u0627\\u064a\\u0632 - \\u0634\\u064a\\u062a\\u0648\\u0632\\nLAYS FORNO AUTH CHSE0001\\t8.45 C\\n\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646\\n7 UP NRB 4\\/6\\/250ML -0001\\t2.50 C\\n170\\t\\u062c \\u0648\\u0627\\u0644\\u062e\\u0644 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633\\u0649 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0646\\u06cc\\u0632\\nLAYS NAT POT CHIP SA0001\\t7.30 C\\n\\u062c 48 \\u0646\\u0627\\u0631 \\u062d\\u0627\\u0631 \\u0634\\u06cc\\u0628\\u06c1 \\u0628\\u0637\\u0627\\u0637\\u0647 \\u0646\\u06cc\\u0632\\nLAYS FLAMING HOT 20\\/0001\\t2.50 C\\n48\\t\\u062c \\u0628\\u0627\\u0644\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u06cc\\u0632\\nLAYS SALT POTATO CHI0001\\t2.50 C\\n23\\u062c\\t\\u0648\\u0627\\u0644\\u0644\\u064a\\u0645\\u0648\\u0646 \\u0627\\u0644\\u0634\\u0637\\u0629 \\u0628\\u0637\\u0639\\u0645 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0644\\u06cc\\u0632\\nLAYS CHILI LIME DUPL0001\\t1.15 C\\nItem Voids (01)\\n\\u0645\\u0644 250-300 \\u0635\\u0648\\u062f\\u0627 \\u0623\\u0628 \\u0633\\u0641\\u0646\\n7 UP NRB 4\\/6\\/250ML -0001\\t-2.50 C\\nItem Voids [01]\\n48\\t\\u062c \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0647 \\u0628\\u0637\\u0627\\u0637\\u0646 \\u0644\\u064a\\u0632\\nLAYS SALT POTATO CHI0001\\t-2.50 C\\nITEMS\\t5\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 TAL\\t27.55\\n\\u0646\\u0642\\u062f\\u0627\\u064b\\nCash\\tSR\\t30.00\\n\\u0627\\u0644\\u0628\\u0627\\u0644\\u064a\\nCHANGE\\tSR\\t-2.45\\nNET TOTAL\\tVAT C\\t23.95\\nVAT\\t\\t15.0%\\t3.59\\nTAMIMI MARKETS CO. L\\n*1037 0165\\/004\\/453\\t05.12.22 21:40 AC-00\\n\\n202212051650041037\\n\\n\\u0627\\u064a\\u0635\\u0627\\u0644 \\u0628\\u062f\\u0648\\u0646 \\u0644\\u0627\\u063a\\u064a \\u0627\\u0644\\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0623\\u0648 \\u0627\\u0644\\u0627\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT--\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0639\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n\\n\\tVisit us at:\\n\\twww.tamimimarkets.com\\nwwwww.facebook.com\\/tamilmarkets\\n\\tCamScanner \\u0628\\u0640 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/4c165e6d-8450-4675-a8c4-4182827869d6\\/7dba8d4c-48f7-4658-b352-3d0a8060d044.pdf?Expires=1710768806&Signature=Tuw3cTN0klBpdqsRUpHpbVdMhONeHqpHvTqbau3Mh0VQ-ciW24btglnQuPD00f7zhPXUcFQWWY6PYQLRd2G4lhoxQuGGJTSRmtzV78NhBSrV05pfqxqYHe38kqP1a2urYzR14G48mfO89tK9P-k3qHBYRIa-RsTlXnyv8mgFmdrsc7sCvSdEgwZ2MLqO8m0qzL~SljFrwIckmRKzbT6x24ldCNA76ReG9f5D-QL99GCWNTNR435pyJGENYjj4UtP~1Z-rZ9drZZNg2t3gAEYuPRxQL~4YZVwlIIjqeHqTAVsum8oWfNUhlfYc9P4IISQddt2qFtZ~Dc14Cg-3vJDKQ__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBHEH-64307\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"165\",\"subtotal\":23.96,\"tax\":3.59,\"tax_lines\":[{\"base\":23.95,\"name\":\"VAT\",\"order\":0,\"rate\":15,\"total\":3.59}],\"tip\":null,\"total\":27.55,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-03-18 13:18:26\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"\\u0627\\u0644\\u0628\\u062f\\u064a\\u0639\\u0629, Al Riyadh, Riyadh, Saudi Arabia\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":24.610556016,\"lng\":46.675832961,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/3eb16ac2-e05f-4dfe-9664-485ab118b669.png\",\"name\":\"\\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0627\\u0644\\u062d\\u0644\\u0648\\u064a\\u0627\\u062a\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"BADIA ROAD RIYADH\",\"raw_name\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\ntamimi markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimarkets.com\"}}\n" +
                    "\t}\n";
        } else if (endPoint.equalsIgnoreCase("HomeFooter_Dispute")) {

            return "{\n" +
                    "\t  \"type\": \"direct\",\n" +
                    "\t  \"challengeId\": \"\",\n" +
                    "\t  \"challengeType\": \"\",\n" +
                    "\t  \"challengeTypeId\": \"\",\n" +
                    "\t  \"isRejected\": false,\n" +
                    "\t  \"rejectionReason\": \"\",\n" +
                    "\t  \"data\": {\n" +
                    "  \"type\": \"direct\",\n" +
                    "  \"challengeId\": \"\",\n" +
                    "  \"challengeType\": \"\",\n" +
                    "  \"challengeTypeId\": \"\",\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\n" +
                    "    \"account_number\": null,\n" +
                    "    \"bill_to\": {\n" +
                    "      \"address\": null,\n" +
                    "      \"name\": null,\n" +
                    "      \"parsed_address\": null,\n" +
                    "      \"vat_number\": null\n" +
                    "    },\n" +
                    "    \"cashback\": null,\n" +
                    "    \"category\": null,\n" +
                    "    \"created_date\": \"2024-03-19 05:36:29\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 21:56:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650084877\",\n" +
                    "    \"document_title\": \"ضريبية فاتورة\",\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 192982032,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"192982032.jpg\",\n" +
                    "\"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/dc453eac-dbd0-41f7-9450-7efe447f93d7/thumbnail.jpg?Expires=1710827504&Signature=IQAr3MV3e87Z2VmNXflVRKEiV45p617bxdXMbNZnRFW-KPaGC5mecardkSwlR5SMvODbo6fC3iXxci7ysZTGS4-4tXLKs00DhNndvQHLO-hG~-NAylBycMib9DyMJFZSZUlUHlyfev3Mak2JgnuK~RKXFUq3h2vffwE5G1QP-ZACP6uQHFO40iiRuu0233-NXIklKI7ed2n7bjPgEBp~YkIiVZ4W7~znMxOY~7YrPOCwqj0WobZ3cUqMRUYY7mbeqLPmhmSvGIX3Zt6QXuWX7C92BBy8rG0x6gkNkdT5ukYHTWxmcJ~L75WFvgbUT8xVurGkd9~F5EAyDPSaUIaa4Q__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "\"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/dc453eac-dbd0-41f7-9450-7efe447f93d7/cb10c07f-97cd-4a97-9381-61b2432a0b85.jpg?Expires=1710827504&Signature=AmyiR5Awm3MJKUKLjlKqBPtnRKBJEa967YwdOQM6cAg8EsgpN0EntLb1MFxKggoxIqVivEupJ5cfHkifzaITPvht~orojfVoDkCWDLBAubZaU2eFVor6pYOK9yl0rUsuulS60K0ZO81wj7Gm0gn1dGhyIwO31D78akjJQ1643VLa9bsZ1MS1qVB0piIyjhjzohRsH1LPgNJRCcVfOHSppI0bXYJ-Jjrxz7lfPDW~Zz-BK7uchFiyW7yqrnx6-O20AqiYwiXZicdufK3QJWJl8xKjdEpvg6Xijvp9wt2uNtobeeSx~5Ue9ev2UiK7gn23wLyTCQGJAflKYoUPI-y-hg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": \"4877\",\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": null,\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"30 ج وجبنة كاتشب اصابع فيتوس\\n*CHEETOS STCK CH/KET0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"end_date\": null,\n" +
                    "        \"full_description\": \"30 ج وجبنة كاتشب اصابع فيتوس *CHEETOS STCK CH/KET0001\",\n" +
                    "        \"hsn\": null,\n" +
                    "        \"id\": 856231858,\n" +
                    "        \"lot\": null,\n" +
                    "        \"normalized_description\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"start_date\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"30\\tج وجبنة كاتشب اصابع فيتوس\\n*CHEETOS STCK CH/KET0001\\t1.15 C\",\n" +
                    "        \"total\": 1.15,\n" +
                    "        \"type\": \"room\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null,\n" +
                    "        \"weight\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": null,\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"85ج وينجز موت نكهة بطاطي شيكاغو باکس نیز\\nLAYS MAXX CHICAGO H00001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"end_date\": null,\n" +
                    "        \"full_description\": \"85ج وينجز موت نكهة بطاطي شيكاغو باکس نیز LAYS MAXX CHICAGO H00001\",\n" +
                    "        \"hsn\": null,\n" +
                    "        \"id\": 856231859,\n" +
                    "        \"lot\": null,\n" +
                    "        \"normalized_description\": null,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"start_date\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"85ج\\tوينجز موت نكهة بطاطي شيكاغو باکس نیز\\nLAYS MAXX CHICAGO H00001\\t4.35 C\",\n" +
                    "        \"total\": 4.35,\n" +
                    "        \"type\": \"room\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null,\n" +
                    "        \"weight\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": null,\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"85ج مکسیکی حار فلفل نكهة بطاطس باکس لیز\\nLAYS MAXX MEXICAN CHO001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"end_date\": null,\n" +
                    "        \"full_description\": \"85ج مکسیکی حار فلفل نكهة بطاطس باکس لیز LAYS MAXX MEXICAN CHO001\",\n" +
                    "        \"hsn\": null,\n" +
                    "        \"id\": 856231860,\n" +
                    "        \"lot\": null,\n" +
                    "        \"normalized_description\": null,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"start_date\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"85ج\\tمکسیکی حار فلفل نكهة بطاطس باکس لیز\\nLAYS MAXX MEXICAN CHO001\\t4.35 C\",\n" +
                    "        \"total\": 4.35,\n" +
                    "        \"type\": \"room\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null,\n" +
                    "        \"weight\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": \"LCD photo\",\n" +
                    "        \"color\": \"red\",\n" +
                    "        \"decision\": \"Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": true,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": true\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.95,\n" +
                    "        \"submissions\": {\n" +
                    "          \"last_2_weeks\": 0,\n" +
                    "          \"last_day\": 0,\n" +
                    "          \"last_minutes\": 0,\n" +
                    "          \"last_month\": 0,\n" +
                    "          \"last_week\": 0\n" +
                    "        },\n" +
                    "        \"version\": null\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2516,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 1805\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2516,\n" +
                    "          \"size_kb\": 2100,\n" +
                    "          \"width\": 1805\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": []\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "\"ocr_text\": \"التميمي اسواق\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE M 800-303-0010\\n\\nالمبسطة ضريبية فاتورة\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n30\\tج وجبنة كاتشب اصابع فيتوس\\n*CHEETOS STCK CH/KET0001\\t1.15 C\\n85ج\\tوينجز موت نكهة بطاطي شيكاغو باکس نیز\\nLAYS MAXX CHICAGO H00001\\t4.35 C\\n85ج\\tمکسیکی حار فلفل نكهة بطاطس باکس لیز\\nLAYS MAXX MEXICAN CHO001\\t4.35 C\\nITEMS\\t3\\nالمجموع\\nTOTAL\\t9.85\\nنقدا\\nCash\\t\\tSR\\t9.85\\n\\nNET TOTAL\\tVAT C\\t8.57\\nVAT\\t\\t15.0%\\t1.28\\nTAMIMI MARKETS CO. L\\n*4877 0165/008/059\\t05.12.22 21:56 AC-00\\n\\n202212051650084877\\n\\n\\t*****\\nإيصال بدون لاغي الإسترجاع أو الإستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT--\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء خدمة من الضريبة الفاتورة\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n\\n\\t***\\nVisit us at:\\nwww.tamimimarkets.com\\n\\nPRE\\tL\\t\\t\\t\\t\\t\\t\\t\\tNEW\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "\"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/dc453eac-dbd0-41f7-9450-7efe447f93d7/fe5914e4-53c7-4b8a-a96c-19ed5f895965.pdf?Expires=1710827504&Signature=WxifXyNfA4jomFnOAccfxuP0cVmRyqNARpHFpNKi-fbdDtCptH3TVgORNNgugFrteTEjt93umNp2yqEc7E7fNesVMDJcgnAY5etC9qad7OgOT-Yx~jeWs890G-pcQ37uhLhSK9Omqiww0f1OnLK~oyhsErEkSnK1AkjDN3f5ba-HzsrwVXwM-8QPVfhiZYzWkeGgPVQOrsmPAJnovDX5zK2Om09IcUcLiDkaorA4wQ9HcCQK8o~QzllnL8S106FcjnaVj77q-yuSQ-qZP9ghXQZIMEKUuk8apkBWiCjJzvGrJo7DTAxCHXI1EmHkdPRfgz0pE~eHTOMlL049fl1B6A__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBHEJ-82032\",\n" +
                    "    \"rounding\": null,\n" +
                    "    \"server_name\": null,\n" +
                    "    \"service_end_date\": null,\n" +
                    "    \"service_start_date\": null,\n" +
                    "    \"ship_date\": null,\n" +
                    "    \"ship_to\": {\n" +
                    "      \"address\": null,\n" +
                    "      \"name\": null,\n" +
                    "      \"parsed_address\": null\n" +
                    "    },\n" +
                    "    \"shipping\": null,\n" +
                    "    \"store_number\": \"165\",\n" +
                    "    \"subtotal\": 8.57,\n" +
                    "    \"tax\": 1.28,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": 8.57,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 1.28\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 9.85,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-03-19 05:36:43\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"البديعة, Al Riyadh, Riyadh, Saudi Arabia\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": 24.610556016,\n" +
                    "      \"lng\": 46.675832961,\n" +
                    "\"logo\": \"https://cdn.veryfi.com/logos/tmp/3eb16ac2-e05f-4dfe-9664-485ab118b669.png\",\n" +
                    "      \"name\": \"التجارية الحلويات\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"BADIA ROAD RIYADH\",\n" +
                    "      \"raw_name\": \"TAMIMI MARKETS CO\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "\"web\": \"www.tamimimarkets.com\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  \"scanStartedDate\": \"2024-03-19\",\n" +
                    "  \"scanStartedTime\": \"05:36:12\"\n" +
                    "}\n" +
                    "\t}\n";
        } else if (endPoint.equalsIgnoreCase("RewardRedemption")) {
            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75570,\n" +
                    "  \"customerId\": \"79030\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA103\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"challenge\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": 2174,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2024-10-07 23:59\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Pep_RewardRdmtn_Chlng")) {

            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75570,\n" +
                    "  \"customerId\": \"79030\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA103\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"challenge\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": 2174,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2024-10-07 23:59\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Pep_RewardRdmtn_Spin")) {

            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75570,\n" +
                    "  \"customerId\": \"79030\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA103\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": 2174,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2024-10-07 23:59\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Pep_RewardRdmtn_Points")) {

            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75570,\n" +
                    "  \"customerId\": \"79030\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA103\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": null,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2024-10-07 23:59\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_StarOnly_Points")) {

            return "{\n" +
                    "  \"challengeId\": 128468,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_QstnOnly_Point")) {

            return "{\n" +
                    "  \"challengeId\": 128473,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Overall Service\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_TextOnly_Points")) {

            return "{\n" +
                    "  \"challengeId\": 128474,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"Api Automation Testing\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_AllFdback_Point")) {

            return "{\n" +
                    "  \"challengeId\": 128475,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Speed & Efficiency,Overall Service,Customer Support,Repair Quality\",\n" +
                    "  \"feedbackHowToImprove\": \"Awesome KSA QA Team \"\n" +
                    "}";
        }
        else {
            return "\n" +
                    "{\n" +
                    "  \"challengeId\": 141595,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 100,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null\n" +
                    "}";
        }
    }

    public static String getBodyFromMethod(String endPoint) throws Exception {
        if (endPoint.equalsIgnoreCase("signUP")) {
            return "{\n" +
                    "  \"profile\": {\n" +
                    "    \"userId\": \"7352902222\",\n" +
                    "    \"firstName\": \"Vivek\",\n" +
                    "    \"lastName\": \"Singh\",\n" +
                    "    \"role\": \"Customer\",\n" +
                    "    \"dob\": \"\",  \n" +
                    "    \"deviceToken\": \"e79c2b66222a956ce04625b22e3cad3a63e91f34b1a21213a458fadb2b459385\",\n" +
                    "    \"deviceType\": \"android\",\n" +
                    "    \"mobilePhone\":\"7352902222\",\n" +
                    "    \"countryCode\":\"+91\"\n" +
                    "  },\n" +
                    "  \"addresses\": [\n" +
                    "    {\n" +
                    "      \"default\": true,\n" +
                    "      \"isStore\": false,\n" +
                    "      \"billingType\": \"soldTo\",\n" +
                    "      \"postalCode\": \"51961\",\n" +
                    "      \"city\": \"Riyadh Al Khabra\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("CompleteChallenge01")) {
            return "{\n" +
                    "  \"challengeId\": 14436,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 13796\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null\n" +
                    "}";

        } else {
            return "{\n" +
                    "\"mobile\":\"9884204899\",\n" +
                    "\"countryCode\":\"+91\"\n" +
                    "}";
        }
    }

    public static String getDelBody() throws Exception {
        return "";
    }

    public static String getPUTBodyFromMethod(String endPoint) throws Exception {

        if (endPoint.equalsIgnoreCase("UpdatePnt_ThrProfileUpdt")) {
            return "{\n" +
                    "\"action\":\"credit\",\n" +
                    "\"activityType\" : \"profile\",\n" +
                    "\"points\" : 50\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("updatepoint_throughSpinPlay")) {
            return "{\n" +
                    "    \"action\": \"credit\",\n" +
                    "    \"activityType\": \"spin\",\n" +
                    "    \"activityTypeId\": 7522,\n" +
                    "    \"wedgeId\": 3,\n" +
                    "    \"points\": 100,\n" +
                    "    \"lastInertId\": 1732\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("account_Update")) {
            return "{\n" +
                    "  \"firstName\": \"Vivek\",\n" +
                    "  \"lastName\": \"Singh\",\n" +
                    "  \"gender\": \"M\",\n" +
                    "  \"dob\": \"01/05/1992\",\n" +
                    "  \"maid\": null,\n" +
                    "  \"languagePreference\": \"en\",\n" +
                    "  \"notificationSettings\": null,\n" +
                    "  \"customAddress\": {\n" +
                    "    \"isdefault\": true,\n" +
                    "    \"position\": 0,\n" +
                    "    \"city\": \"Dawadmi\",\n" +
                    "    \"postalCode\": \"11911\"\n" +
                    "  },\n" +
                    "  \"termsAccepted\": null,\n" +
                    "  \"app_version\": \"0.0.52+317\",\n" +
                    "  \"isFirstLoginDate\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("account_Update_Seg_MaleOnly")) {
            return "{\n" +
                    "  \"firstName\": \"Vivek\",\n" +
                    "  \"lastName\": \"Singh\",\n" +
                    "  \"gender\": \"M\",\n" +
                    "  \"dob\": \"01/05/1992\",\n" +
                    "  \"maid\": null,\n" +
                    "  \"languagePreference\": \"en\",\n" +
                    "  \"notificationSettings\": null,\n" +
                    "  \"customAddress\": {\n" +
                    "    \"isdefault\": true,\n" +
                    "    \"position\": 0,\n" +
                    "    \"city\": \"Dawadmi\",\n" +
                    "    \"postalCode\": \"11911\"\n" +
                    "  },\n" +
                    "  \"termsAccepted\": null,\n" +
                    "  \"app_version\": \"0.0.52+317\",\n" +
                    "  \"isFirstLoginDate\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("account_Update_Seg_FemaleOnly")) {
            return "{\n" +
                    "  \"firstName\": \"Vivek\",\n" +
                    "  \"lastName\": \"Singh\",\n" +
                    "  \"gender\": \"F\",\n" +
                    "  \"dob\": \"01/05/1992\",\n" +
                    "  \"maid\": null,\n" +
                    "  \"languagePreference\": \"en\",\n" +
                    "  \"notificationSettings\": null,\n" +
                    "  \"customAddress\": {\n" +
                    "    \"isdefault\": true,\n" +
                    "    \"position\": 0,\n" +
                    "    \"city\": \"Dawadmi\",\n" +
                    "    \"postalCode\": \"11911\"\n" +
                    "  },\n" +
                    "  \"termsAccepted\": null,\n" +
                    "  \"app_version\": \"0.0.52+317\",\n" +
                    "  \"isFirstLoginDate\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("account_Update_Seg_DOB")) {
            return "{\n" +
                    "  \"firstName\": \"Vivek\",\n" +
                    "  \"lastName\": \"Singh\",\n" +
                    "  \"gender\": \"M\",\n" +
                    "  \"dob\": \"01/05/1992\",\n" +
                    "  \"maid\": null,\n" +
                    "  \"languagePreference\": \"en\",\n" +
                    "  \"notificationSettings\": null,\n" +
                    "  \"customAddress\": {\n" +
                    "    \"isdefault\": true,\n" +
                    "    \"position\": 0,\n" +
                    "    \"city\": \"Dawadmi\",\n" +
                    "    \"postalCode\": \"11911\"\n" +
                    "  },\n" +
                    "  \"termsAccepted\": null,\n" +
                    "  \"app_version\": \"0.0.52+317\",\n" +
                    "  \"isFirstLoginDate\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("account_Update_Seg_City")) {
            return "{\n" +
                    "  \"firstName\": \"Vivek\",\n" +
                    "  \"lastName\": \"Singh\",\n" +
                    "  \"gender\": \"M\",\n" +
                    "  \"dob\": \"01/05/1988\",\n" +
                    "  \"maid\": null,\n" +
                    "  \"languagePreference\": \"en\",\n" +
                    "  \"notificationSettings\": null,\n" +
                    "  \"customAddress\": {\n" +
                    "    \"isdefault\": true,\n" +
                    "    \"position\": 0,\n" +
                    "    \"city\": \"Dawadmi\",\n" +
                    "    \"postalCode\": \"11911\"\n" +
                    "  },\n" +
                    "  \"termsAccepted\": null,\n" +
                    "  \"app_version\": \"0.0.52+317\",\n" +
                    "  \"isFirstLoginDate\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("account_Update_Seg_Combination")) {
            return "{\n" +
                    "  \"firstName\": \"Vivek\",\n" +
                    "  \"lastName\": \"Singh\",\n" +
                    "  \"gender\": \"M\",\n" +
                    "  \"dob\": \"01/01/1992\",\n" +
                    "  \"maid\": null,\n" +
                    "  \"languagePreference\": \"en\",\n" +
                    "  \"notificationSettings\": null,\n" +
                    "  \"customAddress\": {\n" +
                    "    \"isdefault\": true,\n" +
                    "    \"position\": 0,\n" +
                    "    \"city\": \"Dawadmi\",\n" +
                    "    \"postalCode\": \"11911\"\n" +
                    "  },\n" +
                    "  \"termsAccepted\": null,\n" +
                    "  \"app_version\": \"0.0.52+317\",\n" +
                    "  \"isFirstLoginDate\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("update_Mobile")) {
            return "{\n" +
                    "  \"phone\": \"9897071800\",\n" +
                    "  \"reasonToSwitch\": null,\n" +
                    "  \"countryCode\": \"+91\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("email_Update")) {
            return "{\n" +
                    "    \"email\": \"vbackkumar10+1@gmail.com\"\n" +
                    "}";
        } else {
            return "{\n" +
                    "\"action\":\"debit\",\n" +
                    "\"activityType\" : \"spinbuy\",\n" +
                    "\"points\" : 10\n" +
                    "}";
        }

    }

    public Response relatedSFMCLoyalty(String customerUID, String endpoint, String SFMCToken) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>();
        String stringPayload = getBodyFromMethod(customerUID, endpoint);
        switch (endpoint) {
            case "KSALoyaltyProfileUpdate":
                apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("KSALoyaltyProfileUpdateURI");
                break;
            case "KSALoyaltyChallenge_Consumption":
                apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("KSALoyaltyChallenge_Consumption");
                break;
            case "KSALoyaltyChallenge_DE":
                apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("KSALoyaltyChallenge_DE");
                break;
            case "KSALoyaltyVoucher_DE":
                apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("KSALoyaltyVoucher_DE");
                break;
            case "KSALoyaltyRaffle_DE":
                apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("KSALoyaltyRaffle_DE");
                break;
        }
        System.out.println("URL :" + apiUrl);
        headerMap.put("Authorization", "Bearer " + SFMCToken);
        Response response = BaseApi.putSFMCAPI(stringPayload, headerMap, apiUrl);
        System.out.println(response);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info(" Response coming is :- " + response);
        return response;
    }

    public Response relatedAccounts(HashMap<String, Object> dataMap, String endpoint) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        System.out.println("LoginWithPostAPI :" + LoginWith);
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("x-api-key", getjoyLoyaltyPropertyValue("joy-x-api-key"));
        System.out.println("Updated request body :" + dataMap);
        for (Map.Entry mapElement : dataMap.entrySet()) {
            String testField = (String) mapElement.getKey();
            String testVal = (String) dataMap.get(testField);
            if (!testVal.equalsIgnoreCase("")) {
                if (LoginWith.equalsIgnoreCase("accesstoken")) {
                    if (testField.equalsIgnoreCase("okta-accesstoken")) {
                        headerMap.put(testField, getjoyLoyaltyPropertyValue("LatamAccessToken"));
                    } else {
                        headerMap.put(testField, testVal);
                    }
                } else {
                    headerMap.put(testField, getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
                }
                System.out.println("Updated header node :" + headerMap);
            } else {
                headerMap.put(testField, "");
                System.out.println("Updated header node :" + headerMap);
            }
        }
        switch (endpoint) {
            case "signUP":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SIGN_UP");
                break;
            case "delCustomer":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("DelCustomer");
                break;
            case "reactivateCustomer":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("reactivateCustomer");
                break;
        }
        System.out.println("URL :" + apiUrl);
        if (endpoint.equalsIgnoreCase("signUP") || endpoint.equalsIgnoreCase("reactivateCustomer")) {
            String stringPayload = getBodyFromMethod(endpoint);
            Response response = BaseApi.postAccountsAPI(stringPayload, headerMap, apiUrl);
            System.out.println(response);
            logger.info("Response details is :- " + response);
            LoadProperties.logger.info(" Response coming is :- " + response);
            return response;
        } else {
            String delAccountPayload = getDelBody();
            Response response = BaseApi.delAPI(delAccountPayload, headerMap, apiUrl);
            System.out.println(response);
            logger.info("Response details is :- " + response);
            LoadProperties.logger.info(" Response coming is :- " + response);
            return response;
        }
    }

    public Response related_KSA_PUT(HashMap<String, Object> dataMap, String endpoint) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        String stringPayload = getPUTBodyFromMethod(endpoint);
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("x-api-key", getjoyLoyaltyPropertyValue("joy-x-api-key"));
        System.out.println("Updated request body :" + dataMap);
        for (Map.Entry mapElement : dataMap.entrySet()) {
            String testField = (String) mapElement.getKey();
            String testVal = (String) dataMap.get(testField);
            if (!testVal.equalsIgnoreCase("")) {
                if (LoginWith.equalsIgnoreCase("accesstoken")) {
                    if (testField.equalsIgnoreCase("okta-accesstoken")) {
                        headerMap.put(testField, getjoyLoyaltyPropertyValue("LatamAccessToken"));
                    } else {
                        headerMap.put(testField, testVal);
                    }
                } else {
                    headerMap.put(testField, getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
                }
                System.out.println("Updated header node :" + headerMap);
            } else {
                headerMap.put(testField, "");
                System.out.println("Updated header node :" + headerMap);
            }
        }
        switch (endpoint) {
            case "UpdatePnt_ThrProfileUpdt":
            case "Updatepoint_throughSpinPlay":
            case "Updatepoint_throughSpinBuy":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("updatepoint_endPointURL");
                break;
            case "account_Update":
            case "account_Update_Seg_MaleOnly":
            case "account_Update_Seg_FemaleOnly":
            case "account_Update_Seg_DOB":
            case "account_Update_Seg_City":
            case "account_Update_Seg_Combination":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("account_UpdateURL");
                break;
            case "update_Mobile":
            case "email_Update":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("email_UpdateURL");
                break;

        }
        System.out.println("URL :" + apiUrl);
        Response response = BaseApi.putSFMCAPI(stringPayload, headerMap, apiUrl);
        System.out.println(response);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info(" Response coming is :- " + response);
        return response;
    }

    public Response relatedOKTA(HashMap<String, Object> dataMap, String endpoint, String ID) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();
        bodyMap = (HashMap<String, Object>) getBodyFromJson(endpoint);
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        System.out.println("LoginWithPostAPI :" + LoginWith);

        String RID = ID;
        System.out.println("Response ID :" + RID);

        switch (endpoint) {
            case "UserDeactivate":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaDeactivateP1") + RID + LoadProperties.getjoyLoyaltyPropertyValue("oktaDeactivateP2");
                break;
            case "UserReactivate":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaReactivateP1") + RID + LoadProperties.getjoyLoyaltyPropertyValue("oktaReactivateP2");
                break;
            case "UserCreation":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("createOKTAUser");
                break;
            case "UserDeletion":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaDeactivateP1") + RID;
                break;
        }
        System.out.println("URL :" + apiUrl);
        headerMap.put("Authorization", getjoyLoyaltyPropertyValue("OktaDevAuth"));
        System.out.println("Updated request body :" + dataMap);


        if (endpoint.equalsIgnoreCase("UserDeletion")) {
            Response response = BaseApi.delAPI(bodyMap, headerMap, apiUrl);
            logger.info("Response details is :- " + response);
            LoadProperties.logger.info("Delete OktaUser response is :- " + response);
            return response;
        } else {
            Response response = BaseApi.postAPI(bodyMap, headerMap, apiUrl);
            System.out.println(response);
            logger.info("Response details is :- " + response);
            LoadProperties.logger.info(" Response coming is :- " + response);
            return response;
        }


    }

    public Response relatedChallengeComp(HashMap<String, Object> dataMap, String endpoint, String testcase) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();
        //bodyMap = (HashMap<String, Object>) getBodyFromJson(endpoint);
        String stringPayload = getBodyFromMethodForChallenge(endpoint, testcase);
        // String stringPayload=getBodyFromMethod(endpoint);
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        System.out.println("LoginWithPostAPI :" + LoginWith);
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("x-api-key", getjoyLoyaltyPropertyValue("joy-x-api-key"));
        //headerMap.put("okta-accesstoken", getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
        System.out.println("Updated request body :" + dataMap);
        for (Map.Entry mapElement : dataMap.entrySet()) {
            String testField = (String) mapElement.getKey();
            String testVal = (String) dataMap.get(testField);
            if (!testVal.equalsIgnoreCase("")) {
                if (LoginWith.equalsIgnoreCase("accesstoken")) {
                    if (testField.equalsIgnoreCase("okta-accesstoken")) {
                        headerMap.put(testField, getjoyLoyaltyPropertyValue("LatamAccessToken"));
                    } else {
                        headerMap.put(testField, testVal);
                    }
                } else {
                    headerMap.put(testField, getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
                }
                System.out.println("Updated header node :" + headerMap);
            } else {
                headerMap.put(testField, "");
                System.out.println("Updated header node :" + headerMap);
            }
        }
        switch (endpoint) {
            case "CompleteChallenge01":
            case "CompleteChallenge02":
            case "CompleteChallenge03":
            case "CompleteChallenge04":
            case "CompleteChallenge05":
            case "CompleteChallenge06":
            case "CompleteChallenge07":
            case "CompleteChallenge08":
            case "CompleteChallenge09":
            case "CompleteChallenge10":
            case "CompleteChallenge11":
            case "CompleteChallenge12":
            case "CompleteChallenge13":
            case "CompleteChallenge14":
            case "CompleteChallenge15":
            case "CompleteChallenge16":
            case "LongFormatSurvey_Rewards":
            case "LongFormatSurvey_Points":
            case "LongFormatSurvey_Wallpaper":
            case "LongFormatSurvey_Raffle":
            case "Video_Feedback_StarOnly_Vochr":
            case "Video_Feedback_QstnOnly_Voucher":
            case "Video_Feedback_TextOnly_Voucher":
            case "Video_Feedback_AllFdback_Vouche":
            case "Video_Feedback_StarOnly_Raffle":
            case "Video_Feedback_QstnOnly_Raffle":
            case "Video_Feedback_TextOnly_Raffle":
            case "Video_Feedback_AllFdback_Raffle":
            case "Video_Feedback_StarOnly_Wallppr":
            case "Video_Feedback_QstnOnly_Wallppr":
            case "Video_Feedback_TextOnly_Wallppr":
            case "Video_Feedback_AllFdback_Wallpp":
            case "Video_Feedback_StarOnly_Points":
            case "Video_Feedback_QstnOnly_Point":
            case "Video_Feedback_TextOnly_Points":
            case "Video_Feedback_AllFdback_Point":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("completeChallenge");
                break;
            case "TokenGenerate":
                apiUrl = getsfmcServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SFMCTokenGenerateURI");
                break;
            case "RewardRedemption":
            case "Pep_RewardRdmtn_Chlng":
            case "Pep_RewardRdmtn_Spin":
            case "Pep_RewardRdmtn_Points":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("RewardRedemption");
                break;
            case "WelcomeGiftCompletion":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("WelcomeGiftCompletion");
                break;
            case "Draw-Participation":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Draw-Participation");
                break;
            case "Spin_Wedge_Generate":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SpinWedge");
                break;
            case "ScanChallenge_Points":
            case "ScanChallenge_Raffle":
            case "ScanChallenge_Rewards":
            case "ScanChallenge_Wallpaper":
            case "ScanChallenge_MultiReward":
            case "ScanChallenge_Dispute":
            case "HomeFooter":
            case "HomeFooter_Dispute":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("ScanChallenge");
                break;
        }
        System.out.println("URL :" + apiUrl);
        //Response response = BaseApi.postAPI(bodyMap, headerMap, apiUrl);
        Response response = BaseApi.postAccountsAPI(stringPayload, headerMap, apiUrl);
        System.out.println(response);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info(" Response coming is :- " + response);
        return response;
    }

    public Response relatedSFMCTokenGenerate(String endpoint) throws Exception {

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap = (HashMap<String, Object>) getBodyFromJson(endpoint);
        switch (endpoint) {
            case "TokenGenerate":
                apiUrl = getsfmcServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SFMCTokenGenerateURI");
                break;
        }
        System.out.println("URL :" + apiUrl);
        Response response = BaseApi.postAPIforSFMC(bodyMap, apiUrl);
        System.out.println(response);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info(" Response coming is :- " + response);
        return response;

    }

    public Response getResponsefromSFMC(String endpoint, String SFMCToken, String consumptionReqID) throws Exception {

        HashMap<String, Object> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Bearer " + SFMCToken);
        switch (endpoint) {
            case "RequestID_Result":
                apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("SFMCRequestID_Result_P1") + consumptionReqID + LoadProperties.getjoyLoyaltyPropertyValue("SFMCRequestID_Result_P2");
                break;
        }
        System.out.println("HeaderMap is:" + headerMap);
        System.out.println("RequestID Result URL is:" + apiUrl);
        Response response = BaseApi.getAPI(headerMap, apiUrl);
        System.out.println(response);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info(" Response coming is :- " + response);
        return response;

    }

    public Response relatedResponse(HashMap<String, Object> dataMap, String endpoint) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        HashMap<String, Object> bodyMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();
        bodyMap = (HashMap<String, Object>) getBodyFromJson(endpoint);
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("okta-accesstoken", getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
        System.out.println("LoginWithPostAPI :" + LoginWith);

        switch (endpoint) {
            case "RaiseContactUsRequest":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("contactusInquiryRaise");
                break;
        }
        System.out.println("URL :" + apiUrl);
        System.out.println("Updated request body :" + dataMap);
        Response response = BaseApi.postAPI(bodyMap, headerMap, apiUrl);
        System.out.println(response);
        logger.info("Response details is :- " + response);
        LoadProperties.logger.info(" Response coming is :- " + response);
        return response;
    }
}
