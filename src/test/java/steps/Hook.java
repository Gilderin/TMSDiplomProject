package steps;

import core.ReadProperties;
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
        //properties=new ReadProperties();
    }

    @After
    public void tearDown() {
        if(browsersService.getDriver()!=null)
        browsersService.getDriver().quit();
        browsersService = null;
    }
}
