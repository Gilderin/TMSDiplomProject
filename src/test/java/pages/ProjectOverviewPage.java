package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectOverviewPage extends BasePage {
    @FindBy(className = "header-menu-item-selected")
    WebElement identifyPage;

    public ProjectOverviewPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return identifyPage.getText().equalsIgnoreCase("Overview");
    }
}
