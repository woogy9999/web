<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		// 자바 코딩 영역
	String msg="Hello JSP!!";
	List<String> list=new ArrayList<String>();
	list.add("홍길동");
	list.add("가나다");
	list.add("심청스");
	%>
	<h1><% out.println(msg); %></h1>
	<h1><%=msg %></h1>
	
	
	<ul>
		<li><%=list.get(0) %></li>
		<li><%=list.get(1) %></li>
		<li><%=list.get(2) %></li>
	</ul>
</body>
</html>