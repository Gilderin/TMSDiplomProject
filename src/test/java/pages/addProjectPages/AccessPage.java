package pages.addProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccessPage extends BasePage {
    private By DEFAULTACCESSSELECTOR = By.id("access");
    private By PROJECTACCESSSELECTOR = By.xpath("//div[@id='userAccessDropdown']//a[text()='replace']");

    public AccessPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(By.id("accept")).isDisplayed();
    }

    public void setDefaultAccess (String value) {
        WebElement selectElem = driver.findElement(DEFAULTACCESSSELECTOR);
        Select select = new Select(selectElem);
        select.selectByValue(value);
    }

}
