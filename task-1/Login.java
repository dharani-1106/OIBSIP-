import java.util.*;
import java.sql.*;
public class Login {
    public static String startlogin(Connection conn) throws SQLException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to Online Reservation System ");
        System.out.println("Enter username:");
        String u_name=sc.nextLine();
        System.out.println("Enter your password:");
        String pass=sc.nextLine();

            PreparedStatement pre=conn.prepareStatement("SELECT * FROM users WHERE user_name=? AND password=?");
            pre.setString(1,u_name);
            pre.setString(2,pass);
            ResultSet res=pre.executeQuery();
            if(res.next()){
                System.out.println("Login Successful!!");
                return u_name;
            }
            else{
                System.out.println("Invalid Credentials\nTry again");
                 return null;
            }
        
       
        
    }
}
