<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String jsp="home.jsp";

	
	//RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
	//rd.include(request, response);
%>
<!DOCTYPE html>
<html>
<head>
<title>Gravity</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
</head>
<body id="top">
<%-- <!-- header 자리입니다 -->
<%
	pageContext.include("header.jsp");
%>
<!-- main 자리입니다. -->
<%
	pageContext.include("home.jsp");
%>
<!-- footer 자리입니다. -->
<%
	pageContext.include("footer.jsp");
%> --%>
<%@ include file="header.jsp" %><!--%@는 정적으로 고정되는곳에 사용한다  -->
<%-- <jsp:include page="header.jsp"></jsp:include> --%>

<jsp:include page="<%= jsp %>"></jsp:include>
<%-- <jsp:include page="home.jsp"></jsp:include> --%>

<%@ include file="footer.jsp" %>
<%-- <jsp:include page="footer.jsp"></jsp:include> --%>


<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS --> 
<script src="../layout/scripts/jquery.min.js"></script> 
<script src="../layout/scripts/jquery.backtotop.js"></script> 
<script src="../layout/scripts/jquery.mobilemenu.js"></script> 
<script src="../layout/scripts/jquery.flexslider-min.js"></script>
</body>
</html>