package pages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import pages.addProjectPages.AddProjectPage;
import pages.administration.AdministrationPage;

public class DashboardPage extends BasePage {
    private By ADDPROJECTBUTTONSELECTOR = By.id("sidebar-projects-add");
    private By WHATNEWSFORMSELECTOR= By.id("announcementForm");
    private By CLOSEWHATNEWFORMBUTTON=By.cssSelector(".ui-icon.ui-icon-closethick");
    private By USERNAVIGATIONDROPDOWNSELECTOR=By.id("navigation-user");
    private By LOGOUTUSERBUTTONSELECTOR=By.id("navigation-user-logout");
    private By ADMINISTRATIONBUTTONSELECTOR=By.id("navigation-admin");
    public DashboardPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equalsIgnoreCase("All Projects - TestRail");
    }

    public AddProjectPage addProjectButtonClick(){
        browsersService.getWaiters().waitForVisibility(ADDPROJECTBUTTONSELECTOR).click();
        return new AddProjectPage(browsersService);
    }

    public void userNavigationButtonClick(){
        browsersService.getWaiters().waitForVisibility(USERNAVIGATIONDROPDOWNSELECTOR).click();
    }

    public String userNavigationText(){
        return browsersService.getWaiters().waitForVisibility(USERNAVIGATIONDROPDOWNSELECTOR).getText();
    }

    public LoginPage logoutButtonClick(){
        browsersService.getWaiters().waitForVisibility(LOGOUTUSERBUTTONSELECTOR).click();
        return new LoginPage(browsersService);
    }

    public AdministrationPage administrationButtonClick(){
        browsersService.getWaiters().waitForVisibility(ADMINISTRATIONBUTTONSELECTOR).click();
        return new AdministrationPage(browsersService,false);
    }

}
