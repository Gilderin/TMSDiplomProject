package baseEntity;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.log4testng.Logger;
import services.JDBCService;
import utils.SQLqueries;

public abstract class BaseUtil {
    public static Logger logger = Logger.getLogger(JDBCService.class);
    public BrowsersService browsersService;
    public ReadProperties properties;
    public JDBCService jdbcService;
    public SQLqueries sqLqueries;

    public BaseUtil(BrowsersService browsersService) {
        this.browsersService = browsersService;
        properties=new ReadProperties();
        jdbcService=new JDBCService();
        sqLqueries=new SQLqueries();
    }
}
