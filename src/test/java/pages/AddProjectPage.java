package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {
    private By ADDPROJECTBUTTONSELECTOR = By.id("accept");
    private By NAMESELECTOR = By.id("name");
    private By SUITEMODENGLESELECTOR = By.id("suite_mode_single");
    private By SUITEMODESINGLEBASELINESELECTOR = By.id("suite_mode_single_baseline");
    private By SUITEMODEMULTISELECTOR = By.id("suite_mode_multi");
    private By IDENTIFYPAGESELECTOR = By.id("accept");
    private By MASSAGEERRORCREATIONSELECTOR = By.className("message-error");

    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(IDENTIFYPAGESELECTOR).isDisplayed();
    }

}
