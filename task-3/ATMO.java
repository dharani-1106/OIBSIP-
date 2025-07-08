import java.util.*;
public interface ATMO {
    void histroy();
    void w_draw(double amount);
    void deposit(double amount);
    void transfer_amo(String recipt, double amount, List<User> user);
    void c_balance();
}
