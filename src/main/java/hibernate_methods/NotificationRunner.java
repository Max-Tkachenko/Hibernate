package hibernate_methods;

import items.Notification;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NotificationRunner {

    private static SessionFactory sessionFactory;

    public NotificationRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNote(int id, int userId, String context) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Notification note = new Notification(id, userId, context);
        session.save(note);
        transaction.commit();
        session.close();
    }

    public void updateNote(int id, String context) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Notification note = (Notification) session.get(Notification.class, id);
        note.setContext(context);
        session.update(note);
        transaction.commit();
        session.close();
    }

    public void removeNote(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Notification note = (Notification) session.get(Notification.class, id);
        session.delete(note);
        transaction.commit();
        session.close();
    }

    public List listNotes() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List notes = session.createQuery("FROM Notification").list();

        transaction.commit();
        session.close();
        return notes;
    }
}
