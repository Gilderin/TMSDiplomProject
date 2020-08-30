package steps;

import baseEntity.BaseUtil;
import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import models.LoginInfoLombok;
import services.JDBCService;

public class Hook extends BaseUtil {

    public Hook(BrowsersService browsersService) {
        super(browsersService);
    }

    @Before
    public void initializeTest() {

    }

    @After
    public void tearDown() {
        if (browsersService.getDriver() != null)
            browsersService.getDriver().quit();
        browsersService = null;
    }
}
