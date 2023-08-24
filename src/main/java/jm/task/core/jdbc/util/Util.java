package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.*;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String URL = "jdbc:mysql://localhost:3306/katapp1";
    private final static String USER = "root";
    private final static String PASSWORD = "14759530";

    public static boolean execute(String query) {
        try (Connection con = getConnection()) {
            return con.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.URL, URL);
        properties.put(Environment.USER, USER);
        properties.put(Environment.PASS, PASSWORD);
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        return new Configuration().addProperties(properties).addAnnotatedClass(User.class).buildSessionFactory();
    }

}
