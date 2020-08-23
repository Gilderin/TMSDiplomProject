package pages.AddProjectPages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DefectsPage extends BasePage {
    private By DEFECTVEIWSELECTOR = By.id("defect_id_url");
    private By DEFECTADDSELECTOR = By.id("defect_add_url");
    private By DEFECTPLUGINSELECTOR = By.id("defect_plugin");

    public DefectsPage(BrowsersService browsersService) {
        super(browsersService, false);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.id("accept")).isDisplayed();
    }

    public void setDefectPlugin (String value) {
        WebElement selectElem = driver.findElement(DEFECTPLUGINSELECTOR);
        Select select = new Select(selectElem);
        select.selectByValue(value);
    }

    public void setDefectVeiw (String veiwText) {
        browsersService.getWaiters().waitForVisibility(DEFECTVEIWSELECTOR).sendKeys(veiwText);
    }

    public void setDefectAdd (String addText) {
        browsersService.getWaiters().waitForVisibility(DEFECTADDSELECTOR).sendKeys(addText);
    }
}
