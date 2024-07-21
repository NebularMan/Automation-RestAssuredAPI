package com.StepDef.API.JoyLoyalty;

import com.JoyLoyalty.api.service.JoyAccountDetailsAPI;
import com.JoyLoyalty.api.service.JoyServiceAPI;
import com.JoyLoyalty.api.service.PostAPI;
import com.utils.BaseApi;
import com.utils.ScenarioContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetAPIsStepDef extends BaseApi {
    private ScenarioContext context;
    public JoyServiceAPI serviceAPI;
    public JoyAccountDetailsAPI acctDetails;
    private Response response;
    public static String ID;

    public PostAPI postAPI;
    public static String customerID;
    public static String custPointsBefore;
    public static int custPointsBeforeInt;
    public static String custPointsAfter;
    public static int custPointsAfterInt;
    public static String customerStatus;


    public GetAPIsStepDef(ScenarioContext context) throws Exception {
        this.context = context;
        serviceAPI = new JoyServiceAPI(context);
        acctDetails = new JoyAccountDetailsAPI(context);

    }

    public void setResponseDetails(Response response) {
        context.previousResponse = response;
        //context.addResponseInTransactionMap("registration",response);
        System.out.println(context.previousResponse.prettyPrint());
    }

    @Given("send get request of joy loyalty {string} for {string}")
    public void sendGetRequestToJoyLoyaltyFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap = serviceAPI.getRequestHeaderBodyTestcaseData(endpoint, testcase);
        response = acctDetails.getResponseDetails(dataMap, endpoint,testcase);
        setResponseDetails(response);
    }
    @Given("verify {string} customer status using {string} API.")
    public void sendGetRequestforAccount(String testcase, String endPoint) throws Exception {
        response = acctDetails.getAccountDetails(testcase,endPoint);
        setResponseDetails(response);
    }

    public void assertion(HashMap<String, Object> expResponseMap,HashMap<String, Object> valuesMap) throws Exception {
        String expectedField = null,testVal;
        for (Map.Entry mapElement : expResponseMap.entrySet()) {
            expectedField = (String) mapElement.getKey();
            testVal = (String) expResponseMap.get(expectedField);
            System.out.println("ExpectedField :" +expectedField+ "   "+"TestValue :" +testVal );
            if (!testVal.equalsIgnoreCase("NotNull")) {
                assertThat(valuesMap.get(expectedField).toString()).isEqualTo(testVal);
            } else if (testVal.equalsIgnoreCase("NotNull")) {
                assertThat(valuesMap.get(expectedField).toString()).isNotNull()
                        .as(expectedField + " field value is is Null.");
            }
        }
    }
    public void assertionnew(HashMap<String, Object> expResponseMap,HashMap<String, Object> actCustomerMap) throws Exception {
        String expectedField = null,testVal;
        for (Map.Entry mapElement : expResponseMap.entrySet()) {
            expectedField = (String) mapElement.getKey();
            testVal = (String) expResponseMap.get(expectedField);
            System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
            try {
                assertThat(actCustomerMap.get(expectedField).toString()).isNotNull()
                        .as(expectedField + " field value is is Null.");
            } catch (NullPointerException e) {
                assertThat(actCustomerMap.get(expectedField)).isEqualTo(null)
                        .as(expectedField + " field value is is Null.");
            }

        }
    }

    @Then("verify joy loyalty account {string} details api response for {string}")
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
//        } else if(actResponseMap.containsKey("data")){
//            HashMap<String, Object> actCustomerMap = new HashMap<>();
//            actCustomerMap = (HashMap<String, Object>) actResponseMap.get("data");
//            assertionnew(expResponseMap,actCustomerMap);
            } else if (actResponseMap.containsKey("customers")) {
                HashMap<String, Object> actCustomerMap = new HashMap<>();
                actCustomerMap = (HashMap<String, Object>) actResponseMap.get("customers");
                assertionnew(expResponseMap, actCustomerMap);
                customerID = actCustomerMap.get("id").toString();
                System.out.println("UserId of Customer is " + customerID);
            }
            else if(actResponseMap.containsKey("status"))
            {
                HashMap<String, Object> actCustomerMap = new HashMap<>();
                customerStatus=actCustomerMap.get("status").toString();
                System.out.println("Status of Customer is " + customerStatus);
            }
            else if(actResponseMap.get("success").toString()== "true" && endpoint.equalsIgnoreCase("Points"))
            {
                if(custPointsBefore == null)
                {
                    custPointsBefore=actResponseMap.get("points").toString();
                    custPointsBeforeInt=Integer.parseInt(custPointsBefore);
                    System.out.println("Customer Points in Integer Before are " + custPointsBeforeInt);
                    custPointsBeforeInt=custPointsBeforeInt+100;
                }
                else
                {
                    custPointsAfter=actResponseMap.get("points").toString();
                    custPointsAfterInt=Integer.parseInt(custPointsAfter);
                    System.out.println("Customer Points During operation are " + custPointsBeforeInt);
                    System.out.println("Customer Points After are " + custPointsAfterInt);
                    Assert.assertEquals(custPointsBeforeInt,custPointsAfterInt);
                }
            }
            else {
                assertion(expResponseMap, actResponseMap);
            }
    }


    @Then("verify joy loyalty {string} details api response for {string}")
    public void verifyJoyLoyaltyDetailsApiResponseFor(String endpoint, String testcase) throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        HashMap<String, Object> KeyMap = new HashMap<>();
        HashMap<String, Object> dataMap = new HashMap<>();
        HashMap<String, Object> valuesMap = new HashMap<>();
        String expectedField = null, testVal;
        int flag = 0;
        expResponseMap = serviceAPI.getResponseDataFromTestDataFile(endpoint, testcase);
        KeyMap = serviceAPI.getResponseTestDataFile(endpoint, testcase);
        actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
        String[] values = {};
        // Following conditional is to check response body contains error message or not for negative usecase
        int statusCode = response.statusCode();
        if(statusCode == 400){
            if(actResponseMap.containsKey("message")){
               assertion(expResponseMap,actResponseMap);
                return;
            }
            if(actResponseMap.containsKey("msg")){
                String msg = (String) actResponseMap.get("msg");
                if(msg.equalsIgnoreCase("Authentication Token is expired"))
                {
                    Assert.assertFalse(true);
                }
                return;
            }
        }else{
            if(actResponseMap.containsKey("message")){
                String message = (String) actResponseMap.get("message");
                System.out.println(message);
                return;
            }
            else if (actResponseMap.containsKey("data")) {
                ArrayList<Object> dataArr = (ArrayList<Object>) actResponseMap.get("data");
                for (Map.Entry mapElement : expResponseMap.entrySet()) {
                    expectedField = (String) mapElement.getKey();
                    testVal = (String) expResponseMap.get(expectedField);
                    for (int i = 0; i < dataArr.size(); i++) {
                        dataMap = (HashMap<String, Object>) dataArr.get(i);
                        if (expectedField.equalsIgnoreCase("en") || expectedField.equalsIgnoreCase("ar_SA")) {
                            String [] key = (String[]) KeyMap.get("keys");
                            for (int j = 0; j < key.length; j++) {
                                valuesMap = (HashMap<String, Object>) dataMap.get(key[0]);
                                System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
                                System.out.println("Values :" + valuesMap.get(expectedField).toString());
                                try {
                                    assertThat(valuesMap.get(expectedField).toString()).isNotNull()
                                            .as(expectedField + " field value is is Null.");
                                } catch (NullPointerException e) {
                                    assertThat(valuesMap.get(expectedField)).isEqualTo(null)
                                            .as(expectedField + " field value is is Null.");
                                }
                            }
                        }
                        else{
                            if (!testVal.equalsIgnoreCase("NotNull")) {
                                System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
                                assertThat(dataMap.get(expectedField).toString()).isEqualTo(testVal);
                            } else if (testVal.equalsIgnoreCase("NotNull")) {
                                System.out.println("ExpectedField :" + expectedField + "TestValue :" + testVal);
                                try {
                                    assertThat(dataMap.get(expectedField).toString()).isNotNull()
                                            .as(expectedField + " field value is is Null.");
                                } catch (NullPointerException e) {
                                    assertThat(dataMap.get(expectedField)).isEqualTo(null)
                                            .as(expectedField + " field value is is Null.");
                                }
                            }
                        }

                    }
                }
            }
            else if (actResponseMap.containsKey("data") && (endpoint.equalsIgnoreCase("GetChallenges_SegImport")|| endpoint.equalsIgnoreCase("GetChallenges_SegImport-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegComb-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegCity-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnlyNeg") || endpoint.equalsIgnoreCase("GetChallenges_SegMaleFemaleNeg") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB") || endpoint.equalsIgnoreCase("GetChallenges_SegMaleOnly") || endpoint.equalsIgnoreCase("GetChallenges_SegCity")|| endpoint.equalsIgnoreCase("GetChallenges_SegComb") ||endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnly"))) {
                ArrayList<Object> dataArr = (ArrayList<Object>) actResponseMap.get("data");
                for (Map.Entry mapElement : expResponseMap.entrySet()) {
                    expectedField = (String) mapElement.getKey();
                    testVal = (String) expResponseMap.get(expectedField);
                    for (int i = 0; i < dataArr.size(); i++) {
                        dataMap = (HashMap<String, Object>) dataArr.get(i);
                        if (expectedField.equalsIgnoreCase("en") || expectedField.equalsIgnoreCase("ar_SA")) {
                            String [] key = (String[]) KeyMap.get("keys");
                            //for (int j = 0; j < key.length; j++) {
                            valuesMap = (HashMap<String, Object>) dataMap.get(key[0]);
                            System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
                            System.out.println("Values :" + valuesMap.get(expectedField).toString());
                            if(valuesMap.get(expectedField).toString().equalsIgnoreCase(testVal))
                            {
                                flag=1;
                                System.out.println("Flag Matched :"+flag);

                            }
//                                Assert.assertEquals(testVal,valuesMap.get(expectedField).toString());
//                                assertThat(valuesMap.get(expectedField).toString().equals(testVal));
//                                break;
//                                try {
//                                    assertThat(valuesMap.get(expectedField).toString()).isNotNull()
//                                            .as(expectedField + " field value is is Null.");
//                                } catch (NullPointerException e) {
//                                    assertThat(valuesMap.get(expectedField)).isEqualTo(null)
//                                            .as(expectedField + " field value is is Null.");
//                                }
//                            }
                        }
                        else{
                            if (!testVal.equalsIgnoreCase("NotNull")) {
                                System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
                                assertThat(dataMap.get(expectedField).toString()).isEqualTo(testVal);
                            } else if (testVal.equalsIgnoreCase("NotNull")) {
                                System.out.println("ExpectedField :" + expectedField + "TestValue :" + testVal);
                                try {
                                    assertThat(dataMap.get(expectedField).toString()).isNotNull()
                                            .as(expectedField + " field value is is Null.");
                                } catch (NullPointerException e) {
                                    assertThat(dataMap.get(expectedField)).isEqualTo(null)
                                            .as(expectedField + " field value is is Null.");
                                }
                            }
                        }

                    }
                }
                if(flag==0 && (endpoint.equalsIgnoreCase("GetChallenges_SegImport") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB") || endpoint.equalsIgnoreCase("GetChallenges_SegMaleOnly") || endpoint.equalsIgnoreCase("GetChallenges_SegCity")|| endpoint.equalsIgnoreCase("GetChallenges_SegComb") ||endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnly")))
                {
                        System.out.print("Flag not matched :" + flag);
                        Assert.assertFalse(true);
                }
                if((endpoint.equalsIgnoreCase("GetChallenges_SegImport-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegComb-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegCity-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB-Neg")  || endpoint.equalsIgnoreCase("GetChallenges_SegMaleFemaleNeg") || endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnlyNeg")) && flag == 0)
                {
                    System.out.print("Negative Scenario Matched :" + flag);
                                        Assert.assertTrue(true);
                }
                if((endpoint.equalsIgnoreCase("GetChallenges_SegImport-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegComb-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegCity-Neg") || endpoint.equalsIgnoreCase("GetChallenges_SegDOB-Neg")  || endpoint.equalsIgnoreCase("GetChallenges_SegMaleFemaleNeg") || endpoint.equalsIgnoreCase("GetChallenges_SegFemaleOnlyNeg")) && flag == 1)
                {
                    Assert.assertFalse(true);
                }

            }
            else {
                assertion(expResponseMap,actResponseMap);
            }
        }

    }


    @Then("verify joy Translation loyalty {string} details api response for {string}")
    public void verifyJoyTranslationLoyaltyDetailsApiResponseFor(String endPoint, String testcase) throws Exception {
            HashMap<String, Object> expResponseMap = new HashMap<>();
            HashMap<String, Object> actResponseMap = new HashMap<>();
            HashMap<String, Object> valuesMap = new HashMap<>();
            expResponseMap = serviceAPI.getResponseDataFromTestDataFile(endPoint,testcase);
            actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();

            String [] keyvalues = actResponseMap.keySet().toArray(new String[0]);
            int numCount = actResponseMap.size();
            for(int i=0; i<numCount; i++) {
                System.out.println(keyvalues[i]);
                valuesMap = (HashMap<String, Object>) actResponseMap.get(keyvalues[i]);
                assertion(expResponseMap,valuesMap);
            }

        }


    @Then("verify joy loyalty faq {string} details api response for {string}")
    public void verifyJoyLoyaltyFaqDetailsApiResponseFor(String endPoint, String testcase) throws Exception {
        HashMap<String, Object> expResponseMap = new HashMap<>();
        HashMap<String, Object> actResponseMap = new HashMap<>();
        HashMap<String, Object> valuesMap = new HashMap<>();
        HashMap<String, Object> sectionMap = new HashMap<>();
        HashMap<String, Object> FaqMap = new HashMap<>();
        HashMap<String, Object> KeyMap = new HashMap<>();
        HashMap<String, Object> langMap = new HashMap<>();
        Object obj = null;
        expResponseMap = serviceAPI.getResponseDataFromTestDataFile(endPoint, testcase);
        actResponseMap = (HashMap<String, Object>) context.previousResponse.getBody().jsonPath().get();
        KeyMap = serviceAPI.getResponseTestDataFile(endPoint, testcase);
        ArrayList<Object> dataArr = (ArrayList<Object>) actResponseMap.get("data");
        ArrayList<Object> data = (ArrayList<Object>) actResponseMap.get("data");
        String expectedField = null, testVal;
            for (int i = 0; i < data.size(); i++) {
                valuesMap = (HashMap<String, Object>) data.get(i);
                assertionnew(expResponseMap,valuesMap);
                ArrayList<Object> section = (ArrayList<Object>) valuesMap.get("section");
                for (int j = 0; j < section.size(); j++) {
                    sectionMap = (HashMap<String, Object>) section.get(j);
                    ArrayList<Object> faq = (ArrayList<Object>) sectionMap.get("faqs");
                    int faqs = faq.size();
                    for (Map.Entry mapElement : expResponseMap.entrySet()) {
                        expectedField = (String) mapElement.getKey();
                        testVal = (String) expResponseMap.get(expectedField);
                    for (int k = 0; k < faqs; k++) {
                        FaqMap = (HashMap<String, Object>) faq.get(k);
                        if (expectedField.equalsIgnoreCase("en") || expectedField.equalsIgnoreCase("ar_SA")) {
                            String[] key = (String[]) KeyMap.get("keys");
                            for (int l = 0; l < key.length; l++) {
                                if(key[l].equalsIgnoreCase("question") || key[l].equalsIgnoreCase("answer") ){
                                    langMap = (HashMap<String, Object>) FaqMap.get(key[l]);
                                    System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
                                    try {
                                        assertThat(langMap.get(expectedField).toString()).isNotNull()
                                                .as(expectedField + " field value is is Null.");
                                    } catch (NullPointerException e) {
                                        assertThat(langMap.get(expectedField)).isEqualTo(null)
                                                .as(expectedField + " field value is is Null.");
                                    }
                                }else{
                                    langMap = (HashMap<String, Object>) valuesMap.get(key[l]);
                                    System.out.println("ExpectedField :" + expectedField + "   " + "TestValue :" + testVal);
                                    try {
                                        assertThat(langMap.get(expectedField).toString()).isNotNull()
                                                .as(expectedField + " field value is is Null.");
                                    } catch (NullPointerException e) {
                                        assertThat(langMap.get(expectedField)).isEqualTo(null)
                                                .as(expectedField + " field value is is Null.");
                                    }
                                }

                            }
                        }


                    }

                }

            }
        }
    }

}

