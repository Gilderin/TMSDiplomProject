package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministrationPage extends BasePage {
    private By PROJECTLINKSELECTOR= By.xpath("//div[@class = 'info-box-title']/a[. = 'Projects']");
    private By IDENTIFYPAGESELECTOR=By.xpath("//h1[. = 'Administration']");


    public AdministrationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/overview");
    }

    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(IDENTIFYPAGESELECTOR).isDisplayed();
    }

    public ProjectsPage projectLinkClick(){
        browsersService.getDriver().findElement(PROJECTLINKSELECTOR).click();
        return new ProjectsPage(browsersService, true);
    }
}
