import java.util.*;
import java.sql.*;
public class db{
    private static Connection conn;
    public static Connection getConn() throws SQLException{
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
       }
       catch(ClassNotFoundException e){
        System.out.println("drive not found");
       }
        if(conn==null){
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve","root","12345");
        }
        return conn;
    }
}