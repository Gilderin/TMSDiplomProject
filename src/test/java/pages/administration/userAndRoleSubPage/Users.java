package pages.administration.userAndRoleSubPage;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class Users extends BasePage {
    private By ADDSINGLEUSERBUTTONSELECTOR = By.partialLinkText("Add User");
    private By ADDMULTIUSERSBUTTONSELECTOR = By.partialLinkText("Add Multiple Users");

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(ADDSINGLEUSERBUTTONSELECTOR).isDisplayed();
    }

    public Users(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public void addUserButtonClick() {
        browsersService.getWaiters().waitForVisibility(ADDSINGLEUSERBUTTONSELECTOR).click();
    }

    public void addMultipleUsersButtonClick() {
        browsersService.getWaiters().waitForVisibility(ADDMULTIUSERSBUTTONSELECTOR).click();
    }
}
