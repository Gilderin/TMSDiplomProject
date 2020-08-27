package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.AddProjectLombok;
import org.apache.http.HttpStatus;
import services.JDBCService;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class ProjectStepDefs extends BaseStep {
    public ProjectStepDefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @Given("Project info from db where project id = {int}")
    public void getProjectInfoFromDB(Integer id) {
        JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        browsersService.addProjectLombok = AddProjectLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.ProjectInformationSelect(id));
            while (res.next()) {
                browsersService.addProjectLombok.setName(res.getString("name"));
                browsersService.addProjectLombok.setAnnouncement(res.getString("announcement"));
                browsersService.addProjectLombok.setShowAnnouncement(res.getBoolean("show_announcement"));
                browsersService.addProjectLombok.setProjectModeId(res.getInt("projectType"));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @When("Create project")
    public void createProject() {
        String endpoint = "/index.php?/api/v2/add_project";

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"suite_mode\": %d\n" +
                        "}", browsersService.addProjectLombok.getName(), browsersService.addProjectLombok.getProjectModeId()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}

