/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBHandler {

    public static User getUser(String pin) {
        String query = "SELECT * FROM Users WHERE Pin='"+pin+"'";
        User user = new User();
        
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                user = new User(pin, rs.getString("username"), rs.getBoolean("admin"), rs.getString("password"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
		stmt.close();
		conn.close();
            } catch (Exception e) {}
        }
        return user;
    }

    public static void createUser(String pin, String username, boolean admin, String password) {
        //If there is time add check for pin format here
        String query = "INSERT INTO Users VALUES ('"+pin+"', '"+username+"', '"+admin+"','"+password+"')";
        dbVoidCall(query);
    }
    
    public static String getUserPin(String userName){
        String query = "SELECT * FROM Users where userName='" + userName +"'";
        
        String re;
        
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                re = rs.getString("userName");
            }
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
		stmt.close();
		conn.close();
            } catch (Exception e) {}
        }
        return null;
    }

    public static void deleteUser(String pin) {
        String query = "DELETE FROM Users WHERE Pin='"+pin+"'";
        dbVoidCall(query);
    }

    public static void addAdmin(String pin, Integer id) {
        String query = "INSERT INTO Admins VALUES ('"+pin+"', "+id+" )";
        dbVoidCall(query);
    }
    
    public static void removeAdmin(String pin, Integer id) {
        String query = "DELETE FROM Admins WHERE Pin = '"+pin+"' AND Activity_id="+id;
        dbVoidCall(query);
    }
    
    public static boolean isAdmin(String pin /*, Integer id*/) {
        //String query = "SELECT FROM Admins WHERE Pin = '"+pin+"' AND Activity_id="+id;
        String query = "SELECT * FROM Users WHERE Pin = '" + pin + "' AND Admin = True";
        return dbFind(query);
    }
    
    //comment may be an empty string
    public static void addUserToQueue(String pin, Integer id, String location, String comment) {
        String query = "INSERT INTO Users VALUES ('"+pin+"', "+id+", '"+location+"','"+comment+"')";
        dbVoidCall(query);
    }

    public static void removeUserFromQueue(String pin, Integer id) {
        String query = "DELETE FROM Queue WHERE Pin='"+pin+"' AND Activity_id="+id;
    }

    public static void updateQueueStatus(Integer id, boolean status) {
        String query = "UPDATE Activity SET Status = '"+status+"' WHERE id="+id;
        dbVoidCall(query);
    }

    public static boolean authentication(String pin, String password) {
        //If there is time add hashing here
        return dbFind("SELECT * from users WHERE Pin='"+pin+"' AND Password='"+password+"'");
    }
    
    public static List<String> getAllUsers(){
        String query = "select * from users";
        return dbListCall(query, "userName");
    }
    public static List<String> getAllActivities(){
        String query = "select * from activity";
        return dbListCall(query, "name");
    }
    public static List<String> getAllQueues(Integer id){
        String query = "select Queue.id,Activity_id,Queue.pin from Queue INNER JOIN users ON Queue.pin=Users.pin WHERE queue.Activity_id="+id+" ORDER BY id ASC";
        return dbListCall(query, "username");
    }
    
    public static boolean isUserInQueue(String pin){
        String query = "SELECT * from Queue WHERE Pin='"+pin+"'";
        return dbFind(query);
    }
    public static boolean findUser(String pin){
        String query = "SELECT * from Users WHERE Pin='"+pin+"'";
        return dbFind(query);
    }
    
    private static boolean dbFind(String query) {
        
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return true;
            }
            return false;
        }catch(Exception e){

        } finally {
            try {
		stmt.close();
		conn.close();
            } catch (Exception e) {}
        }
        return false;
    }
    
    private static List<String> dbListCall(String query, String getObject){
        List<String> list  = new ArrayList<String>();
        
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                list.add(rs.getString(getObject));  
            }
            
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
		stmt.close();
		conn.close();
            } catch (Exception e) {}
        }
        return list;
    }
    private static void dbVoidCall(String query){
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
  
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
		stmt.close();
		conn.close();
            } catch (Exception e) {}
        }
    }    
}