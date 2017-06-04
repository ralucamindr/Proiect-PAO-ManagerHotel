package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class receptioner_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"manager.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body background='receptie.jpg'>\n");
      out.write("        \n");
      out.write("        <h1> Receptioner </h1>\n");
      out.write("        \n");
      out.write("        ");
 String nume = (String) request.getSession().getAttribute("username"); 
      out.write("\n");
      out.write("        \n");
      out.write("        <h2>Bine ai revenit, ");
      out.print( nume );
      out.write(" !</h2>\n");
      out.write("        \n");
      out.write("        <form action=\"Receptioner\" method=\"post\">\n");
      out.write("            <input type=\"radio\" name=\"radio\" value=\"verifica\" > Verifica starea camerelor \n");
      out.write("            <br> <br>\n");
      out.write("            <input type=\"radio\" name=\"radio\" value=\"afiseaza\" > Afiseaza informatii despre camera:\n");
      out.write("            <input type=\"text\" name=\"camera\">\n");
      out.write("            <br> <br>\n");
      out.write("            <input type=\"radio\" name=\"radio\" value=\"rezerva\" > Rezerva camera: <input type=\"text\" name=\"camerarez\">\n");
      out.write("            <br> <br> Data check_in: <input type=\"text\" name=\"check_in\"> Data check_out: <input type=\"text\" name=\"check_out\">\n");
      out.write("            <br> <br>\n");
      out.write("            <input type=\"submit\" value=\"Verifica\">\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("            \n");
      out.write("            ");

                String camera = (String) request.getSession().getAttribute("camera");
                if(camera != null)
                {
            
      out.write("\n");
      out.write("                <p> ");
      out.print( camera );
      out.write(" </p>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
