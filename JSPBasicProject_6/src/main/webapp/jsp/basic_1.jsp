

<%--  


		<jsp:useBean> : 객체 메모리 할당
		 MemberVo vo=new MemberVO()
		 <jsp:userBean id="vo" class="MemberVO"/>
		<jsp:setProperty> : 객체의 변수값 주입
		 vo.setName("aaa")
		 => 일반 JSP => 사이트 (확장성 없다) => 소규모 / 홈페이지 
		  <jsp:setProperty name="vo" property="name" value="aaa">
		  ***<jsp:setProperty name="vo" property="*">
		  	 => vo가 가지고 있는 모든 setter에 값을 채운다
		  *** 스프링
		  	   public String memberInsert(MemberVO vo)
		  	   => 매개변수
		  	   
		<jsp:getProperty> : 객체의 변수값 출력
		<jsp:param> : 다른 페이지 이동시 필요한 데이터 전송
		
		
		2. DBCP : database Connection pool
					1) 데이터베이스 연결에 소모되는 시간을 단축할 수 있다
						-------------------------- 이게 개느림 
					2) 미리 Connection을 데이터베이스에 연결한 상태에서 저장
					3) 일반적으로 웹프로그램은 대부분 DBCP를 사용한다
					4) Connection의 객체를 제한
					5) 사용후에 재사용한다
					6) Connection을 미리 생성했기 때문에 => 객체관리 쉽다.
					7) 쉽게 서버가 다운되지 않는다
				
				DBCP 방법
					1. 시작과 동시에 Connection객체 생성 (연결된 상태)
						=> 몇개 생성
							maxIdle="10";
						=> 만약에 초과되면 확장 => 추가 maxActive="10"
						
					2. 저장 => 저장 공간 (Pool)
					
					3. 사용자가 요청하면 Connection의 주소를 얻어온다
					4. 사용자 요청 처리
					5. 사용후에는 반드시 POOL에 반환 => 재사용
					
				코딩 
					1. server.xml등록
					2. getConnection() => 미리 생성된 Connection객체 얻기
					3. disConnection() => 반환
					4. 기능은 동일 
					 
		3. Cookie / session
		
		4. JSTL / EL
		
		5. MVC => Spring


--%> 

<!-- 


-->


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.EmpDAO"/>
<%

	List<EmpBean> list=dao.empListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">

</head>
<body>
 <h3>사원목록</h3>
  <table class="table_content" width=500>
  	<tr>
  	 <th>사번</th>
  	 <th>이름</th>
  	 <th>직위</th>
  	 <th>입사일</th>
  	 <th>급여</th>
  	</tr>
  	<%-- 출력 : 자바 / 자바스크립트: 파일 변경을 하지 않는다. --%>
  	
  	<%
  		for(EmpBean vo:list){
  			
  	%>
  	  	<tr>
  	 <td><%=vo.getEmpno() %>사번</td>
  	 <td><%=vo.getEname() %>이름</td>
  	 <td><%=vo.getJob() %>직위</td>
  	 <td><%=vo.getHiredate().toString() %>입사일</td>
  	 <td><%=vo.getSal() %>급여</td>
  	</tr>
  	
  	<%
  		}
  	%>
  </table>
</body>
</html>