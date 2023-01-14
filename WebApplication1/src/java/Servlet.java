

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

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //request.getParameter()to dread 
    //request.getSession()
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Retrieves the current session, if one doesn't exist it creates it
        HttpSession session = request.getSession(true);
        
         
        try{
            
            //check if it is a request to sign in
            if(request.getParameter("username") != null){
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                session.setAttribute("ub", new UseBean(username,password));
            }

            UseBean ub = (UseBean)session.getAttribute("ub");

            if(ub != null){
                //if user is signed in, check what kind of request it is
                if(request.getParameter("createUser") != null){

                }else if(request.getParameter("deleteUser") != null){

                }else if(request.getParameter("setAdmin") != null){ 

                }else if(request.getParameter("removeAdmin") != null){

                }else if(request.getParameter("addToQueue") != null){

                }else if(request.getParameter("removeFromQueue") != null){

                }else if(request.getParameter("openQueue") != null){

                }
            }                    
            
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.forward(request, response); 
          
        }catch(Exception e){
            out.print(e.getMessage());
       
        }
        
       
        
    }
    /*
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    */

}
