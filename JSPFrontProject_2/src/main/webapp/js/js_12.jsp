<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 900px;
}
</style>
<script type="text/javascript">
const sawons=[
	{sabun:1,name:"홍길동",dept:"개발부",job:"대리",pay:3500},
	{sabun:2,name:"김두환",dept:"영업부",job:"사원",pay:3000},
	{sabun:3,name:"박찬수",dept:"인사부",job:"부장",pay:7000},
	{sabun:4,name:"슈퍼맨",dept:"운영부",job:"과장",pay:5000},
	{sabun:5,name:"가나다",dept:"기획부",job:"이사",pay:30000}
]
window.onload=function(){
	let html=""
	sawons.map(function(sawon){
		html+='<li>'+(sawon.sabun+" "+sawon.name+" "+sawon.dept)+'</li>'
	})	
	
	document.querySelector('ul').innerHTML=html
	
}

</script>
</head>
<body>
<ul>
</ul>
</body>
</html>