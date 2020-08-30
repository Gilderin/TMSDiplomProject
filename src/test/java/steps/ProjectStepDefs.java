package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AddProjectLombok;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import pages.DashboardPage;
import pages.addProjectPages.AddProjectPage;
import pages.addProjectPages.ProjectPage;
import pages.administration.AdministrationPage;
import pages.administration.AdministrationProjectsPage;

import java.sql.ResultSet;
import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class ProjectStepDefs extends BaseUtil {
    public ProjectStepDefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @Given("project info from db where project id = {int}")
    public void getProjectInfoFromDB(Integer id) {
        browsersService.addProjectLombok = AddProjectLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.ProjectInformationSelect(id));
            while (res.next()) {
                browsersService.addProjectLombok.setName(res.getString("name"));
                browsersService.addProjectLombok.setAnnouncement(res.getString("announcement"));
                browsersService.addProjectLombok.setShowAnnouncement(res.getBoolean("show_announcement"));
                browsersService.addProjectLombok.setProjectModeId(res.getInt("projectType"));
                browsersService.addProjectLombok.setProjectMode(res.getString("type"));
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
                        "}", browsersService.addProjectLombok.getName(), browsersService.addProjectLombok.getProjectModeId()))
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
        projectPage.setProjectName(browsersService.addProjectLombok.getName());
        projectPage.setProjectAnnouncement(browsersService.addProjectLombok.getAnnouncement());
        if (browsersService.addProjectLombok.isShowAnnouncement()) {
            projectPage.clickShowAnnouncement();
        }
        setProjectMode();
        projectPage.addProjectButtonClick();
    }

    public void setProjectMode() {
        ProjectPage projectPage = new ProjectPage(browsersService);
        switch (browsersService.addProjectLombok.getProjectMode()) {
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

    @And("adnimistration project page opened")
    public void adnimistrationProjectPageOpened() {
        DashboardPage dashboardPage=new DashboardPage(browsersService);
        AdministrationPage administrationPage=dashboardPage.administrationButtonClick();
        AdministrationProjectsPage administrationProjectsPage=administrationPage.projectLinkClick();
        Assert.assertTrue(administrationProjectsPage.isPageOpened());
    }

    @When("delete project with name from db")
    public void deleteProjectWithNameFromDb() {
        AdministrationProjectsPage administrationProjectsPage =new AdministrationProjectsPage(browsersService,false);
        administrationProjectsPage.deleteIconClick(browsersService.addProjectLombok.getName());
        administrationProjectsPage.confirmationYesCheckboxClick();
        administrationProjectsPage.confirmationOkButtonClik();
        Assert.assertFalse(administrationProjectsPage.projectLinkIsVisible(browsersService.addProjectLombok.getName()),"Project not deleted");
    }
}

