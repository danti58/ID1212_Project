<%-- 
    Document   : allActivites
    Created on : 2023-jan-13, 22:39:58
    Author     : Dante
--%>

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
                /*
                if(ub.getCurrentUser().getAdmin()){
                    out.print("<input type='submit' value='Set Admin' name='setAdmin' />");
                    out.print("<input type='submit' value='Delete Admin' name='removeAdmin' />");
                }*/

            %>
        </form>
        <h1>Hello World!</h1>
        
        <form>
            <%
                
                for(int i = 0; i < ub.getAllActivities().size();i++){
                    out.print("<p>" + ub.getAllActivities().get(i).getName() + "<input type='submit' value='" +  ub.getAllActivities().get(i).getId() + "' name='openQueue' />");
                    
                }
            %>
        </form>
    </body>
</html>
