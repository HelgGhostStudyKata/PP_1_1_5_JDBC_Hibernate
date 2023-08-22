package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

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
        Util.execute("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" (\n" +
                "  id int NOT NULL AUTO_INCREMENT,\n" +
                "  name varchar(255) DEFAULT NULL,\n" +
                "  lastname varchar(255) DEFAULT NULL,\n" +
                "  age int DEFAULT NULL,\n" +
                "  PRIMARY KEY (id)\n" +
                ")");
    }

    public void dropUsersTable() {
        Util.execute("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public void saveUser(String name, String lastName, byte age) {
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        ResultSet rs = Util.executeQuery("SELECT * FROM " + TABLE_NAME);
        return new ArrayList<User>();
    }

    public void cleanUsersTable() {

    }
}
