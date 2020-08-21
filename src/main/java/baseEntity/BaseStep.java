package baseEntity;


import core.BrowsersService;
import org.testng.log4testng.Logger;
import services.JDBCService;

public abstract class BaseStep {
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public BrowsersService browsersService;

    public BaseStep(BrowsersService browsersService) {
        this.browsersService = browsersService;
    }
}
