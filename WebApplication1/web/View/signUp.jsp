<%-- 
    Document   : signUp
    Created on : 2023-jan-14, 14:15:57
    Author     : Dante
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
        <h2>Create account here</h2>
        
        <form method='GET'>
            <p>Username <input type='text' name='username' />
            <p>Password <input type='text' name='password' />
            
            <div>
                <p>Admin
                <input type='radio' id='yes' name='admin' value='TRUE' />
                <label for='yes'>Yes</label>
                
                <input type='radio' id='no' name='admin' value='FALSE' checked />
                <label for='no'>No</label>
            </div>
            <p>PIN <input type='text' name='PIN' placeholder='yyyymmddxxxx' /><br><br>
            
            <input type='submit' value='Submit'>
            <!-- Change to signup -->
        </form>
        
        <form><input type='submit' value='signIn' name='login'></form>
    </body>
</html>