package bank.management.system;
import java.sql.*;

public class Conn
{
    Connection con;
    Statement st;
    String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
    String userName = "root";
    String password = "Krishna@2004";
    public Conn(){
        try
        {
        // Class.forName("com.mysql.jdbc.Driver"); Because java khud class path se driver ko pick kar raha hai 
        // to hamko explictly driver ko register karne ki need nhi hai.
         con = DriverManager.getConnection(url,userName,password);
         st = con.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
