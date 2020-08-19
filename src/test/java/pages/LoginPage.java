package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private String URL = "https://aqa5master.testrail.io/";

    @FindBy(id = "name")
    public WebElement email;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "button_primary")
    public WebElement loginButton;
    @FindBy(id = "button_primary")
    public WebElement identifyPage;


    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return identifyPage.isDisplayed();
    }

    public DashboardPage loginButtonClick(){
        loginButton.click();
        return new DashboardPage(browsersService);
    }
}