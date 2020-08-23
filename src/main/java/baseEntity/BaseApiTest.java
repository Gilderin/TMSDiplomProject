package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.JDBCService;
import utils.Listener;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    public BrowsersService browsersService;
    public ReadProperties properties;
    public JDBCService jdbcService;

    @BeforeMethod
    public void setup() {
        jdbcService = new JDBCService();
        jdbcService.connectionDB();
        properties = new ReadProperties();
        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic("", "");
    }
}