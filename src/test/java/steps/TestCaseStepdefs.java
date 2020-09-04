package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import models.TestCasesInfo;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.testcasePages.AddTestCasePage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestCaseStepdefs extends BaseUtil {

    public TestCaseStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("\"Add test case\" button click")
    @When("go to add test case page")
    public void addProjectButtonClick() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        OverviewPage overviewPage = dashboardPage.projectLinkClick(browsersService.addProjectInfo.getName());
        overviewPage.addTestCaseButtonClick();
    }

    @Step("Get information about test case from DB")
    @Given("testCase info from db where id = {int}")
    public void getTestCasesInformation(Integer id) {
        browsersService.testCasesInfo = TestCasesInfo.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.TestCasesInformationSelect(id));
            while (res.next()) {
                browsersService.testCasesInfo.setTitle(res.getString("title"));
                browsersService.testCasesInfo.setEstimate(res.getString("estimate"));
                browsersService.testCasesInfo.setPriorityId(res.getInt("priority"));
                browsersService.testCasesInfo.setTemplateId(res.getInt("template"));
                browsersService.testCasesInfo.setTypeId(res.getInt("type"));
            }
            jdbcService.closeConnection();
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    @Step("Creating test case on UI")
    @Then("create testcase onUI")
    public void createTestcaseOnUI() {
        AddTestCasePage addTestCasePage = new AddTestCasePage(browsersService, false);
        addTestCasePage.setTitleOfCase(browsersService.testCasesInfo.getTitle());
        addTestCasePage.setEstimateOfCase(browsersService.testCasesInfo.getEstimate());
        addTestCasePage.addButtonClick();
    }
}
