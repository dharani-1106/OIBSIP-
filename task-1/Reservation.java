import java.util.*;
import java.sql.*;
public class Reservation {
    Scanner sc=new Scanner(System.in);
    public void reserve(Connection conn , String usern) throws SQLException{
        System.out.println("   Reservation   ");
        System.out.println("Enter your name: ");
        String u_name=sc.nextLine();
        System.out.println("Enter your age: ");
        int age=sc.nextInt();
        System.out.println("Enter train number: ");
        sc.nextLine();
        String t_no=sc.nextLine();
        String t_name=getTrainName(conn,t_no);
        if(t_name.equals("Unknown Train")){
            System.out.println("Invalid Train number\nPlease try again");
            return;
        }
        String[] ava={"SL","3A","2A","1A","CC","2S","GEN"};
        System.out.println("""
    Available Class Types:
SL  - Sleeper
3A  - AC 3 Tier
2A  - AC 2 Tier
1A  - First Class AC
CC  - Chair Car
2S  - Second Sitting
GEN - General""");
System.out.println("Enter the class type :");
String ct=sc.nextLine().toUpperCase();
boolean f=false;
for(String c:ava){
    if(c.equals(ct)){
        f=true;
        break;
    }
}
if(!f){
    System.out.println("Invalid class type\nTry again");
    return;
}
System.out.println("Enter number of seats to reserve: ");
 int s=sc.nextInt();
 sc.nextLine();
 System.out.println("Enter date of journey in yyyy-mm-dd format: ");
 String d=sc.nextLine();
 java.sql.Date sq=java.sql.Date.valueOf(d);

 System.out.println("Enter the starting place:");
 String sour=sc.nextLine();
 System.out.println("Enter the destination place: ");
 String dest=sc.nextLine();
 String query = "INSERT INTO reservations (user_name,name, age, train_no, train_name,class_type,seats,date, source, destination) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?)";
 PreparedStatement pre = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
     pre.setString(1,usern);
    pre.setString(2,u_name);
    pre.setInt(3,age);
    pre.setString(4,t_no);
    pre.setString(5,t_name);
    pre.setString(6,ct);
    pre.setInt(7,s);
    pre.setDate(8,sq);
    pre.setString(9, sour);
    pre.setString(10,dest);
int row=pre.executeUpdate();
if(row>0){
    ResultSet res=pre.getGeneratedKeys();
    if(res.next()){
        long pnr_no=res.getLong(1);
        System.out.println("Reservation done Successful!!");
        System.out.println("Your PNR number is : "+pnr_no);
        System.out.println("Seats: " + s + ", Class: " + ct + ", Date: " + d);     
    }
  }
  else
  System.out.println("Reservation failed\nTry again");

    }
    public String getTrainName(Connection conn ,String t_no) throws SQLException{
        String query="SELECT train_name FROM trains WHERE train_number = ?";
        PreparedStatement pre=conn.prepareStatement(query);
        pre.setString(1,t_no);
        ResultSet res=pre.executeQuery();
        if(res.next())
        return res.getString("train_name");
        else
        return "Unknown Train";

    }
}
