<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
		논리연산자 : and (&&) , or (||) 
 --%>
 <%-- 
 &#36;{10>6 && 5==6}=${10>6 && 5==6 } <br>
 &#36;{10>6 && 5==6}=${10>6 and 5==6 } <br>
 
 &#36;{10>6 || 5==6}=${10>6 || 5==6 } <br>
 &#36;{10>6 || 5==6}=${10>6 or 5==6 } <br>
 
 &#36;{10>6?"A":"B"}=${10>6?"A":"B" }<br>
  --%>
  	
  	<%--
  	
  		list.jsp?id=admin
  		
  		=> request.getParameter("id")
  		=> ${param.id}
  		
  		1. request.setAttribute(키,값)
  			=>${키},${requestScope.키}
  			=> <%=request.getAttribute(키)
  		2. session.setAttribute(키,값)
  			=> session.getAttribute(키)
  				=> ${sessionScope.키}
  				=> <%= session.getAttribute(키) %>
  		3. request.getParameter("키")
  			=> ${param.키}
  	 --%>
  
</body>
</html>