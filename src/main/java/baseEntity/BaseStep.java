package baseEntity;


import core.BrowsersService;
import models.AddProjectLombok;
import models.LoginInfoLombok;
import org.testng.log4testng.Logger;
import services.JDBCService;

public abstract class BaseStep {
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public BrowsersService browsersService;
    public AddProjectLombok addProjectLombok;
    public LoginInfoLombok loginInfoLombok;
    public BaseStep(BrowsersService browsersService) {
        this.browsersService = browsersService;
    }
}
