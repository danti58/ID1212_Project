/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

public class UseBean {
    
    public UseBean(){
        
    }
   
    public User createUser(String pin, String username, boolean admin, String password) {
        User user = new User();
        if(!DBHandler.findUser(pin)){
            DBHandler.createUser(pin, username, admin, password);
        }
        if(DBHandler.findUser(pin)){
            user = new User(pin, username, admin, password);
        }
        return user;
    }

    public void deleteUser(String pin) {
        DBHandler.deleteUser(pin);
    }

    public void addAdmin(String pin, Integer id) {
        DBHandler.addAdmin(pin, id);
    }
    
    public void removeAdmin(String pin, Integer id) {
        DBHandler.removeAdmin(pin, id);
    }
     public boolean isAdmin(String pin, Integer id) {
        return DBHandler.isAdmin(pin, id);
    }
    
    public User getUser(String pin){
        return DBHandler.getUser(pin);
    }
    
    //comment may be an empty string
    public void addUserToQueue(String pin, Integer id, String location, String comment) {
        DBHandler.addUserToQueue(pin, id, location, comment);
    }

    public void removeUserFromQueue(String pin, Integer id) {
        DBHandler.removeUserFromQueue(pin, id);
    }

    public void updateQueueStatus(Integer id, boolean status) {
        DBHandler.updateQueueStatus(id, status);
    }

    public boolean authentication(String pin, String password) {
        return DBHandler.authentication(pin, password);
    }
    public List<User> getAllUsers(){
        return DBHandler.getAllUsers();
    }
    public boolean isUserInQueue(String pin){
        return DBHandler.isUserInQueue(pin);
    }
    
    public List<Activity> getAllActivities(){
        return DBHandler.getAllActivities();
    }
    public List<QueueSpot> getAllQueues(Integer activityID){
        return DBHandler.getAllQueues(activityID);
    }
}
