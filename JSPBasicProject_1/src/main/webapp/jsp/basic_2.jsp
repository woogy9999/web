<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<%-- 

	1) 웹동작
		요청 / 응답
			  --- 서버 (response) => c/s => 네트워크
		---	  클라이언트 (request)
					   => 서버연결시 브라우저를 이용한다
					   	   ------ 브라우저에서 서버 연결되는 부분
					   	     	  ------------------------- 주소창
		=> 반드시 URL을 이용할떄는
		   http://서버IP:PORT/프로젝트명/폴더명/파일명 
		   								   -----
		   								   
		   파일명 생략이 가능한 파일 : welcome파일
		   index.html / index.jsp
		   
		   사용자가 html/jsp/servlet을 요청
		   서버에서는 출력된 => html을 브라우저로 전송 실행
		   			----------소스보기
		   			
		   => JSP를 활용하는 이유 : 동적페이지 
		   					한개의 파일을 이용해서 데이터 변경후 출력
		   					--------- 여러개 처럼 사용이 가능
			서블릿 ===> JSP가 컴파일이 되면 서블릿으로 변경
					   --------------------------- 톰캣 , 레진
			: 서블릿 , JSP => HTML+Java
			
			 		|
			 		사용이 편리
			 
			 서블릿 => HTML 출력에 불편
			 			수정시마다 컴파일을 해야된다 , . class파일(보안 뛰어나다)
			 			로직 , 중요한 데이터가 있는 경우
			 			
			 html을 그대로 사용이 가능
			 수정시에 컴파일 없이 실행 => jsp
			 => 자바로 변경 (톰캣에 의해 변경)
			 => 소스가 노출 (보안에 취약) 
			 => 화면 출력
			
			구성요소 
				브라우저 : 크롬 / 파이어폭스
				웹서버 : Apache / IIS
				웹애플리케이션 : 자바번역 / JSP를 자바로 변경
							=> tomcat
							=> 테스트용 웹서버를 내장
							 
				데이터베이스 : 오라클 / MySQL
			
			동적페이지 : JSP / Servlet => 자바가 데이터 관리 / 필요시에 데이터 갱신
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	URL : <%=request.getRequestURL() %><br>
	URI : <%=request.getRequestURI() %><br>
	ContextPath : <%=request.getContextPath() %><br>
	Server정보: <%= request.getServerName() %><br>
	ServerPort: <%= request.getServerPort() %><br>
</body>
</html>