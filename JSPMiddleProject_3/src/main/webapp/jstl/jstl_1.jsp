<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
		JSTL
			=> JSP standard Tag Library
			=> JS 표준 태그라이브러리
		---------------------------
		core : 일반 프로그램에서 사용되는 변수 / 제어문 / 화면 이동
			   변수
			    <c:set var="변수명" value="값">
			    => request.setAttribute("변수",값)
			    <c:out value="값"> => 그래프 
			    => out.println(값)
			    => JQuery => $() , ${}:EL
			       ----------------------- javascript영역
			       
			    제어문
			    	<c:if test="조건문">
			    	 조건이 true일때 
			    	</c:if> // else문 없음 
			    예)
			    	<c:if test="${id=="admin"}">
			    	</c:if>
			    	
			    <c:forEach var="i" begin="i" end="i" step="1">
			    	반복 수행문장	
			    </c:forEach> // 감소식은 없음
			    
			    <c:forEach var="vo" items="">
			    	가장 많이 사용되는 for => for-each구문
			    </c:forEach>
			    
			    <c:forTokens var="변수명" items="값" delims="구분자">
			    	StringTokenizer st=
			    		new StringTokenizer(값,구분자)
			    </c:forTokens>
			    
			    => 다중조건문
			    	<c:choose>
			    		<c:when test="">출력물</c:when>
			    		<c:when test="">출력물</c:when>
			    		<c:when test="">출력물</c:when>
			    		<c:otherwise> </c:otherwise> // else문장임
			    	</c:choose>
			    	
			    => 화면이동
			    	<c:redirect url="이동할 파일명">
			    	=> response.senRedirect()
			    	*** JSP안에서는 자바코딩을 하지 않는다
			    				  ------ 태그를 이용해서 처리
			    	<% %> <%= %> 사용하지 않는다
			    	<c:import> <c:include> => 사용 빈도가 거의 없다
			    	<jsp:include> => 거의 사용
		format
			<fmt:formatDate> => SimpleDateFormat => 날짜 변환
				request.setAtrtribute("today",new Date())
				<fmt:formatDate value="${today}" pattern="yyyy-mm-dd">
			<fmt:formatNumber> => DecimalFromat => 숫자 변환
			   request.setAttribute("price",30000)
			  <fmt:formatNumber value="${price}" pattern="###,###"
			  				
		function
		sql/xml => 자바로 사용 (사용빈도가 거의 없다) => 보안 / 로직

--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>