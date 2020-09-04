package steps;


import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.AddProjectInfo;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class ApiStepdefs extends BaseUtil {
    public ApiStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    int projectID;
    int sectionID;
    int caseID;
    String name = "fdfd";

    @Step("Connect to api with basic authentication")
    @When("use this information to login")
    public void setupAPI() {
        RestAssured.baseURI = properties.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(browsersService.userInformation.getEmail(), browsersService.userInformation.getPassword());
    }

    @Step("Create project")
    @When("create project")
    public void createProject() {
        String endpoint = "/index.php?/api/v2/add_project";

        projectID = given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"suite_mode\": %d\n" +
                        "}", browsersService.addProjectInfo.getName(), browsersService.addProjectInfo.getProjectModeId()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Step("Delete project")
    @And("delete project")
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

    @Step("Update project")
    @And("Update project")
    public void updateProject() {
        String endpoint = "index.php?/api/v2/update_project/{project_id}";

        AddProjectInfo project = AddProjectInfo.builder().build();
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

    @Step("Get all projects")
    @And("Get all projects")
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Step("Get all users")
    @And("Get all users")
    public void getAllUsers() {
        String endpoint = "/index.php?/api/v2/get_users";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Step("Get all cases")
    @And("get all testCases")
    public void getAllCases() {
        String endpoint = "index.php?/api/v2/get_cases/{project_id}";


        given()
                .when()
                .pathParam("project_id", projectID)
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Step("Create test case")
    @And("create testCase")
    public void createTestCase() {
        String endpoint = "index.php?/api/v2/add_case/{section_id}";

        caseID = given()
                .pathParam("section_id", sectionID)
                .body(String.format("{\n" +
                                "    \"title\": \"%s\",\n" +
                                "    \"template_id\": %d,\n" +
                                "    \"type_id\": %d,\n" +
                                "    \"estimate\": \"%s\",\n" +
                                "    \"priority_id\": %d\n" +

                                "}", browsersService.testCasesInfo.getTitle(), browsersService.testCasesInfo.getTemplateId(),
                        browsersService.testCasesInfo.getTypeId(), browsersService.testCasesInfo.getEstimate(), browsersService.testCasesInfo.getPriorityId()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Step("Create new section")
    @And("create new section")
    public void createSection() {
        String endpoint = "index.php?/api/v2/add_section/{project_id}";

        sectionID = given()
                .pathParam("project_id", projectID)
                .body(String.format("{\n" +
                        "    \"name\": \"%s\"\n" +
                        "}", name))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");

    }

    @Step("Delete test case")
    @And("delete case")
    public void deleteTestCase() {
        String endpoint = "index.php?/api/v2/delete_case/{case_id}";

        given()
                .pathParam("case_id", caseID)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
