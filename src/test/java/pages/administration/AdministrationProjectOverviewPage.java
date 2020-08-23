package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import models.Project;
import org.openqa.selenium.By;
import pages.AddProjectPages.ProjectPage;

public class AdministrationProjectOverviewPage extends BasePage {
    private By IDENTIFYPAGESELECTOR=By.className("header-menu-item-selected");
    private By VIEWALLPROJECTLINKSELECTOR= By.linkText("View projects");
    private By ADDNEWPROJECTLINKSELECTOR= By.linkText("Add a new project");
    private By VIEWUSERSANDROLELINKSELECTOR= By.linkText("View users & roles");
    private By ADDNEWUSERLINKSELECTOR= By.linkText("Add a new user");
    private By MANAGECUSTOMISATIONLINKSELECTOR= By.linkText("Manage customizations");
    private By MANAGEINTEGRATIONLINKSELECTOR= By.linkText("Manage integration");
    private By MANAGESUBSCRIPTIONLINKSELECTOR= By.linkText("Manage subscription");
    private By MANAGESITESETTINGLINKSELECTOR= By.linkText("Manage site settings");

    public AdministrationProjectOverviewPage(BrowsersService browsersService) {
        super(browsersService, true);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(By.className("header-menu-item-selected")).getText().equalsIgnoreCase("Overview");
    }

    public AdministrationProjectsPage projectLinkClick() {
        browsersService.getWaiters().waitForVisibility(VIEWALLPROJECTLINKSELECTOR).click();
        return new AdministrationProjectsPage(browsersService, true);
    }

    public AdministrationCustomizationPage customizationLinkClick() {
        browsersService.getWaiters().waitForVisibility(MANAGECUSTOMISATIONLINKSELECTOR).click();
        return new AdministrationCustomizationPage(browsersService, true);
    }

    public AdministrationIntegrationPage integrationLinkClick() {
        browsersService.getWaiters().waitForVisibility(MANAGEINTEGRATIONLINKSELECTOR).click();
        return new AdministrationIntegrationPage(browsersService,true);
    }

    public AdministrationSubscriptionPage subscriptionLinkClick() {
        browsersService.getWaiters().waitForVisibility(MANAGESUBSCRIPTIONLINKSELECTOR).click();
        return new AdministrationSubscriptionPage(browsersService,true);
    }

    public AdministrationUserAndRolePage userAndRoleLinkClick() {
        browsersService.getWaiters().waitForVisibility(VIEWUSERSANDROLELINKSELECTOR).click();
        return new AdministrationUserAndRolePage(browsersService,true);
    }

    public SiteSettingsPage siteSettingLinkClick() {
        browsersService.getWaiters().waitForVisibility(MANAGESITESETTINGLINKSELECTOR).click();
        return new SiteSettingsPage(browsersService,false);
    }

    public ProjectPage projectPageLinkClick() {
        browsersService.getWaiters().waitForVisibility(ADDNEWPROJECTLINKSELECTOR).click();
        return new ProjectPage(browsersService);
    }
}
