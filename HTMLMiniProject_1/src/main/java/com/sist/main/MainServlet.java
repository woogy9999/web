package com.sist.main;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		// 사용자 요청 페이지를 받는다
		String mode=request.getParameter("mode");
		if(mode==null) {
			mode="5";
		}
		String page=ChangeServlet.pageChange(Integer.parseInt(mode));
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<link rel=stylesheet href=css/food.css>");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		String html="<nav class=\"navbar navbar-inverse\">"
			+ "  <div class=\"container-fluid\">"
			+ "    <div class=\"navbar-header\">"
			+ "      <a class=\"navbar-brand\" href=\"MainServlet\">Food & Music</a>"
			+ "    </div>"
			+ "    <ul class=\"nav navbar-nav\">"
			+ "      <li class=\"active\"><a href=\"MainServlet\">Home</a></li>"
			+ "      <li class=\"dropdown\">"
			+ "        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">맛집"
			+ "        <span class=\"caret\"></span></a>"
			+ "        <ul class=\"dropdown-menu\">"
			+ "          <li><a href=\"MainServlet?mode=3\">맛집검색 1</a></li>"
			+ "          <li><a href=\"MainServlet?mode=4\">맛집검색 2</a></li>"
			+ "        </ul>"
			+ "      </li>"
			+ "		 <li class=\"dropdown\">"
			+ "        <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">뮤직"
			+ "        <span class=\"caret\"></span></a>"
			+ "        <ul class=\"dropdown-menu\">"
			+ "          <li><a href=\"MainServlet?mode=5\">뮤직목록</a></li>"
			+ "          <li><a href=\"MainServlet?mode=7\">뮤직검색 1</a></li>"
			+ "          <li><a href=\"MainServlet?mode=8\">뮤직검색 2</a></li>"
			+ "        </ul>"
			+ "      </li>"
			+ "      <li><a href=\"#\">게시판</a></li>"
			+ "      <li><a href=\"#\">기타</a></li>"
			+ "    </ul>"
			+ "  </div>"
			+ "</nav>";
		out.println(html);
		
		HttpSession session=request.getSession();
		
		//session.setAttribute("id", "hong");
		//session.setAttribute("name", "홍길동");
		
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");

		out.println("<div class=container>");
		out.println("<div class=\"row text-right\">");
		if(id==null) { //로그인이 안된 상태
			
			// 로그인창
			out.println("<form method=post action=LoginServlet>");
			
			out.println("ID:");
			out.println("<input type=text name=id size=15 class=input-sm required>");
			out.println("Password:");
			out.println("<input type=password name=pwd size=15 class=input-sm required>");
			
			out.println("<input type=submit value=로그인 class=\"btn-sm btn-danger\">");
			
			out.println("</form>");
			
		}else { // 로그인이 된 상태
			
			// 로그아웃
			out.println("<form method=get action=LoginServlet>");
			out.println(name+"님 로그인중입니다!!");
			out.println("<input type=submit value=로그아웃 class=\"btn-sm btn-success\">");
			out.println("</form>");
		}
		out.println("</div>");
		out.println("</div>");
		//화면 출력
		RequestDispatcher rd=request.getRequestDispatcher(page);
		rd.include(request, response);
		out.println("</body>");
		out.println("</html>");
	}

}
