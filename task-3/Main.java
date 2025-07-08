import java.util.*;
public class Main {
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
     List<User> user=new ArrayList<>();
    user.add(new User("abc789","1234",10089.0));
    user.add(new User("pqr123","1234",57899.0));
    user.add(new User("xyz456","1234",325.0));
    System.out.println("Welcome!!");
    User curr=null;
    while(curr==null){
        System.out.println("Enter your User id:");
        String uu=sc.nextLine();
        System.out.println("Please Enter the PIN:");
        String pp=sc.nextLine();
        for(User u:user){
            if(u.getu_id().equals(uu) && u.getpin().equals(pp)){
                curr=u;
                break;
            }
        }
        if(curr==null)
        System.out.println("Invalid user id or pin \ncheck again");

    }
    System.out.println("Successful Login done!!");
    ATM mac=new ATM(curr);
    ATMOP ope=new ATMOP(mac);
    System.out.println("   ATM    ");
    System.out.println("1.Withdraw\n2.Deposit\n3.Transfer\n4.Transaction History\n5.Check Balance\n6.Exit");
    int operation;
    do{
        System.out.println("press the number based on your choice ");
        operation=sc.nextInt();

        switch(operation){
            case 1:
            System.out.println("Enter amount to withdraw :");
            double am=sc.nextDouble();
            ope.w_draw(am);
            break;
            case 2:
            System.out.println("Enter amount to deposit :");
            double amm=sc.nextDouble();
            ope.deposit(amm);
            break;
            case 3:
            sc.nextLine();
            System.out.println("Enter the recipient user id");
            String rid=sc.nextLine();
            System.out.println("Enter  amount to transfer");
            double tra=sc.nextDouble();
            ope.transfer_amo(rid, tra, user);
            break;
            case 4:
            ope.histroy();;
            break;
            case 5:
            ope.c_balance();
            break;
            case 6:
             System.out.println("THANK YOU :) :)");
             break;
             default :
             System.out.println("Invalid choice.\nEnter valid choice\n");
        }
    }
    while(operation!=6);
    sc.close();

}
}
