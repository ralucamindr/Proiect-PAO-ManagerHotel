<%-- 
    Document   : manager
    Created on : May 27, 2017, 5:35:22 PM
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
    <body background="manager.jpg">
        
        <h1> Manager </h1>
        
  
        <% String nrcam = (String) session.getAttribute("nrcam1");
            String nretaj = (String) session.getAttribute("nretaj");
            if (nrcam == null)
            { %>
       
             <% String nume = (String) request.getSession().getAttribute("username"); %>
        <h2>Bine ai revenit,<%= nume %>  !</h2>
        <h2>Adauga un nou etaj! </h2>
        <section>
        <form action="Manager">
              <input type="radio" name="nrcam" value="3"/> 3 Camere <br>
                 <input type="radio" name="nrcam" value="4"/> 4 Camere <br>
                 <input type="radio" name="nrcam" value="5"/> 5 Camere <br><br><br>
                 <input type="submit" value="Adauga"  /> <br><br>
            </form>
        </section>
        
         <%
                String error = (String) request.getSession().getAttribute("error");
                if(error != null)
                {
            %>
            <section> <%= error %> </section>
            <%
                }}
            %>
            
            <%if(nrcam!=null){%>
            <h2>Ati ales sa adaugati <%=nrcam%> camere!</h2>
            <section>
            <form action="Manager1">
               <% for(int i=1;i<=Integer.parseInt(nrcam);i++){
                        %>
                        <h2>Camera <%=nretaj%>0<%=i%> </h2>
                       
                        <input type="radio" name="<%=i%>numarcamera" value=<%=nretaj%>0<%=i%> /> Camera <%=nretaj%>0<%=i%> 
                        <h2>Etaj</h2>
                        <input type="radio" name="<%=i%>etaj" value="<%=nretaj%>" /> Etaj <%=nretaj %>
                        <h2>Tip</h2>
                        <input type="radio" name="<%=i%>tip" value="single" /> Single
                              <input type="radio" name="<%=i%>tip" value="twin" /> Twin
                              <input type="radio" name="<%=i%>tip" value="suit" /> Suit
                        <h2>Pret</h2>   <input type="radio" name="<%=i%>pret" value="3000" /> 3000
                                 <input type="radio" name="<%=i%>pret" value="4000" /> 4000
                                 <input type="radio" name="<%=i%>pret" value="5000" /> 5000
                        <h2>Extraoptiuni</h2>
                                <input type="checkbox" name="<%=i%>extra1" value="aerconditionat"/> Aer Conditionat
                                <input type="checkbox" name="<%=i%>extra2" value="spa"/> Spa 
                                  <input type="checkbox" name="<%=i%>extra3" value="locparcare"/> Loc de parcare 
                                    <input type="checkbox" name="<%=i%>extra4" value="balcon"/> Balcon 
                                    <input type="checkbox" name="<%=i%>extra5" value="internet"/> Internet 
                                         <input type="checkbox" name="<%=i%>extra6" value="micdejun"/> Mic Dejun 
                                         <input type="checkbox" name="<%=i%>extra7" value="minibar"/> Mini Bar 
                         
                        <br>
                   <% } %>
         
                <input type="submit" value="Adauga"  />
            </form>
            </section>
                        <%}%>
                        
                        <%
                String error1 = (String) request.getSession().getAttribute("error1");
                if(error1 != null)
                {
            %>
                <p> <%= error1 %> </p>
            <%
                }
            %>


        
     
        
        
    </body>
</html>
