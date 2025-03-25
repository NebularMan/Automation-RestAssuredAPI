package API.JoyLoyalty.api.service;

import API.utils.BaseApi;
import API.utils.Basecode;
import API.utils.LoadProperties;
import API.utils.ScenarioContext;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        }   else if (endPoint.equalsIgnoreCase("CompleteChallenge04") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge07") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge08") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge09") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge10") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge11") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge12") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge13") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
        }  else if (endPoint.equalsIgnoreCase("CompleteChallenge14") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
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
                    "  \"challengeId\": 198027,\n" +
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
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Rewards") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 1980127,\n" +
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
        }  else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Points") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 198029,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Points") && (testcase.equalsIgnoreCase("ChallengewithWrongChallengeID"))) {
            return "{\n" +
                    "  \"challengeId\": 1980329,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }   else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Wallpaper") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 198028,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9213\n" +
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
                    "  \"challengeId\": 1982028,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9213\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }   else if (endPoint.equalsIgnoreCase("LongFormatSurvey_Raffle") && (testcase.equalsIgnoreCase("Valid-AccessToken") || testcase.equalsIgnoreCase("Valid-AccessToken-1") || testcase.equalsIgnoreCase("Blank-AccessToken"))) {
            return "{\n" +
                    "  \"challengeId\": 198030,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 196751\n" +
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
                    "  \"challengeId\": 1982030,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 196751\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Spin_Wedge_Generate") && ((testcase.equalsIgnoreCase("Valid-AccessToken")) || (testcase.equalsIgnoreCase("Blank-AccessToken")))) {
            return "{\n" +
                    "  \"spinId\": \"27724\",\n" +
                    "  \"activeWedgesId\": [\n" +
                    "    5,\n" +
                    "    4,\n" +
                    "    3,\n" +
                    "    2,\n" +
                    "    1\n" +
                    "  ],\n" +
                    "  \"assignedWedgesId\": [],\n" +
                    "  \"wedgesRwdId\": {\n" +
                    "    \"reward\": {\n" +
                    "      \"4\": 192726\n" +
                    "    },\n" +
                    "    \"wallpaper\": {\n" +
                    "      \"2\": 9216\n" +
                    "    },\n" +
                    "    \"draw\": {\n" +
                    "      \"5\": 10883\n" +
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
                    "    \"type\": \"challenge\",\n" +
                    "    \"challengeId\": \"77016\",\n" +
                    "    \"challengeType\": [\n" +
                    "        \"wallpaper\"\n" +
                    "    ],\n" +
                    "    \"challengeTypeId\": {\n" +
                    "        \"wallpaper\": 9213\n" +
                    "    },\n" +
                    "    \"isRejected\": false,\n" +
                    "    \"rejectionReason\": \"\",\n" +
                    "    \"data\": {\n" +
                    "        \"account_number\": null,\n" +
                    "        \"bill_to\": {\n" +
                    "            \"address\": null,\n" +
                    "            \"name\": null,\n" +
                    "            \"parsed_address\": null,\n" +
                    "            \"vat_number\": null\n" +
                    "        },\n" +
                    "        \"cashback\": null,\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "        \"currency_code\": \"SAR\",\n" +
                    "        \"date\": \"2022-12-05 22:24:00\",\n" +
                    "        \"delivery_date\": null,\n" +
                    "        \"discount\": null,\n" +
                    "        \"document_reference_number\": \"202212051650066669\",\n" +
                    "        \"document_title\": null,\n" +
                    "        \"document_type\": \"receipt\",\n" +
                    "        \"due_date\": null,\n" +
                    "        \"duplicate_of\": null,\n" +
                    "        \"external_id\": null,\n" +
                    "        \"guest_count\": null,\n" +
                    "        \"id\": 180156842,\n" +
                    "        \"img_blur\": false,\n" +
                    "        \"img_file_name\": \"180156842.jpg\",\n" +
                    "        \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "        \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "        \"insurance\": null,\n" +
                    "        \"invoice_number\": null,\n" +
                    "        \"is_blurry\": [\n" +
                    "            false\n" +
                    "        ],\n" +
                    "        \"is_document\": true,\n" +
                    "        \"is_duplicate\": false,\n" +
                    "        \"is_money_in\": false,\n" +
                    "        \"line_items\": [\n" +
                    "            {\n" +
                    "                \"category\": \"Meals & Entertainment\",\n" +
                    "                \"date\": null,\n" +
                    "                \"description\": \"ROCKSTAR CLASSIC 30/0001\",\n" +
                    "                \"discount\": null,\n" +
                    "                \"discount_rate\": null,\n" +
                    "                \"id\": 794569106,\n" +
                    "                \"order\": 0,\n" +
                    "                \"price\": null,\n" +
                    "                \"quantity\": 1,\n" +
                    "                \"reference\": null,\n" +
                    "                \"section\": null,\n" +
                    "                \"sku\": null,\n" +
                    "                \"tags\": [\n" +
                    "                    \"PepsiCo\"\n" +
                    "                ],\n" +
                    "                \"tax\": null,\n" +
                    "                \"tax_rate\": null,\n" +
                    "                \"text\": \"ROCKSTAR CLASSIC 30/0001\\t5.10 C\",\n" +
                    "                \"total\": 5.1,\n" +
                    "                \"type\": \"food\",\n" +
                    "                \"unit_of_measure\": null,\n" +
                    "                \"upc\": null\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"Meals & Entertainment\",\n" +
                    "                \"date\": null,\n" +
                    "                \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "                \"discount\": null,\n" +
                    "                \"discount_rate\": null,\n" +
                    "                \"id\": 794569108,\n" +
                    "                \"order\": 1,\n" +
                    "                \"price\": null,\n" +
                    "                \"quantity\": 1,\n" +
                    "                \"reference\": null,\n" +
                    "                \"section\": null,\n" +
                    "                \"sku\": null,\n" +
                    "                \"tags\": [\n" +
                    "                    \n" +
                    "                ],\n" +
                    "                \"tax\": null,\n" +
                    "                \"tax_rate\": null,\n" +
                    "                \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "                \"total\": null,\n" +
                    "                \"type\": \"food\",\n" +
                    "                \"unit_of_measure\": null,\n" +
                    "                \"upc\": null\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"Meals & Entertainment\",\n" +
                    "                \"date\": null,\n" +
                    "                \"description\": \"LAYS MAXX TEXAS BBQB0001\",\n" +
                    "                \"discount\": null,\n" +
                    "                \"discount_rate\": null,\n" +
                    "                \"id\": 794569110,\n" +
                    "                \"order\": 2,\n" +
                    "                \"price\": null,\n" +
                    "                \"quantity\": 1,\n" +
                    "                \"reference\": null,\n" +
                    "                \"section\": null,\n" +
                    "                \"sku\": null,\n" +
                    "                \"tags\": [\n" +
                    "                    \"PepsiCo\"\n" +
                    "                ],\n" +
                    "                \"tax\": null,\n" +
                    "                \"tax_rate\": null,\n" +
                    "                \"text\": \"LAYS MAXX TEXAS BBQB0001\\t7.40 C\",\n" +
                    "                \"total\": 7.4,\n" +
                    "                \"type\": \"food\",\n" +
                    "                \"unit_of_measure\": null,\n" +
                    "                \"upc\": null\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"Meals & Entertainment\",\n" +
                    "                \"date\": null,\n" +
                    "                \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "                \"discount\": null,\n" +
                    "                \"discount_rate\": null,\n" +
                    "                \"id\": 794569112,\n" +
                    "                \"order\": 3,\n" +
                    "                \"price\": null,\n" +
                    "                \"quantity\": 1,\n" +
                    "                \"reference\": null,\n" +
                    "                \"section\": null,\n" +
                    "                \"sku\": null,\n" +
                    "                \"tags\": [\n" +
                    "                    \"PepsiCo\"\n" +
                    "                ],\n" +
                    "                \"tax\": null,\n" +
                    "                \"tax_rate\": null,\n" +
                    "                \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "                \"total\": null,\n" +
                    "                \"type\": \"food\",\n" +
                    "                \"unit_of_measure\": null,\n" +
                    "                \"upc\": null\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"category\": \"Meals & Entertainment\",\n" +
                    "                \"date\": null,\n" +
                    "                \"description\": \"LAYS POTATO CHIPS CHO001\",\n" +
                    "                \"discount\": null,\n" +
                    "                \"discount_rate\": null,\n" +
                    "                \"id\": 794569114,\n" +
                    "                \"order\": 4,\n" +
                    "                \"price\": null,\n" +
                    "                \"quantity\": 1,\n" +
                    "                \"reference\": null,\n" +
                    "                \"section\": null,\n" +
                    "                \"sku\": null,\n" +
                    "                \"tags\": [\n" +
                    "                    \"PepsiCo\"\n" +
                    "                ],\n" +
                    "                \"tax\": null,\n" +
                    "                \"tax_rate\": null,\n" +
                    "                \"text\": \"LAYS POTATO CHIPS CHO001\\t4.30 C\",\n" +
                    "                \"total\": 4.3,\n" +
                    "                \"type\": \"food\",\n" +
                    "                \"unit_of_measure\": null,\n" +
                    "                \"upc\": null\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"meta\": {\n" +
                    "            \"duplicates\": [\n" +
                    "                \n" +
                    "            ],\n" +
                    "            \"fraud\": {\n" +
                    "                \"attribution\": null,\n" +
                    "                \"color\": \"green\",\n" +
                    "                \"decision\": \"Not Fraud\",\n" +
                    "                \"images\": [\n" +
                    "                    {\n" +
                    "                        \"is_lcd\": false,\n" +
                    "                        \"score\": 0.95\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"pages\": [\n" +
                    "                    {\n" +
                    "                        \"is_lcd\": {\n" +
                    "                            \"score\": 0.95,\n" +
                    "                            \"value\": false\n" +
                    "                        }\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"score\": 0.12025686246775091,\n" +
                    "                \"version\": \"v3\"\n" +
                    "            },\n" +
                    "            \"handwritten_fields\": [\n" +
                    "                \n" +
                    "            ],\n" +
                    "            \"language\": [\n" +
                    "                \"en\",\n" +
                    "                \"ar\"\n" +
                    "            ],\n" +
                    "            \"owner\": \"pepsico-amesa-dev\",\n" +
                    "            \"pages\": [\n" +
                    "                {\n" +
                    "                    \"height\": 2691,\n" +
                    "                    \"language\": [\n" +
                    "                        \"en\",\n" +
                    "                        \"ar\"\n" +
                    "                    ],\n" +
                    "                    \"width\": 2023\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"processed_pages\": 1,\n" +
                    "            \"source\": \"lens.receipt\",\n" +
                    "            \"source_documents\": [\n" +
                    "                {\n" +
                    "                    \"height\": 2691,\n" +
                    "                    \"size_kb\": 1359,\n" +
                    "                    \"width\": 2023\n" +
                    "                }\n" +
                    "            ],\n" +
                    "            \"total_pages\": 1,\n" +
                    "            \"warnings\": [\n" +
                    "                {\n" +
                    "                    \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "                    \"type\": \"item_counts_missmatch\"\n" +
                    "                }\n" +
                    "            ]\n" +
                    "        },\n" +
                    "        \"notes\": null,\n" +
                    "        \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "        \"order_date\": null,\n" +
                    "        \"payment\": {\n" +
                    "            \"card_number\": null,\n" +
                    "            \"display_name\": \"Cash\",\n" +
                    "            \"type\": \"cash\"\n" +
                    "        },\n" +
                    "        \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "        \"purchase_order_number\": null,\n" +
                    "        \"reference_number\": \"VBGCB-56842\",\n" +
                    "        \"rounding\": null,\n" +
                    "        \"server_name\": null,\n" +
                    "        \"service_end_date\": null,\n" +
                    "        \"service_start_date\": null,\n" +
                    "        \"ship_date\": null,\n" +
                    "        \"ship_to\": {\n" +
                    "            \"address\": null,\n" +
                    "            \"name\": null,\n" +
                    "            \"parsed_address\": null\n" +
                    "        },\n" +
                    "        \"shipping\": null,\n" +
                    "        \"store_number\": \"6669\",\n" +
                    "        \"subtotal\": 14.61,\n" +
                    "        \"tax\": 2.19,\n" +
                    "        \"tax_lines\": [\n" +
                    "            {\n" +
                    "                \"base\": null,\n" +
                    "                \"name\": null,\n" +
                    "                \"order\": 0,\n" +
                    "                \"rate\": 15,\n" +
                    "                \"total\": 2.19\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"tip\": null,\n" +
                    "        \"total\": 16.8,\n" +
                    "        \"total_weight\": null,\n" +
                    "        \"tracking_number\": null,\n" +
                    "        \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "        \"vendor\": {\n" +
                    "            \"abn_number\": null,\n" +
                    "            \"account_number\": null,\n" +
                    "            \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "            \"bank_name\": null,\n" +
                    "            \"bank_number\": null,\n" +
                    "            \"bank_swift\": null,\n" +
                    "            \"category\": \"Grocery\",\n" +
                    "            \"email\": null,\n" +
                    "            \"fax_number\": null,\n" +
                    "            \"iban\": null,\n" +
                    "            \"lat\": null,\n" +
                    "            \"lng\": null,\n" +
                    "            \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "            \"name\": \"Tamimi Markets\",\n" +
                    "            \"phone_number\": \"800-303-0010\",\n" +
                    "            \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "            \"raw_name\": \"Tamimi Markets\",\n" +
                    "            \"reg_number\": null,\n" +
                    "            \"type\": \"Grocery\",\n" +
                    "            \"vat_number\": \"300508296700003\",\n" +
                    "            \"web\": \"www.tamimimerkete.com\"\n" +
                    "        }\n" +
                    "    }\n" +
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
                    "  \"customerId\": \"200238\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA103\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": null,\n" +
                    "  \"objectId\": null,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2024-12-31 00:00\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Pep_RewardRdmtn_Chlng")) {

            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75566,\n" +
                    "  \"customerId\": \"200238\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA101\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": null,\n" +
                    "  \"objectId\": null,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2025-02-02 23:59\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Pep_RewardRdmtn_Spin")) {

            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75566,\n" +
                    "  \"customerId\": \"200238\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA101\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": null,\n" +
                    "  \"objectId\": null,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2025-02-02 23:59\"\n" +
                    "}";
        } else if (endPoint.equalsIgnoreCase("Pep_RewardRdmtn_Points")) {

            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75566,\n" +
                    "  \"customerId\": \"200238\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA101\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": null,\n" +
                    "  \"objectId\": null,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2025-02-02 23:59\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_StarOnly_Points")){

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
                    "  \"challengeId\": 132422,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 72786\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"All Star\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_StarOnly_Raffle")) {

            return "{\n" +
                    "  \"challengeId\": 132428,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 8184\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_QstnOnly_Raffle")) {

            return "{\n" +
                    "  \"challengeId\": 132423,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 76652\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_TextOnly_Raffle")) {

            return "{\n" +
                    "  \"challengeId\": 132431,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 72830\n" +
                    "  },\n" +
                    "  \"points\": 50,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"Sure\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_AllFdback_Raffle")) {

            return "{\n" +
                    "  \"challengeId\": 132422,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"draw\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"draw\": 72786\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"All Star\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_StarOnly_Vochr")) {

            return "{\n" +
                    "  \"challengeId\": 132430,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 77530\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 2,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_QstnOnly_Voucher")) {

            return "{\n" +
                    "  \"challengeId\": 132430,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 77530\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_TextOnly_Voucher")) {

            return "{\n" +
                    "  \"challengeId\": 132430,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 77530\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"Sure\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_AllFdback_Vouche")) {

            return "{\n" +
                    "  \"challengeId\": 132430,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"reward\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"reward\": 77530\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"All Star\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_AllFdback_Wallpp")) {

            return "{\n" +
                    "  \"challengeId\": 132429,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9216\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"All Star\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_TextOnly_Wallppr")) {

            return "{\n" +
                    "  \"challengeId\": 132429,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9216\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"Sure\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_QstnOnly_Wallppr")) {

            return "{\n" +
                    "  \"challengeId\": 132429,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9216\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 0,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"Customer Support\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("Video_Feedback_StarOnly_Wallppr")) {

            return "{\n" +
                    "  \"challengeId\": 132429,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"wallpaper\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {\n" +
                    "    \"wallpaper\": 9216\n" +
                    "  },\n" +
                    "  \"points\": 0,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 3,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01")  && testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200154,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQ 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 00011\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200154,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQ 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 00011\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200154,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.55,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200154,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQ 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 00011\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200154\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS MAXX TEXAS BBQ 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS MAXX TEXAS BBQ 0001\",\n" +
                    "        \"total\": 20.5,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.4,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario01") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("Valid-AccessToken") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200179,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS CHL 027GX14X5 PB\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.55,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200179,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS CHL 027GX14X5 PB\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200179,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200179,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS CHL 027GX14X5 PB\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200179\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS CHL 027GX14X5 PB\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.55,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS CHL 027GX14X5 PB\",\n" +
                    "        \"total\": 20.55,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.4,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario02") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200181,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQB0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.55,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200181,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQB0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.55,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200181,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.55,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200181,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQB0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.55,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 01\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200181\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS MAXX TEXAS BBQB0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.55,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS MAXX TEXAS BBQB0001\",\n" +
                    "        \"total\": 20.55,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.4,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario03") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200187,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TAS CUMIN LMN 155GX019X1\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200187,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TAS CUMIN LMN 155GX019X1\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 1.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 1.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 1.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 1.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200187,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200187,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 12.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TAS CUMIN LMN 155GX019X1\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200187\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TAS CUMIN LMN 155GX019X1\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 11.00,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TAS CUMIN LMN 155GX019X1\",\n" +
                    "        \"total\": 11.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 11.00,\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "        \"total\": 11.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario04") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200618,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 22.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200618,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 22.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200618,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 22.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200618,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 11.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 11.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"New Age KSA Team 02\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200618\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"AQUAFINA WATER\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 22.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"AQUAFINA WATER\",\n" +
                    "        \"total\": 22.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS FLAMIN HOT L0001\",\n" +
                    "        \"total\": 20.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario05") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200619,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"MARINDA CITRUS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 21.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200619,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"MARINDA CITRUS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 21.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200619,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 21.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200619,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"MARINDA CITRUS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 21.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200619\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"MARINDA CITRUS\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"MARINDA CITRUS\",\n" +
                    "        \"total\": 20.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "        \"total\": 20.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario06") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200620,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"MARINDA CITRUS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200620,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"MARINDA CITRUS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 2.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200620,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200620,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 1.63,\n" +
                    "        \"totalPrice\": 20.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"MARINDA CITRUS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20.00,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200620\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"MARINDA CITRUS\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 2.00,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"MARINDA CITRUS\",\n" +
                    "        \"total\": 2.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "        \"total\": 20.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario07") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200621,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALTED CHIPS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200621,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALTED CHIPS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200621,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200621,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALTED CHIPS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200621\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALTED CHIPS\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 25.00,\n" +
                    "        \"quantity\": 5,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALTED CHIPS\",\n" +
                    "        \"total\": 125.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"AQUAFINA WATER\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 10.00,\n" +
                    "        \"quantity\": 6,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"AQUAFINA WATER\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario08") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200622,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALTED CHIPS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200622,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALTED CHIPS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 1,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200622,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200622,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALTED CHIPS\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200622\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALTED CHIPS\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 25.00,\n" +
                    "        \"quantity\": 5,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALTED CHIPS\",\n" +
                    "        \"total\": 125.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 50.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 200.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario09") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200623,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200623,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200623,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200623,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 25,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 125.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"AQUAFINA WATER\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 6,\n" +
                    "            \"total\": 60.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 50,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 200.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200623\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 25.00,\n" +
                    "        \"quantity\": 5,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"PEPSI CAN DIET 330-30001\",\n" +
                    "        \"total\": 125.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"AQUAFINA WATER\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 10.00,\n" +
                    "        \"quantity\": 6,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"AQUAFINA WATER\",\n" +
                    "        \"total\": 60.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"Snacks\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"Snacks\",\n" +
                    "        \"total\": 1.3,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario10") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200759,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 10.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200759,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 10.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200759,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 10.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 5,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200759,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 10.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200759\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 2.00,\n" +
                    "        \"quantity\": 5,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 5,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario11") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200760,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200760,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200760,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 200760,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200760\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario12") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200761,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200761,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200761,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200761,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200761\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario13") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200762,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200762,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200762,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200762,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200762\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario14") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200763,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 30,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200763,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 2,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 3,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200763,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 30,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("Scenario03-WrongQuantity") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200763,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 30,\n" +
                    "            \"quantity\": 3,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200763\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 30.00,\n" +
                    "        \"quantity\": 3,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario15") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200764,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 30,\n" +
                    "            \"quantity\": 2,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200764,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 30,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS SALT POTATO\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200764,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 20,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 100.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 30,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 120.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200764\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 20.00,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 30.00,\n" +
                    "        \"quantity\": 2,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario16") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }

        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17")&& testcase.equalsIgnoreCase("Valid-AccessToken") )  {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200765,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"199140\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 4,\n" +
                    "            \"total\": 20.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 10.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17") && testcase.equalsIgnoreCase("Scenario01-WrongPrice") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200765,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"TASALI CHILLI PTAT\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 1.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17") && testcase.equalsIgnoreCase("Scenario02-WrongProduct") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\":  200765,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"scanStartedDate\": \"2024-09-05\",\n" +
                    "  \"scanStartedTime\": \"12:36:03\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"200238\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"ym3kgkjck\",\n" +
                    "\"docUrl\": \"https://ps1003dpsdssrs01sa.blob.core.windows.net/receiptscanner/ym3kgkjck.jpeg?sv=2021-12-02&se=2024-09-05T12%3A51%3A07Z&sr=c&sp=rw&sig=Yw5S6DseSg96T%2BpyNar2%2FbTLDUWqhILKiIA88w%2BqxJY%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": \"2024-09-05 12:36:17\",\n" +
                    "    \"status\": \"AUTO_APPROVED\",\n" +
                    "    \"message\": null,\n" +
                    "    \"failedValidations\": [],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"tamimi markets\",\n" +
                    "        \"vendorAddress\": \"BADIA ROAD RIYADH\",\n" +
                    "        \"totalTax\": 10.63,\n" +
                    "        \"totalPrice\": 112.5,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"05.12.22\",\n" +
                    "        \"transactionTime\": \"21:53\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 2.55,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 10,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 1.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"Snacks\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 5,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 20.00,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"ym3kgkjck_1725539776401\",\n" +
                    "    \"maxPoints\": null\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17") && testcase.equalsIgnoreCase("VerifySce01-ValidCase") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"200765\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
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
                    "    \"category\": \"Meals & Entertainment\",\n" +
                    "    \"created_date\": \"2024-01-22 17:34:54\",\n" +
                    "    \"currency_code\": \"SAR\",\n" +
                    "    \"date\": \"2022-12-05 22:24:00\",\n" +
                    "    \"delivery_date\": null,\n" +
                    "    \"discount\": null,\n" +
                    "    \"document_reference_number\": \"202212051650066669\",\n" +
                    "    \"document_title\": null,\n" +
                    "    \"document_type\": \"receipt\",\n" +
                    "    \"due_date\": null,\n" +
                    "    \"duplicate_of\": null,\n" +
                    "    \"external_id\": null,\n" +
                    "    \"guest_count\": null,\n" +
                    "    \"id\": 180156842,\n" +
                    "    \"img_blur\": false,\n" +
                    "    \"img_file_name\": \"180156842.jpg\",\n" +
                    "    \"img_thumbnail_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/thumbnail.jpg?Expires=1705945803&Signature=S5hxVQjBjZCfwyFTtYvOODIuZHwvlzH1Uy9DjJSUnlHlIkiM69I9E4G7cIiKp3Qa4069bDInCJcCqpjTEbBaYA6IBbTCkeMFvyM5gok0TWXIcFlVESw5gA0odqyuImIqjrbB434eeReNskG3Gt2R-eVb4o3shsBHA3uvSeWGYiXWoPPJahkkRRGnFSCXkJPHL5oFnwIJ4g7gMio70ho8ZQvuDrJG7BA5OVNVVEq-qlPOjZ6ycsnRjC3EVFZbpH381aFDHoFyKlm3OsLtYxWlyI62OTOtWO25Ygv9BIMIMxVamcLtAB4yf8haRmhvtk20bHHYCjJMgplfw~XHnBspyw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"img_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/19c6c872-ebb3-476a-a110-f0f6158f4818.jpg?Expires=1705945803&Signature=XZPuVBG9IDXgMYUGsM~XKB7ugv6yzr7WIVc1hGCK0KA6vIoV-eJwEXoXK1xBVIGfNBYM-RoZWrBSLY5425I7VWOLssxmqAG2X51SVVwt96-Ncr11AZxYDD94mkkisbA304ib8TAV4Bj9Jh98nYCFkL6oYZG00ZKhIBDhCgLhE1hz3ZbwUJJJUofrCJQdDrjzyeF08NGNhqrca91dF9iL8LO2h-TMPbuJEyFCSTv2qejT6pinSvnnf9untSe3cr0IlBQHmI2I1ORAsxBmT0DPUt0eQR-CS~yX4wQr9OW-n69Fc5ZSGZ73uTqSimCys2EwN-HZBbNJW07Bji14DhbTvw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"insurance\": null,\n" +
                    "    \"invoice_number\": null,\n" +
                    "    \"is_blurry\": [\n" +
                    "      false\n" +
                    "    ],\n" +
                    "    \"is_document\": true,\n" +
                    "    \"is_duplicate\": false,\n" +
                    "    \"is_money_in\": false,\n" +
                    "    \"line_items\": [\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569106,\n" +
                    "        \"order\": 0,\n" +
                    "        \"price\": 10.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"TASALI CHILLI PTAT\",\n" +
                    "        \"total\": 10.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"160ج باربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569108,\n" +
                    "        \"order\": 1,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569110,\n" +
                    "        \"order\": 2,\n" +
                    "        \"price\": 10.00,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"DORITOS NACHOO CHSE 0001\",\n" +
                    "        \"total\": 120.00,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569112,\n" +
                    "        \"order\": 3,\n" +
                    "        \"price\": null,\n" +
                    "        \"quantity\": 1,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"280 الحار بالفلفل شبس بطاطس ليز\",\n" +
                    "        \"total\": null,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"category\": \"Meals & Entertainment\",\n" +
                    "        \"date\": null,\n" +
                    "        \"description\": \"LAYS SALT POTATO\",\n" +
                    "        \"discount\": null,\n" +
                    "        \"discount_rate\": null,\n" +
                    "        \"id\": 794569114,\n" +
                    "        \"order\": 4,\n" +
                    "        \"price\": 5.00,\n" +
                    "        \"quantity\": 4,\n" +
                    "        \"reference\": null,\n" +
                    "        \"section\": null,\n" +
                    "        \"sku\": null,\n" +
                    "        \"tags\": [\n" +
                    "          \"PepsiCo\"\n" +
                    "        ],\n" +
                    "        \"tax\": null,\n" +
                    "        \"tax_rate\": null,\n" +
                    "        \"text\": \"LAYS SALT POTATO\",\n" +
                    "        \"total\": 20,\n" +
                    "        \"type\": \"food\",\n" +
                    "        \"unit_of_measure\": null,\n" +
                    "        \"upc\": null\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"meta\": {\n" +
                    "      \"duplicates\": [],\n" +
                    "      \"fraud\": {\n" +
                    "        \"attribution\": null,\n" +
                    "        \"color\": \"green\",\n" +
                    "        \"decision\": \"Not Fraud\",\n" +
                    "        \"images\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": false,\n" +
                    "            \"score\": 0.95\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"pages\": [\n" +
                    "          {\n" +
                    "            \"is_lcd\": {\n" +
                    "              \"score\": 0.95,\n" +
                    "              \"value\": false\n" +
                    "            }\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"score\": 0.12025686246775091,\n" +
                    "        \"version\": \"v3\"\n" +
                    "      },\n" +
                    "      \"handwritten_fields\": [],\n" +
                    "      \"language\": [\n" +
                    "        \"en\",\n" +
                    "        \"ar\"\n" +
                    "      ],\n" +
                    "      \"owner\": \"pepsico-amesa-dev\",\n" +
                    "      \"pages\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"language\": [\n" +
                    "            \"en\",\n" +
                    "            \"ar\"\n" +
                    "          ],\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"processed_pages\": 1,\n" +
                    "      \"source\": \"lens.receipt\",\n" +
                    "      \"source_documents\": [\n" +
                    "        {\n" +
                    "          \"height\": 2691,\n" +
                    "          \"size_kb\": 1359,\n" +
                    "          \"width\": 2023\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"total_pages\": 1,\n" +
                    "      \"warnings\": [\n" +
                    "        {\n" +
                    "          \"message\": \"Total Items sold doesn't match number of line items\",\n" +
                    "          \"type\": \"item_counts_missmatch\"\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    },\n" +
                    "    \"notes\": null,\n" +
                    "    \"ocr_text\": \"اسواق\\nالتميمي\\nmarkets\\ntamimi\\nGore 166\\nRIYADH\\nBADIA ROAD\\n\\t800-303-0010\\nCUSTOMER SERVICE -\\n\\tههههه\\n*******\\nالمبسطة فريبية فاتورا\\n\\tInvoice\\nSimplified Tax\\nVAT Number: 300508296700003\\n*******\\tan an\\nمل 250 الطاقة مشروب ستار روك\\nROCKSTAR CLASSIC 30/0001\\t5.10 C\\n160ج\\tباربيكيو نكهة بطاطين تكساس ماكس لیز\\nLAYS MAXX TEXAS BBQB0001\\t7.40 C\\n280 الحار بالفلفل شبس بطاطس ليز\\nLAYS POTATO CHIPS CHO001\\t4.30 C\\nITEMS\\t3\\nالمجموع TAL\\t16.80\\nنقدأ\\nCash\\nSR\\t102.00\\nالباقي\\nCHANGE\\n\\tSR\\t-85.20\\nNET TOTAL\\tVAT C\\t14.61\\nVAT\\n\\t15.0%\\t2.19\\nTAMIMI MARKETS CO. L\\n*6669 0165/006/015 05.12.22 22:24 AC-00\\n\\n202212051650066669\\n\\n\\t***\\nايصال بدون\\tالاسترجاع أو الاستبدال\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT-\\n********\\t******\\n\\t***\\nعلى الحصول يمكنك العميل عزيزي\\nالعملاء الخدمة من القريبة الفاتورة\\nDear Customer. for Tax Invoice\\nPlease Visit Customer Service\\n\\t****\\n\\tVisit\\n\\tus at:\\n|\\twww.tamimimerkete.com\\nwww.facebook.com/tantimimarkets\\n\\tCamSc\\nلاغي\",\n" +
                    "    \"order_date\": null,\n" +
                    "    \"payment\": {\n" +
                    "      \"card_number\": null,\n" +
                    "      \"display_name\": \"Cash\",\n" +
                    "      \"type\": \"cash\"\n" +
                    "    },\n" +
                    "    \"pdf_url\": \"https://scdn.veryfi.com/receipts/9cb172fea58a3d0a/cd2a4ae6-b793-4a8b-bdfc-9565de57246b/6d9ee50c-75ff-4481-87a1-8373ac4752e0.pdf?Expires=1705945803&Signature=FDLcQiBur~f-xVrLh6xrs8v3-wpuXw9SG0DI3R5SQZoK050klYQkBb6b5dh-95ddT9rDPq4sBBxwcbt2JZj-h5o08-UZlgV5sX7NWpJHUmWXac8PrzTp9lQ4o208YmTOny7IYjRUk9cCG46IGR4TTsPXDO0szZUbt7wvMYTLocampzbTs8pgN0Fr--YCvT2r613TRuDLWasmtimHybXKe69GAYxsA3VsFWvFCNugaBm3LETU0Y0zXGR1v0-uSIxa9iIiaqIhqf~aH7ZcsMx3C1RzlsjIxiUcHTVvs~koxjsUu3BBdNuB5OuHB9vSph8DUDvsh3mOgjULQloFtPpi-w__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\n" +
                    "    \"purchase_order_number\": null,\n" +
                    "    \"reference_number\": \"VBGCB-56842\",\n" +
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
                    "    \"store_number\": \"6669\",\n" +
                    "    \"subtotal\": 14.61,\n" +
                    "    \"tax\": 2.19,\n" +
                    "    \"tax_lines\": [\n" +
                    "      {\n" +
                    "        \"base\": null,\n" +
                    "        \"name\": null,\n" +
                    "        \"order\": 0,\n" +
                    "        \"rate\": 15,\n" +
                    "        \"total\": 2.19\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"tip\": null,\n" +
                    "    \"total\": 16.8,\n" +
                    "    \"total_weight\": null,\n" +
                    "    \"tracking_number\": null,\n" +
                    "    \"updated_date\": \"2024-01-22 17:35:03\",\n" +
                    "    \"vendor\": {\n" +
                    "      \"abn_number\": null,\n" +
                    "      \"account_number\": null,\n" +
                    "      \"address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"bank_name\": null,\n" +
                    "      \"bank_number\": null,\n" +
                    "      \"bank_swift\": null,\n" +
                    "      \"category\": \"Grocery\",\n" +
                    "      \"email\": null,\n" +
                    "      \"fax_number\": null,\n" +
                    "      \"iban\": null,\n" +
                    "      \"lat\": null,\n" +
                    "      \"lng\": null,\n" +
                    "      \"logo\": \"https://cdn.veryfi.com/logos/us/150113248.png\",\n" +
                    "      \"name\": \"Tamimi Markets\",\n" +
                    "      \"phone_number\": \"800-303-0010\",\n" +
                    "      \"raw_address\": \"tamimi\\nGore 166\\nRIYADH\",\n" +
                    "      \"raw_name\": \"Tamimi Markets\",\n" +
                    "      \"reg_number\": null,\n" +
                    "      \"type\": \"Grocery\",\n" +
                    "      \"vat_number\": \"300508296700003\",\n" +
                    "      \"web\": \"www.tamimimerkete.com\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17") && testcase.equalsIgnoreCase("VerifySce02-WrongPrice") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17") && testcase.equalsIgnoreCase("VerifySce03-WrongProduct") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario17") && testcase.equalsIgnoreCase("VerifySce04-WrongQuantity") ) {

            return "";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario01-Currency Code Blank") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"type\":\"direct\",\"challengeId\":\"\",\"challengeType\":\"\",\"challengeTypeId\":\"\",\"isRejected\":false,\"rejectionReason\":\"\",\"data\":{\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":null,\"created_date\":\"2024-03-19 05:36:29\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 21:56:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650084877\",\"document_title\":\"\\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\",\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":192982032,\"img_blur\":false,\"img_file_name\":\"192982032.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/dc453eac-dbd0-41f7-9450-7efe447f93d7\\/thumbnail.jpg?Expires=1710827504&Signature=IQAr3MV3e87Z2VmNXflVRKEiV45p617bxdXMbNZnRFW-KPaGC5mecardkSwlR5SMvODbo6fC3iXxci7ysZTGS4-4tXLKs00DhNndvQHLO-hG~-NAylBycMib9DyMJFZSZUlUHlyfev3Mak2JgnuK~RKXFUq3h2vffwE5G1QP-ZACP6uQHFO40iiRuu0233-NXIklKI7ed2n7bjPgEBp~YkIiVZ4W7~znMxOY~7YrPOCwqj0WobZ3cUqMRUYY7mbeqLPmhmSvGIX3Zt6QXuWX7C92BBy8rG0x6gkNkdT5ukYHTWxmcJ~L75WFvgbUT8xVurGkd9~F5EAyDPSaUIaa4Q__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/dc453eac-dbd0-41f7-9450-7efe447f93d7\\/cb10c07f-97cd-4a97-9381-61b2432a0b85.jpg?Expires=1710827504&Signature=AmyiR5Awm3MJKUKLjlKqBPtnRKBJEa967YwdOQM6cAg8EsgpN0EntLb1MFxKggoxIqVivEupJ5cfHkifzaITPvht~orojfVoDkCWDLBAubZaU2eFVor6pYOK9yl0rUsuulS60K0ZO81wj7Gm0gn1dGhyIwO31D78akjJQ1643VLa9bsZ1MS1qVB0piIyjhjzohRsH1LPgNJRCcVfOHSppI0bXYJ-Jjrxz7lfPDW~Zz-BK7uchFiyW7yqrnx6-O20AqiYwiXZicdufK3QJWJl8xKjdEpvg6Xijvp9wt2uNtobeeSx~5Ue9ev2UiK7gn23wLyTCQGJAflKYoUPI-y-hg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":\"4877\",\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":null,\"date\":null,\"description\":\"30 \\u062c \\u0648\\u062c\\u0628\\u0646\\u0629 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0627\\u0635\\u0627\\u0628\\u0639 \\u0641\\u064a\\u062a\\u0648\\u0633\\n*CHEETOS STCK CH\\/KET0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"30 \\u062c \\u0648\\u062c\\u0628\\u0646\\u0629 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0627\\u0635\\u0627\\u0628\\u0639 \\u0641\\u064a\\u062a\\u0648\\u0633 *CHEETOS STCK CH\\/KET0001\",\"hsn\":null,\"id\":856231858,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"30\\t\\u062c \\u0648\\u062c\\u0628\\u0646\\u0629 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0627\\u0635\\u0627\\u0628\\u0639 \\u0641\\u064a\\u062a\\u0648\\u0633\\n*CHEETOS STCK CH\\/KET0001\\t1.15 C\",\"total\":1.15,\"type\":\"room\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":null,\"date\":null,\"description\":\"85\\u062c \\u0648\\u064a\\u0646\\u062c\\u0632 \\u0645\\u0648\\u062a \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a \\u0634\\u064a\\u0643\\u0627\\u063a\\u0648 \\u0628\\u0627\\u06a9\\u0633 \\u0646\\u06cc\\u0632\\nLAYS MAXX CHICAGO H00001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"85\\u062c \\u0648\\u064a\\u0646\\u062c\\u0632 \\u0645\\u0648\\u062a \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a \\u0634\\u064a\\u0643\\u0627\\u063a\\u0648 \\u0628\\u0627\\u06a9\\u0633 \\u0646\\u06cc\\u0632 LAYS MAXX CHICAGO H00001\",\"hsn\":null,\"id\":856231859,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"85\\u062c\\t\\u0648\\u064a\\u0646\\u062c\\u0632 \\u0645\\u0648\\u062a \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a \\u0634\\u064a\\u0643\\u0627\\u063a\\u0648 \\u0628\\u0627\\u06a9\\u0633 \\u0646\\u06cc\\u0632\\nLAYS MAXX CHICAGO H00001\\t4.35 C\",\"total\":4.35,\"type\":\"room\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":null,\"date\":null,\"description\":\"85\\u062c \\u0645\\u06a9\\u0633\\u06cc\\u06a9\\u06cc \\u062d\\u0627\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0628\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX MEXICAN CHO001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"85\\u062c \\u0645\\u06a9\\u0633\\u06cc\\u06a9\\u06cc \\u062d\\u0627\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0628\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632 LAYS MAXX MEXICAN CHO001\",\"hsn\":null,\"id\":856231860,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"85\\u062c\\t\\u0645\\u06a9\\u0633\\u06cc\\u06a9\\u06cc \\u062d\\u0627\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0628\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX MEXICAN CHO001\\t4.35 C\",\"total\":4.35,\"type\":\"room\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":\"LCD photo\",\"color\":\"red\",\"decision\":\"Fraud\",\"images\":[{\"is_lcd\":true,\"score\":0.95}],\"pages\":[{\"is_lcd\":{\"score\":0.95,\"value\":true}}],\"score\":0.95,\"submissions\":{\"last_2_weeks\":0,\"last_day\":0,\"last_minutes\":0,\"last_month\":0,\"last_week\":0},\"version\":null},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2516,\"language\":[\"en\",\"ar\"],\"width\":1805}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2516,\"size_kb\":2100,\"width\":1805}],\"total_pages\":1,\"warnings\":[]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE M 800-303-0010\\n\\n\\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n30\\t\\u062c \\u0648\\u062c\\u0628\\u0646\\u0629 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0627\\u0635\\u0627\\u0628\\u0639 \\u0641\\u064a\\u062a\\u0648\\u0633\\n*CHEETOS STCK CH\\/KET0001\\t1.15 C\\n85\\u062c\\t\\u0648\\u064a\\u0646\\u062c\\u0632 \\u0645\\u0648\\u062a \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u064a \\u0634\\u064a\\u0643\\u0627\\u063a\\u0648 \\u0628\\u0627\\u06a9\\u0633 \\u0646\\u06cc\\u0632\\nLAYS MAXX CHICAGO H00001\\t4.35 C\\n85\\u062c\\t\\u0645\\u06a9\\u0633\\u06cc\\u06a9\\u06cc \\u062d\\u0627\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0643\\u0647\\u0629 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0628\\u0627\\u06a9\\u0633 \\u0644\\u06cc\\u0632\\nLAYS MAXX MEXICAN CHO001\\t4.35 C\\nITEMS\\t3\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639\\nTOTAL\\t9.85\\n\\u0646\\u0642\\u062f\\u0627\\nCash\\t\\tSR\\t9.85\\n\\nNET TOTAL\\tVAT C\\t8.57\\nVAT\\t\\t15.0%\\t1.28\\nTAMIMI MARKETS CO. L\\n*4877 0165\\/008\\/059\\t05.12.22 21:56 AC-00\\n\\n202212051650084877\\n\\n\\t*****\\n\\u0625\\u064a\\u0635\\u0627\\u0644 \\u0628\\u062f\\u0648\\u0646 \\u0644\\u0627\\u063a\\u064a \\u0627\\u0644\\u0625\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0623\\u0648 \\u0627\\u0644\\u0625\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT--\\n\\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u0639\\u0632\\u064a\\u0632\\u064a\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u062e\\u062f\\u0645\\u0629 \\u0645\\u0646 \\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u0629 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n\\n\\t***\\nVisit us at:\\nwww.tamimimarkets.com\\n\\nPRE\\tL\\t\\t\\t\\t\\t\\t\\t\\tNEW\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/dc453eac-dbd0-41f7-9450-7efe447f93d7\\/fe5914e4-53c7-4b8a-a96c-19ed5f895965.pdf?Expires=1710827504&Signature=WxifXyNfA4jomFnOAccfxuP0cVmRyqNARpHFpNKi-fbdDtCptH3TVgORNNgugFrteTEjt93umNp2yqEc7E7fNesVMDJcgnAY5etC9qad7OgOT-Yx~jeWs890G-pcQ37uhLhSK9Omqiww0f1OnLK~oyhsErEkSnK1AkjDN3f5ba-HzsrwVXwM-8QPVfhiZYzWkeGgPVQOrsmPAJnovDX5zK2Om09IcUcLiDkaorA4wQ9HcCQK8o~QzllnL8S106FcjnaVj77q-yuSQ-qZP9ghXQZIMEKUuk8apkBWiCjJzvGrJo7DTAxCHXI1EmHkdPRfgz0pE~eHTOMlL049fl1B6A__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBHEJ-82032\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"165\",\"subtotal\":8.57,\"tax\":1.28,\"tax_lines\":[{\"base\":8.57,\"name\":null,\"order\":0,\"rate\":15,\"total\":1.28}],\"tip\":null,\"total\":9.85,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-03-19 05:36:43\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"\\u0627\\u0644\\u0628\\u062f\\u064a\\u0639\\u0629, Al Riyadh, Riyadh, Saudi Arabia\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":24.610556016,\"lng\":46.675832961,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/3eb16ac2-e05f-4dfe-9664-485ab118b669.png\",\"name\":\"\\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0627\\u0644\\u062d\\u0644\\u0648\\u064a\\u0627\\u062a\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"BADIA ROAD RIYADH\",\"raw_name\":\"TAMIMI MARKETS CO\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimarkets.com\"}},\"scanStartedDate\":\"2024-03-19\",\"scanStartedTime\":\"05:36:12\"}\n" +
                    "}";
        }

        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario03-Doc Handwritten") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-06-09 06:59:37\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 21:02:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650041008\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":214652144,\"img_blur\":false,\"img_file_name\":\"214652144.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/46873778-cab5-458f-a4da-282d31a134c2\\/thumbnail.jpg?Expires=1717917280&Signature=b6W~MJK~bXT~VRgVsx30rQYuQbXYsC-mAzoXRaL7ZIDsqpQWkR7JYrLciOkn0P6MDZ2bQXpkIUkzXVWBKUDVPuPbQdwJ3dVd4Y8isibb-4srI17mleyHDzS8ch404TiAYUDqdeCKjU7W2cYaUDkwyPZ9Ojd3UCyxZFbUVmDk81qe7TR5e4VYZ2Udqa5XYL3o~E~Ra7wdNXZSMhdeie7dfAg3vZsobmnSpzm75SRTo5ZJcWpIqNKiUWbJ1EBdmiys6LguSP8~qZfb-Dr2aryWri-tJpF00GTWosPBdssqLSZudmM~bMYJqviIjgIjTlPOy7itIioO1qet~kTJo2kpmg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/46873778-cab5-458f-a4da-282d31a134c2\\/851d3621-c546-4463-bea2-719d045102d0.jpg?Expires=1717917280&Signature=ZryUXo0m~uxZV4J5bGKdxXC5gGmVyl2igGJRF63A3zSTOxZOh~57MxTa2JV88yCa7znDCOtZZY0nxxLLAjjBEZcXkMkyTl7ZjxN9Bq5Yx0e~azmN-h12WeJ47YEe5tIT1Nc-fwKMADbAVn~2ncqMFIzdFGvlX0rZzJTrJjDlMACNSaujFNVH3qcu6F1ya9fvUeSC6OnT9~XIQjcADku2HJvlGgWKe1WvprZHKOygcIOXlZ--VlkJwQy9TZZGecOYL-YiJrE6SsFjFNmZCUikl267PclTtEzn-5uNWc2CosCUMsfHhR--mwYadW4IBzvXvxYhANi1fiVLX4b3fhVUvA__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u062a\\u0633\\u0627\\u0644\\u064a \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0643\\u0645\\u0648\\u0646 \\u060c \\u0644\\u064a\\u0645\\u0648\\u0646 23 12 \\u062d\\u0628\\u0629\\nTASALI CUMIN LEMON 50001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u062a\\u0633\\u0627\\u0644\\u064a \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0643\\u0645\\u0648\\u0646 \\u060c \\u0644\\u064a\\u0645\\u0648\\u0646 23 12 \\u062d\\u0628\\u0629 TASALI CUMIN LEMON 50001\",\"hsn\":null,\"id\":957755761,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062a\\u0633\\u0627\\u0644\\u064a \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0643\\u0645\\u0648\\u0646 \\u060c \\u0644\\u064a\\u0645\\u0648\\u0646 23 12 \\u062d\\u0628\\u0629\\nTASALI CUMIN LEMON 50001\\t17.95 C\",\"total\":17.95,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0645\\u0644 330-355 \\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u062a\\u0641\\u0627\\u062d\\nMIRINDA CAN APPLE 330001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0644 330-355 \\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u062a\\u0641\\u0627\\u062d MIRINDA CAN APPLE 330001\",\"hsn\":null,\"id\":957755762,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0644 330-355 \\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u062a\\u0641\\u0627\\u062d\\nMIRINDA CAN APPLE 330001\\t2.75 C\",\"total\":2.75,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0633\\u0641\\u0646 \\u0623\\u0628 \\u0639\\u0644\\u0628\\u0629 325 \\u0645\\u0644\\n7-UP CAN 4\\/6\\/325ML 0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0633\\u0641\\u0646 \\u0623\\u0628 \\u0639\\u0644\\u0628\\u0629 325 \\u0645\\u0644 7-UP CAN 4\\/6\\/325ML 0001\",\"hsn\":null,\"id\":957755763,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0633\\u0641\\u0646 \\u0623\\u0628 \\u0639\\u0644\\u0628\\u0629 325 \\u0645\\u0644\\n7-UP CAN 4\\/6\\/325ML 0001\\t2.50 C\",\"total\":2.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0645\\u0644 330-355 \\u0645\\u0631\\u06cc\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0628\\u0631\\u062a\\u0642\\u0627\\u0644 \\u0639\\u0644\\u064a\\u0629\\nMIRINDA CAN ORANGE 30001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0644 330-355 \\u0645\\u0631\\u06cc\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0628\\u0631\\u062a\\u0642\\u0627\\u0644 \\u0639\\u0644\\u064a\\u0629 MIRINDA CAN ORANGE 30001\",\"hsn\":null,\"id\":957755764,\"lot\":null,\"normalized_description\":null,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0644 330-355 \\u0645\\u0631\\u06cc\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0628\\u0631\\u062a\\u0642\\u0627\\u0644 \\u0639\\u0644\\u064a\\u0629\\nMIRINDA CAN ORANGE 30001\\t2.75 C\",\"total\":2.75,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"BERITOS NACHO 2\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"BERITOS NACHO 2\",\"hsn\":null,\"id\":957755765,\"lot\":null,\"normalized_description\":null,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"BERITOS NACHO 2\\t10.050\",\"total\":10.05,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":\"Handwritten characters\",\"color\":\"red\",\"decision\":\"Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.96}],\"pages\":[{\"is_lcd\":{\"score\":0.96,\"value\":false}}],\"score\":1,\"submissions\":{\"last_2_weeks\":1,\"last_day\":1,\"last_minutes\":1,\"last_month\":1,\"last_week\":1},\"version\":null},\"handwritten_fields\":[\"line_items.4.total\"],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2501,\"language\":[\"en\",\"ar\"],\"width\":1759}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2501,\"size_kb\":1395,\"width\":1759}],\"total_pages\":1,\"warnings\":[{\"message\":\"Subtotal for Line Items 36.0 doesn't match subtotal on document 122.57\",\"type\":\"totals_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0633\\u0648\\u0627\\u0642 \\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE # 800-303-0010\\n\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0641\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n\\u062a\\u0633\\u0627\\u0644\\u064a \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0643\\u0645\\u0648\\u0646 \\u060c \\u0644\\u064a\\u0645\\u0648\\u0646 23 12 \\u062d\\u0628\\u0629\\nTASALI CUMIN LEMON 50001\\t17.95 C\\n\\u0645\\u0644 330-355 \\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u062a\\u0641\\u0627\\u062d\\nMIRINDA CAN APPLE 330001\\t2.75 C\\n\\u0633\\u0641\\u0646 \\u0623\\u0628 \\u0639\\u0644\\u0628\\u0629 325 \\u0645\\u0644\\n7-UP CAN 4\\/6\\/325ML 0001\\t2.50 C\\n\\u0645\\u0644 330-355 \\u0645\\u0631\\u06cc\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0628\\u0631\\u062a\\u0642\\u0627\\u0644 \\u0639\\u0644\\u064a\\u0629\\nMIRINDA CAN ORANGE 30001\\t2.75 C\\nBERITOS NACHO 2\\t10.050\\nTOTAL\\t125.95\\n\\u0646\\u0642\\u062f\\u0627\\u064b\\nCash\\tSR\\t25.95\\n\\nNET TOTAL\\tVAT C\\t22,57\\nVAT\\t\\t15.0%\\t3.38\\nTAMIMI MARKETS CO. L\\n*1008 0165\\/004\\/453\\t05.12.22 21:02 AC-00\\n\\n202212051650041008\\n\\n*******\\n\\u0627\\u0644\\u0627\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644 \\u0623\\u0648 \\u0627\\u0644\\u0625\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u0644\\u0627\\u063a\\u064a \\u0628\\u062f\\u0648\\u0646 \\u0627\\u064a\\u0635\\u0627\\u0644\\n-NO EXCHANGE OR RETURN WITHOUT RECEIPT--\\n\\u0639\\u0632\\u064a\\u0632\\u064a \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u064a\\u0645\\u0643\\u0644\\u0645\\u0644\\u0643 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u0639\\u0644\\u0649\\n\\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u0629 \\u0645\\u0646 \\u0644\\u062e\\u062f\\u0645\\u0629 \\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n*******\\nVisit us at:\\nwww.tamimimarkets.com\\nwww.facebook.com\\/tamimimarkets\\n\\tCamScanner \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0628\\u0640\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"terms\":null,\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/46873778-cab5-458f-a4da-282d31a134c2\\/761d93d3-e4ad-4bff-a209-49bb5e4d8a26.pdf?Expires=1717917280&Signature=I~KW7XwVFPEXP96EZuFTayiChLYSvRL~HQOnDbESW7Eq9VMmjVjrNjUJHfI2eKu1IelRFslgcby1yLOijZCO~ypp4~eXhiGwfm523s-21LcfE7mHAY-rL1JOgHvX2eX7hvHv9DKERaxvjHikY94XPqxsjZKpjeQ2ZF-kj19t-yS1dmWTeVcozf0YxZCwPRNtird~0cOIxeNWsVQUKCfdT5a8HWQzlqdkWlJMOq9dikLQnMAUG2FMK2cTzsoeyD-WdILvt9zt-IfopYjYZUmdOv1LVU49HjeQnfvj1IepSNeHkeJ1~nvtVA2oN6NrpUZr1b1cS7G0J3R7n84w44oKiA__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBJGG-52144\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"165\",\"subtotal\":122.57,\"tags\":[],\"tax\":3.38,\"tax_lines\":[{\"base\":22.57,\"name\":\"VAT\",\"order\":0,\"rate\":15,\"total\":3.38}],\"tip\":null,\"total\":125.95,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-06-09 06:59:40\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"BADIA ROAD RIYADH\\nCUSTOMER SERVICE #\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":24.610556016,\"lng\":46.675832961,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/us\\/150113248.png\",\"name\":\"Tamimi Markets\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"BADIA ROAD RIYADH\",\"raw_name\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\ntamimi markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.tamimimarkets.com\"}}\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario04-Total is Negative") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"barcodes\":[{\"data\":\"414662\",\"type\":\"CODE39\"},{\"data\":null,\"type\":null}],\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-02-05 13:46:42\",\"currency_code\":\"SAR\",\"custom_fields\":[],\"date\":\"2024-02-05 15:41:44\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"0502072253\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":183128350,\"img_blur\":false,\"img_file_name\":\"183128350.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/94458b96-c87f-4f1c-a030-3ba7a5f0074c\\/thumbnail.jpg?Expires=1722852453&Signature=FdJMB0z~IRqwc9zYNlbdAB4RbmVCAU0F77aOzykC6FKHX0NQY8Pg4BkW1-TrQNG48gnLfky6op3HsH7bFfjSpCroKlNs73hA~AsiBfZ9cFybhPsUT2qCWLK0yckzId4~WdEvn7cMyVWeL4W0a~rzX6K53~-XpZzw89gh81bwpAmU2xIQCEuDEQPx0ovC2ubPaMpsFrbY9yJuHJggBKFjcAk6eZr808FcdIRf-zIVTokd0bm~ifZnHZODBIkdazI4TiqERRrHuMZuTbN4qdAgRMda-JS3x1IPkEcUwQNsG9XJFZZVNm6Hshx2a2qQzGxRpJk7PBGVlprVOTBbuRRcMA__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/94458b96-c87f-4f1c-a030-3ba7a5f0074c\\/0c14de83-feef-4278-898d-c78535b9e992.jpg?Expires=1722852453&Signature=C1EE2zx23gYQeajPkpbHqmfdeRw7NO262~aa8pebc0ph9mVyXzxvl2b-7695rZa73yoY9LEoo6D5G94e4LaP8iV5LyJwlSxU78vcg00ojpioaQKNAsYYomHcJfvidbtvdyV-Hlhl1Y3I8UwKti1a8vGALJ5pIml6wFpWpYtj6b43wb~43RNQ3y4JovtsqrhHw6l~~Z8ovVFtDBuNedme2mv744DgkZIbbTj5blg7vcjLcRnFdvMed5cG0QKAjh5rUz8O0C434peEls-iyc408rAi8~giw7ihopF3oCWCEvXUXJFg8giAFB0PytCM3FiTz2r-2JWEnYl0TCbrVG-Z7Q__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":\"155\",\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS TOMATO KETHUP 160 160\\u062c \\u0643\\u0627\\u062a\\u0634\\u0628\\n\\u0644\\u064a\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":808579094,\"order\":0,\"price\":1,\"quantity\":7.5,\"reference\":null,\"section\":null,\"sku\":\"6281036108104\",\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"1 6281036108104\\t1.00\\t7.50\\t7.50\\nLAYS TOMATO KETHUP 160\\t160\\u062c\\t\\u0643\\u0627\\u062a\\u0634\\u0628 \\u0644\\u064a\\u0632\",\"total\":7.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS CHILLI 12G\\n12 \\u062c \\u062d\\u0627\\u0631 \\u0644\\u064a\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":808579095,\"order\":1,\"price\":1,\"quantity\":0.5,\"reference\":null,\"section\":null,\"sku\":\"6281036110206\",\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"2 6281036110206\\t1.00\\t0.50\\t0.50\\nLAYS CHILLI 12G\\t\\t12\\t\\u062c \\u062d\\u0627\\u0631 \\u0644\\u064a\\u0632\",\"total\":0.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS CHILLI PC\",\"discount\":null,\"discount_rate\":null,\"id\":808579096,\"order\":2,\"price\":1,\"quantity\":1.5,\"reference\":null,\"section\":null,\"sku\":\"6281036113207\",\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"6281036113207\\t1.00 1.50\\t1.50\\nLAYS CHILLI PC\",\"total\":1.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"RANI THREE JEWELS 180M1 80 \\u062c\\u0648\\u0627\\u0647\\u0631 \\u062b\\u0644\\u0627\\u062b \\u0631\\u0627\\u0646\\u064a\",\"discount\":null,\"discount_rate\":null,\"id\":808579097,\"order\":3,\"price\":2,\"quantity\":2,\"reference\":null,\"section\":null,\"sku\":\"6281034910389\",\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"6281034910389\\t2.00 2.00\\t4.00\\nRANI THREE JEWELS \\t180M1\\t80 \\u062c\\u0648\\u0627\\u0647\\u0631 \\u062b\\u0644\\u0627\\u062b \\u0631\\u0627\\u0646\\u064a\",\"total\":4,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"BREAD BIG SWITZ\",\"discount\":null,\"discount_rate\":null,\"id\":808579098,\"order\":4,\"price\":1,\"quantity\":5,\"reference\":null,\"section\":null,\"sku\":\"6281123037010\",\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"5 6281123037010\\t1.00 5.00\\t5.00\\nBREAD BIG SWITZ\",\"total\":5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"PUCK CREAM CHEEZ 140G \\u0628\\u0648\\u0643 \\u0643\\u0631\\u064a\\u0645 \\u062c\\u0628\\u0646\\u0629\",\"discount\":null,\"discount_rate\":null,\"id\":808579099,\"order\":5,\"price\":1,\"quantity\":7,\"reference\":null,\"section\":null,\"sku\":\"5760466738088\",\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"6 5760466738088\\t1.00 7.00\\t7.00\\nPUCK CREAM CHEEZ 140G\\t\\u0628\\u0648\\u0643 \\u0643\\u0631\\u064a\\u0645 \\u062c\\u0628\\u0646\\u0629\",\"total\":7,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"INDOMIE SPECIAL CHICKET | \\u0627\\u0644\\u062f\\u062c\\u0627\\u062c \\u0628\\u0646\\u0643\\u0647\\u0629 (\\u0625\\u0646\\u062f\\u0648\\u0645\\u064a\",\"discount\":null,\"discount_rate\":null,\"id\":808579100,\"order\":6,\"price\":1,\"quantity\":15,\"reference\":null,\"section\":null,\"sku\":\"5285000391029\",\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"7 5285000391029\\t1.00 15.00\\t15.00\\nINDOMIE SPECIAL \\tCHICKET\\t| \\u0627\\u0644\\u062f\\u062c\\u0627\\u062c \\u0628\\u0646\\u0643\\u0647\\u0629 (\\u0625\\u0646\\u062f\\u0648\\u0645\\u064a\",\"total\":15,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.94}],\"pages\":[{\"is_lcd\":{\"score\":0.94,\"value\":false}}],\"score\":0.12025686246775091,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"ar\",\"en\"],\"owner\":\"pepsico-amesa\",\"pages\":[{\"height\":2827,\"language\":[\"ar\",\"en\"],\"width\":1213}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2827,\"size_kb\":855,\"width\":1213}],\"total_pages\":1,\"warnings\":[{\"message\":\"Found Barcode but wasn't able to decode it\",\"type\":\"barcode_decoding_issue\"}]},\"notes\":null,\"ocr_text\":\"Luhamart\\n\\u0644\\u0648\\u0647\\u0627\\u0645\\u0627\\u0631\\u062a\\n\\n\\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0627\\u0644\\u0642\\u062d\\u0637\\u0627\\u0646\\u064a \\u0633\\u0639\\u062f \\u0639\\u0627\\u0636 \\u062d\\u0646\\u0627\\u0646 \\u0645\\u0624\\u0633\\u0633\\u0629\\n\\u0627\\u0644\\u0631\\u064a\\u0627\\u0636 - \\u0627\\u0644\\u0623\\u0645\\u0644 \\u062d\\u064a - \\u0627\\u0644\\u0645\\u062e\\u062a\\u0627\\u0631 \\u0639\\u0645\\u0631 \\u0634\\u0627\\u0631\\u0639\\nVATE 310864270500003\\nCR:1010687089\\nMOB:0502072253\\nSimplified Tax \\tInvoice\\t- \\u0645\\u0628\\u0633\\u0637\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\nBILL \\tNO\\t\\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0631\\u0642\\u0645\\tDATE \\u0627\\u0644\\u062a\\u0627\\u0631\\u064a\\u062e\\n155\\t05\\/02\\/2024 3:41:44PM\\nItem\\tQty\\tPrice Amount\\nNo.\\t\\u0627\\u0644\\u0648\\u0635\\u0641\\t\\u0627\\u0644\\u0643\\u0645\\u064a\\u0629 \\t\\u0633\\u0639\\u0631 \\u0627\\u0644\\u0625\\u062c\\u0645\\u0627\\u0644\\u064a\\n1 6281036108104\\t1.00\\t7.50\\t7.50\\nLAYS TOMATO KETHUP 160\\t160\\u062c\\t\\u0643\\u0627\\u062a\\u0634\\u0628 \\u0644\\u064a\\u0632\\n2 6281036110206\\t1.00\\t0.50\\t0.50\\nLAYS CHILLI 12G\\t\\t12\\t\\u062c \\u062d\\u0627\\u0631 \\u0644\\u064a\\u0632\\n3\\t6281036113207\\t1.00 1.50\\t1.50\\nLAYS CHILLI PC\\n4\\t6281034910389\\t2.00 2.00\\t4.00\\nRANI THREE JEWELS \\t180M1\\t80 \\u062c\\u0648\\u0627\\u0647\\u0631 \\u062b\\u0644\\u0627\\u062b \\u0631\\u0627\\u0646\\u064a\\n5 6281123037010\\t1.00 5.00\\t5.00\\nBREAD BIG SWITZ\\n6 5760466738088\\t1.00 7.00\\t7.00\\nPUCK CREAM CHEEZ 140G\\t\\u0628\\u0648\\u0643 \\u0643\\u0631\\u064a\\u0645 \\u062c\\u0628\\u0646\\u0629\\n7 5285000391029\\t1.00 15.00\\t15.00\\nINDOMIE SPECIAL \\tCHICKET\\t| \\u0627\\u0644\\u062f\\u062c\\u0627\\u062c \\u0628\\u0646\\u0643\\u0647\\u0629 (\\u0625\\u0646\\u062f\\u0648\\u0645\\u064a\\nTotal Amount\\t40.50\\t\\u0627\\u0644\\u0645\\u0628\\u0644\\u063a \\u0627\\u062c\\u0645\\u0627\\u0644\\u064a\\nDiscount\\t\\t0.00\\t\\u0627\\u0644\\u062e\\u0635\\u0645\\nNet Amount\\t40.50\\t\\u0627\\u0644\\u0635\\u0627\\u0641\\u064a\\n\\nVAT 15% Included\\t5.28 \\u0627\\u0644\\u0645\\u0636\\u0627\\u0641\\u0629 \\u0627\\u0644\\u0642\\u064a\\u0645\\u0629 \\u0636\\u0631\\u064a\\u0628\\u0629\\nCash \\tPaid\\t\\u0627\\u0644\\u0645\\u062f\\u0641\\u0648\\u0639 \\u0627\\u0644\\u0645\\u0628\\u0644\\u063a\\t\\t0.00\\nCash \\tChange\\t\\u0627\\u0644\\u0645\\u062a\\u0628\\u0642\\u064a\\t\\t-40.50\\nCASH CUSTOMER\\t\\t\\tCounter\\n\\nBy: ADMIN 2\\tCounter Ac.No.:\\t1000206\\n\\n414662\\nThank You...\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/94458b96-c87f-4f1c-a030-3ba7a5f0074c\\/08df4776-3909-4f2e-8726-0823e3974efd.pdf?Expires=1722852453&Signature=GgX9JEyuDhi~O6YIeMx1DVXC63nAHaZ1Y24dbfQGGEbF3v6mbprwM4AvoyNIRxshmlDTRPNd~n2Vni7blU3UPTmcRnRSRsioCQqZB918KzyI-LtQFHv8ABAMxwd3Oq6GSfE3DC0NwnTx3jIi3HgqXwMa3T9r3Mc9mGgrbqRBi8TnZB-sSibpDxeAS-~0D8-d4VCUIpKx7tE6hTzyXBJVF~siH4XkbSJfs-~elQcmAfYopA-pd7kiBefokMK4jG8tZF7FaS9HcG3UOXOgOq1-lJmrsRxgTQ2NtxunPwNKJWmfTdjsCrwqLe6RuS6locmGZyIYJF6~xojix3YtPv2RIQ__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":\"1000206\",\"reference_number\":\"VBGFB-28350\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":null,\"subtotal\":40.5,\"tax\":5.28,\"tax_lines\":[{\"base\":null,\"name\":null,\"order\":0,\"rate\":15,\"total\":5.28}],\"tip\":null,\"total\":-40.5,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-02-05 13:46:53\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"\\u0627\\u0644\\u0631\\u064a\\u0627\\u0636 - \\u0627\\u0644\\u0623\\u0645\\u0644 \\u062d\\u064a - \\u0627\\u0644\\u0645\\u062e\\u062a\\u0627\\u0631 \\u0639\\u0645\\u0631 \\u0634\\u0627\\u0631\\u0639\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/ca36edee-e65d-4364-9516-2e6d66a833bf.png\",\"name\":\"Luhamart\",\"phone_number\":\"1010687089\",\"raw_address\":\"\\u0627\\u0644\\u0631\\u064a\\u0627\\u0636 - \\u0627\\u0644\\u0623\\u0645\\u0644 \\u062d\\u064a - \\u0627\\u0644\\u0645\\u062e\\u062a\\u0627\\u0631 \\u0639\\u0645\\u0631 \\u0634\\u0627\\u0631\\u0639\",\"raw_name\":\"Luhamart\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"310864270500003\",\"web\":null},\"warnings\":[]}\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario05-Vendor Blank") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-06-10 05:54:36\",\"currency_code\":\"SAR\",\"date\":\"2024-03-02 19:58:11\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":null,\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":214791104,\"img_blur\":false,\"img_file_name\":\"214791104.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/bfcd8324-0ad7-4508-9312-648ea734fed3\\/thumbnail.jpg?Expires=1717999779&Signature=RbbRABLlqmqIPiHAfCXbDOzeqKsADphpv6zxYmpQ9bEoxPscsUoozyPa--5kl7LiWGyZeVIQb51jzpgJy6U5n79YQxvpU3bWi5hP4PBWHIDvKeisvghArtMkl5nTA91aa34QTlyk2fIiGNNIaHNxQ~NjySwiCP7C5V71Ca1h3KHuVNMuHK7gYnEw0pbywR2QHVMEhq33UasFc2YB9LtNpcb2MTXswqCwuD0IbX7INuIm110otOi9fYXkfe2leqvZWOpjEowXn6wdmAcNhvmm27~EiMI-XcPiBXqpmYkUrJivhhvjM-azztVoqydq-ejYA920bLH-XqGp~teLWfKJRg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/bfcd8324-0ad7-4508-9312-648ea734fed3\\/c63e7249-c026-4643-ada2-ff99e4ac9019.jpg?Expires=1717999779&Signature=VZqT2lui3Xg0-IBqD8wXxlqPAcBxLwQ7g3glpyxP4nlloLixdmySFyFOxARbqGlC~K0WH47x~pxoqnmPigutJ813pivGvbGmhVpBSxiXEeL1cWt2mnpq16YBBiEYoA3TKsgJ4KvLCg1mrapDyRFv2LLOKb7dHk75e9CfMP-25o79ELfLRgu60DKwcFPUoX0~Q3ox~F5sFENkvheNGtiEVzkbzaB15TGMuxHDazZ4InDceUeEZ0AoSVz2zigcdriOxmG8EXhcHodGGLh2ZwzwydPm4ZHFo9cbnqq7Gf70MY0LvP3xHjvTE8kbXnYABUTi-xjcBwltliMOgY7KBctdEQ__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":\"H12D223387\",\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0627\\u0644\\u0628\\u0637\\u0644 \\u0641\\u0634\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0643\\u0631\\u0627\\u0645\\u064a\\u0644\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0627\\u0644\\u0628\\u0637\\u0644 \\u0641\\u0634\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0643\\u0631\\u0627\\u0645\\u064a\\u0644\",\"hsn\":null,\"id\":958483350,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":5.65,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":\"627606\",\"start_date\":null,\"tags\":[],\"tax\":0.85,\"tax_rate\":null,\"text\":\"1 627606\\t1.00 PCS 5.65\\t0.85\\t6.50\\n\\u0627\\u0644\\u0628\\u0637\\u0644 \\u0641\\u0634\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0643\\u0631\\u0627\\u0645\\u064a\\u0644\",\"total\":6.5,\"type\":\"food\",\"unit_of_measure\":\"PCS\",\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"AL-BATAL CARAMEL POPCORN 140 GM\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"AL-BATAL CARAMEL POPCORN 140 GM\",\"hsn\":null,\"id\":958483351,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":2.17,\"quantity\":2,\"reference\":null,\"section\":null,\"sku\":\"698987\",\"start_date\":null,\"tags\":[],\"tax\":0.65,\"tax_rate\":null,\"text\":\"AL-BATAL CARAMEL POPCORN 140 GM\\n\\n2 698987\\t2.00 PCS 2.17\\t0.65\\t5.00\",\"total\":5,\"type\":\"food\",\"unit_of_measure\":\"PCS\",\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0644\\u064a\\u0631 \\u0645\\u0627\\u0643\\u0633 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0634\\u064a\\u0628\\u0633\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0644\\u064a\\u0631 \\u0645\\u0627\\u0643\\u0633 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0634\\u064a\\u0628\\u0633\",\"hsn\":null,\"id\":958483352,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0644\\u064a\\u0631 \\u0645\\u0627\\u0643\\u0633 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0634\\u064a\\u0628\\u0633\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS MAXX TEXAS BBQ BRISKET POTATO CHIPS 45 G\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"LAYS MAXX TEXAS BBQ BRISKET POTATO CHIPS 45 G\",\"hsn\":null,\"id\":958483353,\"lot\":null,\"normalized_description\":null,\"order\":3,\"price\":2.17,\"quantity\":2.3041,\"reference\":null,\"section\":null,\"sku\":\"699047\",\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":0.65,\"tax_rate\":null,\"text\":\"LAYS MAXX TEXAS BBQ BRISKET POTATO CHIPS 45 G\\n\\n3 699047\\t2.00 PC6 2.17\\t0.65\\t5.00\",\"total\":5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS MAX CHICAGO HOT WINGS 45 GM\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"LAYS MAX CHICAGO HOT WINGS 45 GM\",\"hsn\":null,\"id\":958483354,\"lot\":null,\"normalized_description\":null,\"order\":4,\"price\":2.17,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":\"621062\",\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":0.33,\"tax_rate\":null,\"text\":\"LAYS MAX CHICAGO HOT WINGS 45 GM\\n\\n4 621062\\t1.00 PCS 2.17\\t0.33\\t2.50\",\"total\":2.5,\"type\":\"food\",\"unit_of_measure\":\"PCS\",\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0644\\u064a\\u0632 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062d\\u0644 \\u0628\\u0637\\u0627\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0644\\u064a\\u0632 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062d\\u0644 \\u0628\\u0637\\u0627\",\"hsn\":null,\"id\":958483355,\"lot\":null,\"normalized_description\":null,\"order\":5,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0644\\u064a\\u0632 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062d\\u0644 \\u0628\\u0637\\u0627\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"LAYS SALT & VINEGAR POTATO CHIPS +BGM\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"LAYS SALT & VINEGAR POTATO CHIPS +BGM\",\"hsn\":null,\"id\":958483356,\"lot\":null,\"normalized_description\":null,\"order\":6,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS SALT & VINEGAR POTATO CHIPS +BGM\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":null,\"color\":\"green\",\"decision\":\"Not Fraud\",\"images\":[{\"is_lcd\":false,\"score\":0.89}],\"pages\":[{\"is_lcd\":{\"score\":0.89,\"value\":false}}],\"score\":0.1203,\"submissions\":{\"last_2_weeks\":0,\"last_day\":0,\"last_minutes\":0,\"last_month\":0,\"last_week\":0},\"version\":null},\"handwritten_fields\":[],\"language\":[\"ar\",\"en\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2540,\"language\":[\"ar\",\"en\"],\"width\":1805}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2540,\"size_kb\":2105,\"width\":1805}],\"total_pages\":1,\"warnings\":[{\"message\":\"Line item #2 has a problem. Quantity x Price != Total\",\"type\":\"line_item_amount_missmatch\"},{\"message\":\"Line item #4 has a problem. Quantity x Price != Total\",\"type\":\"line_item_amount_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0640\\u0640\\u062a\\u0627\\u062c\\u0631 \\u0644\\n\\u0627\\u0644\\u062d\\u0627\\u0632\\u0645\\u064a\\n\\u0634\\u0631\\u0643\\u0629 \\u0645\\u062a\\u0627\\u062c\\u0631 \\u0627\\u0644\\u062d\\u0627\\u0632\\u0645\\u064a \\u0627\\u0644\\u062a\\u062c\\u0627\\u0631\\u064a\\u0629 \\u0627\\u0644\\u0645\\u062d\\u062f\\u0648\\u062f\\u0629\\n\\u06f3\\u06f1\\u06f1\\u06f3\\u06f2\\u06f3\\u06f1\\u06f8\\u06f9\\u06f8\\u06f0\\u06f0\\u06f0.\\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u064a \\u06f3: \\u0631\\u0642\\u0645\\n\\u0627\\u0644\\u0645\\u0645\\u0644\\u0643\\u0629 \\u0627\\u0644\\u0639\\u0631\\u0628\\u064a\\u0629 \\u0627\\u0644\\u0633\\u0639\\u0648\\u062f\\u064a\\u0629 - \\u0627\\u0644\\u062f\\u0627\\u0626\\u0631\\n\\u0665\\u0669\\u0660\\u0660\\u0661\\u0664\\u0662\\u0666\\u0660\\u0665\\t: \\u0633 \\u062a\\nSimplified TAX \\tinvoloe\\t- \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0645\\u0628\\u0633\\u0637\\u0629\\nBales \\tInvoice\\t- \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0627\\u0644\\u0645\\u0628\\u064a\\u0639\\u0627\\u062a\\nBill No\\tH12D223387\\t\\u0631\\u0642\\u0645 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0647\\n:\\tCustomer \\u0627\\u0633\\u0645 \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u062d\\u0633\\u0627\\u0628 \\u0627\\u0644\\u0646\\u0642\\u062f\\u064a\\u0629\\nDate\\t\\u062a\\u0627\\u0631\\u06cc\\u062e\\t02\\/03\\/2024 19:58:11\\nCounter&User : \\u0648\\u0644\\u0645\\u0633\\u062a\\u062e\\u062f\\u0645) \\u0627\\u0644\\u0639\\u062f\\u0627\\u062f\\tLeos-5 - hallma2\\n\\t5-\\tPOS\\nSL Description\\tQty Unit\\tRate Val\\tAmount\\n\\u0627\\u062c\\u0645\\u0627\\u0644\\u064a \\u0636\\u0631\\u064a\\u0628\\u0629 \\u0634\\u0639\\u0631 \\u0648\\u062d\\u062f\\u0629 \\u0643\\u0645\\u064a\\u0629 \\u0627\\u0633\\u0645 \\u0627\\u0644\\u0635\\u0646\\u0641\\n\\n1 627606\\t1.00 PCS 5.65\\t0.85\\t6.50\\n\\u0627\\u0644\\u0628\\u0637\\u0644 \\u0641\\u0634\\u0627\\u0631 \\u0628\\u0627\\u0644\\u0643\\u0631\\u0627\\u0645\\u064a\\u0644\\nAL-BATAL CARAMEL POPCORN 140 GM\\n\\n2 698987\\t2.00 PCS 2.17\\t0.65\\t5.00\\n\\u0644\\u064a\\u0631 \\u0645\\u0627\\u0643\\u0633 \\u062a\\u0643\\u0633\\u0627\\u0633 \\u0634\\u064a\\u0628\\u0633\\nLAYS MAXX TEXAS BBQ BRISKET POTATO CHIPS 45 G\\n\\n3 699047\\t2.00 PC6 2.17\\t0.65\\t5.00\\n\\u0644\\u064a\\u0631 \\u0645\\u0627\\u0643\\u0633 \\u0634\\u064a\\u0643\\u0627\\u063a\\u0648 \\u0647\\u0648\\u062a\\nLAYS MAX CHICAGO HOT WINGS 45 GM\\n\\n4 621062\\t1.00 PCS 2.17\\t0.33\\t2.50\\n\\u0644\\u064a\\u0632 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062d\\u0644 \\u0628\\u0637\\u0627\\nLAYS SALT & VINEGAR POTATO CHIPS +BGM\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":null,\"terms\":null,\"type\":null},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/bfcd8324-0ad7-4508-9312-648ea734fed3\\/bfc30158-939e-4f3b-8370-ab9ea6d19864.pdf?Expires=1717999779&Signature=bT32b5VUwGK3Ina1WZZ-CH9ghkueBcBcObWTqfkXT~WyGSTekrPqoL0DyOWexRuSLpzmL94CNigIVfPJgeVpqLdaNFlz1S-qiY5vUltiDH-Ndlryk80JO2xGP~n1BFlWP7QXI7A973RTnTgW7ML1HhxqHZIFTcPCESrDCxiC~FMGgRnsjsANtF1K2noMUzgtKAFjq88owbxSI601GzMXO4auuzJRkoAYrOQpKqMcFDep4DLq-EfwI~t070We9E1xiXyjC0i7J~tPSgSKKc1HUyTOzFKjkKlmqe9ByQUzgLwD5fmet2cbwNHwJ6KaW6PhO4vyXVQc~aXe-DZ8aEU0SQ__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBJGH-91104\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":null,\"subtotal\":null,\"tags\":[],\"tax\":null,\"tax_lines\":[],\"tip\":null,\"total\":19,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-06-10 05:54:39\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":null,\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":null,\"name\":null,\"phone_number\":null,\"raw_address\":null,\"raw_name\":null,\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":null,\"web\":null}}\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario06-Color Red") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-06-28 07:18:43\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 21:41:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"202212051650041038\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":220192669,\"img_blur\":false,\"img_file_name\":\"220192669.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/fb5847e8-2ff4-4c63-9599-d1e00517f4aa\\/thumbnail.jpg?Expires=1719560027&Signature=T-m-0GEe3GH4GBM5qtVvwO9CEXJhA7yqA-jd29T9dXpM~um1TsxHXBiUOACM~nZ3kZTTCQLytH-hhY3xZ2BxeAeyI9KAQlRorbPnZH~kFVtxVtsALCdGhA~Xx9L4BBuzymCmTF3fE69dMpeUiiC0jTM9g10zrEJocEKusZrOitEYLJVUAwchRDjlR4ZUntkAD61A39hNPQP3xXGwsdl~~kRlrjc9YHxb~qd2XJnqnFJbRbwHsCdY069TOw1gNQuPyAUc3U48hZT0oDUZi-dgBAMft99SIJaGWd8W8J8YMkNL-XpHcEcmDc1UMGBPswSfwaT3c3vK86T1GbzTEKOpKQ__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/fb5847e8-2ff4-4c63-9599-d1e00517f4aa\\/ca03fae8-0c0e-43d6-a6fa-d7116aa0d3d6.jpg?Expires=1719560027&Signature=QLMxO4b1ttSEk~P4FuNc6ppM7mkv4~6o3udb~kiowkScE4PJP23W0oDETAUi46G1hkGBDpf6nHTRzhBHtr0LYaNP5VgiG34mzVC8a2RLfMKo4srPdvX5ETxFu65m3De1LsPII0zFjB4DVdt4O7IXbHyJwoz3E5lbSqJZB6eXSoxbDq66CuGPqJ0I4UXc7a57KvSYJCCPEbcMvK-mImb239roq82L6mkskkQyqwodx2i0oe718Cm4u4dPQHVCmzcXXuxpoQMWn5ODQVrz4NeyW0M1IFjSkHxsGPXuV0KdTBWpeltx7hXSRn0ZyEiY2I8zoRlfECXyiZZ0Cy1vuAOXWA__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646\\u0629 21\\u062c 12 \\u062d\\u0628\\u0629\\nLAYS NAT POT CHIPS C0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646\\u0629 21\\u062c 12 \\u062d\\u0628\\u0629 LAYS NAT POT CHIPS C0001\",\"hsn\":null,\"id\":981247969,\"lot\":null,\"normalized_description\":null,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646\\u0629 21\\u062c 12 \\u062d\\u0628\\u0629\\nLAYS NAT POT CHIPS C0001\\t1.25 C\",\"total\":1.25,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"43 \\u0644\\u0627\\u06cc\\u0632 \\u0641\\u0648\\u0631\\u0646\\u0648 \\u0631\\u0642\\u0627\\u0626\\u0642 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0645\\u062e\\u0628\\u0648\\u0632\\u0629 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u062c\\nLAYS FORNO AUTHENTIC0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"43 \\u0644\\u0627\\u06cc\\u0632 \\u0641\\u0648\\u0631\\u0646\\u0648 \\u0631\\u0642\\u0627\\u0626\\u0642 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0645\\u062e\\u0628\\u0648\\u0632\\u0629 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u062c LAYS FORNO AUTHENTIC0001\",\"hsn\":null,\"id\":981247970,\"lot\":null,\"normalized_description\":null,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"43\\t\\u0644\\u0627\\u06cc\\u0632 \\u0641\\u0648\\u0631\\u0646\\u0648 \\u0631\\u0642\\u0627\\u0626\\u0642 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0645\\u062e\\u0628\\u0648\\u0632\\u0629 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u062c\\nLAYS FORNO AUTHENTIC0001\\t3.15 C\",\"total\":3.15,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"46 \\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062e\\u0644 \\u062c\\nLAYS SALT&VINEGAR P00001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"46 \\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062e\\u0644 \\u062c LAYS SALT&VINEGAR P00001\",\"hsn\":null,\"id\":981247972,\"lot\":null,\"normalized_description\":null,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"46\\t\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062e\\u0644 \\u062c\\nLAYS SALT&VINEGAR P00001\\t2.90 C\",\"total\":2.9,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"170 \\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0644\\u06c1 \\u0634\\u06cc\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u062c\\nLAYS NAT POT CHIP SA0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"170 \\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0644\\u06c1 \\u0634\\u06cc\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u062c LAYS NAT POT CHIP SA0001\",\"hsn\":null,\"id\":981247974,\"lot\":null,\"normalized_description\":null,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"170\\t\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0644\\u06c1 \\u0634\\u06cc\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u062c\\nLAYS NAT POT CHIP SA0001\\t7.30 C\",\"total\":7.3,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0627\\u0644\\u0641\\u0631\\u0627\\u0648\\u0644\\u0629 1 \\u0644\\u062a\\u0631\\nMIRINDA CITRUS \\/1LTR0001\",\"discount\":null,\"discount_rate\":null,\"end_date\":null,\"full_description\":\"\\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0627\\u0644\\u0641\\u0631\\u0627\\u0648\\u0644\\u0629 1 \\u0644\\u062a\\u0631 MIRINDA CITRUS \\/1LTR0001\",\"hsn\":null,\"id\":981247976,\"lot\":null,\"normalized_description\":null,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"start_date\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0627\\u0644\\u0641\\u0631\\u0627\\u0648\\u0644\\u0629 1 \\u0644\\u062a\\u0631\\nMIRINDA CITRUS \\/1LTR0001\\t5.00 C\",\"total\":5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null,\"weight\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":\"High velocity, LCD photo\",\"color\":\"red\",\"decision\":\"Fraud\",\"images\":[{\"is_lcd\":true,\"score\":0.81}],\"pages\":[{\"is_lcd\":{\"score\":0.81,\"value\":true}}],\"score\":0.81,\"submissions\":{\"last_2_weeks\":8,\"last_day\":8,\"last_minutes\":7,\"last_month\":8,\"last_week\":8},\"version\":null},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2643,\"language\":[\"en\",\"ar\"],\"width\":1784}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2643,\"size_kb\":1824,\"width\":1784}],\"total_pages\":1,\"warnings\":[]},\"notes\":null,\"ocr_text\":\"\\u0627\\u0633\\u0648\\u0627\\u0642 \\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a\\ntamimi markets\\nStore 165\\nBADIA ROAD RIYADH\\nCUSTOMER SERVICE # 800-303-0010\\n\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0627\\u0644\\u0645\\u0628\\u0633\\u0637\\u0629\\nSimplified Tax Invoice\\nVAT Number: 300508296700003\\n\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646\\u0629 21\\u062c 12 \\u062d\\u0628\\u0629\\nLAYS NAT POT CHIPS C0001\\t1.25 C\\n43\\t\\u0644\\u0627\\u06cc\\u0632 \\u0641\\u0648\\u0631\\u0646\\u0648 \\u0631\\u0642\\u0627\\u0626\\u0642 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0645\\u062e\\u0628\\u0648\\u0632\\u0629 \\u0628\\u0627\\u0644\\u062c\\u0628\\u0646 \\u062c\\nLAYS FORNO AUTHENTIC0001\\t3.15 C\\n46\\t\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0633 \\u0634\\u064a\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u0648\\u0627\\u0644\\u062e\\u0644 \\u062c\\nLAYS SALT&VINEGAR P00001\\t2.90 C\\n170\\t\\u0644\\u06cc\\u0632 \\u0628\\u0637\\u0627\\u0637\\u0644\\u06c1 \\u0634\\u06cc\\u0628\\u0633 \\u0628\\u0627\\u0644\\u0645\\u0644\\u062d \\u062c\\nLAYS NAT POT CHIP SA0001\\t7.30 C\\n\\u0645\\u0631\\u064a\\u0646\\u062f\\u0627 \\u0635\\u0648\\u062f\\u0627 \\u0627\\u0644\\u0641\\u0631\\u0627\\u0648\\u0644\\u0629 1 \\u0644\\u062a\\u0631\\nMIRINDA CITRUS \\/1LTR0001\\t5.00 C\\nITEMS\\t5\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639\\nTOTAL\\t19.60\\n\\u0646\\u0642\\u062f\\u0627\\nCash\\tSR\\t50.00\\n\\u0627\\u0644\\u0628\\u0627\\u0642\\u064a\\nCHANGE\\tSR\\t-30.40\\n\\nNET TOTAL\\tVAT C\\t17.04\\nVAT\\t15.0%\\t2.56\\nTAMIMI MARKETS CO. L\\n*1038 0165\\/004\\/453\\t05.12.22 21:41 AC-00\\n\\n202212051650041038\\n\\n\\t****\\n--EURN\\n\\u0644\\u0627\\u063a\\u064a \\u0628\\u062f\\u0648\\u0646 \\u0625\\u064a\\u0635\\u0627\\u0644\\n-NO EXCHANGE\\tWITHOUT RECEIPT\\n\\u0639\\u0632\\u064a\\u0632\\u064a \\u0627\\u0644\\u0639\\u0645\\u064a\\u0644 \\u064a\\u0645\\u0643\\u0646\\u0643 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u0639\\u0644\\u0649\\n\\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0627\\u0644\\u0636\\u0631\\u064a\\u0628\\u0629 \\u0645\\u0646 \\u062e\\u062f\\u0645\\u0629 \\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621\\nDear Customer, for Tax Invoice\\nPlease Visit Customer Service\\n\\nVisit us at:\\nwww.laminimarkets.com\\nwww.facebook.com\\/taminimarkets\\n\\tCamScanner \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0628\\u0640\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":\"Cash\",\"terms\":null,\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/fb5847e8-2ff4-4c63-9599-d1e00517f4aa\\/d7683dee-54e3-4c64-9634-2ce38695f352.pdf?Expires=1719560027&Signature=GL-hi48L7kM~Orn5K2Z6zwxKRoxUvUkO4G537W9VdzVTFZqMha1YhmNV6D8l8HjNLKpjp8TMSyum72xdy1h0XLJYlPdj47YR3RamxUi1V1Bbqq~j3O0GeBKCRL6rKqOLWzvvhwropG1~uFaAhk9Y1hYN5pngxEwQppR5cEoBXlncJ6OKUXPCoTRtl-HPwkbBOQ6NfqKZ6JmViKzY~AkOqvpAGVPVslOsk8sRvtKmSqYKH4JmmjQbDf-QR6rEsrEJA98FZDEESAPAfcnPds730pZZIHL3VlBupT6eVUN~qiNOh9w5oHDp5rCIXbN6i1dABhuzZ97V-U1DQzKSwAE8XQ__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VCACB-92669\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"165\",\"subtotal\":17.04,\"tags\":[],\"tax\":2.56,\"tax_lines\":[{\"base\":17.04,\"name\":\"VAT\",\"order\":0,\"rate\":15,\"total\":2.56}],\"tip\":null,\"total\":19.6,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-06-28 07:18:47\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"BADIA ROAD RIYADH\\nCUSTOMER SERVICE #\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":24.610556016,\"lng\":46.675832961,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/us\\/150113248.png\",\"name\":\"Tamimi Markets\",\"phone_number\":\"800-303-0010\",\"raw_address\":\"BADIA ROAD RIYADH\",\"raw_name\":\"\\u0627\\u0644\\u062a\\u0645\\u064a\\u0645\\u064a \\u0627\\u0633\\u0648\\u0627\\u0642\\ntamimi markets\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"300508296700003\",\"web\":\"www.laminimarkets.com\"}}\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario07-Color Yellow") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":null,\"created_date\":\"2024-01-24 05:46:17\",\"currency_code\":\"SAR\",\"date\":\"2022-12-05 20:05:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"1120501641034\",\"document_title\":null,\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":180516397,\"external_id\":null,\"guest_count\":null,\"id\":180516481,\"img_blur\":false,\"img_file_name\":\"180516481.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd8a3b58-dc7e-4cac-94bd-5b9eb9fb3b4e\\/thumbnail.jpg?Expires=1706076085&Signature=R1raD-qSoDovO9J4o0MfOiK2WP9351l59FYH1MS~k9X3ez7QAxIZ5FrdkUZe95pkY72oon~p0V5SpyUtljilq6Qe5FYJDdweMTVCvnBlbAc8Me1NO7bhG3uq-mAkn7iNCVcyes35G7O2KlWYHZ10kHwf~cWohVeHzjFtyyoLsH7efalulitGbYHcAS1hTpwlcWXgGKyzpCpPmEDNoe19l~ZmanNiRdzYq9loEW8W-VVwLli-ocwnGYQkAM3rahmgaWlFmzm5qJaRg41TiNRMYTtAaioxmzLFb~zG1EevpllE-ZTzdlGivMh9RIMdcrXvPW5g6RRz-FUFYrD98RUqSg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd8a3b58-dc7e-4cac-94bd-5b9eb9fb3b4e\\/2fbe5027-3924-4e51-a91f-11335495ca42.jpg?Expires=1706076085&Signature=FZAGqtzrxA8zqAbBaAfB8FFDJFpVPjiSJLNDi~~LvnGcl60M5oVVfbVXjDmDF1SK2awz5UlPW~HeFddSTJR0KyKntaqPctHncHSjX-yw2vOuLYoXYFtmIRZCXuI0cvfuPfZWTCKAS9v7Rsrrp9Rf-UTQwJZ5~KfQfJeOmAyE0cw2mwLOAMm690EHqphyiBehKuOaCzaWT-7ztuvbeLfRQADNZH1BDojxIM~tQ1hSpK4I9KGX3dpJWZDcAvFwpr1jFLReT8kVQxxR7eOZEr6zW7NgECUosNYdykRvhVsM5b906f12NgbW~XoDgB18SEuSSQnXtpvhPX8w8f9Vrh3C4Q__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":null,\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":true,\"is_money_in\":false,\"line_items\":[{\"category\":null,\"date\":null,\"description\":\"\\u062c\\u0645 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0647\\u06cc\\u06cc\\u0633 \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":796124476,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062c\\u0645 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0647\\u06cc\\u06cc\\u0633 \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"LAY'S KETCHUP CHIP\",\"discount\":null,\"discount_rate\":null,\"id\":796124477,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAY'S KETCHUP CHIP\\t1.50 C\",\"total\":1.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"\\u062c\\u0645 \\u0646\\u062d\\u0644 \\u0628\\u0644\\u062c \\u0634\\u0628\\u0628\\u0633\\u064a \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":796124478,\"order\":2,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062c\\u0645 \\u0646\\u062d\\u0644 \\u0628\\u0644\\u062c \\u0634\\u0628\\u0628\\u0633\\u064a \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"LAY'S SALT&VINGR C\",\"discount\":null,\"discount_rate\":null,\"id\":796124479,\"order\":3,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAY'S SALT&VINGR C\\t11.50 C\",\"total\":11.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"165 \\u062c\\u0645 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0637\\u0639\\u0645 \\u0644\\u06cc\\u0632\",\"discount\":null,\"discount_rate\":null,\"id\":796124480,\"order\":4,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"165\\t\\u062c\\u0645 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0637\\u0639\\u0645 \\u0644\\u06cc\\u0632\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"LAYS P\\/CHP KETCHP\\\"\",\"discount\":null,\"discount_rate\":null,\"id\":796124481,\"order\":5,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS P\\/CHP KETCHP\\\"\\t7.50 C\",\"total\":7.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"\\u0628\\u062e\\u0627\\u0637\\u06c1 \\u0631\\u0642\\u0627\\u0644\\u06cc \\u062a\\u0633\\u0627\\u0644\",\"discount\":null,\"discount_rate\":null,\"id\":796124482,\"order\":6,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0628\\u062e\\u0627\\u0637\\u06c1 \\u0631\\u0642\\u0627\\u0644\\u06cc \\u062a\\u0633\\u0627\\u0644\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"TASALI CHILLI PTAT\",\"discount\":null,\"discount_rate\":null,\"id\":796124483,\"order\":7,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"TASALI CHILLI PTAT\\t6.50 C\",\"total\":6.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"\\u062c\\u0645 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0633\\u0627\\u0644 \\u0634\\u064a\\u0628\\u0633\",\"discount\":null,\"discount_rate\":null,\"id\":796124484,\"order\":8,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u062c\\u0645 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0633\\u0627\\u0644 \\u0634\\u064a\\u0628\\u0633\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"TASALI CHILLI POTA\",\"discount\":null,\"discount_rate\":null,\"id\":796124485,\"order\":9,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"TASALI CHILLI POTA\\t1,50 C\",\"total\":1.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"LAY'S SALTED CHIPS\",\"discount\":null,\"discount_rate\":null,\"id\":796124486,\"order\":10,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAY'S SALTED CHIPS\\t1.50 C\",\"total\":1.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"\\u0627\\u062e\\u0636\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0644\\u06cc\\u0632 \\u0644\\u06cc\\u0631\",\"discount\":null,\"discount_rate\":null,\"id\":796124487,\"order\":11,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"\\u0627\\u062e\\u0636\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0644\\u06cc\\u0632 \\u0644\\u06cc\\u0631\",\"total\":null,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":null,\"date\":null,\"description\":\"LAYS SPICY GREEN P\",\"discount\":null,\"discount_rate\":null,\"id\":796124488,\"order\":12,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"LAYS SPICY GREEN P\\t1.50 C\",\"total\":1.5,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":\"Duplicate receipt\",\"color\":\"yellow\",\"decision\":\"Requires Review\",\"images\":[{\"is_lcd\":false,\"score\":0.96}],\"pages\":[{\"is_lcd\":{\"score\":0.96,\"value\":false}}],\"score\":0.51,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"en\",\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2610,\"language\":[\"en\",\"ar\"],\"width\":1834}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2610,\"size_kb\":2358,\"width\":1834}],\"total_pages\":1,\"warnings\":[{\"message\":\"Total Items sold doesn't match number of line items\",\"type\":\"item_counts_missmatch\"},{\"message\":\"Subtotal for Line Items 31.5 doesn't match subtotal on document 18.7\",\"type\":\"totals_missmatch\"}]},\"notes\":null,\"ocr_text\":\"Danube\\t\\u0627\\u0644\\u062f\\u0627\\u0646\\u0648\\u0628\\nDANUBE SUPERMARKET\\n\\u0639\\u0628\\u062f\\u0627\\u0644\\u0637\\u0644\\u0628 \\u0645\\u0646 \\u0641\\u0632\\u0627\\t\\u0628\\u0644\\u0627\\u0632\\u0627 \\u0627\\u0644\\u0633\\u0627\\u0628\\u0639\\u0629\\n\\u0648\\u0627\\u0644\\u0643\\u0645\\u0627\\u0644\\u064a\\u0627\\u062a \\u0627\\u0644\\u0645\\u0627\\u0644\\u064a\\u0629 \\u0627\\u0646\\n\\t\\u0644\\u0644\\u0645\\u0631\\u0627\\u0629 \\u0627\\u0644\\u0627\\u0644\\u0648\\u0646 \\u0644\\u0631\\u062f\\nDanube Co, for Food Stuff & Commodities\\ncustomer service no:8002442225\\nemail: danube@danubeco.com\\nwww.danubeco.com\\nSimplified TAX Invoice\\n\\t\\u0641\\u064a\\u0633\\u0629 \\u0641\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u0644\\u0648\\u0631\\u0629\\n3100 72568710003 (V\\u06f8\\u06f3 \\u0627\\u0644\\u0639\\u0631\\u0628\\u064a \\u0627\\u0644\\u0631\\u0642\\u0645\\n:Price\\nInclude \\tV\\u06f8\\u06f3\\t\\u0627\\u0644\\u0642\\u0631\\u064a\\u0628\\u0629 \\u0634\\u0627\\u0645\\u0644 \\u0633\\u0639\\u0631\\n***\\n23\\t\\u062c\\u0645 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0647\\u06cc\\u06cc\\u0633 \\u0644\\u06cc\\u0632\\nLAY'S KETCHUP CHIP\\t1.50 C\\n23\\t\\u062c\\u0645 \\u0646\\u062d\\u0644 \\u0628\\u0644\\u062c \\u0634\\u0628\\u0628\\u0633\\u064a \\u0644\\u06cc\\u0632\\nLAY'S SALT&VINGR C\\t11.50 C\\n165\\t\\u062c\\u0645 \\u0643\\u0627\\u062a\\u0634\\u0628 \\u0637\\u0639\\u0645 \\u0644\\u06cc\\u0632\\nLAYS P\\/CHP KETCHP\\\"\\t7.50 C\\n\\u0628\\u062e\\u0627\\u0637\\u06c1 \\u0631\\u0642\\u0627\\u0644\\u06cc \\u062a\\u0633\\u0627\\u0644\\nTASALI CHILLI PTAT\\t6.50 C\\n25\\t\\u062c\\u0645 \\u0641\\u0644\\u0641\\u0644 \\u0646\\u0633\\u0627\\u0644 \\u0634\\u064a\\u0628\\u0633\\nTASALI CHILLI POTA\\t1,50 C\\n23\\t\\u062c\\u0645 \\u0645\\u0644\\u062d \\u0634\\u064a\\u0628\\u0633\\u064a \\u0644\\u064a\\u0644\\nLAY'S SALTED CHIPS\\t1.50 C\\n\\u0627\\u062e\\u0636\\u0631 \\u0641\\u0644\\u0641\\u0644 \\u0644\\u06cc\\u0632 \\u0644\\u06cc\\u0631\\nLAYS SPICY GREEN P\\t1.50 C\\n\\u0627\\u0644\\u0641\\u0631\\u0639\\u064a \\u0627\\u0644\\u0645\\u062c\\u0648\\u0639\\n\\tSUBTOTAL\\t21.50\\nITEMS\\t7\\n\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639\\tTAL\\t21.50\\n\\u06a9\\u0627\\u0631\\u062f \\u0633\\u0628\\u0627\\u0646\\nSPAN CARD\\tSR\\t21.50\\nCARD-NO\\t484783***5555\\nEFT TERM,\\t5503586345211013\\nAUTH CODE\\t182146\\n\\nNET TOTAL\\tGRP C\\t18.70\\nVAT\\t\\t15.0%\\t2.80\\n\\u0644\\u0644\\u062f\\u0648\\u0627\\u062f\\u0627 \\u0627\\u0644\\u062f\\u0627\\u0646\\u0648\\u0628 \\u0634\\u0631\\u0643\\u0629\\n*4103 0152\\/016\\/303 05.12.22 20:05 AC-00\\n\\nThank you for your visit, come again!\\n\\u0642\\u0631\\u064a\\u0628\\u0627 \\u0628\\u0632\\u064a\\u0627\\u0631\\u062a\\u0646\\u0627 \\u062a\\u0627\\u0645\\u0644 \\u0648 \\u0644\\u0632\\u064a\\u0627\\u0631\\u062a\\u0643 \\u0634\\u0643\\u0631\\u0627\\n\\u0627\\u0644\\u0639\\u0645\\u0644\\u0627\\u0621 \\u062e\\u062f\\u0645\\u0629 \\u0645\\u0631\\u0627\\u062c\\u0639\\u0629 \\u064a\\u0631\\u062c\\u0649 \\u0627\\u0644\\u0625\\u0633\\u062a\\u0628\\u062f\\u0627\\u0644 \\u0623\\u0648 \\u0644\\u0644\\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639\\nThank you for your visit, come again!\\nFor exchange\\/return, please contact our customer service\\n\\n1120501641034\\n\\tCamScanner \\u0628\\u0640 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629\\n\\t\\u0645\\u0631\\u064a\\u062f\",\"order_date\":null,\"payment\":{\"card_number\":\"5555\",\"display_name\":\"Visa ***5555\",\"type\":\"visa\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/cd8a3b58-dc7e-4cac-94bd-5b9eb9fb3b4e\\/ff85e0a2-54b6-4f48-8107-6f7445359646.pdf?Expires=1706076085&Signature=RfDkh4BOilqEPG4B83HmLzHeTOjOTQ1WYlwkPeb9p7PPG~1TQ~EYOgy53zQ-CtKFLm-tS3NjG~FVV-P~6zvLqhXQil80FWfMzmRs-BmQHyZDwnt2UPMQI2xE5v29t7M-4SP2r~M0whbL2iQJtMhoq13RL7Hz7o-D6NZvpKGLYhgrbDc2dlwrwobRbMRT~rdmv5uxX52ISr6PCRuPkkYFgrWyQQNv8TcOZwo1AHRPvRJnz5f3kEP6BUIfU-9y5xRzloGrXC5~U4bhLpWwM50Skl~KV6SLGpa0DA6~SrLZq2SaPNVQMUOX~aL1VWM4IunnwZoJrq0bi0O2t2EGkhvQCw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBGCF-16481\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":\"4103\",\"subtotal\":18.7,\"tax\":2.8,\"tax_lines\":[{\"base\":null,\"name\":\"VAT\",\"order\":0,\"rate\":15,\"total\":2.8}],\"tip\":null,\"total\":21.5,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-01-24 05:46:25\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":null,\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":\"danube@danubeco.com\",\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/5c5fb667-7393-4c30-8a2c-52e8da3ecee7.png\",\"name\":\"Danube\",\"phone_number\":\"8002442225\",\"raw_address\":null,\"raw_name\":\"Danube\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"72568710003\",\"web\":\"www.danubeco.com\"}}\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ScanVer02_Scenario18") && testcase.equalsIgnoreCase("Scenario08-LCD Attribution") ) {

            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": \"201913\",\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"\",\n" +
                    "  \"data\": {\"account_number\":null,\"bill_to\":{\"address\":null,\"name\":null,\"parsed_address\":null,\"vat_number\":null},\"cashback\":null,\"category\":\"Meals & Entertainment\",\"created_date\":\"2024-01-24 04:39:13\",\"currency_code\":\"SAR\",\"date\":\"2022-12-06 02:49:00\",\"delivery_date\":null,\"discount\":null,\"document_reference_number\":\"300057178310003\",\"document_title\":\"\\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\",\"document_type\":\"receipt\",\"due_date\":null,\"duplicate_of\":null,\"external_id\":null,\"guest_count\":null,\"id\":180511133,\"img_blur\":false,\"img_file_name\":\"180511133.jpg\",\"img_thumbnail_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/02e89c09-f3cb-4876-b84f-4a2d55e3a2d2\\/thumbnail.jpg?Expires=1706072062&Signature=dKBiGFnRUUQwBpAqahDIi9wccJ1c4hhm66u21tku6HNu6wiyiT9yOlMVPXADs~jke2ZCzxti1SxJWgMDf~Z6snF1cUUu1M6ruLfGbBYjZ0YP8wXQ8bD3buthH6bs~R05LuBu7e5Hv9TXX1ROVF6uEGnisNMJHv-9T-ujEvj-tTBmGvYoYcJk1XAWvSShb1NOkOAKdsjZzqLk798WmGR72pM9W5CHH72hi0MayNGallRp-CBHQYuawRP0f-8z7rWvZ3M2cuzk3Knebzi9l2RgtkG-YbFY6oIZr8K37aMHjoSTWJrHLpZ-Uxk8BvM1YReSwEJWOKmPGGMxjjU1ufwGfw__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"img_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/02e89c09-f3cb-4876-b84f-4a2d55e3a2d2\\/db7bc3b9-d8ac-490f-a2b2-b55e2a070fd0.jpg?Expires=1706072062&Signature=FK2b5Uft6RQ9hEsGgYxpHlFbbcoaAhrj5L3VMeb3hQOLdkgu3PBORnGJxjurnlItZfo8XoP6bw4mTq9WQSjIO-EKHCDQVFE9gg7WDwyUxkXmnuEudS3EyI6TMaNsjqzpAf4n1XUMGCVp-bkvffCkiaWjb1uayXXTGWOYyQKNpGq4i~FtJOYrBVxaH362x1U8c6fudG5nd97lbyGKJKJ~UJOrZ8-cJ4t8cTn50c2Ls6hkxd4IGWrsa76YO8MOhlm5LQNXnDcZ4MO9CN7tRmDjnWd3zVgo1l5qf5rFAyGZdluS-gpSwQWp0fVljJBsCbwxrsQZOvutsj8RtIsFI-QNeg__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"insurance\":null,\"invoice_number\":\"93667\",\"is_blurry\":[false],\"is_document\":true,\"is_duplicate\":false,\"is_money_in\":false,\"line_items\":[{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":\"\\u060c\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648 \\u0633\\u0646\\u0627\\u0643\\u0633 \\u0644\\u064a\\u0632 \\u0634\\u064a\\u0628\\u0633\",\"discount\":null,\"discount_rate\":null,\"id\":796105372,\"order\":0,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[\"PepsiCo\"],\"tax\":null,\"tax_rate\":null,\"text\":\"11.95\\t1.000\\t\\u060c\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648\\t\\u0633\\u0646\\u0627\\u0643\\u0633 \\u0644\\u064a\\u0632 \\u0634\\u064a\\u0628\\u0633\",\"total\":11.95,\"type\":\"food\",\"unit_of_measure\":null,\"upc\":null},{\"category\":\"Meals & Entertainment\",\"date\":null,\"description\":null,\"discount\":null,\"discount_rate\":null,\"id\":796105373,\"order\":1,\"price\":null,\"quantity\":1,\"reference\":null,\"section\":null,\"sku\":null,\"tags\":[],\"tax\":null,\"tax_rate\":null,\"text\":\"11.95\\t1\",\"total\":11.95,\"type\":null,\"unit_of_measure\":null,\"upc\":null}],\"meta\":{\"duplicates\":[],\"fraud\":{\"attribution\":\"LCD photo\",\"color\":\"red\",\"decision\":\"Fraud\",\"images\":[{\"is_lcd\":true,\"score\":0.94}],\"pages\":[{\"is_lcd\":{\"score\":0.94,\"value\":true}}],\"score\":0.94,\"version\":\"v3\"},\"handwritten_fields\":[],\"language\":[\"ar\"],\"owner\":\"pepsico-amesa-dev\",\"pages\":[{\"height\":2118,\"language\":[\"ar\"],\"width\":1563}],\"processed_pages\":1,\"source\":\"lens.receipt\",\"source_documents\":[{\"height\":2118,\"size_kb\":1967,\"width\":1563}],\"total_pages\":1,\"warnings\":[{\"message\":\"Subtotal for Line Items 23.9 doesn't match subtotal on document 11.95\",\"type\":\"totals_missmatch\"}]},\"notes\":null,\"ocr_text\":\"\\u0645\\u0628\\u0633\\u0637\\u0629 \\u0636\\u0631\\u064a\\u0628\\u064a\\u0629 \\u0641\\u0627\\u062a\\u0648\\u0631\\u0629\\n\\u0627\\u0635\\u0627\\u0628\\u0629\\n\\u0627\\u0644\\u0639\\u0644\\u064a\\u0645\\nOthelm\\t\\u0627\\u0644\\u0639\\u062b\\u064a\\u0645 \\u0639 \\u0623\\u0633\\u0648\\u0627\\u0642 \\u0634\\u0631\\u0643\\u0629\\nMENJANA\\n\\u06f2\\u06f0\\u06f1\\u06f7\\u06f0\\u06f0\\u06f0 \\u0634 - \\u0627\\u0644\\u0631\\u064a\\u0627\\u0636 \\u060c \\u0627\\u0644\\u0631\\u0628\\u0648\\u0629 - \\u0627\\u0644\\u0639\\u0627\\u0645\\u0629 \\u0627\\u0644\\u0625\\u062f\\u0627\\u0631\\u0629\\n\\u0627\\u0644\\u0645\\u062f\\u064a\\u0646\\u0629 \\u0634\\u0627\\u0631\\u0639 \\u0627\\u0644\\u0628\\u062f\\u064a\\u0646\\u0629 \\u0645\\u0638\\u0647\\u0631\\u0629 \\u0627\\u0644\\u0631\\u064a\\u0627\\u0636\\n\\t920000702 :\\n300057178310003\\t\\t\\u061b \\u0627\\u0644\\u0637\\u0631\\u064a\\u0628\\u064a\\n06\\/12\\/22 02:49\\t:\\t202-107-0502-12 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0627\\u0644\\u062a\\u0627\\u0631\\u064a\\u062e \\u0631\\u0642\\u0645\\n\\t1 : \\u0627\\u0644\\u0641\\u0627\\u0636\\u0644 \\u0639\\u0645\\u064a\\u0644\\u0646\\u0627\\n\\u0627\\u0644\\u0633\\u0641\\u0631\\t\\u0627\\u0644\\u0643\\u0645\\u064a\\u0629\\t\\u0627\\u0644\\u0635\\u0644\\u0641 \\u0648\\u0635\\u0641\\n\\n11.95\\t1.000\\t\\u060c\\u0628\\u0627\\u0631\\u0628\\u064a\\u0643\\u064a\\u0648\\t\\u0633\\u0646\\u0627\\u0643\\u0633 \\u0644\\u064a\\u0632 \\u0634\\u064a\\u0628\\u0633\\n11.95\\t1\\t\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639 \\u0648 \\u0627\\u0644\\u0623\\u0635\\u0646\\u0627\\u0641 \\u0639\\u062f\\u062f\\n11.95\\t\\t\\u0627\\u0644\\u0645\\u062c\\u0645\\u0648\\u0639\\n56.08\\n-44.13\\t\\t\\u0627\\u0644\\u0645\\u062a\\u0628\\u0642\\u064a\\n\\u0627\\u0644\\u0645\\u0636\\u0627\\u0641\\u0629 \\u0627\\u0644\\u0642\\u064a\\u0645\\u0629 \\u0636\\u0631\\u064a\\u0628\\u0629 \\u0634\\u0627\\u0645\\u0644\\u0629 \\u0627\\u0644\\u0623\\u0633\\u0639\\u0627\\u0631\\n\\u06f1\\u066b\\u06f5 \\u06f1 (\\u0661\\u0665%) \\u0644\\u0646\\u0633\\u0628\\u0629 \\u0627\\u0644\\u062e\\u0627\\u0636\\u0639\\u0629 \\u0627\\u0644\\u0623\\u0635\\u0646\\u0627\\u0641 \\u0636\\u0631\\u064a\\u0628\\u0629\\n\\u0633\\u0627\\u0639\\u0629 \\u06f7\\u06f2\\t\\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0628\\u0648\\u062c\\u0648\\u062f \\u0627\\u0644\\u0625\\u0631\\u062c\\u0627\\u0639\\n\\u0633\\u0627\\u0639\\u0647 \\u06f1\\u06f2\\t\\u0648\\u0627\\u0644\\u0645\\u062c\\u0645\\u062f\\u0627\\u062a \\u0627\\u0644\\u0637\\u0627\\u0632\\u062c\\u0629 \\u0648\\u0627\\u0644\\u0627\\u0635\\u0646\\u0627\\u0641\\n\\u0627\\u0644\\u0634\\u0631\\u0643\\u0629 \\u0648\\u0633\\u064a\\u0627\\u0633\\u0629 \\u0634\\u0631\\u0648\\u0637 \\u0648\\u0646\\u0637\\u0628\\u0642 \\u0627\\u0644\\u0641\\u0627\\u062a\\u0648\\u0631\\u0629 \\u0628\\u0648\\u062c\\u0648\\u062f\\n\\u0627\\u0644\\u0625\\u0644\\u0643\\u062a\\u0631\\u0648\\u0646\\u064a \\u0627\\u0644\\u0634\\u062d\\u0646 \\u0628\\u0637\\u0627\\u0642\\u0627\\u062a \\u0627\\u0633\\u062a\\u0631\\u062c\\u0627\\u0639 \\u064a\\u0645\\u0643\\u0646 \\u0644\\u0627\\n\\u0627\\u0643\\u062a\\u0633\\u0627\\u0628 \\u0645\\u0645\\u064a\\u0632\\u0627\\u062a \\u0645\\u0646 \\u0644\\u0644\\u0627\\u0633\\u062a\\u0641\\u0627\\u062f\\u0629\\n\\u062e\\u0644\\u0627\\u0644 \\u0645\\u0646 \\u0648\\u062a\\u0641\\u0639\\u064a\\u0644\\u0647\\u0627 \\u0627\\u0644\\u0628\\u0637\\u0627\\u0644\\u0629 \\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644 \\u064a\\u0631\\u062c\\u0649\\n\\u0623\\u0648 \\u06f9\\u06f7\\u06f0\\u06f0\\u06f0\\u06f0\\u06f7 \\u060c \\u06f2 \\u0627\\u0644\\u0645\\u0648\\u062d\\u062f\\t\\u0639\\u0644\\u0649 \\u0627\\u0644\\u0627\\u062a\\u0635\\u0627\\u0644\\n\\u0645\\u0628\\u0627\\u0634\\u0631\\u0629 \\u0627\\u0643\\u062a\\u0633\\u0627\\u0628 \\u062a\\u0637\\u0628\\u064a\\u0642 \\u0645\\u0646 \\u0631\\u0642\\u0645\\u064a\\u0629 \\u0628\\u0637\\u0627\\u0642\\u0629 \\u0639\\u0644\\u0649 \\u0627\\u0644\\u062d\\u0635\\u0648\\u0644\\n\\u0623\\u0645\\u0633 \\u064a\\u0648\\u0645 \\u062d\\u062a\\u0649 \\u0627\\u0644\\u062c\\u0645\\u0639\\u064a\\u0627\\u062a \\u0644\\u062c\\u0645\\u064a\\u0639 \\u0627\\u0644\\u062a\\u0628\\u0631\\u0639\\u0627\\u062a \\u0625\\u062c\\u0645\\u0627\\u0644\\u064a \\u0628\\u0644\\u063a\\n\\t) \\u0662\\u0660\\u0666,\\u06f9,\\u06f1\\u06f2\\u06f0 (\\n\\u062d\\u064a\\u0627\\u062a\\u0643 \\u064a\\u062d\\u0645\\u064a ...\\t\\u0627\\u0644\\u064a\\u062f\\u064a\\u0646 \\u063a\\u0633\\u0644\\n\\u0627\\u0644\\u0635\\u063a\\u0631\\t\\u0627\\u0644\\u0643\\u0645\\u064a\\u0629\\t\\u0627\\u0644\\u0635\\u0646\\u0641 \\u0648\\u0635\\u0641\\n\\twww.k\\n06\\/12\\/22 02:49\\t12-6502-107-282\\t93667\\n\\n6.0 @ 04-08-2022 (T)\\n\\u0644\\u0631\\u0627\\u0643\\u0645 ..\\t\\u0644\\u062a\\u0633\\u0648\\u0642\\u0643\\u0645 \\u0634\\u0643\\u0631\\u0627\\n\\n3,000,000 66\\n\\u0631\\u064a\\u0640\\u0627\\u0644 YEARS\\n\\u0627\\u0644\\u0622\\u0646 \\u0627\\u0634\\u062a\\u0631\\u0643\\n\\u0627\\u0644\\u0631\\u0627\\u0628\\u062d\\u064a\\u0646 \\u0623\\u062d\\u062f \\u0648\\u0643\\u0646\\n\\n\\tCamScanner \\u0628\\u0640 \\u0636\\u0648\\u0626\\u064a\\u0627 \\u0627\\u0644\\u0645\\u0645\\u0633\\u0648\\u062d\\u0629\\n\\t\\u0627\\u062a\\u0641\\n\\t\\u0627\\u0644\\u0631\\u0642\\u0645\\n\\u0631\\u06cc\\u0627\\u0644\\n\\u062e\\u0644\\u0627\\u0644\\n\\u062e\\u0644\\u0627\\u0644\\n\\t\\u0627\\u0644\\u0631\\u0642\\u0645\\n\\t\\u0631\\u064a\\u0627\\u0644\\n\\u062c\\u064a\\u062f\\u0627\\u064b\\n\\u0642\\u0631\\u064a\\u0628\\u0627\\t\\u0645\\u0639\\u0646\\u0627\",\"order_date\":null,\"payment\":{\"card_number\":null,\"display_name\":null,\"type\":\"cash\"},\"pdf_url\":\"https:\\/\\/scdn.veryfi.com\\/receipts\\/9cb172fea58a3d0a\\/02e89c09-f3cb-4876-b84f-4a2d55e3a2d2\\/f702f021-a47e-47c5-a5ec-8ad13a67f559.pdf?Expires=1706072062&Signature=W~T4ELOUsIMwiT3JV7wDqk1ILVLgZvrNac742G3qAhephxKc4WqaA3LpYvFnSPlJm28b0k86jAXxTjMKWJZFrjOkX5wS7knyK0fcCW-3RPH60gCdxFf2HtX3L9BCiOtfCgOfStaciFnZPYPA8Mv05GVwIU-bqcWaBXOobzH~wOWBNQAg58AwDFUQ2~eCz3-fBten~zACR6monZAp34fFCP4AMW35Fx89IM5OMVU1m92cSsLd01lNeopi9vzGVajtAj1ReDv0DZipwCdctW1v9zLkL2k-qBf760nYk-wd8EMLlUs5d4zsF-7S7wLeHAaRH7hOFTp~AYqOrfIosDoGtA__&Key-Pair-Id=APKAJCILBXEJFZF4DCHQ\",\"purchase_order_number\":null,\"reference_number\":\"VBGCF-11133\",\"rounding\":null,\"server_name\":null,\"service_end_date\":null,\"service_start_date\":null,\"ship_date\":null,\"ship_to\":{\"address\":null,\"name\":null,\"parsed_address\":null},\"shipping\":null,\"store_number\":null,\"subtotal\":11.95,\"tax\":-44.13,\"tax_lines\":[],\"tip\":null,\"total\":56.08,\"total_weight\":null,\"tracking_number\":null,\"updated_date\":\"2024-01-24 04:39:22\",\"vendor\":{\"abn_number\":null,\"account_number\":null,\"address\":\"\\u0627\\u0644\\u0631\\u064a\\u0627\\u0636 \\u060c \\u0627\\u0644\\u0631\\u0628\\u0648\\u0629 - \\u0627\\u0644\\u0639\\u0627\\u0645\\u0629 \\u0627\\u0644\\u0625\\u062f\\u0627\\u0631\\u0629\\n\\u0627\\u0644\\u0645\\u062f\\u064a\\u0646\\u0629 \\u0634\\u0627\\u0631\\u0639 \\u0627\\u0644\\u0628\\u062f\\u064a\\u0646\\u0629 \\u0645\\u0638\\u0647\\u0631\\u0629 \\u0627\\u0644\\u0631\\u064a\\u0627\\u0636\",\"bank_name\":null,\"bank_number\":null,\"bank_swift\":null,\"category\":\"Grocery\",\"email\":null,\"fax_number\":null,\"iban\":null,\"lat\":null,\"lng\":null,\"logo\":\"https:\\/\\/cdn.veryfi.com\\/logos\\/tmp\\/5da6b592-0ca9-41f3-829c-022023a7868a.png\",\"name\":\"Othaim\",\"phone_number\":\"202-107-0502-12\",\"raw_address\":\"\\u0627\\u0644\\u0631\\u064a\\u0627\\u0636 \\u060c \\u0627\\u0644\\u0631\\u0628\\u0648\\u0629 - \\u0627\\u0644\\u0639\\u0627\\u0645\\u0629 \\u0627\\u0644\\u0625\\u062f\\u0627\\u0631\\u0629\\n\\u0627\\u0644\\u0645\\u062f\\u064a\\u0646\\u0629 \\u0634\\u0627\\u0631\\u0639 \\u0627\\u0644\\u0628\\u062f\\u064a\\u0646\\u0629 \\u0645\\u0638\\u0647\\u0631\\u0629 \\u0627\\u0644\\u0631\\u064a\\u0627\\u0636\",\"raw_name\":\"Othaim\",\"reg_number\":null,\"type\":\"Grocery\",\"vat_number\":\"920000702\",\"web\":null}}\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_Survey")) {
            return "{\n" +
                    "  \"challengeId\": 207808,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
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
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_Video")) {
            return "{\n" +
                    "  \"challengeId\": 207858,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": 5,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": \"\",\n" +
                    "  \"feedbackHowToImprove\": \"\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_Scan")) {
            return "{\n" +
                    "  \"type\": \"challenge\",\n" +
                    "  \"challengeId\": 207808,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"isRejected\": false,\n" +
                    "  \"rejectionReason\": \"Document is Handwritten, LCD Photo\",\n" +
                    "  \"scanStartedDate\": \"2024-12-02\",\n" +
                    "  \"scanStartedTime\": \"06:37:01\",\n" +
                    "  \"data\": {\n" +
                    "    \"appName\": \"JOY_SAUDI_CHALLENGE\",\n" +
                    "    \"userId\": \"207849\",\n" +
                    "    \"userName\": \"NA\",\n" +
                    "    \"docId\": \"5rk8zwt3z4\",\n" +
                    "\"docUrl\": \"https://ps1003dpsrsqa01sa.blob.core.windows.net/receiptscanner/5rk8zwt3z4.jpeg?sv=2021-12-02&se=2025-11-27T17%3A05%3A23Z&sr=c&sp=rw&sig=wbEPnz2eCThSKXPBj7aVf908rtIgUVGU6hXzW4VDvUw%3D\",\n" +
                    "    \"points\": null,\n" +
                    "    \"defaultPoints\": null,\n" +
                    "    \"totalPoints\": null,\n" +
                    "    \"rewardReason\": null,\n" +
                    "    \"scanStartDateAndTime\": null,\n" +
                    "    \"processingDate\": null,\n" +
                    "    \"status\": \"DISPUTED\",\n" +
                    "    \"message\": \"Document is Handwritten\",\n" +
                    "    \"failedValidations\": [\n" +
                    "      {\n" +
                    "        \"description\": \"Document is Handwritten\",\n" +
                    "        \"rule\": \"RS-HW\",\n" +
                    "        \"status\": \"FAILURE\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"description\": \"LCD Photo\",\n" +
                    "        \"rule\": \"RS-SCREEN\",\n" +
                    "        \"status\": \"FAILURE\"\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"docSummary\": [\n" +
                    "      {\n" +
                    "        \"vendorName\": \"TAMIMI MARKETS CO. L\",\n" +
                    "        \"vendorAddress\": null,\n" +
                    "        \"vendorCategory\": null,\n" +
                    "        \"totalTax\": 14.61,\n" +
                    "        \"totalPrice\": 16.8,\n" +
                    "        \"currency\": \"SAR\",\n" +
                    "        \"formattedDocDate\": \"2022-12-05\",\n" +
                    "        \"transactionDate\": \"2022-12-05\",\n" +
                    "        \"transactionTime\": \"22:24:00\",\n" +
                    "        \"products\": [\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"ROCKSTAR CLASSIC 30/0001\",\n" +
                    "            \"category\": \"Beverage\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 5.1,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS MAXX TEXAS BBQBO001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 7.4,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"isPepsiCo\": true,\n" +
                    "            \"id\": null,\n" +
                    "            \"name\": \"LAYS POTATO CHIPS CHO001\",\n" +
                    "            \"category\": \"Snacks\",\n" +
                    "            \"price\": 0,\n" +
                    "            \"quantity\": 1,\n" +
                    "            \"total\": 4.3,\n" +
                    "            \"tax\": 0,\n" +
                    "            \"taxRate\": 0,\n" +
                    "            \"discount\": 0,\n" +
                    "            \"unit\": null\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"additionalInfo\": null,\n" +
                    "    \"transactionId\": \"5rk8zwt3z4_1733121457223\",\n" +
                    "    \"maxPoints\": null,\n" +
                    "    \"maxAllowedDays\": 1000000\n" +
                    "  }\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_Coupon")) {
            return "{\n" +
                    "  \"challengeId\": 207809,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
                    "  \"couponCode\": [\n" +
                    "    \"dbdbd\"\n" +
                    "  ],\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_LFSurvey")) {
            return "{\n" +
                    "  \"challengeId\": 207810,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
                    "  \"couponCode\": null,\n" +
                    "  \"surveyData\": null,\n" +
                    "  \"feedbackRateExperience\": null,\n" +
                    "  \"feedbackQuestion\": \"Tell us what can be improved ?\",\n" +
                    "  \"feedbackImprovements\": null,\n" +
                    "  \"feedbackHowToImprove\": null\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_Reward")) {
            return "{\n" +
                    "  \"campaignType\": null,\n" +
                    "  \"rewardId\": 75697,\n" +
                    "  \"customerId\": \"207995\",\n" +
                    "  \"partnerId\": \"ABCTest01\",\n" +
                    "  \"offerId\": \"ABCKSA110\",\n" +
                    "  \"customEmail\": \"vbackkumar10+1@gmail.com\",\n" +
                    "  \"offerType\": \"rewardRedeem\",\n" +
                    "  \"offerTypeId\": null,\n" +
                    "  \"lastInertId\": null,\n" +
                    "  \"objectId\": null,\n" +
                    "  \"spinWinWedgeId\": null,\n" +
                    "  \"ExpiresOn\": \"2025-02-28 23:59\"\n" +
                    "}";
        }
        else if (endPoint.equalsIgnoreCase("ProfileCompltn_SurveyP")) {
            return "{\n" +
                    "  \"challengeId\": 207982,\n" +
                    "  \"challengeType\": [\n" +
                    "    \"points\"\n" +
                    "  ],\n" +
                    "  \"challengeTypeId\": {},\n" +
                    "  \"points\": 500,\n" +
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

        }

        else {
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
                    "  \"action\": \"credit\",\n" +
                    "  \"activityType\": \"profile\",\n" +
                    "  \"activityTypeId\": null,\n" +
                    "  \"wedgeId\": null,\n" +
                    "  \"points\": 100,\n" +
                    "  \"lastInertId\": null\n" +
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
            case "ProfileCompltn_Survey":
            case "ProfileCompltn_Video":
            case "ProfileCompltn_Scan":
            case "ProfileCompltn_Coupon":
            case "ProfileCompltn_LFSurvey":
            case "ProfileCompltn_SurveyP":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("completeChallenge");
                break;
            case "TokenGenerate":
                apiUrl = getsfmcServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SFMCTokenGenerateURI");
                break;
            case "RewardRedemption":
            case "Pep_RewardRdmtn_Chlng":
            case "Pep_RewardRdmtn_Spin":
            case "Pep_RewardRdmtn_Points":
            case "ProfileCompltn_Reward":
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
            case "ScanVer02_Scenario01":
            case "ScanVer02_Scenario02":
            case "ScanVer02_Scenario03":
            case "ScanVer02_Scenario04":
            case "ScanVer02_Scenario05":
            case "ScanVer02_Scenario06":
            case "ScanVer02_Scenario07":
            case "ScanVer02_Scenario08":
            case "ScanVer02_Scenario09":
            case "ScanVer02_Scenario10":
            case "ScanVer02_Scenario11":
            case "ScanVer02_Scenario12":
            case "ScanVer02_Scenario13":
            case "ScanVer02_Scenario14":
            case "ScanVer02_Scenario15":
            case "ScanVer02_Scenario16":
            case "ScanVer02_Scenario17":
            case "ScanVer02_Scenario18":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("NewScanChallenge");
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
