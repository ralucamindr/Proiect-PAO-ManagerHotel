<%-- 
    Document   : serviciu
    Created on : May 27, 2017, 5:35:08 PM
    Author     : Alexandra-Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="manager.css">
        <title>Page</title>
    </head>
    <body background="serviciu.jpg">
        
        <h1> Serviciu </h1>
        
        <% String nume = (String) request.getSession().getAttribute("username"); %>
        
        <h2>Bine ai revenit, <%= nume %> !</h2>
        
        <section>
        <form action="Serviciu" method="post">
            Declara camera: <input type="text" name="nr_camera"> ca fiind curatata.
            <br> <br>
            <input type="submit" value="Curata">
            
        </form>
        
            
            <%
                String camera = (String) request.getSession().getAttribute("camera");
                if(camera != null)
                {
            %>
                <p> <%= camera %> </p>
            <%
                }
            %>
        </section>
    </body>
</html>
