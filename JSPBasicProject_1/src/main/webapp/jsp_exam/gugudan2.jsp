<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!-- 

	Spring Framwork는
	9버전까지만 지원가능.
	
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
</head> 

<body> 
	<h1>구구단</h1>  
	<table border=1 bordercolor=black width=600>
		<tr>
			<c:forEach var="i" begin="2" end="9">

				<th>${i }단</th>
			</c:forEach> 
		</tr> 

		<c:forEach var="i" begin="1" end="9">
			<tr>
			<c:forEach var="j" begin="2" end="9">
				<th>${j }*${i }=${i*j }</th>
			</c:forEach>

		</tr>
		</c:forEach>

	</table>
</body>
</html>