<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 

	callback : 매개변수로 전송되는 함수
			   -------------------
			   Redux
			   -----
			   JSP / MVC (Model 2)
			   Model1
			   
			   React => MVC(Redux) => spring (mobx)
			   									|
			   								   배민
			   Vue	 => MVC(vuex)
			   
			   => map(function(){})
			   => forEach(funcion(){})
			   ----------------------------------
			   => then(function(response){})
			   => success:fuction(response){}
			   ---------------------------------- 사용자 요청 / 서버 응답
 -->
<script type="text/javascript">
function func(callback){
	for(let i=1; i<=5; i++){
		callback()	
	}
}
let callback=function(){
	document.write("함수 호출... <br>")
}
window.onload=function(){
	func(callback)
}

</script>
</head>
<body>

</body>
</html>