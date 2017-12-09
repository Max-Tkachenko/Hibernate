package hibernate_methods;

import items.UsersChats;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsersChatsRunner {

    private static SessionFactory sessionFactory;

    public UsersChatsRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUsersChats(int id, int userId, int chatId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UsersChats usersChats = new UsersChats(id, userId, chatId);
        session.save(usersChats);
        transaction.commit();
        session.close();
    }

    public void updateUsersChats(int id, int chatId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UsersChats usersChats = (UsersChats) session.get(UsersChats.class, id);
        usersChats.setChatId(chatId);
        session.update(usersChats);
        transaction.commit();
        session.close();
    }

    public void removeUsersChats(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        UsersChats usersChats = (UsersChats) session.get(UsersChats.class, id);
        session.delete(usersChats);
        transaction.commit();
        session.close();
    }

    public List listUsersChats() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List usersChats = session.createQuery("FROM UsersChats").list();

        transaction.commit();
        session.close();
        return usersChats;
    }
}
