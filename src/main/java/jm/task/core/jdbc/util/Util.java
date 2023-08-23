package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL = "jdbc:mysql://localhost:3306/katapp1";
    private final static String USER = "root";
    private final static String PASSWORD = "14759530";

    public static boolean execute(String query) {
        try(Connection con = getConnection()) {
            return con.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }


}
