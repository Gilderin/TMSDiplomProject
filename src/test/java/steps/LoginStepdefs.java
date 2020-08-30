package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserInformation;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginStepdefs extends BaseUtil {
    public LoginStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @When("login to website")
    public void loginToSite() {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(browsersService.userInformation.getEmail());
        loginPage.setPassword(browsersService.userInformation.getPassword());
        loginPage.loginButtonClick();
    }

    @When("browser is open")
    public void browserIsOpen() {
        browsersService.SetupBrowser();
    }

    @When("open login page")
    public void openLoginPage() {
        browsersService.getDriver().get(properties.getURL());
    }

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

    @Then("dashboard page is opened")
    public void dashboardPageIsOpened() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        Assert.assertTrue(dashboardPage.isPageOpened());
    }

    @And("information about the user should be coincident with the data from the database")
    public void userDataShoudBeFromUserWithId() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        Assert.assertEquals(dashboardPage.userNavigationText(), browsersService.userInformation.getName_on_site(), "User name on site not equals from DB");
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        LoginPage loginPage = new LoginPage(browsersService);
        Assert.assertTrue(loginPage.messageTitleDisplayed());
    }

    @And("error message text is {string}")
    public void errorMessageTextIs(String messageText) {
        LoginPage loginPage = new LoginPage(browsersService);
        Assert.assertEquals(loginPage.errorMessageText(), messageText, "Error message is not correct");
    }

    @Then("logout from site")
    public void logoutFromSite() {
        DashboardPage dashboardPage=new DashboardPage(browsersService);
        dashboardPage.userNavigationButtonClick();
        LoginPage loginPage=dashboardPage.logoutButtonClick();
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Given("browser is open and loginPage loaded")
    public void browserIsOpenAndLoginPageLoaded() {
        browsersService.SetupBrowser();
        browsersService.getDriver().get(properties.getURL());
    }
}
