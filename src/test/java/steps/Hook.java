package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class Hook extends BaseUtil {

    public Hook(BrowsersService browsersService) {
        super(browsersService);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (browsersService.getDriver() != null) {
            try {
                if (scenario.isFailed()) {
                    byte[] screenshot = ((TakesScreenshot) browsersService.getDriver()).getScreenshotAs(OutputType.BYTES);
                    scenario.attach(screenshot, "image/png", "Screenshot");
                    saveScreenshot(screenshot);
                }
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots);
            }
            browsersService.getDriver().quit();
            browsersService = null;
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
