package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    private String URL = "https://aqa5master2.testrail.io/";

    private By EMAILSELECTOR = By.id("name");
    private By PASSWORDSELECTOR = By.id("password");
    private By LOGINBUTTON = By.id("button_primary");
    private By MESSAGESELECTOR=By.className("loginpage-message-title");
    private By MESSAGETEXTSELECTOR=By.className("error-text");


    public LoginPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        WebElement login=browsersService.getDriver().findElement(By.id("button_primary"));
        return login.isDisplayed();
    }

    public void setEmail(String email) {
        browsersService.getWaiters().waitForVisibility(EMAILSELECTOR).sendKeys(email);
    }

    public boolean messageTitleDisplayed(){
        return browsersService.getWaiters().waitForVisibility(MESSAGESELECTOR).isDisplayed();
    }
    public String errorMessageText(){
        return browsersService.getWaiters().waitForVisibility(MESSAGETEXTSELECTOR).getText();
    }


    public void setPassword(String password) {
        browsersService.getWaiters().waitForVisibility(PASSWORDSELECTOR).sendKeys(password);
    }

    public void loginButtonClick() {
        browsersService.getDriver().findElement(LOGINBUTTON).click();
    }



}