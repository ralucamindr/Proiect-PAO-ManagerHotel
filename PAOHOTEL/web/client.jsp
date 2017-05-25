<%-- 
    Document   : client
    Created on : May 25, 2017, 3:21:33 PM
    Author     : Raluca Mindrut
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ResultSet resultSet=null; 
    Statement statement;
    Connection connection;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
      <%  
          connection= (Connection)session.getAttribute("connection");
        
         
          
         statement =connection.createStatement();
        String query = "SELECT * FROM camere";
	resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
					
                        %>
                        <p> 
                            <% resultSet.getString("nr_etaj");%>
                        </p>
                        <% }%>
                        
    </body>
</html>
