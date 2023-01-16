<%-- 
    Document   : setAdmin
    Created on : 2023-jan-16, 03:56:37
    Author     : Dante
--%>

<jsp:useBean class="Model.UseBean" id="ub" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Set Admin</title>
    </head>
    <body>
        
        <input type='submit' value='Logout' name='signOut' />
        <input type='submit' value='Delete account' name='deleteUser' />
        <%
            if(ub.getCurrentUser().getAdmin()){
                out.print("<input type='submit' value='Set Admin' name='setAdmin' />");
                out.print("<input type='submit' value='Delete Admin' name='removeAdmin' />");
            }
        %>
        <h1>brah</h1>
        <form>
            <%
                //Query funkar inte
                for(int i = 0; i < ub.getAllUsers().size(); i++){
                    if(!ub.isAdmin(ub.getUserPIN(ub.getAllUsers().get(i)))){
                        out.print("<p>" + ub.getAllUsers().get(i) + "</p>");
                    }
                }
            %>
        </form>
    </body>
</html>
