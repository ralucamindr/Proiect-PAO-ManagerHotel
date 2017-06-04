<%-- 
    Document   : receptioner
    Created on : May 26, 2017, 10:29:37 AM
    Author     : Alexandra-Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="manager.css">
        <title>JSP Page</title>
    </head>
    <body background='receptie.jpg'>
        
        <h1> Receptioner </h1>
        
        <% String nume = (String) request.getSession().getAttribute("username"); %>
        
        <h2>Bine ai revenit, <%= nume %> !</h2>
        <section> 
        <form action="Receptioner" method="post">
            <input type="radio" name="radio" value="verifica" > Verifica starea camerelor 
            <br> <br>
            <input type="radio" name="radio" value="afiseaza" > Afiseaza informatii despre camera:
            <input type="text" name="camera">
            <br> <br>
            <input type="radio" name="radio" value="rezerva" > Rezerva camera: <input type="text" name="camerarez">
            <br> <br> Data check_in: <input type="text" name="check_in"> Data check_out: <input type="text" name="check_out">
            <br> <br>
            <input type="submit" value="Verifica">
            
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
