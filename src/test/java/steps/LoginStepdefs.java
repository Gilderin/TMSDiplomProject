package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import io.cucumber.java.bm.Bagi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginInfoLombok;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import services.JDBCService;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginStepdefs extends BaseStep {
    public LoginStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @When("login to website")
    public void loginToSite() {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(browsersService.loginInfoLombok.getEmail());
        loginPage.setPassword(browsersService.loginInfoLombok.getPassword());
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
        browsersService.loginInfoLombok= LoginInfoLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.LoginInformationSelect(id));
            while (res.next()) {
                browsersService.loginInfoLombok.setEmail(res.getString("email"));
                browsersService.loginInfoLombok.setPassword(res.getString("password"));
            }
        }catch (SQLException throwables){
            logger.error(throwables.getMessage());
        }
    }

    @Given("login info from db where user id = {int}")
    public void loginInfoFromDbWhereUserId(Integer id) {
        JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        browsersService.loginInfoLombok= LoginInfoLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.LoginInformationSelect(id));
            while (res.next()) {
                browsersService.loginInfoLombok.setEmail(res.getString("email"));
                browsersService.loginInfoLombok.setPassword(res.getString("password"));
            }
        }catch (SQLException throwables){
            logger.error(throwables.getMessage());
        }
    }

    @Then("dashboard page is opened")
    public void dashboardPageIsOpened() {
        DashboardPage dashboardPage= new DashboardPage(browsersService);
        Assert.assertTrue(dashboardPage.userNavigationIsDisplayed());
    }

    @And("user data shoud be from user with id = {int}")
    public void userDataShoudBeFromUserWithId(Integer id) {
    }
}
