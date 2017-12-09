package run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection connection;
    public static String URL = "jdbc:mysql://91.238.103.81/test";
    public static String DRIVER = "com.mysql.jdbc.Driver";

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        connection = DriverManager.getConnection(URL, "max", "max12345");
        System.out.println("Connection successful...");
    }
}