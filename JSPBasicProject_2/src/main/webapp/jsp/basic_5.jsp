<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%-- 
    	import : 라이브러리 로드
    	contentType : 브라우저에 보낼 데이터 형식지정
    	errorPage : 에러 발생 시 화면 이동
    	 errorpage="error.jsp"
    	buffer : 출력에 필요한 html을 저장할 메모리 공간 크기 
    	------
    	buffer="16kb"
    
         page에서 제공하는 모든 속성은 한번만 사용이 가능
    	예) import 는 예외
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= application.getRealPath("/") %>
</body>
</html>