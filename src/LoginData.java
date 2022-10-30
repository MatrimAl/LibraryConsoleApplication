public class LoginData {
    private final String Id;
    private final String Password;
    public LoginData(String Id, String Password){
        this.Id = Id;
        this.Password = Password;
    }
    public String getId(){
        return this.Id;
    }

    public String getPassword(){
        return this.Password;
    }
}
