package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;

public class AdministrationCustomizationPage extends BasePage {
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public AdministrationCustomizationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
}
