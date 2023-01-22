<%-- 
    Document   : removeAdmin
    Created on : 2023-jan-16, 04:45:54
    Author     : Dante
--%>


<jsp:useBean class="Model.UseBean" id="ub" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Admin</title>
    </head>
    <body>
        <form>
            <input type='submit' value='Logout' name='signOut' />
            <input type='submit' value='Delete account' name='deleteUser' />
            <input type='submit' value='Select Activity' name='allActivites' />
            <%
                /*
                if(ub.getCurrentUser().getAdmin()){
                    out.print("<input type='submit' value='Set Admin' name='setAdmin' />");
                    out.print("<input type='submit' value='Delete Admin' name='removeAdmin' />");
                }*/
            %>
            
            
            <%
                
                for(int i = 0; i < ub.getAllUsers().size(); i++){
                    if(ub.isAdminInQueue(ub.getAllUsers().get(i).getPin(), Integer.parseInt(request.getParameter("removeAdmin")))){
                        out.print("<p>" + ub.getAllUsers().get(i).getUsername() + "<input type='submit' value='" + ub.getAllUsers().get(i).getPin() + "-" + request.getParameter("removeAdmin") + "' name='removeAdminResult' />");
                    }
                }
            %>
        </form>
    </body>
</html>
