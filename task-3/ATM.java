import java.util.*;
public class ATM{
    private  User u_name;
    private List<String> trans;
    public ATM(User u_name){
        this.u_name=u_name;
        this.trans=new ArrayList<>();
    }
    public User getuser(){
        return u_name;
    }
    public void setuser(User u_name){
        this.u_name=u_name;
        this.trans.clear();
    }
    public void track(String transs){
        trans.add(transs);
    }
    public List<String> gethistroy(){
        return trans;
    }
}