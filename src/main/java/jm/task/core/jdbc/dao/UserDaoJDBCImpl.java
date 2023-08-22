package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final String TABLE_NAME = "users";
    private final String COLUMN_NAME = "name";
    private final String COLUMN_LASTNAME = "lastname";
    private final String COLUMN_AGE = "age";
    private final String COLUMN_ID = "id";
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Util.execute(String.format("CREATE TABLE IF NOT EXISTS %s (\n" +
                "  %s int NOT NULL AUTO_INCREMENT,\n" +
                "  %s varchar(255) DEFAULT NULL,\n" +
                "  %s varchar(255) DEFAULT NULL,\n" +
                "  %s int DEFAULT NULL,\n" +
                "  PRIMARY KEY (%s))",
                TABLE_NAME,
                COLUMN_ID,
                COLUMN_NAME,
                COLUMN_LASTNAME,
                COLUMN_AGE,
                COLUMN_ID));
    }

    public void dropUsersTable() {
        Util.execute("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void saveUser(String name, String lastName, byte age) {
        Util.execute(String.format("INSERT INTO %s (%s, %s, %s)\n" +
                "VALUES ('%s', '%s', %d)",
                TABLE_NAME, COLUMN_NAME, COLUMN_LASTNAME, COLUMN_AGE,
                name, lastName, age));
    }

    public void removeUserById(long id) {
        Util.execute(String.format("DELETE from users where %s = %d", COLUMN_ID, id));
    }

    public List<User> getAllUsers() {
        ArrayList<User> res = new ArrayList<>();
        try (Connection connection = Util.getConnection()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM " + TABLE_NAME);
            while (rs.next()) {
                res.add(new User(rs.getString(2), rs.getString(3), rs.getByte(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void cleanUsersTable() {
        Util.execute("DELETE from " + TABLE_NAME);
        //dropUsersTable();
        //createUsersTable();
    }
}
