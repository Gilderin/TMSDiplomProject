package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import io.cucumber.java.bm.Bagi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginInfoLombok;
import pages.LoginPage;
import services.JDBCService;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginStepdefs extends BaseStep {
    public LoginStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @When("Login to Site")
    public void loginToSite() {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(loginInfoLombok.getEmail());
        loginPage.setPassword(loginInfoLombok.getPassword());
        loginPage.loginButtonClick();
    }

    @When("Browser is open")
    public void browserIsOpen() {
        browsersService.SetupBrowser();
    }

    @When("Open login page")
    public void openLoginPage() {
        browsersService.getDriver().get(properties.getURL());
    }

    @Then("Get User Info to login from DB. User id = {int}")
    public void getUserInfoToLoginFromDBUserIdInt(Integer id) {
        JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        loginInfoLombok= LoginInfoLombok.builder().build();
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
    }
}
