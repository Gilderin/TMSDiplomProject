package steps;


import baseEntity.BaseUtil;
import core.BrowsersService;
import models.AddProjectInfo;
import pages.DashboardPage;
import pages.addProjectPages.AddProjectPage;
import pages.addProjectPages.ProjectPage;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectSteps extends BaseUtil {
    public ProjectSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public AddProjectInfo getProjectInfo(Integer id) {
        //JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        AddProjectInfo addProjectInfo = AddProjectInfo.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.ProjectInformationSelect(id));
            while (res.next()) {
                addProjectInfo.setName(res.getString("name"));
                addProjectInfo.setAnnouncement(res.getString("announcement"));
                addProjectInfo.setShowAnnouncement(res.getBoolean("showAnnouncement"));
                addProjectInfo.setProjectMode(res.getString("type"));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
        return addProjectInfo;
    }

    public void createProject(AddProjectInfo addProjectInfo) {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        AddProjectPage addProjectPage = dashboardPage.addProjectButtonClick();
        ProjectPage projectPage = addProjectPage.moveToProject();
        projectPage.setProjectName(addProjectInfo.getName());
        switch (addProjectInfo.getProjectMode()) {
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
        projectPage.addProjectButtonClick();
    }
}
