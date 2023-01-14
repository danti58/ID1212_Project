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
        String query = "INSERT INTO Users VALUES ('"+pin+"', '"+username+"', '"+admin+"','"+password+"')";
        dbVoidCall(query);
    }

    public void deleteUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void removeUserFromQueue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateQueueStatus(Integer id, Boolean status) {
        String query = "UPDATE Activity SET Status = '"+status+"' WHERE id="+id;
        dbVoidCall(query);
    }

    public void authentication() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<String> getAllUsers(){
        List<String> list  = new ArrayList<String>();
        
        Statement stmt = null;
        Connection conn = null;
        
        try{
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");

            DataSource ds = (DataSource)envContext.lookup("jdbc/derby");
            conn = ds.getConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            
            while (rs.next()) {
                list.add(rs.getString("USERNAME"));
               
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
}
