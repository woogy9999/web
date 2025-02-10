<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%-- 
		JSP : JAVA Server Page => 서버에서 실행되는 자바 파일
   			  = Back-End
   			  = JSP : Servlet을 쉽게 작성이 가능하게 만든 파일
   			  		  => 영역 : doGet/doPost
   			  		  => 메소드 영역이다 => 대부분은 지역변수
   			  		  => JSP는 View역할 (화면 출력)
   			  		  => Front-End로 전향
   			  		   
   			  = Servlet : 보안 (라이브러리 , 보안 파일 , 연결)
   			  				   -------- 스프링 
   			  
   			  Back-End : Java / oracle / servlet / spring 
   			  Front-End : HTML / CSS / JavaScript / JSP
   			  --------- + Full Stack 
   		
   		JSP => HTML / CSS / JavaScript / Java / Oracle / 
   		
   			1. HTML + 자바 : 구분
   				자바를 코딩하는 영역 : 스크립트
   				<% 
   					일반 자바 : 메소드 호출 / 변수 설정 / 제어문...
   				%>
   				
   				<%= %> 표현식 => 데이터 출력   => 문장이 끝나면 ;을 사용하지 않는다 
   				
   				<%! %> 선언식 : 전역변수 , 메소드 선언시에 사용
   				
   				
   			2. 동작방식 => 정적페이지 / 동적페이지
   						 --------
   						 데이터변경이 없다 (HTML)
   						 
   		 	3. JSP => 사용법
   		 		= 지시자
   		 			1. 변환 => 브라우저 출력시 어떤 형식을 출력할지 지정
   		 				html => text/html
   		 				xml => text/xml
   		 				json => text/plain
   		 				------------------
   		 				자바스크립트 객체 표현법
   		 				=> JavaScript Object Nontation
   		 				=> 자바 : VO => 자바스크립트에서는 VO인식이 불가능
   		 					VO => {변수:값...}
   		 					let sawon={}
   		 					List => [] => Array
   		 					-------------------- java에서 변환 후 전송
   		 										 => Ajax / Vue / React
   		 			2) 라이브러리 읽기 : import
   		 			
   		 			3) 한글 변환 : pageEncoding 
   		 			4) 에러 페이지 : errorPage
   		 							
   		 	4. taglib : 자바 / HTM을 분리한 경우에 주로 사용
   		 				JSTL / EL
   		 	 include
   		 	
   		 	=자바 코딩 방법
   		 	=자원 라이브러리 (내장 객체)
   		 		request / response / session / out
   		 		application/ pageContext
   		 		config / exception / page
   		 		-------------------------------------
   		 		미리 객체를 생성해서 필요시마다 사용이 가능하게 만든 객체
   		 	
   		 	= Cookie / Session
   		 				=> 서버
   		 		=> 브라우저
   		 		
   		 	= JSP 액션태그
   		 		<jsp:include> : JSP 특정 영역에 다른 JSP를 포함
   		 			=> RequestDispatcher
   		 		<jsp:useBean> : 클래스 메모리 할당
   		 			<jsp:useBean id="dao" class="BoardDAO">
   		 							-----객체명	--------- 메모리 할당대상
   		 				=> BoardDAO dao=new BoardDAO()
   		 		<jsp:setProperty> : 멤버변수에 값을 채우는 경우
   		 		<jsp:param> : 다른 JSP로 값을 전송시에 사용
   		 		
   		 		=> 자바+HTML이 혼합
   		 			=> 최대한으로 자바소스를 줄여서 사용 => 태그형   		 		
   		 	= JSTL / EL
   		 	
   		 	= ***MVC => MV => MVC
   		 	
   		 	
   		 	_jspService(final jakarta.servlet.http.HttpServletRequest request, 
   		 	final jakarta.servlet.http.HttpServletResponse response)
   		 	
   		 	 PageContext pageContext;
  			 HttpSession session = null;
   			 ServletContext application;
   			 ServletConfig config;
   			 JspWriter out = null;
  			 Object page = this;
   			 JspWriter _jspx_out = null;
  			 PageContext _jspx_page_context = null;
   		 	
   		 	
--%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! int a=10;
		public void display(){}
	%>
	<% 
		String name="홍길동";
	%>
	<%=name %>
</body>
</html>