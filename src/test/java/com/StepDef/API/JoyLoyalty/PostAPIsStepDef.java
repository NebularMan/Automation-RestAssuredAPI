package com.StepDef.API.JoyLoyalty;

import com.JoyLoyalty.api.service.JoyAccountDetailsAPI;
import com.JoyLoyalty.api.service.JoyServiceAPI;
import com.JoyLoyalty.api.service.PostAPI;
import com.utils.BaseApi;
import com.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PostAPIsStepDef extends BaseApi {
    private ScenarioContext context;
    public JoyServiceAPI serviceAPI;

    public PostAPI postAPI;
    private Response response;

    public JoyAccountDetailsAPI acctDetails;
    public static String ID;
    public static String SFMCToken;
    public static String RequestId;
    public static String ConsumptionRequestId;

    public PostAPIsStepDef(ScenarioContext context) throws Exception {
        this.context = context;
        serviceAPI = new JoyServiceAPI(context);
        postAPI = new PostAPI(context);
    }

    public void setResponseDetails(Response response) {
        context.previousResponse = response;
        //context.addResponseInTransactionMap("registration",response);
        System.out.println(context.previousResponse.prettyPrint());
    }

    @Then("verify Okta account {string} details api response for {string}")
    public void verifyJoyLoyaltyAccountDetailsApiResponseFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        HashMap<String, Object> contentMap = new HashMap<>();
        String expectedField = null, testVal;
        expResponseMap = serviceAPI.getResponseDataFromTestDataFile(endpoint, testcase);
        actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
        // Following conditional is to check response body contains error message or not for negative usecase
        if (actResponseMap.containsKey("msg")) {
            assertion(expResponseMap, actResponseMap);
        } else if (actResponseMap.containsKey("data")) {
            HashMap<String, Object> actCustomerMap = new HashMap<>();
            actCustomerMap = (HashMap<String, Object>) actResponseMap.get("data");
            assertionnew(expResponseMap, actCustomerMap);
        } else if (actResponseMap.containsKey("customers")) {
            HashMap<String, Object> actCustomerMap = new HashMap<>();
            actCustomerMap = (HashMap<String, Object>) actResponseMap.get("customers");
            assertionnew(expResponseMap, actCustomerMap);
        } else {
            assertion(expResponseMap, actResponseMap);
        }
        // fetching the ID of User
        if (testcase.equalsIgnoreCase("Valid-AuthToken")) {
            ID = actResponseMap.get("id").toString();
            System.out.println("ID of User is " + ID);
        }
    }

    public void assertion(HashMap<String, Object> expResponseMap, HashMap<String, Object> valuesMap) throws Exception {
        String expectedField = null, testVal;
        for (Map.Entry mapElement : expResponseMap.entrySet()) {
            expectedField = (String) mapElement.getKey();
            testVal = (String) expResponseMap.get(expectedField);
            System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
            if (!testVal.equalsIgnoreCase("NotNull")) {
                assertThat(valuesMap.get(expectedField).toString()).isEqualTo(testVal);
            } else if (testVal.equalsIgnoreCase("NotNull")) {
                assertThat(valuesMap.get(expectedField).toString()).isNotNull()
                        .as(expectedField + " field value is is Null.");
            }
        }
    }

    public void assertionnew(HashMap<String, Object> expResponseMap, HashMap<String, Object> actCustomerMap) throws Exception {
        String expectedField = null, testVal;
        for (Map.Entry mapElement : expResponseMap.entrySet()) {
            expectedField = (String) mapElement.getKey();
            testVal = (String) expResponseMap.get(expectedField);
            System.out.println("ExiectedField :" + expectedField + "   " + "TestValue :" + testVal);
            try {
                assertThat(actCustomerMap.get(expectedField).toString()).isNotNull()
                        .as(expectedField + " field value is is Null.");
            } catch (NullPointerException e) {
                assertThat(actCustomerMap.get(expectedField)).isEqualTo(null)
                        .as(expectedField + " field value is is Null.");
            }

        }
    }

    @When("post  loyalty {string} request for {string}")
    public void postLoyaltyRequestFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.generateWedge(dataMap, endpoint);
        setResponseDetails(response);
    }

    @When("post  loyalty Contact US {string} request for {string}")
    public void postLoyaltyContactRequestFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.relatedResponse(dataMap, endpoint);
        setResponseDetails(response);
    }

    @When("post  OKTA {string} request for {string}")
    public void postOKTARequestFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.relatedOKTA(dataMap, endpoint, ID);
        setResponseDetails(response);

    }

    @When("post {string} API request for {string}")
    public void postChallengeCompletion(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.relatedChallengeComp(dataMap, endpoint, testcase);
        setResponseDetails(response);
    }

    @When("post {string} API request for {string} with.")
    public void postAccounts(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.relatedAccounts(dataMap, endpoint);
        setResponseDetails(response);
    }

    @When("del {string} API request for {string} with.")
    public void delAccounts(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.relatedAccounts(dataMap, endpoint);
        setResponseDetails(response);
    }

    @When("post SFMC {string} API request for ValidClientID")
    public void postSFMCAPI(String endpoint) throws Exception {
        response = postAPI.relatedSFMCTokenGenerate(endpoint);
        setResponseDetails(response);
        verifySFMCApiResponseFor(endpoint);
    }

    @When("get Response from SFMC {string} API")
    public void getResponseFromSFMC(String endpoint) throws Exception {
        Thread.sleep(5000);
        response = postAPI.getResponsefromSFMC(endpoint, SFMCToken, ConsumptionRequestId);
        setResponseDetails(response);
        verifyRequestID_ResultAPIResponse(ConsumptionRequestId);

    }

    @When("put SFMC {string} API request for ValidClientID")
    public void putSFMC(String endpoint) throws Exception {
        String userID = GetAPIsStepDef.customerID;
        response = postAPI.relatedSFMCLoyalty(userID, endpoint, SFMCToken);
        setResponseDetails(response);
        verifySFMCApiResponseFor(endpoint);
    }

    @When("HTTP PUT request of {string} API for {string}.")
    public void putReqAPI(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = postAPI.related_KSA_PUT(dataMap, endpoint);
        setResponseDetails(response);

    }

    public void verifySFMCApiResponseFor(String endpoint) throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        HashMap<String, Object> contentMap = new HashMap<>();
        String expectedField = null, testVal;
        if (endpoint.equalsIgnoreCase("TokenGenerate")) {
            actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
            SFMCToken = actResponseMap.get("access_token").toString();
            System.out.println("SFMC Token is " + SFMCToken);
        } else if (endpoint.equalsIgnoreCase("KSALoyaltyProfileUpdate")) {
            actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
            RequestId = actResponseMap.get("requestId").toString();
            System.out.println("RequestID is " + RequestId);
        } else if (endpoint.equalsIgnoreCase("KSALoyaltyChallenge_Consumption")) {
            actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
            ConsumptionRequestId = actResponseMap.get("requestId").toString();
            System.out.println("RequestID is " + ConsumptionRequestId);
        }

    }

    public void verifyRequestID_ResultAPIResponse(String consumptionID) throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        HashMap<String, Object> contentMap = new HashMap<>();
        String expectedField = null, testVal;
        actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();

//        String actualMessage= actResponseMap.get("requestId").toString();
//        Assert.assertEquals(consumptionID,actualMessage);
    }

    @Then("verify joy loyalty SpinWedge {string} details api response for {string}")
    public void verifyJoyLoyaltySpinWedgeDetailsApiResponseFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        expResponseMap = serviceAPI.getResponseDataFromTestDataFile(endpoint, testcase);
        actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
        String expectedField = null, testVal;
        for (Map.Entry mapElement : expResponseMap.entrySet()) {
            expectedField = (String) mapElement.getKey();
            testVal = (String) expResponseMap.get(expectedField);
            System.out.println("ExiectedField :" + expectedField + "   " + "TestValue :" + testVal);
            try {
                assertThat(actResponseMap.get(expectedField).toString()).isNotNull()
                        .as(expectedField + " field value is is Null.");
            } catch (NullPointerException e) {
                assertThat(actResponseMap.get(expectedField)).isEqualTo(null)
                        .as(expectedField + " field value is is Null.");
            }

        }
    }

}
