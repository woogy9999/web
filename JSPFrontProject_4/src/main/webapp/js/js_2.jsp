<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* 


*/
window.onload=function(){
	/* let won=10000000
	document.write(won.toLocaleString()) */
	let today=new Date()
	let year=today.getFullYear()
	let month=today.getMonth()+1
	let date=today.getDate()
	let day=today.getDay()
	let strWeek=["일","월","화","수","목","금","토"]
	document.write("오늘은 "+year+"년 "+month+"월 "+date+"일 "+strWeek[day]+"요일입니다")
	
}</script>
</head>
<body>

</body>
</html>