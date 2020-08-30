package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import pages.testcasePages.AddTestCasePage;

public class OverviewPage extends BasePage {

    private By PROJECTNAMESELECTOR = By.id("navigation-project");
    private By ADDMILESTONESSELECTOR = By.id("sidebar-milestones-add");
    private By VIEWALLMILESTONESSELECTOR = By.id("sidebar-milestones-viewall");
    private By ADDTESTRUNSSELECTOR = By.id("sidebar-runs-add");
    private By VIEWALLTESTRUNSSELECTOR = By.id("sidebar-runs-viewall");
    private By ADDTESTCASESSELECTOR = By.id("sidebar-cases-add");
    private By VIEWALLTESTCASESSELECTOR = By.id("sidebar-suites-viewall");
    private By EDITPROJECTBUTTONSELECTOR = By.cssSelector(".button-edit");

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.id("navigation-project")).isDisplayed();
    }

    public OverviewPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public String nameOfProject() {
        return browsersService.getWaiters().waitForVisibility(PROJECTNAMESELECTOR).getText();
    }

    public void addMilestoneButtonClick() {
        browsersService.getWaiters().waitForVisibility(ADDMILESTONESSELECTOR).click();
    }

    public void viewAllMilestoneButtonClick() {
        browsersService.getWaiters().waitForVisibility(VIEWALLMILESTONESSELECTOR).click();
    }

    public void addTestRunButtonClick() {
        browsersService.getWaiters().waitForVisibility(ADDTESTRUNSSELECTOR).click();
    }

    public void viewAllTestRunsButtonClick() {
        browsersService.getWaiters().waitForVisibility(VIEWALLTESTRUNSSELECTOR).click();
    }

    public AddTestCasePage addTestCaseButtonClick() {
        browsersService.getWaiters().waitForVisibility(ADDTESTCASESSELECTOR).click();
        return new AddTestCasePage(browsersService,false);
    }

    public void viewAllTestCasesButtonClick() {
        browsersService.getWaiters().waitForVisibility(VIEWALLTESTCASESSELECTOR).click();
    }

    public void editProjectButtonClick() {
        browsersService.getWaiters().waitForVisibility(EDITPROJECTBUTTONSELECTOR).click();
    }
}
