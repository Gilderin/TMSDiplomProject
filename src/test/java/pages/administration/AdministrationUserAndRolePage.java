package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import pages.administration.userAndRoleSubPage.Groups;
import pages.administration.userAndRoleSubPage.Roles;
import pages.administration.userAndRoleSubPage.Users;

public class AdministrationUserAndRolePage extends BasePage {
    private By USERTABUSERSSELECTOR=By.id("");
    private By USERTABGROUPSSELECTOR=By.id("");
    private By USERTABROLESSELECTOR=By.id("");
    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equals("Users & Roles - TestRail");
    }

    public AdministrationUserAndRolePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    public Users usersTabClick(){
        browsersService.getWaiters().waitForVisibility(USERTABUSERSSELECTOR).click();
        return  new Users(browsersService,true);
    }
    public Groups groupsTabClick(){
        browsersService.getWaiters().waitForVisibility(USERTABGROUPSSELECTOR).click();
        return  new Groups(browsersService,true);
    }
    public Roles rolesTabClick(){
        browsersService.getWaiters().waitForVisibility(USERTABROLESSELECTOR).click();
        return  new Roles(browsersService,true);
    }
}
