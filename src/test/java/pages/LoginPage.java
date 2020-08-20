package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    private String URL = "https://aqa5master2.testrail.io/";

    private By EMAIL = By.id("name");
    private By PASSWORD = By.id("password");
    private By LOGINBUTTON = By.id("button_primary");
    private By IDENTIFYPAGE = By.id("button_primary");



    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(IDENTIFYPAGE).isDisplayed();
    }

    public void setEmail(String email) {
        browsersService.getWaiters().waitForVisibility(EMAIL).sendKeys(email);
    }


    public void setPassword(String password) {
        browsersService.getWaiters().waitForVisibility(PASSWORD).sendKeys(password);
    }

    public DashboardPage loginButtonClick(){
        browsersService.getDriver().findElement(LOGINBUTTON).click();
        return new DashboardPage(browsersService);
    }
}