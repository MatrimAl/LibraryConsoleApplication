import java.util.*;
import java.util.ArrayList;
public class Login {
    static Scanner input = new Scanner(System.in);
    public String userid;
    static ArrayList<LoginData> listLogin = new ArrayList<LoginData>();
    boolean check2 = false;
    public boolean choose() {
        System.out.println("Do you want to log in or do you want to register?");
        System.out.println("If you want to log in, write 'login'");
        System.out.println("Or you want to register, write 'register'");
        String choose = input.nextLine();
        if (choose.equals("login")){
            userLogin();
        }
        else if (choose.equals("register")){
            userRegister();
        }
        return check2;
    }
    public boolean userLogin(){

            System.out.println("Enter your username");
            userid = input.nextLine();
            System.out.println("Enter your password");
            String password = input.nextLine();
            for (LoginData data : listLogin) {
                data.getId();
                data.getPassword();
                if (data.getId().equals(userid) && data.getPassword().equals(password)){
                    System.out.println("Welcome to library.");
                    check2 = true;
                    return check2;
                }
            }
            System.out.println("Invalid username or password. Try again.");
            choose();

        return false;
    }
    public void userRegister(){
        System.out.println("Set your username.");
        String id = input.nextLine();
        System.out.println("Set your password.");
        String password = input.nextLine();
        listLogin.add(new LoginData(id, password));
        System.out.println("Successfully registered.");
        choose();
    }

    public String getId() {
        return this.userid;
    }
}
