package hibernate_methods;

import items.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NewsRunner {

    private static SessionFactory sessionFactory;

    public NewsRunner(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNews(int id, int chatId, String dateOfCreating, String context) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        News news = new News(id, chatId, dateOfCreating, context);
        session.save(news);
        transaction.commit();
        session.close();
    }

    public void updateNews(int id, String context) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        News news = (News) session.get(News.class, id);
        news.setContext(context);
        session.update(news);
        transaction.commit();
        session.close();
    }

    public void removeNews(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        News news = (News) session.get(News.class, id);
        session.delete(news);
        transaction.commit();
        session.close();
    }

    public List listNews() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        List news = session.createQuery("FROM News").list();

        transaction.commit();
        session.close();
        return news;
    }
}
