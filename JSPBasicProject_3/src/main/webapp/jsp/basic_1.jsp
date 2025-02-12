<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
    
    	내부객체 , 내장객체, 기본객체
    	 public void _jspService(HttpServletRequest request,HttpServletResponse response)
    	{
   		  	  ServletContext application;
  			  ServletConfig config;
  			  JspWriter out = null;
  			  Object page = this;
  			  PageContext pageContext = null;
    	
    		  try{
    		  	--------------JSP---------------
    		  	
    		  		  메소드 처리 내용을 만든다 => 파일 형식으로 제공
    		  	
    		  	--------------------------------
    		  }
    		  catch(Exception e){}
    	
    	}
    		JSP 파일이 아니고 => _jspService메소드 안을 코딩하는 부분
    		=> 지역변수 
    		
    		내부객체의 종류
    		***1. request
    		HttpServletRequest 객체
    		------------------ 
    			1) 역할 // 
    				서버정보
    					서버이름,프로토콜 , 전송방식 확인(get/post)
    					URL 정보
    				브라우저 정보
    				 클라이언트의 ip / 클라이언트의 port
    				사용자 요청 정보
    				
    			2) 주요메소드
    				서버 정보 관련 메소드
    				  서버이름 :getServerName() => localhost
    				  프로토콜 ㅣ getProtocol => 80
    				  전송방식 : getMethod()
    				  URL : getRequestURI
    				  Contextpath = getRequest(contextPath()
    				 
    				
    				브라우저 정보 관련 메소드
    				 IP : getRemoteAddr() => 접속자 IP
    				 POtes 
    				사용자 요청 관련 정보
    				
    				?name=aaa&sex=man&age20
    					request.setAtrribute("name","aaa")
    					
    				?hobby=aaa&hobby=bbb&hobby=ccc
    				=> checkbox
    				String[] hobby=requset.get.Pal
    				
    				public void disply(a)
    		***2. response
    		
    		*3. application
    		*4. out
    		***5. session
    		*6. pageContext
    		7. page =this
    		8. config = web.xml
    		9. exception
    		
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