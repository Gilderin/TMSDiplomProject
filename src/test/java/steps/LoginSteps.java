package steps;

import baseEntity.BaseStep;
import core.BrowsersService;
import models.LoginInfoLombok;
import pages.DashboardPage;
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
        loginInfoLombok= LoginInfoLombok.builder().build();
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
        //return loginInfoLombok;
    }

    public void login(LoginInfoLombok loginInfoLombok) {
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(loginInfoLombok.getEmail());
        loginPage.setPassword(loginInfoLombok.getPassword());
        loginPage.loginButtonClick();
    }

    public void login(String email,String password){
        LoginPage loginPage = new LoginPage(browsersService);
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.loginButtonClick();
    }

    public LoginPage logout(){
        DashboardPage dashboardPage=new DashboardPage(browsersService);
        dashboardPage.userNavigationButtonClick();
        return dashboardPage.logoutButtonClick();
    }
}
