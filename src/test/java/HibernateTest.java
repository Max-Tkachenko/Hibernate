import hibernate_methods.*;
import liquibase.exception.LiquibaseException;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import run.Connect;
import run.Main;
import java.sql.SQLException;

public class HibernateTest {

    @BeforeClass
    public static void onlyOnce() throws SQLException, ClassNotFoundException, LiquibaseException {
        Connect.connect();
    }

    @AfterClass
    public static void afterTest() throws SQLException, ClassNotFoundException {
        Connect.connection.close();
    }

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(Main.sessionFactory);
        ChatRunner chatRunner = new ChatRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(chatRunner.listChats().get(0).toString());
    }

    @Test
    public void getObjectsTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        ChatRunner chatRunner = new ChatRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(chatRunner.listChats().get(0).toString());

        MessageRunner messageRunner = new MessageRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(messageRunner.listMessages().get(0).toString());

        NewsRunner newsRunner = new NewsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(newsRunner.listNews().get(0).toString());

        NotificationRunner notificationRunner = new NotificationRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(notificationRunner.listNotes().get(0).toString());

        UserRunner userRunner = new UserRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(userRunner.listUsers().get(0).toString());

        UsersChatsRunner usersChatsRunner = new UsersChatsRunner(new Configuration().configure().buildSessionFactory());
        System.out.println(usersChatsRunner.listUsersChats().get(0).toString());
    }

    @Test
    public void updateTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        ChatRunner chatRunner = new ChatRunner(new Configuration().configure().buildSessionFactory());
        chatRunner.updateChat(1, "New Chat");

        NewsRunner newsRunner = new NewsRunner(new Configuration().configure().buildSessionFactory());
        newsRunner.updateNews(1, "News about KPI...");

        MessageRunner messageRunner = new MessageRunner(new Configuration().configure().buildSessionFactory());
        messageRunner.updateMessage(1, "New Message!");

        NotificationRunner notificationRunner = new NotificationRunner(new Configuration().configure().buildSessionFactory());
        notificationRunner.updateNote(1, "New Notification");

        UserRunner userRunner = new UserRunner(new Configuration().configure().buildSessionFactory());
        userRunner.updateUser(1, 25);

        UsersChatsRunner usersChatsRunner = new UsersChatsRunner(new Configuration().configure().buildSessionFactory());
        usersChatsRunner.updateUsersChats(1, 1);
    }

    @Test
    public void addRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Main.createTables(new Configuration().configure().buildSessionFactory());

        ChatRunner chatRunner = new ChatRunner(new Configuration().configure().buildSessionFactory());
        chatRunner.addChat(4, "Chat1", "2010-05-10");
        chatRunner.removeChat(4);

        NewsRunner newsRunner = new NewsRunner(new Configuration().configure().buildSessionFactory());
        newsRunner.addNews(4,2,"2010-05-10", "News1");
        newsRunner.removeNews(4);

        NotificationRunner notificationRunner = new NotificationRunner(new Configuration().configure().buildSessionFactory());
        notificationRunner.addNote(4,2,"Note");
        notificationRunner.removeNote(4);

        UserRunner userRunner = new UserRunner(new Configuration().configure().buildSessionFactory());
        userRunner.addUser(4, "Max", "Shevchuk", 23);
        userRunner.removeUser(4);

        UsersChatsRunner usersChatsRunner = new UsersChatsRunner(new Configuration().configure().buildSessionFactory());
        usersChatsRunner.addUsersChats(4,2,1);
        usersChatsRunner.removeUsersChats(4);
    }
}
