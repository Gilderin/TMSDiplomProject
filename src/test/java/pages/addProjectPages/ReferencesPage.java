package pages.addProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class ReferencesPage extends BasePage {
    private By REFERENCEVIEWSELECTOR = By.id("reference_id_url");
    private By REFERENCEADDSELECTOR = By.id("reference_add_url");


    public ReferencesPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().findElement(By.id("accept")).isDisplayed();
    }

    public void setReferenceVeiw (String veiwText) {
        browsersService.getWaiters().waitForVisibility(REFERENCEVIEWSELECTOR).sendKeys(veiwText);
    }

    public void setReferenceAdd (String addText) {
        browsersService.getWaiters().waitForVisibility(REFERENCEADDSELECTOR).sendKeys(addText);
    }
}
