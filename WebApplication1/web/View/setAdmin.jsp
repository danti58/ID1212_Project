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
        <form>
            <input type='submit' value='Logout' name='signOut' />
            <input type='submit' value='Delete account' name='deleteUser' />
            <input type='submit' value='Select Activity' name='allActivites' />
        </form>

        <h1>Set Admin</h1>
            <%
                for(int i = 0; i < ub.getAllUsers().size(); i++){
                    if(ub.isAdmin(ub.getAllUsers().get(i).getPin())){
                        if(!ub.isAdminInQueue(ub.getAllUsers().get(i).getPin(), Integer.parseInt(request.getParameter("setAdmin")))){
                            out.print("<form><input type='hidden' value='" + ub.getAllUsers().get(i).getPin() + "-" + request.getParameter("setAdmin") +"' name='setAdminResult' /><input type='submit' value='" + ub.getAllUsers().get(i).getUsername() + "' /></form>");
                        }
                    }
                }
            %>
    </body>
</html>
