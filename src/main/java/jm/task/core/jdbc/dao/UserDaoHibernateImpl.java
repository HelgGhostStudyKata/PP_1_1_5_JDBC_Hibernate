package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery(String.format("CREATE TABLE IF NOT EXISTS %s (\n" +
                            "  %s int NOT NULL AUTO_INCREMENT,\n" +
                            "  %s varchar(255) DEFAULT NULL,\n" +
                            "  %s varchar(255) DEFAULT NULL,\n" +
                            "  %s int DEFAULT NULL,\n" +
                            "  PRIMARY KEY (%s))",
                    "users",
                    "id",
                    "name",
                    "lastname",
                    "age",
                    "id")).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createSQLQuery(String.format("DROP TABLE IF EXISTS " + "users")).executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(new User(name, lastName, age));
            session.getTransaction().commit();
        }
    }

    @Override
    public void removeUserById(long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> res = new ArrayList<>();
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            res = session.createQuery("from User", User.class).list();
            session.getTransaction().commit();
        }
        return res;
    }

    @Override
    public void cleanUsersTable() {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
