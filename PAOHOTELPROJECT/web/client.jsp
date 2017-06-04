<%-- 
    Document   : client
    Created on : May 27, 2017, 6:47:13 PM
    Author     : Raluca Mindrut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="Client.css">
        <title>client</title>
    </head>
    <body background="Client.jpg">
        <h1>BUN VENIT IN MODUL CLIENT</h1>
           <section>
        <form action="Client">
         
            <h2> Poti alege sa vizualizezi camerele din PAOHOTEL</h2>
            <h3>Selecteaza camere in functie de:</h3>
            <h4> Pret:</h4>
                <input type="radio" name="pret" value="pretcrescator"/> Pret Crescator <br>
                <input type="radio" name="pret" value="pretdescrescator"/> Pret Descrescator<br>
              <h4> Pret:</h4>
                <input type="radio" name="tip" value="single"/> Tip Single <br>
                 <input type="radio" name="tip" value="twin"/> Tip Twin <br>
                  <input type="radio" name="tip" value="suit"/> Tip Suit <br>
                <h4> Extraoptiune:</h4>
                <input type="checkbox" name="extra1" value="aerconditionat"/> Aer Conditionat<br>
                 <input type="checkbox" name="extra2" value="spa"/> Spa <br>
                  <input type="checkbox" name="extra3" value="locparcare"/> Loc de parcare <br>
                  <input type="checkbox" name="extra4" value="balcon"/> Balcon <br>
                 <input type="checkbox" name="extra5" value="internet"/> Internet <br>
                  <input type="checkbox" name="extra6" value="micdejun"/> Mic Dejun <br>
                  <input type="checkbox" name="extra7" value="minibar"/> Mini Bar <br>
                  <br>
                  <br>
                <input type="submit" value="Cauta"  />
            </form>
                   </section>

    </body>
</html>
