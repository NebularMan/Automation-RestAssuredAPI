package API.JoyLoyalty.api.service;

import API.au.loyalty.api.service.RegistrationAPI;
import API.utils.BaseApi;
import API.utils.Basecode;
import API.utils.LoadProperties;
import API.utils.ScenarioContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JoyAccountDetailsAPI extends Basecode {
    private ScenarioContext context;
    private Sheet sheet;
    private String apiUrl;
    private RegistrationAPI acctDetails;
    String value = null;


    public JoyAccountDetailsAPI(ScenarioContext context) throws Exception {
        this.context = context;
        logger.info("Registration API URL :- " + apiUrl);
    }
    public String verifyJoyLoyaltyTokenD() throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        HashMap<String, Object> contentMap = new HashMap<>();
        String expectedField = null, testVal;
        actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
        String tokenOKTA = (String) actResponseMap.get("token");
        System.out.println("Token -- " + tokenOKTA);
        return tokenOKTA;
    }

    public Response beforeScenario(String endpoint) throws Exception {
        HashMap<String, Object> headerMap = new HashMap<>();
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("x-api-key", getjoyLoyaltyPropertyValue("joy-x-api-key"));
        apiUrl = LoadProperties.getjoyLoyaltyPropertyValue("TokenGen");
        Response response = BaseApi.getAPIToke(headerMap, apiUrl);
        System.out.println("Updated header node :" + apiUrl);
        JsonPath jsonPathEvaluator = (JsonPath) response.jsonPath();
        System.out.println("Respose Started ----");
        System.out.println(response);
        System.out.println("Respose End ----");
        return response;
    }

    public Response getResponseDetails(HashMap<String, Object> dataMap, String endpoint,String testcase, String tokenOKTA) throws Exception {
        HashMap<String, Object> headerMap = new HashMap<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();

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
                }
                else if(endpoint.equalsIgnoreCase("GetOKTAUserStatus") || endpoint.equalsIgnoreCase("GetOKTAUserStatusAfterDeactive") || endpoint.equalsIgnoreCase("UserReactivate") || endpoint.equalsIgnoreCase("UserCreation")  )
                {
                    headerMap.put(testField, getjoyLoyaltyPropertyValue("OktaDevAuth"));
                }
                else if(endpoint.equalsIgnoreCase("GetAccountDetails"))
                {

                    headerMap.put("okta-accesstoken",tokenOKTA);
                    //headerMap.put("okta-accesstoken", getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
                }
                else {
                    headerMap.put(testField, getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));
                }
                if(testcase.equalsIgnoreCase("Wrong-AuthToken"))
                {
                    headerMap.put(testField, getjoyLoyaltyPropertyValue("WrongOktaDevAuth"));
                }

                System.out.println("Updated header node :" + headerMap);
            } else {
                headerMap.put(testField, "");
                System.out.println("Updated header node :" + headerMap);
            }
        }
        System.out.println("API request header is - " + headerMap);
        switch (endpoint) {
            case "GetAccountDetails":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("acctDetails");
                break;
                //----
            case "GetOKTAUserStatus":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaUserStatus");
                break;
            case "GetOKTAUserStatusAfterDeactive":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaUserStatus");
                break;
            case "UserReactivate":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaUserStatus");
                break;
            case "UserCreation":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaUserStatus");
                break;
            case "UserDeletion":
                apiUrl = getOktaServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("oktaUserStatus");
                break;
            case "GetRewardCategoryList":
                apiUrl = getjoyServerUrl()+ LoadProperties.getjoyLoyaltyPropertyValue("GetRewardCategoryList");
                break;
            case "GetRedeemedRewardList":
                apiUrl = getjoyServerUrl()+ LoadProperties.getjoyLoyaltyPropertyValue("GetRedeemedRewardList");
                break;
            case "GetWelcomeGiftDetails":
                apiUrl = getjoyServerUrl()+ LoadProperties.getjoyLoyaltyPropertyValue("GetWelcomeGiftDetails");
                break;
                //--end
            case "GetSpin":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Spin");
                break;
            case "SpinDetails":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("spinDetails");
                break;
            case "GetChallenges":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("challenge");
                break;
            case "GetChallenges_SegMaleOnly":
            case "GetChallenges_SegFemaleOnly":
            case "GetChallenges_SegDOB":
            case "GetChallenges_SegCity":
            case "GetChallenges_SegComb":
            case "GetChallenges_SegMaleFemaleNeg":
            case "GetChallenges_SegFemaleOnlyNeg":
            case "GetChallenges_SegComb-Neg":
            case "GetChallenges_SegCity-Neg":
            case "GetChallenges_SegDOB-Neg":
            case "GetChallenges_SegImport":
            case "GetChallenges_SegImport-Neg":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("challenge");
                break;
            case "CompletedChallenges":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("completedChallenge");
                break;
            case "GetEndingSoon":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("EndingSoon");
                break;
            case "GetExclusiveOrJustIn":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Exclusive");
                break;
            case "Translation":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("translation");
                break;
            case "Terms&Conditions":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("terms&Conditions");
                break;
            case "Privacy&Policy":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("privacy&policy");
                break;
            case "Points":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("points");
                break;
            case "Features":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("feature");
                break;
            case "GetChallengeDetails":
                value = getjoyLoyaltyPropertyValue("ParamId-Challenge");
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Challengedetails") + value;
                System.out.println("Updated header node :" + apiUrl);
                break;
            case "SurveyList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("SurvyList");
                break;
            case "WallpaperList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Wallpaperlist");
                break;
            case "DrawList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("drawList");
                break;
            case "Point_History_Transaction":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("transactionsHistory");
                break;
            case "SurveyDetails":
                if(testcase.equalsIgnoreCase("Blank-ID")){
                    apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Surveydetails");
                } else if (testcase.equalsIgnoreCase("invalid-ID")) {
                    value=getNumericString(2);
                    apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Surveydetails")+value;
                }else{
                    value = getjoyLoyaltyPropertyValue("ParamId-Survey");
                    apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("Surveydetails")+value;
                }
                break;
            case "WallpaperDetails":
                value = getjoyLoyaltyPropertyValue("ParamId-Wallpaper");
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("wallpalerDetail")+value;
                System.out.println("Updated header node :" + apiUrl);
                break;
            case "DrawDetail":
                value = getjoyLoyaltyPropertyValue("ParamId-Draw");
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("DrawDetail")+value;
                break;
            case "OffersList":
            case "AutoHideReward":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("offerList");
                break;
            case "HotOfferList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("hotOfferList");
                break;
            case "OffersDetails":
                value = getjoyLoyaltyPropertyValue("ParamId-Offer");
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("offerDetails")+value;
                break;
            case "MyRewardsList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("MyOfferList");
                break;
            case "ContactUsInquiry":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("contactusInquiry");
                break;
            case "GetFaq":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("getFaq");
                break;
            case "GetBrands":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("getBrand");
                break;
            case "Fnzn_RaffleWinnerList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("RaffleWinnerList");
                break;
            case "Fnzn_RaffleWinnerrecords":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("RaffleWinnerrecords");
                break;
            case "Fnzn_CustomerTestmnlsList":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("CustomerTestmnlsList");
                break;
        }
        System.out.println("URL :"  + apiUrl);
        Response response = BaseApi.getAPI(headerMap, apiUrl);
        logger.info("Response details is :- " + response);
        if (endpoint.equalsIgnoreCase("GetChallenges") || endpoint.equalsIgnoreCase("GetChallenges_SegImport")|| endpoint.equalsIgnoreCase("GetChallenges_SegImport-Neg")|| endpoint.equalsIgnoreCase("GetChallenges_SegComb-Neg") ||endpoint.equalsIgnoreCase("GetChallenges_SegCity-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB-Neg") ||endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnlyNeg") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB") || endpoint.equalsIgnoreCase("GetChallenges_SegMaleFemaleNeg")|| endpoint.equalsIgnoreCase("GetChallenges_SegCity") ||endpoint.equalsIgnoreCase("GetChallenges_SegComb") || endpoint.equalsIgnoreCase("GetChallenges_SegMaleOnly")|| endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnly") || endpoint.equalsIgnoreCase("SurveyList")
                || endpoint.equalsIgnoreCase("WallpaperList") || endpoint.equalsIgnoreCase("DrawList") || endpoint.equalsIgnoreCase("OffersList")) {
            JsonPath jsonPathEvaluator = (JsonPath) response.jsonPath();
            responseMap = jsonPathEvaluator.get();
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            List<Integer> list = new ArrayList<>();
            if (responseMap.containsKey("data")) {
                ArrayList<Object> dataArr = (ArrayList<Object>) responseMap.get("data");
                for (int i = 0; i < dataArr.size(); i++) {
                    System.out.println("Size of Payload in Array :"+dataArr.size());
                    challengeMap = (HashMap<String, Object>) dataArr.get(i);
                    int id = (int) challengeMap.get("id");
                    list.add(id);
                }
                          int ID = getRandomElement(list);
                            updateID("ParamId", ID);
            }
        }
            return response;
        }

    public Response getAccountDetails(String testcase, String endPoint) throws Exception {
        HashMap<String, Object> headerMap = new HashMap<>();
        HashMap<String, Object> responseMap = new HashMap<>();
        HashMap<String, Object> challengeMap = new HashMap<>();
        String LoginWith = getjoyLoyaltyPropertyValue("LoginWith");
        headerMap.put("siteId", getjoyLoyaltyPropertyValue("joy-siteid"));
        headerMap.put("x-api-key", getjoyLoyaltyPropertyValue("joy-x-api-key"));
        headerMap.put("okta-accesstoken", getjoyLoyaltyPropertyValue("joy-okta-accesstoken"));

        switch (endPoint) {
            case "GetCustomerStatus":
                apiUrl = getjoyServerUrl() + LoadProperties.getjoyLoyaltyPropertyValue("custStatus");
                break;
        }
        System.out.println("URL :"  + apiUrl);
        Response response = BaseApi.getAPI(headerMap, apiUrl);
        logger.info("Response details is :- " + response);
        return response;

    }
}
