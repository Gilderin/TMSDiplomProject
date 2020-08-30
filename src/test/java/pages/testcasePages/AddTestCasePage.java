package pages.testcasePages;

import baseEntity.BasePage;
import core.BrowsersService;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddTestCasePage extends BasePage {
    private By TITLECASEFIELD= By.id("title");
    private By SECTIONSELECTOR=By.id("section_id");
    private By TEMPLATESELECTOR=By.id("template_id");
    public AddTestCasePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getDriver().getTitle().equals("Add Test Case - TestRail");
    }

    public void template(){
        Select select= new Select(browsersService.getDriver().findElement(TEMPLATESELECTOR));
        select.selectByValue("3");
    }
}
