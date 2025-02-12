<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
MajorVersion:<%=application.getMajorVersion() %><br>
Minorversion:<%=application.getMinorVersion() %><br>
version:<%=application.getMajorVersion()+"."+application.getMinorVersion() %>
<br>
서버명<%= application.getServerInfo() %>
<%
	String driver=application.getInitParameter("driver");
	String url=application.getInitParameter("url");
	String username=application.getInitParameter("username");
	String password=application.getInitParameter("password");

		application.log("Driver:"+driver);
		application.log("URL:"+url);
		application.log("Username:"+username);
		application.log("Password:"+password);
%>
</body>
</html>