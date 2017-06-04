/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servleti;

import bazadedate.BazaDeDate;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandra-Andreea
 */
public class Manager1 extends HttpServlet {

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
        
        
        RequestDispatcher view ;
        
        int nrcam = Integer.parseInt((String) request.getSession().getAttribute("nrcam1"));
        
            request.getSession().setAttribute("verificare","da");
        for(int i=1; i<=nrcam; i++)
        {
        String numarcamera = request.getParameter(i + "numarcamera");
        String etaj = request.getParameter(i +"etaj");
        String tip = request.getParameter(i + "tip");
        String pret = request.getParameter(i + "pret");
        String extra1 = request.getParameter(i + "extra1");
        String extra2 = request.getParameter(i + "extra2");
        String extra3 = request.getParameter(i + "extra3");
        String extra4 = request.getParameter(i + "extra4");
        String extra5 = request.getParameter(i + "extra5");
        String extra6 = request.getParameter(i + "extra6");
        String extra7 = request.getParameter(i + "extra7");
        
        
        if(numarcamera==null){
            request.getSession().setAttribute("error1", "Adaugati numarul camerei!");    
         
        }
        else if (etaj==null){
            request.getSession().setAttribute("error1", "Adaugati numarul etajului!");    
           
        }
        else if(tip==null)
        {
            
            request.getSession().setAttribute("error1", "Adaugati tipul camerei!");    
        
        
        
        }
        
         else if(pret==null){
            request.getSession().setAttribute("error1", "Adaugati pretul camerei!");    
         
            
        }
        
         else {
             
             BazaDeDate.add(numarcamera,etaj,tip,pret);
             if(extra1!=null)
                 BazaDeDate.addopt(numarcamera,extra1);
             if(extra2!=null)
                 BazaDeDate.addopt(numarcamera,extra2);
             if(extra3!=null)
                 BazaDeDate.addopt(numarcamera,extra3);
             if(extra4!=null)
                 BazaDeDate.addopt(numarcamera,extra4);
             if(extra5!=null)
                 BazaDeDate.addopt(numarcamera,extra5);
             if(extra6!=null)
                 BazaDeDate.addopt(numarcamera,extra6);
             if(extra7!=null)
                 BazaDeDate.addopt(numarcamera,extra7); 
             request.getSession().setAttribute("error1", "Ati adaugat cu succes " + nrcam + " camere!"); 
         }
        }
        view = request.getRequestDispatcher("login.jsp");
        view.forward(request, response);
        
        
        /*
        try (PrintWriter out = response.getWriter()) {
            
            
            
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Manager1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Manager1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        */
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
