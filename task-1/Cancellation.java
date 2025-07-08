import java.util.*;
import java.sql.*;
public class Cancellation {
    public static void cancelt( Connection conn,String user_n) throws SQLException{
        Scanner sc=new Scanner(System.in);
       
        System.out.println("To cancel your reservation enter your pnr number : ");
        long pnr=sc.nextLong();
        sc.nextLine();
        String f="SELECT * FROM reservations WHERE pnr_no = ? AND user_name = ?";
        PreparedStatement pre=conn.prepareStatement(f);
        pre.setLong(1, pnr);
        pre.setString(2, user_n);
        ResultSet res=pre.executeQuery();
        if(res.next()){
            System.out.println("Reservation found");
            System.out.println("Name: "+res.getString("name")+"\nTrain: "+res.getString("train_name")+"\nDate: "+res.getString("date")+"\nConfirm cancel\nEnter yes/no to cancel");
            String can=sc.nextLine();
            if(can.equalsIgnoreCase("yes")){
                String del="UPDATE reservations SET status = 'Cancelled' WHERE pnr_no = ?";
                PreparedStatement ps = conn.prepareStatement(del);
                ps.setLong(1, pnr);
                ps.executeUpdate();
                System.out.println("Cancellation done successfully!");

                PreparedStatement dell=conn.prepareStatement(del);
                dell.setLong(1, pnr);
                dell.executeUpdate();
                System.out.println("Cancellection done successfully!!");

            }
            else
            System.out.println("Cancelltion failed\nTry again");

        }
        else
        System.out.println("No Reservation found with is PNR number\nCheck your PNR number");
        
    }
}
