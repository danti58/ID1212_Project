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
        
        <%
            //Borde vara rätt kod för att uppdatera, kanske borde vara i servlet
            //response.setHeader("Refresh", "0; URL=request.getContextPath()");
            
            //response.setHeader("Refresh", "3; URL=request.getContextPath()");
            
            if(ub.getCurrentUser().getAdmin()){
                out.print("<form><input type='hidden' value='"+ request.getParameter("openQueue") + "' name='setAdmin' /><input type='submit' value='Set Admin' /></form>");
                out.print("<form><input type='hidden' value='"+ request.getParameter("openQueue") + "' name='removeAdmin' /><input type='submit' value='Remove Admin' /></form>");
                out.print("<form><input type='hidden' value='"+ request.getParameter("openQueue") + "' name='sendMessage' /><input type='submit' value='Send Message to Queue' /></form>");
            }
        %>
        
        <h1>Queue</h1>
        
        <%
            for(int i = 0; i < ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).size(); i++){
                
                if(ub.getCurrentUser().getAdmin()){
                    if(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin().equals(ub.getCurrentUser().getPin())){
                    out.print("<p style='color:green; display: inline-block;'>" + ub.getUser(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin()).getUsername() + "</p><p style='display: inline-block;' >: " + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getComment() + "</p><form style='display: inline-block;' ><input type='hidden' value='" + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin() + "' name='removeUserFromQueue' /><input type='hidden' value='" + request.getParameter("openQueue") +"' name='queueID' /><input type='submit' value='Remove' /></form>");
                    
                    }
                    else {
                        out.print("<div><p style='color:blue; display: inline-block; '>" + ub.getUser(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin()).getUsername() + "</p><p style='display: inline-block; '>: " + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getComment() + "</p><form style='display: inline-block;' ><input type='hidden' value='" + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin() + "' name='removeUserFromQueue' /><input type='hidden' value='" + request.getParameter("openQueue") +"' name='queueID' /><input type='submit' value='Remove' /></form>");
                    }
                }
                
                else{
                    if(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin().equals(ub.getCurrentUser().getPin())){
                    out.print("<p style='color:green; display: inline-block;'>" + ub.getUser(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin()).getUsername() + "</p><p style='display: inline-block;' >: " + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getComment() + "</p>");
                    
                    }
                    else {
                        out.print("<div><p style='color:blue; display: inline-block; '>" + ub.getUser(ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getPin()).getUsername() + "</p><p style='display: inline-block; '>: " + ub.getAllQueues(Integer.parseInt(request.getParameter("openQueue"))).get(i).getComment() + "</p></div>");
                    } 
                }
                
               
            }
           
        %>
        
        
            <%
                if(ub.isUserInCurrentQueue(ub.getCurrentUser().getPin(), Integer.parseInt(request.getParameter("openQueue")))){
                    
                    out.print("<form><input type='hidden' value='" + request.getParameter("openQueue") + "' name='removeFromQueue' /><input type='submit' value='Leave queue' /></form>");
                    
                    /*if(!ub.getCurrentUser().getUserIsInQueue()){
                        
                    }   
                    else{
                        out.print("<form><input type='hidden' value='" + request.getParameter("openQueue") + "' name='removeFromQueue' /><input type='submit' value='Leave queue' /></form>");
                    }*/
                }
                else {
                    if(ub.getCurrentUser().getUserIsInQueue() ){
                        out.print("<h1 style='color:red;'>Leave current queue before joining a new one</h1>");
                    }
                    else {
                        out.print("<form><input type='hidden' value='" + request.getParameter("openQueue") + "' name='addToQueue' /><input type='text' name='comment' placeholder='Write comment here' /><input type='submit' value='Join queue' /></form>");
                    }
                }
            %>
        
    </body>
</html>
