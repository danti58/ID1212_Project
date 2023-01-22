<%-- 
    Document   : allActivites
    Created on : 2023-jan-12, 21:27:26
--%>


<%@page import="Model.Activity"%>
<%@page import="java.util.List"%>
<jsp:useBean class="Model.UseBean" id="ub" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Activity Selector</title>
    </head>
    <body>
        <form>
            <input type='submit' value='Logout' name='signOut' />
            <input type='submit' value='Delete account' name='deleteUser' />
            <%
                
            %>
        </form>
        <h1>Hello Activities!</h1>
        
       
            <%
                List<Activity> allActivities = ub.getAllActivities();
                for(int i = 0; i < allActivities.size();i++){
                    Integer id = allActivities.get(i).getId();
                    if(allActivities.get(i).getstatus()){
                        out.print("<form><input type='hidden' value='" +  id + "' name='openQueue'><input type='submit' value='" + allActivities.get(i).getName() + "'/></form>");//name='openQueue'
                    }else{
                        out.print("<h3> "+ allActivities.get(i).getName() + " [closed] </h3>");//name='openQueue'
                    }
                    if(ub.getCurrentUser().getAdmin()){
                            out.print("<form><input type='hidden' value='"+ id + "' name='toggleQueueStatus'/><input type='submit' value='Toggle Queue Status' /></form><br>");
                    }
                }
            %>
        
    </body>
</html>