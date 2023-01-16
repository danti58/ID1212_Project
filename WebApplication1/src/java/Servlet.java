/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.UseBean;
import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

 
    /*
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Retrieves the current session, if one doesn't exist it creates it
        HttpSession session = request.getSession(true);
        
        
        //Check if it's a request to sign up
        if(request.getParameter("username") != null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
            String PIN = request.getParameter("PIN");
            
            UseBean temp = new UseBean();
            temp.createUser(PIN, username, admin, password);
            session.setAttribute("ub", temp);
            //session.setAttribute("ub", new UseBean(PIN, username, admin, password));
           
        }
        //check if it is a request to sign in
        else if(request.getParameter("PIN") != null){
            String PIN = request.getParameter("PIN");
            String password = request.getParameter("password");
            
            UseBean temp = new UseBean();
            temp.login(PIN, password);
            session.setAttribute("ub", temp);
            
            //session.setAttribute("ub", new UseBean(username,password));
        }
        
        UseBean ub = (UseBean)session.getAttribute("ub");
        
        
        if(ub != null){
            if(ub.getCurrentUser() == null){
                ub = null;
            }
        }
            
        if(ub != null){
            //if user is signed in, check what kind of request it is
            /*if(request.getParameter("createUser") != null){
            
            }else*/ if(request.getParameter("deleteUser") != null){
                ub.deleteUser(ub.getCurrentUser().getPin());
                ub = null;
                RequestDispatcher rd = request.getRequestDispatcher("View/signIn.jsp");
                rd.forward(request, response); 
            }else if(request.getParameter("signOut") != null){
                ub = null;
                RequestDispatcher rd = request.getRequestDispatcher("View/signIn.jsp");
                rd.forward(request, response); 
            }else if(request.getParameter("setAdmin") != null){ 
                RequestDispatcher rd = request.getRequestDispatcher("View/setAdmin.jsp");
                rd.forward(request, response); 
            }else if(request.getParameter("setAdminResult") != null){ 
                
                //Set admin
                
                String[] res = request.getParameter("setAdminResult").split("-");
                
                ub.addAdmin(res[0], Integer.parseInt(res[1]));
                
                RequestDispatcher rd = request.getRequestDispatcher("View/allActivites.jsp");
                rd.forward(request, response); 
            }else if(request.getParameter("removeAdmin") != null){
                RequestDispatcher rd = request.getRequestDispatcher("View/removeAdmin.jsp");
                rd.forward(request, response);  
            }else if(request.getParameter("removeAdminResult") != null){
                
                String[] res = request.getParameter("removeAdminResult").split("-");
                
                ub.removeAdmin(res[0], Integer.parseInt(res[1]));
                
                RequestDispatcher rd = request.getRequestDispatcher("View/allActivites.jsp");
                rd.forward(request, response);  
            }else if(request.getParameter("addToQueue") != null){
                
                //Database Add user to queue with comment
                
                RequestDispatcher rd = request.getRequestDispatcher("View/queue.jsp");
                rd.forward(request, response);  
            }else if(request.getParameter("removeFromQueue") != null){
                
                //Database remove from queue
                
                RequestDispatcher rd = request.getRequestDispatcher("View/queue.jsp");
                rd.forward(request, response);  
            }else if(request.getParameter("openQueue") != null){
                RequestDispatcher rd = request.getRequestDispatcher("View/queue.jsp");
                rd.forward(request, response);  
            } else if(request.getParameter("allActivites") != null) {
                RequestDispatcher rd = request.getRequestDispatcher("View/allActivites.jsp");
                rd.forward(request, response);
            }else {
                RequestDispatcher rd = request.getRequestDispatcher("View/allActivites.jsp");
                rd.forward(request, response); 
            }
        }
        else if(request.getParameter("createUser") != null) {
            RequestDispatcher rd = request.getRequestDispatcher("View/signUp.jsp");
            rd.forward(request, response); 
        }
        else {
            request.getRequestDispatcher("View/signIn.jsp").include(request, response);
            
            
            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}