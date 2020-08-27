package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import services.JDBCService;

import static io.restassured.RestAssured.given;

public class ApiStepdefs extends BaseStep {
    public ApiStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }
    @When("Use this information to login")
    public void setupAPI(){
       // RestAssured.baseURI = browsersService.getBaseUrl();
        //JDBCService jdbcService=new JDBCService();

       // RestAssured.requestSpecification = given()
        //properties = new ReadProperties();
        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(browsersService.loginInfoLombok.getEmail(), browsersService.loginInfoLombok.getPassword());
    }

}
