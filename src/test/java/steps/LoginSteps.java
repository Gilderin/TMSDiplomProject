package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import models.LoginInfoLombok;
import pages.LoginPage;
import services.JDBCService;
import utils.SQLqueries;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSteps extends BaseStep {
    public LoginSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public void getLogin(Integer id) {
        JDBCService jdbcService = new JDBCService();
        SQLqueries sqLqueries = new SQLqueries();
        LoginInfoLombok loginInfoLombok= LoginInfoLombok.builder().build();
        jdbcService.connectionDB();
        try {
            ResultSet res = jdbcService.executeQuery(sqLqueries.LoginInformationSelect(id));
            while (res.next()) {
                loginInfoLombok.setEmail(res.getString("email"));
                loginInfoLombok.setPassword(res.getString("password"));
            }
        }catch (SQLException throwables){
            logger.error(throwables.getMessage());
        }
    }

    public void login() {
        LoginInfoLombok loginInfoLombok= LoginInfoLombok.builder().build();
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(loginInfoLombok.getEmail());
        loginPage.setPassword(loginInfoLombok.getPassword());
        loginPage.loginButtonClick();
    }
}
