package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FormCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Gestión de Clientes</title>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            background-color: #f0f8ff;\n");
      out.write("            color: #333;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("            height: 100vh;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            background-color: #fff;\n");
      out.write("            border: 2px solid #4CAF50;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            padding: 20px;\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            width: 350px;\n");
      out.write("        }\n");
      out.write("        h1 {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px;\n");
      out.write("            margin: -20px -20px 20px -20px;\n");
      out.write("            border-radius: 10px 10px 0 0;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        label {\n");
      out.write("            display: block;\n");
      out.write("            margin: 10px 0 5px;\n");
      out.write("        }\n");
      out.write("        input {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 8px;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("        button {\n");
      out.write("            background-color: #4CAF50;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("            width: 100%;\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("        }\n");
      out.write("        button:hover {\n");
      out.write("            background-color: #45a049;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h1>Gestión de Clientes</h1>\n");
      out.write("        <!-- Formulario para Registrar Cliente -->\n");
      out.write("        <form action=\"ClienteControl\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"accion\" value=\"registrar\">\n");
      out.write("            <label>Nombre:</label>\n");
      out.write("            <input type=\"text\" name=\"nombre\" required>\n");
      out.write("            <label>Apellido:</label>\n");
      out.write("            <input type=\"text\" name=\"apellido\" required>\n");
      out.write("            <label>Dirección:</label>\n");
      out.write("            <input type=\"text\" name=\"direccion\" required>\n");
      out.write("            <label>Teléfono:</label>\n");
      out.write("            <input type=\"text\" name=\"telefono\" required>\n");
      out.write("            <button type=\"submit\">Registrar</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <!-- Formulario para Actualizar Cliente -->\n");
      out.write("        <form action=\"ClienteControl\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"accion\" value=\"actualizar\">\n");
      out.write("            <label>ID Cliente (Actualizar):</label>\n");
      out.write("            <input type=\"number\" name=\"idCliente\" required>\n");
      out.write("            <button type=\"submit\">Actualizar</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <!-- Formulario para Eliminar Cliente -->\n");
      out.write("        <form action=\"ClienteControl\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"accion\" value=\"eliminar\">\n");
      out.write("            <label>ID Cliente (Eliminar):</label>\n");
      out.write("            <input type=\"number\" name=\"idCliente\" required>\n");
      out.write("            <button type=\"submit\">Eliminar</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
