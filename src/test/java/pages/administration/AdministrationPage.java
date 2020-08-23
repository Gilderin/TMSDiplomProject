package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class AdministrationPage extends BasePage {
    private By PROJECTLINKSELECTOR = By.id("navigation-sub-projects");
    private By OVERVIEWLINKSELECTOR = By.id("navigation-sub-overview");
    private By USERANDROLELINKSELECTOR = By.id("navigation-sub-users");
    private By CUSTOMIZATIONLINKSELECTOR = By.id("navigation-sub-customization");
    private By INTEGRATIONLINKSELECTOR = By.id("navigation-sub-integration");
    private By SUBBSCRITIONLINKSELECTOR = By.id("navigation-sub-subscription");
    private By SITESETTINGLINKSELECTOR = By.id("navigation-sub-sitesettings");

    private By IDENTIFYPAGESELECTOR = By.xpath("//h1[. = 'Administration']");


    public AdministrationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/overview");
    }

    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(By.xpath("//h1[. = 'Administration']")).isDisplayed();
    }

    public AdministrationProjectsPage projectLinkClick() {
        browsersService.getWaiters().waitForVisibility(PROJECTLINKSELECTOR).click();
        return new AdministrationProjectsPage(browsersService, true);
    }

    public AdministrationCustomizationPage customizationLinkClick() {
        browsersService.getWaiters().waitForVisibility(CUSTOMIZATIONLINKSELECTOR).click();
        return new AdministrationCustomizationPage(browsersService, true);
    }

    public AdministrationIntegrationPage integrationLinkClick() {
        browsersService.getWaiters().waitForVisibility(INTEGRATIONLINKSELECTOR).click();
        return new AdministrationIntegrationPage(browsersService,true);
    }

    public AdministrationSubscriptionPage subscriptionLinkClick() {
        browsersService.getWaiters().waitForVisibility(SUBBSCRITIONLINKSELECTOR).click();
        return new AdministrationSubscriptionPage(browsersService,true);
    }

    public AdministrationProjectOverviewPage overviewLinkClick() {
        browsersService.getWaiters().waitForVisibility(OVERVIEWLINKSELECTOR).click();
        return new AdministrationProjectOverviewPage(browsersService);
    }

    public AdministrationUserAndRolePage userAndRoleLinkClick() {
        browsersService.getWaiters().waitForVisibility(USERANDROLELINKSELECTOR).click();
        return new AdministrationUserAndRolePage(browsersService,true);
    }

    public SiteSettingsPage siteSettingLinkClick() {
        browsersService.getWaiters().waitForVisibility(SITESETTINGLINKSELECTOR).click();
        return new SiteSettingsPage(browsersService,false);
    }


}
