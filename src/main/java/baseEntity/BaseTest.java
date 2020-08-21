package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;
import services.JDBCService;
import utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTest {
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public BrowsersService browsersService;
    public ReadProperties properties;
    public JDBCService jdbcService;

    @BeforeClass
    public void openPage() {
        jdbcService = new JDBCService();
        jdbcService.connectionDB();
        browsersService = new BrowsersService();
        properties = new ReadProperties();
        browsersService.getDriver().get(properties.getURL());
    }

    @AfterClass
    public void closePage() {
        jdbcService.closeConnection();
        browsersService.getDriver().quit();
        browsersService = null;
    }
}