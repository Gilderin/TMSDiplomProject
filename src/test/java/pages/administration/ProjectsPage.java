package pages.administration;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    private By CONFIRMATIONYESCHECKBOXSELECTOR=By.cssSelector("#dialog-ident-deleteDialog input");
    private By CONFIRMATIONOKBUTTONSELECTOR=By.cssSelector("#dialog-ident-deleteDialog .button-ok");
    private By SUCCESSMESSAGESELECTOR=By.className("message-success");
    @FindBy(css = "#dialog-ident-deleteDialog input")
    public WebElement confirmationYesCheckbox;
    @FindBy(css = "#dialog-ident-deleteDialog .button-ok")
    public WebElement confirmationOkButton;
    @FindBy(className = "message-success")
    public WebElement messageSuccess;


    public ProjectsPage(BrowsersService browsersService, boolean openPageByUrl) {
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
        WebElement itemLink=browsersService.getDriver().findElement(By.linkText(projectName));
        return itemLink;
    }

    public void confirmationYesCheckboxClick() {
        browsersService.getDriver().findElement(CONFIRMATIONYESCHECKBOXSELECTOR).click();
    }

    public void deleteIconClick(String projectName) {
        String deleteIcon="//*[text()='replace']/../..//*[@class='icon-small-delete']";
        String tmpIconSelector=deleteIcon.replace("replace",projectName);
        WebElement element = browsersService.getDriver().findElement(By.xpath(tmpIconSelector));
        element.click();
    }

    public void confirmationOkButtonClik() {
        browsersService.getDriver().findElement(CONFIRMATIONOKBUTTONSELECTOR).click();
    }

    public String getMessageSuccessText() {
        return browsersService.getDriver().findElement(SUCCESSMESSAGESELECTOR).getText();
    }

}
