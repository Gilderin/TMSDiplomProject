package tests;

import baseEntity.BaseTest;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class FirstTest extends BaseTest {

    @Test
    public void login(){
        LoginSteps loginSteps=new LoginSteps(browsersService);
        loginSteps.getLogin(1);
        loginSteps.login();
    }
}
