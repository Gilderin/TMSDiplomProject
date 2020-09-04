package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseUtil {

    public Hook(BrowsersService browsersService) {
        super(browsersService);
    }

    @After
    public void tearDown() {
        if (browsersService.getDriver() != null)
            browsersService.getDriver().quit();
        browsersService = null;
    }
}
