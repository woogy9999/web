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
	width: 9600px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	
	$('.btn-sm').click(function(){
		let type=$(this).val()
		alert(type)
	})
})


</script>
</head>
<body>
	<div class="container">
		<div class="row text-center">
			<input type="button" value="한식" class="btn-sm btn-danger">
			<input type="button" value="양식" class="btn-sm btn-info">
			<input type="button" value="중식" class="btn-sm btn-success">
			<input type="button" value="일식" class="btn-sm btn-warning">
			<input type="button" value="분식" class="btn-sm btn-primary">
			
		</div>
		<div class="row print" style="margin-top:20px">
		
		</div>
</body>
</html>