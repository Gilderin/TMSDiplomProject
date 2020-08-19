package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    @FindBy(id = "sidebar-projects-add")
    public WebElement addProjectButton;

    public DashboardPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equalsIgnoreCase("All Projects - TestRail");
    }

    public AddProjectPage addProjectPageClick(){
        addProjectButton.click();
        return new AddProjectPage(browsersService);
    }

}
