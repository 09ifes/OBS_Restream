package cucumberTest.api.stepLib;

import io.restassured.response.Response;
import net.serenitybdd.core.annotations.findby.FindBy;
import utils.FileUtils;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class NbaCheckMethods {

    FileUtils fileUtils = new FileUtils();

    public void verifyResponseCode(int expectedResponseCode, Response actualResponse) {
        if (!(actualResponse.getBody() == null)) {
            assertThat(actualResponse.getStatusCode()).isEqualTo(expectedResponseCode);
        } else {
            fail("The response is null");
        }
    }

    public void verifyResponseContainsExpectedData(Map<String, String> expectedData, Map<String, String> actualDataRaw) {
      Map<String, String> actualData = fileUtils.flattenJsonToStringMap(actualDataRaw);
        assertThat(actualData).containsAllEntriesOf(expectedData);
    }

}
