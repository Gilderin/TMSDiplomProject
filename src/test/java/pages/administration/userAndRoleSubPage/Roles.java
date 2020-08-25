package pages.administration.userAndRoleSubPage;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class Roles extends BasePage {
private By ADDROLEBUTTONSELECTOR=By.partialLinkText("Add Role");

    public Roles(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(ADDROLEBUTTONSELECTOR).isDisplayed();
    }

    public void addRolesButtonClick(){
        browsersService.getWaiters().waitForVisibility(ADDROLEBUTTONSELECTOR).click();
    }
}
