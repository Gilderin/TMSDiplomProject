package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import models.AddProjectLombok;
import models.LoginInfoLombok;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.log4testng.Logger;
import services.JDBCService;
import utils.Listener;

@Listeners(Listener.class)
public abstract class BaseTest {
    public WebDriver driver;
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public BrowsersService browsersService;
    public ReadProperties properties;
    public JDBCService jdbcService;

}