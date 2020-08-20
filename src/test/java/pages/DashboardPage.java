package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    private By ADDPROJECTBUTTONSELECTOR = By.id("sidebar-projects-add");

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
        browsersService.getWaiters().waitForVisibility(ADDPROJECTBUTTONSELECTOR).click();
        return new AddProjectPage(browsersService);
    }

}
