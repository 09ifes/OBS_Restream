package cucumberTest.api.stepLib;

import cucumberTest.api.model.NbaRequest;
import io.restassured.response.Response;

import java.util.Map;

public class NbaActionMethods {

    NbaRequest nbaRequest = new NbaRequest();

    public Response fetchNbaData(Map<String, String> requestData, String endpoint) {
        return nbaRequest.getNbaData(requestData, endpoint);
    }

}
