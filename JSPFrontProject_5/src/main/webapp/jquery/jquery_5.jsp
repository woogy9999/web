<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		/*
			$()
			  - 브라우저 객체 
			
			$(this)
			 ----- 자신의 객체
		
		 */
/* 		$('img').css('width', '200px')
		$('img').css('height', '250px') */
		$('img').css({
			'width':'250px',
			'height':'300px'
		})
		
		$('img').hover(function(){
			$(this).css('cursor','pointer')
			$(this).css('opacity',0.2)
		},function(){
			$(this).css('opacity',1)
		})
	})
</script>
</head>
<body>
	<img src="m1.jpg">
	<img src="m2.jpg">
</body>
</html>