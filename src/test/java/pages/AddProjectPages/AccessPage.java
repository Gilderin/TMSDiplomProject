package pages.AddProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;

public class AccessPage extends BasePage {

    public AccessPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}
