import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection getDatabaseConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student","root","");
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

}

