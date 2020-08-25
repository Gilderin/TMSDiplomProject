package steps;

import baseEntity.BaseTest;
import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import models.AddProjectLombok;
import models.LoginInfoLombok;
import services.JDBCService;

public class Hook extends BaseTest {

    public Hook(BrowsersService browserService) {
        this.browsersService=browserService;
    }

    @Before
    public void initializeTest() {
        jdbcService = new JDBCService();
        jdbcService.connectionDB();
        browsersService = new BrowsersService();
        properties = new ReadProperties();
        driver = this.browsersService.getDriver();
        //driver.get(browsersService.getProperties().getURL());
    }

    @After
    public void tearDown() {
        browsersService.getDriver().quit();
        browsersService = null;
    }



}
