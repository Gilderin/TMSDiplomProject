package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;

public class AdministrationIntegrationPage extends BasePage {
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public AdministrationIntegrationPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
}
