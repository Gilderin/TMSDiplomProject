package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import baseEntity.BaseTest;
import core.BrowsersService;

public class Hook extends BaseTest {
    public Hook(BrowsersService browsersService) {
        this.browsersService = browsersService;
    }

    @Before
    public void initializeTest() {
        this.browsersService.SetupBrowser();
        driver = this.browsersService.getDriver();
        driver.get(browsersService.getBaseUrl());
    }

    @After
    public void tearDown() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}
