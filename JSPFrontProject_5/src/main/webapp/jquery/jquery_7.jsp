<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
//	$('span:nth-child(1)').text("Hello Jquery")
	$('span:eq(0)').text("Hello Jquery")
	// textContent
	// 같은 태그 여러개 있는 경우에 인덱스로 이용 => 0번부터
	$('span:eq(1)').html('<font color=red>Hello Jquery</font>')
	// innerHTML
	// appendChild() =>  append()
})
</script>
</head>
<body>
	<span>
	</span><br>
	<span>
	</span>
</body>
</html>