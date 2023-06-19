import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {

    private static String url, user, password;

    static void init() {
        url = "jdbc:mysql://localhost/propertymanagementsystem"; 
        user = "root"; 
        password = "szabist@100"; 
    }

    public static Connection getConnection() {
       init();

       try {
           return DriverManager.getConnection(url, user, password);
       } catch (Exception ex) {
           System.out.println("Error Connection");
           ex.printStackTrace();
           return null;
       }
    }
}