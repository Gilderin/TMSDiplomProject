package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import pages.LoginPage;

public class LoginSteps extends BaseStep {
    public LoginSteps(BrowsersService browsersService) {
        super(browsersService);
    }
    public void getLogin(){

    }
    public void Login(String email, String password){
        LoginPage loginPage=new LoginPage(browsersService);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.loginButtonClick();
    }
}
