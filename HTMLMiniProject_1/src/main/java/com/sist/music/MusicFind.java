package com.sist.music;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
		servlet
			|
		  init() => 변수에 초기화
			   	    web.xml파일 읽기 , 자동 로그인
			|
		사용자 요청시마다 호출
		    |
		  doGet 
		  doPost
		 ---------- + service() => _jspService() => JSP파일은 사용자에서 전송하는 파일
		 	|										-------- 메소드 영역
		 메모리 해제
		 destory() => 화면 이동 / 브라우저 종료 / 새로고침 => _jspDestory()
		 
		 request  /response / session / cookie
		 -----------------------------  ------- 브라우저 관리
		 | 톰캣관리 						
		 
		 request / response : 지역변수 => 한번사용하면 초기화
		   => 서블릿 한개에서 사용이 가능
		 session/cookie : 전역변수 => 기간 만료 / 브라우저 종료
		 				  로그아웃 
		  => 모든 서블릿 파일에서 사용이 가능
		  
		 JSP = servelt 파일 변경 => 컴파일 => 실행 => 브라우저에서 HTML읽기
		 
		 Spring => 화면 JSP

 */
@WebServlet("/MusicFind")
public class MusicFind extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSP 파일 코딩 
		// 1. 브라우저로 전송 => HTML을 전송한다
				// HTML,XML,JSON => response(HTML,Cookie 전송이 가능)
				response.setContentType("text/html;charset=UTF-8");
				// 2. 브라우저 연결
				PrintWriter out = response.getWriter();

				// 사용자가 보내준 값을 받는다
				String strPage = request.getParameter("page");
				if (strPage == null) {
					strPage = "1";
				}
				int curpage = Integer.parseInt(strPage);

				String column = request.getParameter("column");
				String fd=request.getParameter("fd");
				
				MusicDAO dao = MusicDAO.newInstance();
				List<MusicVO> list = dao.musicFind(curpage, column, fd);
				int totalpage = dao.musicFindTotalpage(column, fd);

				final int BLOCK = 10;
				int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
				int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

				if (endPage > totalpage) {
					endPage = totalpage;
				}
				// => DAO에서 결과값을 받는다
				out.println("<html>");
				out.println("<head>");
				out.println(
						"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
				out.println("<link rel=stylesheet href=css/food.css>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div class=container>");
				out.println("<div class=\"row\">");
				out.println("<form method=post action=MainServlet?mode=8>");
				out.println("<select name=column class=intput-sm>");
				out.println("<option value=title>음악명</option>");
				out.println("<option value=album>앨범명</option>");
				out.println("<option value=singer>가수</option>");
				out.println("</select>");
				out.println("<input type=text name=fd size=15 class=intput-sm>");
				out.println("<button class=\"btn-sm btn-danger\">검색</button>");
				out.println("</form>");
				out.println("</div>");
				out.println("<div class=row style=\'margin-top:20px\'>");

				// response는 기능을 한개 수행이 가능 ------------------------------- 1. 쿠키 전송 => Detail이동
				// => HTML전송 2. HTML전송

				if(list!=null) {
					
				for (MusicVO vo : list) {
					out.println("<div class=\"col-md-3\">");
					out.println("<div class=\"thumbnail\">");
					out.println("<a href=\"MusicBeforeDetail?mno=" + vo.getMno() + "\">");
					out.println("<img src=" + vo.getPoster() + " style=\"width:200px; height:150px\">");
					out.println("<div class=\"caption\">");
					out.println("<p>" + vo.getTitle() + "</p>");
					out.println("</div>");
					out.println("</a>");
					out.println("</div>");
					out.println("</div>");
					}
				}
				out.println("</div>");
				out.println("<div class=\"row text-center\">");
				out.println("<ul class=\"pagination\">"); //
				out.println(" <li><a href=\"#\">&lt;</a></li>"); // <모양

				if (startPage > 1) {
					out.println("<li><a href=\"MainServlet?mode=8&column=" + column+"&fd="+fd + "&page=" + (startPage - 1) + "\">&lt;</a></li>");
				}

				for (int i = startPage; i <= endPage; i++) {

					if (i == curpage) {
						out.println(" <li class=active><a href=\"MainServlet?mode=8&column=" + column+"&fd="+fd + "&page=" + i + "\">" + i
								+ "</a></li>");
					} else {
						out.println(" <li><a href=\"MainServlet?mode=8&column=" + column+"&fd="+fd + "&page=" + i + "\">" + i + "</a></li>");
					}
				}

				if (endPage < totalpage) {
					out.println("<li><a href=\"MainServlet?mode=8&column=" + column+"&fd="+fd + "&page=" + (endPage + 1) + "\">&gt;</a></li>");
				}

				// out.println(" <li><a href=\"#\">&gt;</a></li>"); // > 모양
				out.println("</ul>");

				out.println("</div>");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
		
	}
}
