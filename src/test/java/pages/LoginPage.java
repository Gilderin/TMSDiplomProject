package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {
    private String URL = "https://aqa5master2.testrail.io/";

    private By EMAILSELECTOR = By.id("name");
    private By PASSWORDSELECTOR = By.id("password");
    private By LOGINBUTTON = By.id("button_primary");
    public By IDENTIFYPAGE = By.id("button_primary");


    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.id("button_primary")) != null;
    }

    public void setEmail(String email) {
        browsersService.getWaiters().waitForVisibility(EMAILSELECTOR).sendKeys(email);
    }


    public void setPassword(String password) {
        browsersService.getWaiters().waitForVisibility(PASSWORDSELECTOR).sendKeys(password);
    }

    public DashboardPage loginButtonClick() {
        browsersService.getDriver().findElement(LOGINBUTTON).click();
        return new DashboardPage(browsersService);
    }
}