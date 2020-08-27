package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import pages.addProjectPages.AddProjectPage;

public class DashboardPage extends BasePage {
    private By ADDPROJECTBUTTONSELECTOR = By.id("sidebar-projects-add");
    private By WHATNEWSFORMSELECTOR= By.id("announcementForm");
    private By CLOSEWHATNEWFORMBUTTON=By.cssSelector(".ui-icon.ui-icon-closethick");
    private By USERNAVIGATIONDROPDOWNSELECTOR=By.id("navigation-user");
    private By LOGOUTUSERBUTTONSELECTOR=By.id("navigation-user-logout");
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

    public void userNavigationButtonClick(){
        browsersService.getWaiters().waitForVisibility(USERNAVIGATIONDROPDOWNSELECTOR).click();
    }
    public boolean userNavigationIsDisplayed(){
        return browsersService.getWaiters().waitForVisibility(USERNAVIGATIONDROPDOWNSELECTOR).isDisplayed();
    }

    public String userNavigationText(){
        return browsersService.getWaiters().waitForVisibility(USERNAVIGATIONDROPDOWNSELECTOR).getText();
    }

    public LoginPage logoutButtonClick(){
        browsersService.getWaiters().waitForVisibility(LOGOUTUSERBUTTONSELECTOR).click();
        return new LoginPage(browsersService);
    }

}
