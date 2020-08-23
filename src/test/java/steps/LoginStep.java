package steps;

import baseEntity.BaseStep;
import baseEntity.BaseTest;
import core.BrowsersService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import models.LoginInfoLombok;
import pages.LoginPage;
import services.JDBCService;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginStep extends BaseStep {
    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Given("Get User Info to login from DB. User id = {int}")
    public LoginInfoLombok getUserInfoToLoginFromDB(Integer id) {
        JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        LoginInfoLombok loginInfoLombok= LoginInfoLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.LoginInformationSelect(id));
            while (res.next()) {
                loginInfoLombok.setEmail(res.getString("email"));
                loginInfoLombok.setPassword(res.getString("password"));
            }
        }catch (SQLException throwables){
            logger.error(throwables.getMessage());
        }
        return loginInfoLombok;
    }

    @When("Login to Site")
    public void loginToSite(LoginInfoLombok loginInfoLombok) {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(loginInfoLombok.getEmail());
        loginPage.setPassword(loginInfoLombok.getPassword());
        loginPage.loginButtonClick();
    }
}
