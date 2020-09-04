package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import models.AddProjectInfo;
import org.testng.Assert;
import pages.DashboardPage;
import pages.addProjectPages.AddProjectPage;
import pages.addProjectPages.ProjectPage;
import pages.administration.AdministrationPage;
import pages.administration.AdministrationProjectsPage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectStepDefs extends BaseUtil {
    public ProjectStepDefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Get information about project from DB")
    @Given("project info from db where project id = {int}")
    public void getProjectInfoFromDB(Integer id) {
        browsersService.addProjectInfo = AddProjectInfo.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.ProjectInformationSelect(id));
            while (res.next()) {
                browsersService.addProjectInfo.setName(res.getString("name"));
                browsersService.addProjectInfo.setAnnouncement(res.getString("announcement"));
                browsersService.addProjectInfo.setShowAnnouncement(res.getBoolean("show_announcement"));
                browsersService.addProjectInfo.setProjectModeId(res.getInt("projectType"));
                browsersService.addProjectInfo.setProjectMode(res.getString("type"));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @Step("Add project button click on dashboard page")
    @When("add project button click")
    public void addProjectButtonClick() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.addProjectButtonClick();
    }

    @Step("Create project on UI")
    @Then("create project on UI")
    public void createProjectOnUI() {
        AddProjectPage addProjectPage = new AddProjectPage(browsersService);
        ProjectPage projectPage = addProjectPage.moveToProject();
        projectPage.setProjectName(browsersService.addProjectInfo.getName());
        projectPage.setProjectAnnouncement(browsersService.addProjectInfo.getAnnouncement());
        if (browsersService.addProjectInfo.isShowAnnouncement()) {
            projectPage.clickShowAnnouncement();
        }
        setProjectMode();
        projectPage.addProjectButtonClick();
    }

    @Step("Set project mode")
    public void setProjectMode() {
        ProjectPage projectPage = new ProjectPage(browsersService);
        switch (browsersService.addProjectInfo.getProjectMode()) {
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

    @Step("Open administration page")
    @And("adnimistration project page opened")
    public void adnimistrationProjectPageOpened() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        AdministrationPage administrationPage = dashboardPage.administrationButtonClick();
        AdministrationProjectsPage administrationProjectsPage = administrationPage.projectLinkClick();
        Assert.assertTrue(administrationProjectsPage.isPageOpened());
    }

    @Step("Deleting a project with given name")
    @When("delete project with name from db")
    public void deleteProjectWithNameFromDb() {
        AdministrationProjectsPage administrationProjectsPage = new AdministrationProjectsPage(browsersService, false);
        administrationProjectsPage.deleteIconClick(browsersService.addProjectInfo.getName());
        administrationProjectsPage.confirmationYesCheckboxClick();
        administrationProjectsPage.confirmationOkButtonClik();
        Assert.assertFalse(administrationProjectsPage.projectLinkIsVisible(browsersService.addProjectInfo.getName()), "Project not deleted");
    }
}

