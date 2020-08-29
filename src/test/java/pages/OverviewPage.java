package pages;

import baseEntity.BasePage;
import baseEntity.BaseUtil;
import core.BrowsersService;
import org.openqa.selenium.By;

public class OverviewPage extends BasePage {

    private By PROJECTNAMESELECTOR=By.id("navigation-project");

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.id("navigation-project")).isDisplayed();
    }

    public OverviewPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
}
