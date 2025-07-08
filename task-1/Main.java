import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String[] args){
        try{
            Connection c=db.getConn();
            Scanner sc=new Scanner(System.in);
            Login log=new Login();
            Reservation res=new Reservation();
            Cancellation can=new Cancellation();
            Details det=new Details();
            String user=log.startlogin(c);
           
            if(user==null)
            return;
            while(true){
                System.out.println("  Online Reservation System");
                 System.out.println("1.Reservation\n2.Cancel Reservation\n3.History\n4.Exit");
                System.out.println("Enter your choice: ");
                 int ope=sc.nextInt();
                 sc.nextLine();
                 switch (ope) {
                    case 1:
                        res.reserve(c, user);
                        break;
                    case 2:
                    can.cancelt(c, user);
                    break;
                    case 3:
                    det.detail(c, user);
                    break;
                    case 4:
                    System.out.println("THANK YOU :)");
                    return;
                    default:
                    System.out.println("invalid option");
                        break;
                 }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
