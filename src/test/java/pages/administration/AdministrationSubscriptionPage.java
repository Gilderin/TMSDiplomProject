package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;

public class AdministrationSubscriptionPage extends BasePage {
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public AdministrationSubscriptionPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
}
