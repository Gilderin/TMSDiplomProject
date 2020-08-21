package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class ProjectOverviewPage extends BasePage {
    private By IDENTIFYPAGESELECTOR=By.className("header-menu-item-selected");

    public ProjectOverviewPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(IDENTIFYPAGESELECTOR).getText().equalsIgnoreCase("Overview");
    }
}
