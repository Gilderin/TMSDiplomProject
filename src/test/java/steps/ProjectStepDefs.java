package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AddProjectLombok;
import org.apache.http.HttpStatus;
import pages.DashboardPage;
import pages.addProjectPages.AddProjectPage;
import pages.addProjectPages.ProjectPage;

import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class ProjectStepDefs extends BaseUtil {
    public ProjectStepDefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @Given("project info from db where project id = {int}")
    public void getProjectInfoFromDB(Integer id) {
        addProjectLombok = AddProjectLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.ProjectInformationSelect(id));
            while (res.next()) {
                addProjectLombok.setName(res.getString("name"));
                addProjectLombok.setAnnouncement(res.getString("announcement"));
                addProjectLombok.setShowAnnouncement(res.getBoolean("show_announcement"));
                addProjectLombok.setProjectModeId(res.getInt("projectType"));
                addProjectLombok.setProjectMode(res.getString("type"));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @When("create project")
    public void createProject() {
        String endpoint = "/index.php?/api/v2/add_project";

        given()
                .body(String.format("{\n" +
                        "    \"name\": \"%s\",\n" +
                        "    \"suite_mode\": %d\n" +
                        "}", addProjectLombok.getName(), addProjectLombok.getProjectModeId()))
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @When("add project button click")
    public void addProjectButtonClick() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.addProjectButtonClick();
    }

    @Then("create project on UI")
    public void createProjectOnUI() {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        ProjectPage projectPage = addProjectPage.moveToProject();
        projectPage.setProjectName(addProjectLombok.getName());
        projectPage.setProjectAnnouncement(addProjectLombok.getAnnouncement());
        if (addProjectLombok.isShowAnnouncement()) {
            projectPage.clickShowAnnouncement();
        }
        setProjectMode();
        projectPage.addProjectButtonClick();
    }

    public void setProjectMode() {
        ProjectPage projectPage = new ProjectPage(browsersService);
        switch (addProjectLombok.getProjectMode()) {
            case "Use a single repository for all cases (recommended)":
                projectPage.setSuiteModeSingle();
                break;
            case "Use a single repository with baseline support":
                projectPage.setSuiteModeSingleBaseLine();
                break;
            case "Use multiple test suites to manage cases":
                projectPage.setSuiteModeMulti();
                break;
        }
    }
}

