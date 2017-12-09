package hibernate_methods;

import items.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserRunner {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();;

    public UserRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(int id, String name, String surname, int age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = new User(id, name, surname, age);
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateUser(int id, int age) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        user.setAge(age);
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public List listUsers() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List users = session.createQuery("FROM User").list();

        transaction.commit();
        session.close();
        return users;
    }
}
