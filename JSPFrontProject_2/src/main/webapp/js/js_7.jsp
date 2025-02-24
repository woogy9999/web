<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	
	let a="HELLO";
	let b="JAVASCRIPT";
	
	console.log("a===b"+(a===b))
	console.log("a!==b"+(a!==b))
	console.log("a>b"+(a>b))
	console.log("a<b"+(a<b))
	console.log("a<=b"+(a<=b))
	console.log("a>=b"+(a>=b))
}

// 처리 => 함수
function send(){
	
	let frm=document.frm
	
	if(frm.id.value===""){
		alert("아이디를 입력하세요")
		frm.id.focus()
		return
	}
	if(frm.pwd.value==="")
	{
		alert("비밀번호를 입력하세요")
		frm.pwd.focus()
		return
			
	}
	alert("id : "+frm.id.value+"pw : "+frm.pwd.value)
}

</script>
</head>
<body>
	<form name="frm">
		ID:<input type=text name=id size=10><br>
		PW:<input type=password name=pwd size=10><br>
		<input type=button value="전송" onclick="send()">
		
	</form>
</body>
</html>