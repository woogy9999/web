<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		EL : 표현식 exprese Language
		<%= %> => 대체
		형식)
			${값}
			
			=> 연산자
			=> 내장 객체
			
			${값}
			----- request.getAttibute("name")
					${name}
					session.setAttribute("id","admin")
					=> ${id} => admin
					=> ===== 일반 변수(X) => request,session
					=> ${name}
						------- 키
						
					request.setAttribute("name","홍길동1");	
					session.setAttribute("name","홍길동2");
					
					${name} => request
					${requestScope.name} => 생략이 가능
					${sessionScope.name}
					
					우선순위 => request => session => application	
		
 --%>
 
 <%
 		String name="홍길동";
 		request.setAttribute("name", "박문슈");
 		session.setAttribute("name", "심청이");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${name }<br>
	이름 : ${sessionScope.name }<br>
	이름 : <%=name %>
</body>
</html>