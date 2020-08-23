package pages.AddProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ProjectPage extends BasePage {
    private By ADDPROJECTBUTTONSELECTOR = By.id("accept");
    private By NAMESELECTOR = By.id("name");
    private By SUITEMODESINGLESELECTOR = By.id("suite_mode_single");
    private By SUITEMODESINGLEBASELINESELECTOR = By.id("suite_mode_single_baseline");
    private By SUITEMODEMULTISELECTOR = By.id("suite_mode_multi");
    private By IDENTIFYPAGESELECTOR = By.id("accept");
    private By MASSAGEERRORCREATIONSELECTOR = By.className("message-error");
    private By ANNOUNCMENTSELECTOR = By.id("announcement");
    private By SHOWANNOUNCMENTSELECTOR = By.id("show_announcement");

    public ProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.id("accept")).isDisplayed();
    }

    public void AddProjectButtonClick () {
        ((JavascriptExecutor) browsersService.getDriver()).executeScript("arguments[0].scrollIntoView(true);", browsersService.getDriver().findElement(ADDPROJECTBUTTONSELECTOR));
        browsersService.getDriver().findElement(ADDPROJECTBUTTONSELECTOR).click();
    }

    public void setProjectName (String name) {
        browsersService.getWaiters().waitForVisibility(NAMESELECTOR).sendKeys(name);
    }

    public void setSuiteModeSingle () {
        browsersService.getDriver().findElement(SUITEMODESINGLESELECTOR).click();
    }

    public void setSuiteModeSingleBaseLine () {
        browsersService.getDriver().findElement(SUITEMODESINGLEBASELINESELECTOR).click();
    }

    public void setSuiteModeMulti () {
        browsersService.getDriver().findElement(SUITEMODEMULTISELECTOR).click();
    }

    public void setProjectAnnouncement (String announcement) {
        browsersService.getWaiters().waitForVisibility(ANNOUNCMENTSELECTOR).sendKeys(announcement);
    }

    public void clickShowAnnouncement () {
        browsersService.getWaiters().waitForVisibility(SHOWANNOUNCMENTSELECTOR).click();
    }

    public String getErrorMesage () {
        return browsersService.getDriver().findElement(MASSAGEERRORCREATIONSELECTOR).getText();
    }

}
