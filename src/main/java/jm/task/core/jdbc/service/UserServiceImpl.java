package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl userDaoJDBCImpl = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDaoJDBCImpl.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBCImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {

        return userDaoJDBCImpl.getAllUsers();
    }

    public void cleanUsersTable() {

    }
}
