import java.util.*;
import java.sql.*;
public class Details {
    public static void detail(Connection conn, String user)throws SQLException{
        String q="SELECT * FROM reservations WHERE user_name = ?";
        PreparedStatement pre=conn.prepareStatement(q);
        pre.setString(1, user);
        ResultSet res=pre.executeQuery();
        System.out.println("   Your Reservation Histroy");
        while(res.next()){
            System.out.println("PNR: " + res.getLong("pnr_no"));
            System.out.println("Name: " + res.getString("name"));
            System.out.println("Train no: " + res.getString("train_no"));
            System.out.println("Train name: "+ res.getString("train_name"));
            System.out.println("Source place: " + res.getString("source"));
            System.out.println("Destination place: "+res.getString("destination"));
            System.out.println("Date: " + res.getDate("date"));
            System.out.println("Class: " + res.getString("class_type"));
            System.out.println("Seats: " + res.getInt("seats"));
            System.out.println("Status: " + res.getString("status"));
        }
    }
}
