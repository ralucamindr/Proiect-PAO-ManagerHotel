/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servleti;

import bazadedate.BazaDeDate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raluca Mindrut
 */
public class Client extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String pret = request.getParameter("pret");
            String tip = request.getParameter("tip");
            String extra1 = request.getParameter("extra1");
            String extra2 = request.getParameter("extra2");
            String extra3 = request.getParameter("extra3");
            String extra4 = request.getParameter("extra4");
            String extra5 = request.getParameter("extra5");
            String extra6 = request.getParameter("extra6");
            String extra7 = request.getParameter("extra7");
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head >");
            out.println("<title>Client</title>");            
            out.println("</head>");
            out.println("<body background='Client.jpg'>");
            out.println("<h1 style='text-align: center;'>"+"BUN VENIT IN MODUL CLIENT"+ "</h1>");
           
             out.println("<p style='text-align:center';margin-left:auto; margin-right:auto;width:75%; >");
              out.println("Camere la PAOHOTEL:"+"<br>");
            BazaDeDate.cauta_camere(pret,tip,out);
            out.println("</p>");
            if(extra1!=null||extra2!=null||extra3!=null||extra4!=null||extra5!=null||extra6!=null||extra7!=null){
               
                 out.println("<p style='text-align:center';margin-left:auto; margin-right:auto;width:75%; >");
                  out.println("Camere cu extraoptiunea dorita:");
                out.println("<br>");
                BazaDeDate.cauta_extra(extra1, out);
                BazaDeDate.cauta_extra(extra2, out);
                BazaDeDate.cauta_extra(extra3, out);
                BazaDeDate.cauta_extra(extra4, out);
                BazaDeDate.cauta_extra(extra5, out);
                BazaDeDate.cauta_extra(extra6, out);
                BazaDeDate.cauta_extra(extra7, out);
                out.println("</p>");
                
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
