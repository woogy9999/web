<%--  



	1. HTML과 Java 분리
		=<%! %> : 선언문
		=<%@ %> : 선언문
		=
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 

public int add(int a,int b){
	
	return a+b;
}
%>
<%
	int a=10;
	int b=20;
	int c=add(a,b);
	
%>
<%= c %>
</body>
</html>