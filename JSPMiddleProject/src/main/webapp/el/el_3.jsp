<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
	// => 자바파일에서 전송
	List<String> names=new ArrayList<String>();
	names.add("홍길동");
	names.add("가나다");
	names.add("라마바");
	names.add("아차");
	names.add("후후이");
	
	// ${} => request/session에 저장
	request.setAttribute("list",names);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<%
			for(String name:names)
			{
			
		
		%>
	<li><%=name %></li>		
		<%
			}
		
		%>
	</ul>
	<h3>&lt;c:forEach &gt; 구문</h3>
	<ul>
		<c:forEach var="name" items="${list }" varStatus="s">
		<li>${s.index+1.$}{name}</li>
		</c:forEach>
	</ul>
</body>
</html>