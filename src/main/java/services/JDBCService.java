package services;

import baseEntity.BaseTest;

import java.sql.*;

public class JDBCService extends BaseTest {
    private static Connection connection = null;
    private static Statement statement = null;

    public  void connectionDB(){
        logger.info("Setup JDBC connector");

        String host = "localhost";
        String port = "5432";
        String database = "postgres";
        String username = "postgres";
        String password = "Andrey17";
        String db_URL = "jdbc:postgresql://" + host + ":" + port + "/" + database;

        try {
            Class.forName("org.postgresql.Driver");
            logger.info("Class has been found");

            connection = DriverManager.getConnection(db_URL, username, password);
            logger.info("Connection has been establihed");
            logger.info("Setup statement");

            statement = connection.createStatement();
            logger.info("Statement has been created");
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }


    public void closeConnection() {
        try {
            if (!statement.isClosed()) {
                statement.close();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTableProject() {
        String sqlQuery="Create Table IF NOT EXISTS Project" +
                " (id SERIAL primary key," +
                " ProjectName character varying(100)," +
                " Announcement character varying(500)," +
                " ShowAnnouncment boolean," +
                " ProjectType character varying(500))";
        try {
            statement.execute(sqlQuery);
        }catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    public void insertTestData(){
        String sqlInsert = "INSERT INTO public.\"project\" (projectname, announcement, showannouncment, projecttype) VALUES" +
                " ('AndreysProject1', 'lalalala', true, 'Use a single repository for all cases (recommended)')," +
                " ('', 'opaa', false, 'Use a single repository with baseline support');";
        try {
            statement.execute(sqlInsert);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
    public void deleteTableProject(){
        String sqlQuery="Drop Table project";
        try {
            statement.execute(sqlQuery);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
