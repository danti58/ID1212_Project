<%-- 
    Document   : queue
    Created on : 2023-jan-13, 22:45:45
    Author     : Dante
--%>

<jsp:useBean class="Model.UseBean" id="ub" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Queue</title>
    </head>
    <body>
        <form>
            <input type='submit' value='Logout' name='signOut' />
            <input type='submit' value='Delete account' name='deleteUser' />
            <input type='submit' value='Select Activity' name='allActivites' />
        </form>
        <form>
        <%
            //Borde vara rätt kod för att uppdatera, kanske borde vara i servlet
            //response.setHeader("Refresh", "0; URL=request.getContextPath()");
            
            //response.setHeader("Refresh", "3; URL=request.getContextPath()");
            
            if(ub.getCurrentUser().getAdmin()){
                out.print("<p>SetAdmin<input type='submit' value='"+ request.getParameter("openQueue") + "' name='setAdmin' />");
                out.print("<p>deleteAdmin<input type='submit' value='"+ request.getParameter("openQueue") + "' name='removeAdmin' />");
                out.print("<p>Message<input type='submit' value='" + request.getParameter("openQueue") +"' name='Message' />");
            }
        %>
        </form>
        <h1>Hello World!</h1>
        
        <%
            for(int i = 0; i < ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).size(); i++){
                
                if(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin().equals(ub.getCurrentUser().getPin())){
                    out.print("<h1>" + ub.getUser(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin()).getUsername() + " " + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getComment() + "</h1>");
                    
                }
                else {
                    out.print("<p>" + ub.getUser(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin()).getUsername() + " " + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getComment() +  "</p>");
                }
                
                //Funkar inte med PIN vs username
                /*
                if(ub.isUserInQueue(ub.getAllUsers().get(i))){
                    if(ub.getAllUsers().get(i) == ub.getCurrentUser().get){
                        out.print("<h1>" + ub.getCurrentUser().getUsername() +"</h1>");
                    }
                    else {
                        out.print(ub.getAllUsers().get(i));
                    }
                }
                */
            }
           
        %>
        
        
            <%
                if(!ub.getCurrentUser().getUserIsInQueue()){
                    out.print("<p>Join queue</p>");
                    out.print("<form><input type='text' name='comment' placeholder='Write comment here'><input type='submit' value='" + request.getParameter("openQueue") + "' name='addToQueue' /></form>");
                }
                else{
                    out.print("<p>Leave queue</p>");
                    out.print("<form><input type='submit' value='" + request.getParameter("openQueue") + "' name='removeFromQueue' /></form>");
                }
            %>
        
    </body>
</html>
