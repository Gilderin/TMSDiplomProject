package pages.administration.userAndRoleSubPage;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class Groups extends BasePage {
    private By ADDGROUPSBUTTONSELECTOR = By.partialLinkText("Add Group");
    public Groups(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(ADDGROUPSBUTTONSELECTOR).isDisplayed();
    }

    public void addGroupsButtonClick() {
        browsersService.getWaiters().waitForVisibility(ADDGROUPSBUTTONSELECTOR).click();
    }
}
