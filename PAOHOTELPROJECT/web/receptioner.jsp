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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% String nume = (String) request.getSession().getAttribute("nume"); %>
        
        <p> <%= nume %> </p>
    </body>
</html>
