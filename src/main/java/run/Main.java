package run;

import hibernate_methods.*;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.SQLException;

public class Main {

    public static SessionFactory sessionFactory;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, LiquibaseException {
        Connect.connect();
        sessionFactory = new Configuration().configure().buildSessionFactory();
        createTables(sessionFactory);
    }

    public static void createTables(SessionFactory sessionFactory) throws ClassNotFoundException, SQLException, LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File create_tables = new File(ClassLoader.getSystemResource("liquibase/1.0-create-tables.xml").getFile());
        Liquibase create = new liquibase.Liquibase(create_tables.toString(), new FileSystemResourceAccessor(), database);
        create.update(new Contexts(), new LabelExpression());

        File set_data = new File(ClassLoader.getSystemResource("liquibase/2.0-set-data.xml").getFile());
        Liquibase insert = new liquibase.Liquibase(set_data.toString(), new FileSystemResourceAccessor(), database);
        insert.update(new Contexts(), new LabelExpression());

        ChatRunner chatRunner = new ChatRunner(sessionFactory);
        MessageRunner messageRunner = new MessageRunner(sessionFactory);
        NewsRunner newsRunner = new NewsRunner(sessionFactory);
        NotificationRunner notificationRunner = new NotificationRunner(sessionFactory);
        UserRunner userRunner = new UserRunner(sessionFactory);
        UsersChatsRunner usersChatsRunner = new UsersChatsRunner(sessionFactory);
    }
}
