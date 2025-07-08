import java.util.*;
public class User {
    private String u_id;
    private String pin;
    private double ball_amo;
    public User(String u_id, String pin, double ball_amo){
        this.u_id=u_id;
        this.pin=pin;
        this.ball_amo=ball_amo;
    }
    public String getu_id(){
        return u_id;
    }
    public String getpin(){
        return pin;
    }
    public double getball(){
        return ball_amo;
    }
    public void setball(double ball_amo){
        this.ball_amo=ball_amo;
    }
}
