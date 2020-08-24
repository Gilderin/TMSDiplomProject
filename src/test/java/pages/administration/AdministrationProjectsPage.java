package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.addProjectPages.ProjectPage;

public class AdministrationProjectsPage extends BasePage {
    private By CONFIRMATIONYESCHECKBOXSELECTOR=By.cssSelector("#dialog-ident-deleteDialog input");
    private By CONFIRMATIONOKBUTTONSELECTOR=By.cssSelector("#dialog-ident-deleteDialog .button-ok");
    private By SUCCESSMESSAGESELECTOR=By.className("message-success");
    private By ADDNEWPROJECTBUTTONSELECTOR=By.cssSelector(".button-group.grid-buttons");
    public AdministrationProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(browsersService.getBaseUrl() + "index.php?/admin/projects/overview");
    }

    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equalsIgnoreCase("Projects - TestRail");
    }

    public WebElement getProjectItemLink(String projectName) {
        return browsersService.getWaiters().waitForVisibility(By.linkText(projectName));
    }

    public void confirmationYesCheckboxClick() {
        browsersService.getWaiters().waitForVisibility(CONFIRMATIONYESCHECKBOXSELECTOR).click();
    }

    public void deleteIconClick(String projectName) {
        String deleteIcon="//*[text()='replace']/../..//*[@class='icon-small-delete']";
        String tmpIconSelector=deleteIcon.replace("replace",projectName);
        WebElement element = browsersService.getDriver().findElement(By.xpath(tmpIconSelector));
        element.click();
    }

    public void confirmationOkButtonClik() {
        browsersService.getWaiters().waitForVisibility(CONFIRMATIONOKBUTTONSELECTOR).click();
    }

    public String getMessageSuccessText() {
        return browsersService.getWaiters().waitForVisibility(SUCCESSMESSAGESELECTOR).getText();
    }

    public ProjectPage addProjectButtonClick(){
        browsersService.getWaiters().waitForVisibility(ADDNEWPROJECTBUTTONSELECTOR).click();
        return new ProjectPage(browsersService);
    }

}
