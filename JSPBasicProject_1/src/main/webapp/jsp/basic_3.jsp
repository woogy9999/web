<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// servlet 형식 => service메소드 영역
	// response.setContentType("text/html;charset=UTF-8")
	// PrintWrite out=response.getWriter()
	out.write("<html>");
	out.write("<body>");
	out.write("<h1>Hello Servlet!!</h1>");
	out.write("</body>");
	out.write("</html>");


%>
<%--
public class basic_3_jsp extends HttpServlet
 public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request,HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

   

    PageContext pageContext;
    HttpSession session = null;
    ServletContext application;
    ServletConfig config;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
    
      out.write("\r\n");
      out.write("    \r\n");

	// servlet 형식 => service메소드 영역
	// response.setContentType("text/html;charset=UTF-8")
	// PrintWrite out=response.getWriter()
	out.write("<html>");
	out.write("<body>");
	out.write("<h1>Hello Servlet!!</h1>");
	out.write("</body>");
	out.write("</html>");



      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>