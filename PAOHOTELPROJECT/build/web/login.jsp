<%-- 
    Document   : login
    Created on : May 25, 2017, 7:59:57 PM
    Author     : Alexandra-Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <div>
            
            <form action="Login" method="post">
                Username: <input type="text" name="username" /> <br>
                Password: <input type="password" name="password" /> <br>
               
                <input type="radio" name="mod" value="Manager"/> Manager <br>
                <input type="radio" name="mod" value="Receptioner"/> Receptioner <br>
                <input type="radio" name="mod" value="Serviciu"/> Serviciu <br>
                <input type="submit" value="Login"  />
            </form>
        </div>
    </body>
</html>
