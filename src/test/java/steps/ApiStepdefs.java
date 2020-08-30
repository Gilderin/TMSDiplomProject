package steps;


import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class ApiStepdefs extends BaseUtil {
    public ApiStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @When("use this information to login")
    public void setupAPI() {
        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(browsersService.loginInfoLombok.getEmail(), browsersService.loginInfoLombok.getPassword());
    }
}
