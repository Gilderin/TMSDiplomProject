package pages.testcasePages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class AddTestCasePage extends BasePage {
    private By TITLECASEFIELD = By.id("title");
    private By SECTIONSELECTOR = By.id("section_id");
    private By TEMPLATESELECTOR = By.id("template_id");
    private By ESTIMATEFIELDSELECTOR = By.id("estimate");
    private By PRECONDITIONSFIELDSELECTOR = By.id("custom_preconds");
    private By STEPSFIELDSELECTOR = By.id("custom_steps");
    private By EXPECTEDRESULTFIELDSELECTOR = By.id("custom_expected");
    private By ADDCASEBUTTONSELECTOR = By.id("accept");
    private By ADDANDNEXTBUTTONSELECTOR = By.id("accept_and_next");
    private By CANCELBUTTONSELECTOR = By.cssSelector(".button-cancel.case-form-cancel");

    public AddTestCasePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equals("Add Test Case - TestRail");
    }

    public void setTitleOfCase(String title) {
        browsersService.getWaiters().waitForVisibility(TITLECASEFIELD).sendKeys(title);
    }

    public void setEstimateOfCase(String estimate) {
        browsersService.getWaiters().waitForVisibility(ESTIMATEFIELDSELECTOR).sendKeys(estimate);
    }

    public void setPreconditionOfCase(String precondition) {
        browsersService.getWaiters().waitForVisibility(PRECONDITIONSFIELDSELECTOR).sendKeys(precondition);
    }

    public void setStepsOfCases(String steps) {
        browsersService.getWaiters().waitForVisibility(STEPSFIELDSELECTOR).sendKeys(steps);
    }

    public void setExpectedConditionOfCase(String condition){
        browsersService.getWaiters().waitForVisibility(EXPECTEDRESULTFIELDSELECTOR).sendKeys(condition);
    }

    public void addButtonClick(){
        ((JavascriptExecutor) browsersService.getDriver()).executeScript("arguments[0].scrollIntoView(true);", browsersService.getDriver().findElement(ADDCASEBUTTONSELECTOR));
        browsersService.getWaiters().waitForVisibility(ADDCASEBUTTONSELECTOR).click();
    }
}
