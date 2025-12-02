package cucumberTest.api.steps;

import cucumberTest.api.model.NbaStandingsRequestDTO;
import cucumberTest.api.stepLib.NbaActionMethods;
import cucumberTest.api.stepLib.NbaCheckMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import org.assertj.core.api.Fail;
import utils.SessionVariable;

import java.util.List;
import java.util.Map;

public class NbaSteps {

    NbaActionMethods nbaActionMethods = new NbaActionMethods();
    NbaCheckMethods nbaCheckMethods = new NbaCheckMethods();

    @Given("A request is made to the nba {string} endpoint with the following")
    public void aRequestIsMadeToTheNbaEndpointWithTheFollowing(String endpoint, List<Map<String, String>> requestData) {
        Response response = nbaActionMethods.fetchNbaData(requestData.get(0), endpoint);
        Serenity.setSessionVariable(SessionVariable.NBA_API_RESPONSE).to(response);
    }

    @And("The NBA api request returns a response code of {int}")
    public void theNbaApiRequestReturnsAResponseCodeOf(int responseCode) {
        Response nbaStandings = Serenity.sessionVariableCalled(SessionVariable.NBA_API_RESPONSE);
        nbaCheckMethods.verifyResponseCode(responseCode, nbaStandings);
    }

    @Then("The NBA api response should contain the following")
    public void theNbaApiResponseShouldContainTheFollowing(List<Map<String, String>> expectedData) {
        if (!Serenity.hasASessionVariableCalled(SessionVariable.NBA_API_RESPONSE)) {
            Fail.fail("Api response is empty");
        }
        Response nbaStandingsResponse = Serenity.sessionVariableCalled(SessionVariable.NBA_API_RESPONSE);
        Map<String, String> expectedDataMap = expectedData.get(0);
        Map<String, String> actualData = nbaStandingsResponse.as(Map.class);
        nbaCheckMethods.verifyResponseContainsExpectedData(expectedDataMap, actualData);
    }

}
