/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servleti;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bazadedate.BazaDeDate;

/**
 *
 * @author Alexandra-Andreea
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String mod = request.getParameter("mod");
        
        boolean gasit = false;
        
        RequestDispatcher view;
        
        if(username == null || username.trim().equals(""))
        {
            request.getSession().setAttribute("error", "Introduceti username!");
            view = request.getRequestDispatcher("login.jsp");
        }
        else
            if(password == null || password.trim().equals(""))
            {
                request.getSession().setAttribute("error", "Introduceti parola!");
                view = request.getRequestDispatcher("login.jsp");
            }
        else
            if(mod == null)
            {
                request.getSession().setAttribute("error", "Alegeti modul de logare!");
                view = request.getRequestDispatcher("login.jsp");
            }
        else
            if( BazaDeDate.login(username, password, mod))
            {
                if(mod.equals("receptioner"))
                    view = request.getRequestDispatcher("receptioner.jsp");
                else
                if(mod.equals("manager"))
                    view = request.getRequestDispatcher("manager.jsp");
                else
                    view = request.getRequestDispatcher("serviciu.jsp");
                
                request.getSession().setAttribute("username", username); 
                
            }
        else
            {
                request.getSession().setAttribute("error", "Datele introduse nu sunt corecte!");    
                view = request.getRequestDispatcher("login.jsp");
            }
        
        view.forward(request, response);
        
        /*
        try (PrintWriter out = response.getWriter()) 
        {
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("<p> " + username + "  " + password + " " + mod + "</p>");
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
