/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

public class UseBean {
    
    User user;
    
    public UseBean(){
        
    }
    /*public UseBean(String PIN,String password){
        if(authentication(PIN, password)){
            this.user = DBHandler.getUser(PIN);
        }
    }
   
    public UseBean(String pin, String username, boolean admin, String password) {
        
        if(!DBHandler.findUser(pin)){
            DBHandler.createUser(pin, username, admin, password);
            if(DBHandler.findUser(pin)){
                this.user = new User(pin, username, admin, password); 
            }
        }
    }*/
    
    public boolean login(String PIN, String password){
        boolean success = false;
        if(authentication(PIN, password)){
            this.user = DBHandler.getUser(PIN);
            this.user.setUserIsInQueue(isUserInQueue(PIN));
            success = true;
        }
        
        return success;
    }
    
    public boolean createUser(String pin, String username, boolean admin, String password){
        boolean success = false;
        
        if(!DBHandler.findUser(pin)){
            DBHandler.createUser(pin, username, admin, password);
            if(DBHandler.findUser(pin)){
                this.user = new User(pin, username, admin, password); 
                this.user.setUserIsInQueue(false);
                success = true;
            }
        }
        
        return success;
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
    public boolean isAdmin(String pin /*, Integer id*/) {
        return DBHandler.isAdmin(pin /*, id*/);
    }
    public boolean isAdminInQueue(String pin, Integer id){
        return DBHandler.isAdminInQueue(pin, id);
    }
    
    public User getUser(String pin){
        return DBHandler.getUser(pin);
    }
     
    public String getUserPIN(String userName){
        return DBHandler.getUserPin(userName);
    }
     
     public User getCurrentUser(){
        return this.user;
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
    //
    public void toggleQueueStatus(Integer id) {
        DBHandler.toggleQueueStatus(id);
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
    
    /*public List<String> getAllActivities(){
        return DBHandler.getAllActivities();
    }*/
    public boolean isUserInCurrentQueue(String pin, Integer id){
        return DBHandler.isUserInCurrentQueue(pin, id);
    }
    
    public List<Activity> getAllActivities(){
        return DBHandler.getAllActivities();
    }
    
    public void setActivityMessage(String message, Integer id){
        DBHandler.setActivityMessage(message, id);
    }
    
    public static String getActivityMessage(Integer id){
         return DBHandler.getActivityMessage(id);
    }
    
    /*public List<String> getAllQueues(Integer activityID){
        return DBHandler.getAllQueues(activityID);
    }*/
    public List<QueueSpot> getAllQueues(Integer activityID){
        return DBHandler.getAllQueues(activityID);
    }
}