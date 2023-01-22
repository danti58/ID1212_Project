<%-- 
    Document   : signin
    Created on : 2023-jan-12, 21:23:26
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to O'Laoghaires!</h1>
        <h2>Please sign in</h2>
        
        <form method='GET'>
            <p>PIN <input type='text' name='PIN' />
            <p>Password <input type='text' name='password' /><br>
            <input type='submit' value='Submit'>
            
        </form>
        
        <form><input type='submit' value='SignUp' name='createUser'></form>
        
    </body>
</html>