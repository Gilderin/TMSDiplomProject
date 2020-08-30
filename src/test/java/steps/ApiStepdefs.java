package steps;


import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.AddProjectLombok;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class ApiStepdefs extends BaseUtil {
    public ApiStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    int projectID;

    @When("use this information to login")
    public void setupAPI() {
        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(browsersService.userInformation.getEmail(), browsersService.userInformation.getPassword());
    }

    @When("create project")
    public void createProject() {
        String endpoint = "/index.php?/api/v2/add_project";

        projectID = given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"suite_mode\": %d\n" +
                        "}", browsersService.addProjectLombok.getName(), browsersService.addProjectLombok.getProjectModeId()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    public void deleteProject() {
        String endpoint = "index.php?/api/v2/delete_project/{project_id}";

        given()
                .pathParam("project_id", projectID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void updateProject() {
        String endpoint = "index.php?/api/v2/update_project/{project_id}";

        AddProjectLombok project =  AddProjectLombok.builder().build();
                project.setName("PR04_UPD");
                project.setAnnouncement("Test!!!");
                project.setShowAnnouncement(true);
                project.setCompleted(true);

        given()
                .pathParam("project_id", projectID)
                .body(project, ObjectMapperType.GSON)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void getAllUsers() {
        String endpoint = "/index.php?/api/v2/get_users";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void getAllCases() {
        String endpoint = "index.php?/api/v2/get_cases/{project_id}";


        given()
                .when()
                .pathParam("project_id", projectID)
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    public void addTestCase() {


    }


}
