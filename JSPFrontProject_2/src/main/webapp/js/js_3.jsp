<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
// 연산자 처리
/*
  
 		연산자
 		1. 단항연산자
 			증감연산자   (++,--)
			형변환연산자 
			"10" => Numer("10"=> 10)
					ParseInt("10")=>10
			10 => String(10) => "10"
			Boolean => Boolean(1) , Boolean(0)
						true			false
						
 		2. 이항연산자
 			=> 산술연산자 (+,-,*,/)
 			
 		3. 삼항연산자
 		
 
 */
window.onload=function(){
 	let a=10;
 	console.log("a="+a)
 	a++;
 	console.log("a="+a)
 	++a;
 	console.log("a="+a)
 	
 	let b=10;
 	console.log("b="+b)
 	b--
 	console.log("b="+b)
 	--b
 	console.log("b="+b)
 	
 	// 반복문
 	let k=true
 	console.log("k="+k)
 	k=!k
 	console.log("k="+k)
 	
 	let n="10"
 	document.write("변경전 n="+n+","+typeof n+"<br>")
 	document.write("변경전 n="+n+","+typeof Number(n)+"<br>")
 	document.write("변경전 n="+n+","+typeof parseInt(n)+"<br>")
 	document.write("변경전 n="+n+","+typeof Boolean(n)+"<br>")
 	
 	let h=10
 	document.write("변경전 h="+h+","+typeof h+"<br>")
 	document.write("변경전 h="+h+","+typeof String(h)+"<br>")
 	document.write("변경전 h="+h+","+typeof Boolean(h)+"<br>")
 	
}
</script>
</head>
<body>

</body>
</html>