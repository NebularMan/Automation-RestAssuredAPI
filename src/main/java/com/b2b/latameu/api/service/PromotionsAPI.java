package com.b2b.latameu.api.service;

import com.utils.BaseApi;
import com.utils.Basecode;
import com.utils.LoadProperties;
import com.utils.ScenarioContext;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PromotionsAPI extends Basecode {
    private ScenarioContext context;
    private String apiUrl;

    public PromotionsAPI(ScenarioContext context) throws Exception {
        this.context = context;
        logger.info("Registration API URL :- " + apiUrl);
    }

    /**
     * Method to get the Promotions API response
     * @return response
     */
    public Response getPromotionsResponse(HashMap<String, Object> testdata) throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        for (Map.Entry mapElement : testdata.entrySet()) {
            String testField = (String) mapElement.getKey();
            String testVal = (String) testdata.get(testField);
            switch (testField) {
                case "okta-accesstoken":
                    if (testVal.equalsIgnoreCase("blank")) {
                        headerMap.put(testField, "");
                    } else {
                        headerMap.put(testField, testVal);
                    }
                    break;
                case "SiteId":
                    String strProject = getProject().toString();
                    if (testVal.equalsIgnoreCase("value")) {
                        headerMap = getSiteIdMap(getProject().toString(),headerMap);
                    } else {
                        headerMap.put(testField, "");
                    }
                    break;
                case "storeId":
                    String apiServer = getAppServerForProject(getProject());
                    apiUrl = apiServer+ readCommonConfigProperty("Promotions");
                    System.out.println("Promotion API URL :- " + apiUrl);
                    System.out.println("Promotion Header :- " + headerMap);

                    if (testVal.equalsIgnoreCase("blank")) {
                        apiUrl = apiUrl+"";
                    } else  {
                        apiUrl = apiUrl+testVal;
                    }
                    break;
            }
            System.out.println("Updated headermap :" + headerMap);
            System.out.println("Updated request URL :" + apiUrl);
        }
        Response response = BaseApi.getAPIMap(headerMap,apiUrl);
        logger.info("Promotion API response is :- " + response);
        return response;
    }
}
