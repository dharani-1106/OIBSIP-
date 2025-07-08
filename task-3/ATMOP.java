import java.util.*;
public class ATMOP implements ATMO {
    private ATM amo;
    public ATMOP(ATM amo){
        this.amo=amo;
    }
    public void histroy(){
        System.out.println("Here is your account Transaction History");
        for(String m:amo.gethistroy())
        System.out.println(m);
        if(amo.gethistroy().isEmpty())
        System.out.println("No transaction histroy found");
    }
    public void w_draw(double amount){
        if(amount<=amo.getuser().getball()){
            amo.getuser().setball(amo.getuser().getball()-amount);
            amo.track("Amount debited :"+amount);
            System.out.println(amount+" withdrawn successfully..");
            
        }
        else{
            System.out.println("Your account has insufficient balance to withdraw the amount");
        }
    }
    public void deposit(double amount){
        amo.getuser().setball(amo.getuser().getball()+amount);
        amo.track("Amount Deposited :"+amount);
        System.out.println(amount+" deposited successfully..");
    }
    public void transfer_amo(String r_id,double amount,List<User>user){
        if(amount<=0){
           System.out.println("Enter proper amount value");
           return ; 
        }
        User rep=amo.getuser();
        if(rep.getball()<amount){
            System.out.println("Insufficient Balance\nPlease check it\n");
            return;
        }
        boolean f=false;
        for(User r:user){
            if(r.getu_id().equals(r_id)){
                f=true;
                
                rep.setball(rep.getball()-amount);
                r.setball(r.getball()+amount);
                amo.track(amount+" Transferred to recipient id "+r_id);
                System.out.println(amount+"Transferred to "+r_id+" successful");
                return;
            }
        }
        if(!f){
            System.out.println("Invalid recipient id\nTry again");
        }
      
    }
    public void c_balance(){
        System.out.println("Your current account balance is :"+amo.getuser().getball());
    }
    
}
