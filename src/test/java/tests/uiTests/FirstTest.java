package tests.uiTests;

import baseEntity.BaseTest;
import models.LoginInfoLombok;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class FirstTest extends BaseTest {

    @Test
    public void login(){
        LoginSteps loginSteps=new LoginSteps(browsersService);
        LoginInfoLombok loginInfoLombok=loginSteps.getLogin(1);
        loginSteps.login(loginInfoLombok);
    }
}
