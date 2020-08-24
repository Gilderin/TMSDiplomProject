package pages.addProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class AddProjectPage extends BasePage {
    private By CURRENTPROJECTSELECTOR = By.cssSelector(".tab-header .tab1.current");
    private By CURRENTACCESSELECTOR = By.cssSelector(".tab-header .tab2.current");
    private By CURRENTDEFECTSSELECTOR = By.cssSelector(".tab-header .tab3.current");
    private By CURRENTREFERENCESSELECTOR = By.cssSelector(".tab-header .tab4.current");
    private By PROJECTLINKSELECTOR = By.cssSelector(".tab-header .tab1");
    private By ACCESSLINKSELECTOR = By.cssSelector(".tab-header .tab2");
    private By DEFECTSSELECTOR = By.cssSelector(".tab-header .tab3");
    private By REFERENCESSELECTOR = By.cssSelector(".tab-header .tab4");


    public AddProjectPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(By.id("accept")).isDisplayed();
    }

    public ProjectPage moveToProject() {
        try {
            browsersService.getDriver().findElement(CURRENTPROJECTSELECTOR);
        } catch (NoSuchElementException e) {
            browsersService.getWaiters().waitForVisibility(PROJECTLINKSELECTOR).click();
        }
        return new ProjectPage(browsersService);
    }


    public AccessPage moveToAccess() {
        try {
            browsersService.getDriver().findElement(CURRENTACCESSELECTOR);
        } catch (NoSuchElementException e) {
            browsersService.getWaiters().waitForVisibility(ACCESSLINKSELECTOR).click();
        }
        return new AccessPage(browsersService);
    }

    public DefectsPage moveToDefects() {
        try {
            browsersService.getDriver().findElement(CURRENTDEFECTSSELECTOR);
        } catch (NoSuchElementException e) {
            browsersService.getWaiters().waitForVisibility(DEFECTSSELECTOR).click();
        }
        return new DefectsPage(browsersService);
    }

    public ReferencesPage moveToReferences() {
        try {
            browsersService.getDriver().findElement(CURRENTREFERENCESSELECTOR);
        } catch (NoSuchElementException e) {
            browsersService.getWaiters().waitForVisibility(REFERENCESSELECTOR).click();
        }
        return new ReferencesPage(browsersService);
    }

}
