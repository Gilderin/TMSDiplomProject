package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends BasePage {
    @FindBy(id = "accept")
    public WebElement addProjectButton;
    @FindBy(id = "name")
    public WebElement name;
    @FindBy(id = "suite_mode_single")
    public WebElement suiteModeSingle;
    @FindBy(id = "suite_mode_single_baseline")
    public WebElement suiteModeSingleBaseline;
    @FindBy(id = "suite_mode_multi")
    public WebElement suiteModeMulti;
    @FindBy(id = "accept")
    public WebElement identifyPage;
    @FindBy(className = "message-error")
    public WebElement messageErrorCreation;

    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return identifyPage.isDisplayed();
    }

}
