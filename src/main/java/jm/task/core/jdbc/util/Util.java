package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL = "jdbc:mysql://localhost:3306/kataPP1";
    private final static String USER = "root";
    private final static String PASSWORD = "14759530";

    public static boolean execute(String query) {
        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return con.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ResultSet executeQuery(String query) {

        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return con.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ResultSet) new Object();
    }


}
