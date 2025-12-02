package cucumberTest.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;

public class NbaRequest {

    private static String BASE_URL = "https://v2.nba.api-sports.io";
    private static String STANDINGS_ENDPOINT = "standings";
    private static String PLAYERS_ENDPOINT = "players";
    private static final Logger LOGGER = LoggerFactory.getLogger(NbaRequest.class);

    public Response getNbaData(Map<String, String> requestData, String endpoint) {
        String selectedEndpoint;
        switch (endpoint) {
            case "players" -> selectedEndpoint = PLAYERS_ENDPOINT;
            default -> selectedEndpoint = STANDINGS_ENDPOINT;
        }
        return getRequestWithQueryParamsAndHeaders(requestData, getNbaRequestHeaders(), BASE_URL, selectedEndpoint);
    }

    private Response getRequestWithQueryParamsAndHeaders(Map<String, String> queryParams, List<Header> headers,
                                                         String baseUrl, String endpoint) {
        Response response = given()
                .contentType(ContentType.JSON)
                .headers(new Headers(headers))
                .queryParams(queryParams).log().all()
                .get(String.join("/", baseUrl, endpoint));
        LOGGER.info("Request headers: {}\nRequest parameters: {}", headers, queryParams);
        LOGGER.info("Response is {}", response);
        return response;
    }

    private List<Header> getNbaRequestHeaders() {
        List<Header> headers = new ArrayList<>();
        headers.add(new Header("x-rapidapi-host", "v2.nba.api-sports.io"));
        headers.add(new Header("x-rapidapi-key", "ddcc7da093f859b75ca48a022193b577"));
        return headers;
    }

}
