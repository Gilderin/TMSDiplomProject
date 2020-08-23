package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import models.AddProjectLombok;
import pages.AddProjectPage;
import pages.DashboardPage;
import services.JDBCService;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectSteps extends BaseStep {
    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public AddProjectLombok getProjectInfo(Integer id) {
        JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        AddProjectLombok addProjectLombok = AddProjectLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.ProjectInformationSelect(id));
            while (res.next()) {
                addProjectLombok.setName(res.getString("name"));
                addProjectLombok.setAnnouncement(res.getString("announcement"));
                addProjectLombok.setShowAnnouncement(res.getBoolean("showAnnouncement"));
                addProjectLombok.setProjectMode(res.getString("type"));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return addProjectLombok;
    }

    public void createProject(AddProjectLombok addProjectLombok) {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        AddProjectPage addProjectPage = dashboardPage.addProjectPageClick();
        addProjectPage.setProjectName(addProjectLombok.getName());
        switch (addProjectLombok.getProjectMode()) {
            case "Use a single repository for all cases (recommended)":
                addProjectPage.setSuiteModeSingle();
                break;
            case "Use a single repository with baseline support":
                addProjectPage.setSuiteModeSingleBaseLine();
                break;
            case "Use multiple test suites to manage cases":
                addProjectPage.setSuiteModeMulti();
                break;
        }
        addProjectPage.AddProjectButtonClick();
    }
}
