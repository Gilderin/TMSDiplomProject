package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;

public class AdministrationUserAndRolePage extends BasePage {
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public AdministrationUserAndRolePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }
}
