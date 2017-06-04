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
 * @author Alexandra-Andreea
 */
public class Receptioner extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String metoda = request.getParameter("radio");
        if(metoda == null)
        {
             request.getSession().setAttribute("camera", "Selecteaza o bulina");
             request.getRequestDispatcher("receptioner.jsp").forward(request, response);
        }
        else
                if(metoda.equals("verifica"))
                {
                    try (PrintWriter out = response.getWriter()) 
                    {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet Receptioner</title>");
                        out.println("</head>");
                        out.println("<body background='receptie.jpg'>"); 
                        out.println("<table>");
                        out.println("<tr>");
                        out.println("<td> Camera </td>");
                        out.println("<td> Stare </td>");
                        out.println("</tr>");
                        out.println(BazaDeDate.verificaCamere());
                        out.println("</table>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }
                else
                    if(metoda.equals("afiseaza"))
                    {
                        String nr_camera = request.getParameter("camera");
                        if(nr_camera == null || nr_camera.trim().equals(""))
                            request.getSession().setAttribute("camera", "Introduceti numarul camerei" );
                        else
                            request.getSession().setAttribute("camera", BazaDeDate.afiseazaCamera(nr_camera));
                        
                        request.getRequestDispatcher("receptioner.jsp").forward(request, response);
                    }
                else
                    if(metoda.equals("rezerva"))
                    {
                        String nr_camera = request.getParameter("camerarez");
                        String data_check_out = request.getParameter("check_in");
                        String data_check_in = request.getParameter("check_out");
                        if(nr_camera == null || nr_camera.trim().equals(""))
                            request.getSession().setAttribute("camera", "Introduceti numarul camerei" );
                        else
                            request.getSession().setAttribute("camera", BazaDeDate.rezervaCamera(nr_camera, data_check_in, data_check_out));
                        
                        request.getRequestDispatcher("receptioner.jsp").forward(request, response);
                    }
                
            }
        
            
        }
        
    
    

    


