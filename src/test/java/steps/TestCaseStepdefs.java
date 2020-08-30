package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.testcasePages.AddTestCasePage;

public class TestCaseStepdefs extends BaseUtil {

    public TestCaseStepdefs(BrowsersService browsersService) {
        super(browsersService);
    }

    @When("go to add test case page")
    public void addProjectButtonClick() {
        DashboardPage dashboardPage = new DashboardPage(browsersService);
        OverviewPage overviewPage=dashboardPage.projectLinkClick(browsersService.addProjectLombok.getName());
        AddTestCasePage addTestCasePage=overviewPage.addTestCaseButtonClick();
        addTestCasePage.template();

    }
}
