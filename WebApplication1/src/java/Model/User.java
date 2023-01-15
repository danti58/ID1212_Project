package Model;


public class User {
    
    private String pin;
    private String username;
    private String password;
    private Boolean admin;
    private Boolean userIsInQueue;
    
    public User(String pin, String username, Boolean admin, String password){
        this.pin = pin;
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.userIsInQueue = false;
        
    }
    
}

