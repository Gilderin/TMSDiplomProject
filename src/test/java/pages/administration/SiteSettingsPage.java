package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;

public class SiteSettingsPage extends BasePage {
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public SiteSettingsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
}
