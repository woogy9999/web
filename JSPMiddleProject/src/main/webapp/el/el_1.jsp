<%--

	${"10"+10}
	---------- 자동으로 Integer.pardeInt("10") => 정수변경
	----------- 결과값 20
	
	
	${null+10}
	  ----- 자동으로 0으로 대체
	EL에서 처리는 문자  /날짜로 사용한다
	
	
	${vo.if==sessionScope.id}
	${vo.id eq sessionScope.id}
	${sessionScope.id==null}
	
			<c:if test="EL"> => if()
			<c:when test="EL"> => switch
	삼항연산자 => ${조건?값:값}
	
	출력형식
		=> ${데이터 출력}
			---------- 일반 변수는 사용할 수 없다
				| request에 담긴 값
				  request.setAttribute("id","hong")
				  ${requestScope.id}
				  				 -- 키
				 | => requestScope는 생략이 가능
				 => ${id}
				 
				 | session에 담긴값
				 	session.setAttribute("id","admin");
				 	=> <%= session.getAttibute("id") %>
				 	=> ${sessionScope.id}
				 					  -- 키
				 |
		=> 제어문 (JSTL) => JSP => MVC 사용시에는 자바를 사용하지 않는다
			-----------	자바가 없는 것처럼 보인다 => 자바 제어문
						-------------------- 태그로 만들어진 라이브러리
		*** =core : 제어문 , 변수 선언, 화면 이동
				=> import : uri="jakarta.tags.core
				=>  제어문
					조건문 => else가 없다 => if문만 사용한다 
						 => 단일 조건문만 사용이 가능하다
						 => 형식) 
						 		<c:if test="${조건문(논리/비교)}">
						 		      ---- 조건문이 수행
						 		  조건이 true면 수행하는 HTML을 사용
						 		
						 		<c:if test="${!조건문(논리/비교)}">
						 				---- 조건문이 수행
						 			조건이 true면 수행하는 hTML을 사용
						 		</c:if>
						 		
						 		
					선택문	: 다중 조건문 사용
							  <c:choose>
							  	<c:when test=""></c:when>
							  	<c:when test=""></c:when>
							  	<c:when test=""></c:when>
							  	<c:otherwise></c:otherwise>
							  	
					반복문	: <c:forEach var="i" begin="i" end="10" step="1">
															-----	-------
															<=10	1인 경우 생략이 가능
								*** 단점 : 감소식은 사용할 수 없다				
							  </c:forEach>
							  
							  => forEach
							  for(MovieVO vo:list)
							  <c:forEach var="vo" items="${list}">
							  
							  </c:forEach>
							  
							  *** <c:forTokens> => StringTokenizer
							  
							  
				=>	변수 선언 
					-------- <c:set var="id" value="hong">
							 String id="hong" (X)
							 request.setAttribute("id","hong")
				=>	화면 이동
					-------
							response.sendRedirect("파일명")
							<c:redirect url="파일명">
				
		*** =fmt : 날짜 변환, 숫자 변환
					---------------
								| DecimalFormat => 천단위 ,
					| simpleDateFormat => yyyy-mm-dd
					-----------------------------------
					많이 사용하지 않는다 : 오라클에서 변경 이 가능 to_CHAR
					
					<fmt:formatDate>
					<fmt:formatNumber>
					
		*** = fn : String클래스의 메소드 호출  => uri="jakarta.tags.function
					length(), substring()
					${fn:length(문자열)} => 자바에서 제어
		---------
		=xml
		= sql : DAO
		-------------- MVC/MV구조에서는 사용하지 않는다 (순수 JSP로 제작)				
		
 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%-- 
	core : 제이문을 지원 / 변수 선언 / 화면 이동
	prefix="c" => <c:forEach>
	prefix="core" => <core:forEach>
	------------- 개발자가 선택
	

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- forEach : for문 : 반복문 --%>
	<h3>일반 자바 for문</h3>
	<%
	for (int i = 1; i <= 10; i++) {
	%>
		<%=i %>&nbsp;
	<%
	}
	%>
	<h3>&lt;forEach&gt;사용</h3>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }
	
	</c:forEach>
</body>
</html>