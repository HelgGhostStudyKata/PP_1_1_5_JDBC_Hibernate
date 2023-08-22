package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        User users[] = new User[4];
        users[0] = new User("Вася","Пупкин", (byte) 23);
        users[1] = new User("Петя","Веревкин", (byte) 43);
        users[2] = new User("Игнат","Оглы", (byte) 51);
        users[3] = new User("Иосиф","Каварашвилли", (byte) 32);
        for (User user : users) {
            userService.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем – "+ user.getName() + " добавлен в базу данных");
        }
        List<User> lu = userService.getAllUsers();
        for (User user : lu) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
