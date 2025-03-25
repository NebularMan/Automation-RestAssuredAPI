package API.b2b.latameu.api.service;


import API.utils.BaseApi;
import API.utils.Basecode;
import API.utils.LoadProperties;
import API.utils.ScenarioContext;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class HomeAPI extends Basecode {
    private ScenarioContext context;
    private String apiUrl;

    public HomeAPI(ScenarioContext context) throws Exception {
        this.context = context;
        //apiUrl = getlatamServerUrl()+ LoadProperties.readCommonConfigProperty("Home");
        if(getProject().equalsIgnoreCase("columbia")) {
            apiUrl = getCommonConfigPropertyValue("co_QA_apiserver");
        }else if (getProject().equalsIgnoreCase("brazil")){
            apiUrl = getCommonConfigPropertyValue("br_QA_apiserver");
        }else if (getProject().equalsIgnoreCase("spain")){
            apiUrl = getCommonConfigPropertyValue("es_QA_apiserver");
        }else if (getProject().equalsIgnoreCase("dominic")){
            apiUrl = getCommonConfigPropertyValue("dr_QA_apiserver");
        }
        apiUrl = apiUrl+getCommonConfigPropertyValue("QA_apiversion") +
                getCommonConfigPropertyValue("Home");
        LoadProperties.logger.info("Content API URL :- " + apiUrl);
    }
    public Map<String, String> getHomeHeaderAsMap() throws Exception {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap = getSiteIdMap(getProject().toString(),headerMap);
        System.out.println("Site Id as API request header is - " + headerMap);
        return headerMap;
    }

    /**
     * Method to get the Home API response
     * @return response
     */
    public Response getHomeApiDetails() throws Exception {
        System.out.println("Updated header map : "+ getHomeHeaderAsMap());
        System.out.println("Updated URL : "+ apiUrl);
        Response response = BaseApi.getAPIMap(getHomeHeaderAsMap(),apiUrl);
        LoadProperties.logger.info("Response details is :- " + response);
        return response;
    }
}
