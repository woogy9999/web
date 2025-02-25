<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	// main
	window.onload=function(){
		let a=10;
		let b=20;
		
		let p1=plus1(a,b)
		let p2=plus2(a,b)
		let p3=plus3(a,b)
		let p4=plus4(a,b)
		// 브라우저 출력
		document.write("p1="+p1+"<br>")
		document.write("p2="+p2+"<br>")
		document.write("p3="+p3+"<br>")
		document.write("p4="+p4+"<br>")
	}
	// 선언적 함수 선언
	function plus1(a,b){
		return a+b
	}
	// 익명의 함수
	let plus2=function(a,b)
	{
		return a+b
	}
	// 가장 많이 사용
	let plus3=(a,b)=>{
		return a+b
	}
	// 가독성
	let plus4=(a,b)=>a+b
	{
		
	}
	
</script>
</head>
<body>

</body>
</html>