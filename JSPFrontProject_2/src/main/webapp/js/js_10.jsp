<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    
    		제어문
    			조건문 
    				=> 단일 조건문
    					if(조건)
    					{
    					}
    				=> 선택 조건문
    					if(조건)
    					{}
    					else{}
    				=> 다중조건문
    					if(조건)
    					else if(조건)
    					...els
    					{}
    				선택문
    				 switch(숫자,문자)
    				 {
    				   case 값
    				     처리문자
    				     break
    				 }
    				 
    				 반복문
    				  while / do~while / for
    				 반복제어문
    				  break / continue
    					
    					
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* window.onload=function(){
	
}
 */
window.onload=()=>{
	const names=["홍길동","심청이","박문수","이순신"]
	const sexs=["남자","여자","남자","여자"]
	
	document.write("<h3>일반 for</h3>")
	
	for(let i=0; i<names.length; i++){
		document.write(names[i]+"<br>")
	}
	

	

	for(let index in names){
		document.write(names[index]+"("+sexs[index]+")")
	}
	document.write("<hr>")
	document.write("<h3>for-of(for-each)</h3>");
	document.write("<h3>for-in (인덱스)</h3>")


	for(let name of names){
		document.write(name+"<br>")
	}
	
	
}


</script>
</head>
<body>

</body>
</html>