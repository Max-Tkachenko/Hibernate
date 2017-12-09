package hibernate_methods;

import items.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MessageRunner {

    private static SessionFactory sessionFactory;

    public MessageRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addMessage(int id, int userId, int chatId, String date, String context) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Message message = new Message(id, userId, chatId, date, context);
        session.save(message);
        transaction.commit();
        session.close();
    }

    public void updateMessage(int id, String context) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Message message = (Message) session.get(Message.class, id);
        message.setContext(context);
        session.update(message);
        transaction.commit();
        session.close();
    }

    public void removeMessage(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Message message = (Message) session.get(Message.class, id);
        session.delete(message);
        transaction.commit();
        session.close();
    }

    public List listMessages() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List messages = session.createQuery("FROM Chat").list();

        transaction.commit();
        session.close();
        return messages;
    }
}
