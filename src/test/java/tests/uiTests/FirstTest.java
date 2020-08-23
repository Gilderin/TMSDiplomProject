package tests.uiTests;

import baseEntity.BaseTest;
import models.AddProjectLombok;
import models.LoginInfoLombok;
import models.Project;
import org.testng.annotations.Test;
import steps.LoginSteps;
import steps.ProjectSteps;

public class FirstTest extends BaseTest {

    @Test
    public void login(){
        LoginSteps loginSteps=new LoginSteps(browsersService);
        LoginInfoLombok loginInfoLombok=loginSteps.getLogin(1);
        loginSteps.login(loginInfoLombok);
    }

    @Test(dependsOnMethods = "login")
    public void addProject(){
        ProjectSteps projectSteps=new ProjectSteps(browsersService);
        AddProjectLombok addProjectLombok=projectSteps.getProjectInfo(3);
        projectSteps.createProject(addProjectLombok);
    }
}
