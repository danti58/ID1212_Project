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

    public void createUser(String pin, String username, boolean admin, String password) {
        //If there is time add check for pin format here
        String query = "INSERT INTO Users VALUES ('"+pin+"', '"+username+"', '"+admin+"','"+password+"')";
        dbVoidCall(query);
    }

    public void deleteUser(String pin) {
        String query = "DELETE FROM Users WHERE Pin='"+pin+"'";
    }

    public void updateAdmin(String pin, Integer id) {
        String query = "INSERT INTO Admins VALUES ('"+pin+"', "+id+" )";
        dbVoidCall(query);
    }
    
    //comment may be an empty string
    public void addUserToQueue(String pin, Integer id, String location, String comment) {
        String query = "INSERT INTO Users VALUES ('"+pin+"', "+id+", '"+location+"','"+comment+"')";
        dbVoidCall(query);
    }

    public void removeUserFromQueue(String pin, Integer id) {
        String query = "DELETE FROM Queue WHERE Pin='"+pin+"' AND Activity_id="+id;
    }

    public void updateQueueStatus(Integer id, Boolean status) {
        String query = "UPDATE Activity SET Status = '"+status+"' WHERE id="+id;
        dbVoidCall(query);
    }

    public void authentication(String pin, String password) {
        //If there is time add hashing here
        auth(pin, password);
    }
    public List<String> getAllUsers(){
        String query = "select * from users";
        return dbListCall(query, "users");
    }
    
    private List<String> dbListCall(String query, String getObject){
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
    private void dbVoidCall(String query){
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
  
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try {
		stmt.close();
		conn.close();
            } catch (Exception e) {}
        }
    }
    
    private Boolean auth(String username, String password){
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from users WHERE Username='"+username+"'");
            while (rs.next()) {
                //Integer id = rs.getInt("id");
                //if(this.username.equals(rs.getString("username")) && this.password.equals(rs.getString("password"))){
                if(password.equals(rs.getString("password"))){
                    //userId = id;
                    rs.close();
                    return true;
                }
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
}
