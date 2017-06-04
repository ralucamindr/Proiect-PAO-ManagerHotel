package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <body background=\"manager.jpg\">\n");
      out.write("        \n");
      out.write("        <h1> Manager </h1>\n");
      out.write("        \n");
      out.write("  \n");
      out.write("        ");
 String nrcam = (String) session.getAttribute("nrcam1");
            String nretaj = (String) session.getAttribute("nretaj");
            if (nrcam == null)
            { 
      out.write("\n");
      out.write("       \n");
      out.write("             ");
 String nume = (String) request.getSession().getAttribute("username"); 
      out.write("\n");
      out.write("        <h2>Bine ai revenit,");
      out.print( nume );
      out.write("  !</h2>\n");
      out.write("        <h2>Adauga un nou etaj! </h2>\n");
      out.write("        <section>\n");
      out.write("        <form action=\"Manager\">\n");
      out.write("              <input type=\"radio\" name=\"nrcam\" value=\"3\"/> 3 Camere <br>\n");
      out.write("                 <input type=\"radio\" name=\"nrcam\" value=\"4\"/> 4 Camere <br>\n");
      out.write("                 <input type=\"radio\" name=\"nrcam\" value=\"5\"/> 5 Camere <br><br><br>\n");
      out.write("                 <input type=\"submit\" value=\"Adauga\"  /> <br><br>\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("         ");

                String error = (String) request.getSession().getAttribute("error");
                if(error != null)
                {
            
      out.write("\n");
      out.write("            <section> ");
      out.print( error );
      out.write(" </section>\n");
      out.write("            ");

                }}
            
      out.write("\n");
      out.write("            \n");
      out.write("            ");
if(nrcam!=null){
      out.write("\n");
      out.write("            <h2>Ati ales sa adaugati ");
      out.print(nrcam);
      out.write(" camere!</h2>\n");
      out.write("            <section>\n");
      out.write("            <form action=\"Manager1\">\n");
      out.write("               ");
 for(int i=1;i<=Integer.parseInt(nrcam);i++){
                        
      out.write("\n");
      out.write("                        <h2>Camera ");
      out.print(nretaj);
      out.write('0');
      out.print(i);
      out.write(" </h2>\n");
      out.write("                       \n");
      out.write("                        <input type=\"radio\" name=\"");
      out.print(i);
      out.write("numarcamera\" value=");
      out.print(nretaj);
      out.write('0');
      out.print(i);
      out.write(" /> Camera ");
      out.print(nretaj);
      out.write('0');
      out.print(i);
      out.write(" \n");
      out.write("                        <h2>Etaj</h2>\n");
      out.write("                        <input type=\"radio\" name=\"");
      out.print(i);
      out.write("etaj\" value=\"");
      out.print(nretaj);
      out.write("\" /> Etaj ");
      out.print(nretaj );
      out.write("\n");
      out.write("                        <h2>Tip</h2>\n");
      out.write("                        <input type=\"radio\" name=\"");
      out.print(i);
      out.write("tip\" value=\"single\" /> Single\n");
      out.write("                              <input type=\"radio\" name=\"");
      out.print(i);
      out.write("tip\" value=\"twin\" /> Twin\n");
      out.write("                              <input type=\"radio\" name=\"");
      out.print(i);
      out.write("tip\" value=\"suit\" /> Suit\n");
      out.write("                        <h2>Pret</h2>   <input type=\"radio\" name=\"");
      out.print(i);
      out.write("pret\" value=\"3000\" /> 3000\n");
      out.write("                                 <input type=\"radio\" name=\"");
      out.print(i);
      out.write("pret\" value=\"4000\" /> 4000\n");
      out.write("                                 <input type=\"radio\" name=\"");
      out.print(i);
      out.write("pret\" value=\"5000\" /> 5000\n");
      out.write("                        <h2>Extraoptiuni</h2>\n");
      out.write("                                <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra1\" value=\"aerconditionat\"/> Aer Conditionat\n");
      out.write("                                <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra2\" value=\"spa\"/> Spa \n");
      out.write("                                  <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra3\" value=\"locparcare\"/> Loc de parcare \n");
      out.write("                                    <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra4\" value=\"balcon\"/> Balcon \n");
      out.write("                                    <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra5\" value=\"internet\"/> Internet \n");
      out.write("                                         <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra6\" value=\"micdejun\"/> Mic Dejun \n");
      out.write("                                         <input type=\"checkbox\" name=\"");
      out.print(i);
      out.write("extra7\" value=\"minibar\"/> Mini Bar \n");
      out.write("                         \n");
      out.write("                        <br>\n");
      out.write("                   ");
 } 
      out.write("\n");
      out.write("         \n");
      out.write("                <input type=\"submit\" value=\"Adauga\"  />\n");
      out.write("            </form>\n");
      out.write("            </section>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        \n");
      out.write("                        ");

                String error1 = (String) request.getSession().getAttribute("error1");
                if(error1 != null)
                {
            
      out.write("\n");
      out.write("                <p> ");
      out.print( error1 );
      out.write(" </p>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("     \n");
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
