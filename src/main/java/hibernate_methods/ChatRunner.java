package hibernate_methods;

import items.Chat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ChatRunner {

    private static SessionFactory sessionFactory;

    public ChatRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addChat(int id, String name, String dateOfCreating) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Chat chat = new Chat(id, name, dateOfCreating);
        session.save(chat);
        transaction.commit();
        session.close();
    }

    public void updateChat(int id, String name) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Chat chat = (Chat) session.get(Chat.class, id);
        chat.setName(name);
        session.update(chat);
        transaction.commit();
        session.close();
    }

    public void removeChat(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Chat chat = (Chat) session.get(Chat.class, id);
        session.delete(chat);
        transaction.commit();
        session.close();
    }

    public List listChats() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List chats = session.createQuery("FROM Chat").list();

        transaction.commit();
        session.close();
        return chats;
    }
}
