package pages.testcasePages;

import baseEntity.BasePage;
import core.BrowsersService;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class TestCasePage extends BasePage {
    private By TITLEOFCASESELECTOR=By.cssSelector(".content-header-title.page_title");
    private By ATTACHMENTSELECTOR=By.className("markdown-img");
    public TestCasePage(BrowsersService browsersService, boolean openPageByUrl) {
        super(browsersService, openPageByUrl);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        return browsersService.getWaiters().waitForVisibility(By.cssSelector(".content-header-title.page_title")).isDisplayed();
    }

    public boolean attachmentIsDisplayed(){
        try {
            return browsersService.getWaiters().waitForVisibility(ATTACHMENTSELECTOR).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public String getNameOfCase(){
        return  browsersService.getWaiters().waitForVisibility(TITLEOFCASESELECTOR).getText();
    }
}
