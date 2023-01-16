package Model;


public class User {
    
    private String pin;
    private String username;
    private String password;
    private Boolean admin;
    private Boolean userIsInQueue;
    
    public User(){
    }
    
    
    public User(String pin, String username, Boolean admin, String password){
        this.pin = pin;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }
    
    public String getPin(){
        return this.pin;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }            
    public Boolean getAdmin(){
        return this.admin;
    }
    public Boolean getUserIsInQueue(){
        return this.userIsInQueue;
    }
    
    public void setPin(String pin){
        this.pin = pin;
    }
    public void setUsername(String username){
        this.username = username;
    }   
    public void setPassword(String password){
        this.password = password;
    }            
    public void setAdmin(Boolean admin){
        this.admin = admin;
    }
    public void setUserIsInQueue(Boolean userIsInQueue){
        this.userIsInQueue = userIsInQueue;
    }
                
}