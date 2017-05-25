<%-- 
    Document   : index
    Created on : May 25, 2017, 12:56:43 PM
    Author     : Raluca Mindrut
--%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>WELCOME TO PAO HOTEL! </h2>
        
        <button>Login </button>
         <input type="button" value="Client" onclick="window.location='client.jsp'" >
     
    </body>
</html>
