/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class UseBean {
    
    public UseBean(String username,String password){
        
    }
   
    public void createUser(String pin, String username, boolean admin, String password) {
        DBHandler.createUser(pin, username, admin, password);
        if(DBHandler.findUser(pin)){
            User user = new User(pin, username, admin, password);
        }
    }

    public void deleteUser(String pin) {
        DBHandler.deleteUser(pin);
    }

    public void updateAdmin(String pin, Integer id) {
        DBHandler.updateAdmin(pin, id);
    }
    
    //comment may be an empty string
    public void addUserToQueue(String pin, Integer id, String location, String comment) {
        DBHandler.addUserToQueue(pin, id, location, comment);
    }

    public void removeUserFromQueue(String pin, Integer id) {
        DBHandler.removeUserFromQueue(pin, id);
    }

    public void updateQueueStatus(Integer id, Boolean status) {
        DBHandler.updateQueueStatus(id, status);
    }

    public void authentication(String pin, String password) {
        DBHandler.authentication(pin, password);
    }
    public void getAllUsers(){
        DBHandler.getAllUsers();
    }
    public Boolean isUserInQueue(String pin){
        return DBHandler.isUserInQueue(pin);
    }
}
