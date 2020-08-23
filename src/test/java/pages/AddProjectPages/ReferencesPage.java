package pages.AddProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class ReferencesPage extends BasePage {

    public ReferencesPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.id("accept")).isDisplayed();
    }
}
