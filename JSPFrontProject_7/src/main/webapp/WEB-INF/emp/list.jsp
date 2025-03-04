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
	width: 800px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$.ajax({
		type:'get'
		url:'list.json.do'
		success:function(json){
			let html=''
			let emp=JSON.parse(json)
			emp.map(function(vo){
				html+='<tr>'
					+='<td class="text-center">'+vo.empno +'</td>'
					+'<td class="text-center">'+vo.ename +'</td>'
					+'<td class="text-center">'+vo.job +'</td>'
					+'<td class="text-center">'+vo.dbday +'</td>'
					+'<td class="text-center">'+vo.sal +'</td>'
					+'</tr>'
			})
		}
	})
})
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3 class="text-center">사원 목록</h3>
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">사번</th>
						<th class="text-center">이름</th>
						<th class="text-center">직위</th>
						<th class="text-center">입사일</th>
						<th class="text-center">급여</th>
					</tr>
				</thead>
			</table>
			<div id="print"></div>
		</div>
	</div>
</body>
</html>