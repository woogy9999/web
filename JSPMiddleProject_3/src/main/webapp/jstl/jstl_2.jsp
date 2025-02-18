<%@page import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		List<String> names=new ArrayList<String>();
			for(char c='A'; c<='Z'; c++){
				
				names.add(String.valueOf(c));
			}
	
	%>

	<c:set var="names" value="<%=names %>"/>	
	<c:forEach var="alpha" items="${names }">
	 ${alpha }
	</c:forEach>
	
	<c:forEach var="alpha" items="${names }">
		<c:out value="${alpha }"/>
	</c:forEach>
	
	
</body>
</html>