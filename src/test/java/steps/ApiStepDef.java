package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import services.JDBCService;
import utils.SQLqueries;

import static io.restassured.RestAssured.given;

public class ApiStepDef extends BaseStep {

    public ApiStepDef(BrowsersService browsersService) {
        super(browsersService);
    }

    public void setupAPI(){
        RestAssured.baseURI = browsersService.getBaseUrl();
        JDBCService jdbcService=new JDBCService();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic("", "");
    }
}
