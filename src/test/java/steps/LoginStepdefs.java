package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import models.UserInformation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginStepdefs extends BaseUtil {
    public LoginStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Login to site")
    @When("login to website")
    public void loginToSite() {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(browsersService.userInformation.getEmail());
        loginPage.setPassword(browsersService.userInformation.getPassword());
        loginPage.loginButtonClick();
    }

    @Step("Open browser")
    @When("browser is open")
    public void browserIsOpen() {
        browsersService.SetupBrowser();
    }

    @Step("Open login page with Alert")
    @When("open login page with Alert")
    public void openLoginPageWithAlert() {
        browsersService.getDriver().get(properties.getURL());
        ((JavascriptExecutor) browsersService.getDriver()).executeScript("alert('It is an ALERT');");
    }

    @Step("Get text from alert")
    @And("get text from Alert")
    public void getTextFromAlert() {
        Alert alert = browsersService.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(), "It is an ALERT");
    }

    @Step("Close Alert")
    @And("close the Alert")
    public void acceptTheAlert() {
        Alert alert = browsersService.getDriver().switchTo().alert();
        alert.accept();
    }

    @Step("Move to login page")
    @When("open login page")
    public void openLoginPage() {
        browsersService.getDriver().get(properties.getURL());

    }

    @Step("Get info about user from db")
    @Given("login info from db where user id = {int}")
    public void loginInfoFromDbWhereUserId(Integer id) {
        browsersService.userInformation = UserInformation.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.LoginInformationSelect(id));
            while (res.next()) {
                browsersService.userInformation.setEmail(res.getString("email"));
                browsersService.userInformation.setPassword(res.getString("password"));
                browsersService.userInformation.setName_on_site(res.getString("name_on_site"));
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @Step("Get status dashboard page opened")
    @Then("dashboard page is opened")
    public void dashboardPageIsOpened() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @Step("Compare username on site and DB")
    @And("information about the user should be coincident with the data from the database")
    public void userDataShoudBeFromUserWithId() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        Assert.assertEquals(dashboardPage.userNavigationText(), browsersService.userInformation.getName_on_site(), "User name on site not equals from DB");
    }

    @Step("Get status error message")
    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        LoginPage loginPage = new LoginPage(browsersService);
        Assert.assertTrue(loginPage.messageTitleDisplayed());
    }

    @Step("Get text from error message")
    @And("error message text is {string}")
    public void errorMessageTextIs(String messageText) {
        LoginPage loginPage = new LoginPage(browsersService);
        Assert.assertEquals(loginPage.errorMessageText(), messageText, "Error message is not correct");
    }

    @Step("Logout from site")
    @Then("logout from site")
    public void logoutFromSite() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        dashboardPage.userNavigationButtonClick();
        LoginPage loginPage = dashboardPage.logoutButtonClick();
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Step("Start browser and go to the login page")
    @Given("browser is open and loginPage loaded")
    public void browserIsOpenAndLoginPageLoaded() {
        browsersService.SetupBrowser();
        browsersService.getDriver().get(properties.getURL());
    }
}
