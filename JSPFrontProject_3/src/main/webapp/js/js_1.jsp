<!-- 
		자바스크립트 : 브라우저에서 화면 출력
					정적 => HTML / CSS
					동적 => JavaScript
						   ----------- 서버 요청 / 서버응당
						   			=> Ajax / axios
		=> 1. 데이터형
			  자동 데이터형 변경
			  ---------------
			  let / const
			  => number (숫자형)
			  => 
		=> 2. 연산자
		=> 3. 제어문
		=> 4. 함수
		=> 5. 태그 선택 ( 객체 모델
		=> 6. 객체 (배열 / JSON)
		=> 이벤트 처리
		=> 내장 객체 (브라우저 객체 , 일반 객체)
								---------- String / Date / Number
		=> Jquery 이용해서 처리
			------- 자바스크립트 기반
			=> JSP / Spring / Spring-Boot => 자바
			
			class A
			{
				constructor(msg)
				{
					this.msg=msg
				}
				test:function(){
				axios.get('URL',{데이터전송})
				.then((response))=>{
					this.msg=response.data.msg
				})
				}
			}
			=> 사용처는 이벤트 처리
				onclick
				onmouseover / onmouseout
				onkeyup / onkeydown
				=> 사용자 정의 함수를 주로 이용
				
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
let login=function(){
	
}
window.onload=function(){
	document.write("login "+ typeof login)
	
}
</script>
</head>
<body>

</body>
</html>