package pages.milestonesPages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

public class AddMilestonesPage extends BasePage {
    private By NEMEMILESTONEFIELDSELECTOR = By.id("name");
    private By REFERENCESFIELSDSELECTOR = By.id("reference");
    private By DDESCRIPTIONFIELDSELECTOR = By.id("description");
    private By STARTDATEFIELDSELECTOR = By.id("start_on");
    private By ENDDATEFIELDSELECTOR=By.id("due_on");
    private By MILESTONEISCOMPLETEDCHECKBOXSELECTOR=By.id("is_completed");
    public AddMilestonesPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equals("Add Milestone - TestRail");
    }
}
