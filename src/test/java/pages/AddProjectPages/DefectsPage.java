package pages.AddProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;

public class DefectsPage extends BasePage {

    public DefectsPage(BrowsersService browsersService) {
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
