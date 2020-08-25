package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class AdministrationCustomizationPage extends BasePage {
    private By ADDCASEFIELDBUTTONSELECTOR= By.partialLinkText("Add Field");

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equals("Customizations - TestRail");
    }

    public AdministrationCustomizationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
    public void addCaseFieldButtonClick(){
        browsersService.getWaiters().waitForVisibility(ADDCASEFIELDBUTTONSELECTOR).click();
    }
}
