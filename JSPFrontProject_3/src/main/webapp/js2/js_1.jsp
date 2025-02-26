<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    		자바스크립트는 브라우저에서 실행 => 인터프리터 => 에러출력(X)
    		=> 개발자 도구
    		
    		1. 변수 => 대입값에 따라 데이터형이 변경
    			let (지역변수) / const(상수)
    			=> number : 숫자형 (int, double)
    			=> string : 문자형 (char,string)
    			=> object : 배열 / 객체
    						[]		{} => JSON
    			=> function : 함수 
    		=> 문자열 결합 / 상품 갯수 => 총합(오라클)
    		=> 모든 처리 => 자바 (서버)
    		=> 자바스크립트/HTML => 출력
    					------ 데이터변경 (정적페이지)
    			-------- 데이터 변경이 가능 (동적페이지)
    		3. 제어문
    		   조건문 : if
    		   반복문 : for / for-each
    		   
    		 => for-each => 배열일 경우에만 사용이 가능
				for(변수 in 배열)
					--- 배열의 index 번호 => 0    		 
    		 	for(변수 in 객체)
    		 		--- 객체의 key값을 받는다
    		 	let arr=[1,2,3,4,5] 
    		 	for(let i in arr)
    		 		--- 1,2,3,4,5
    		 	
    		 	let arr=[1,2,3,4,5] 
    		 	배열.map(function(value){})
							callback=>자동실행되는 함수
				let arr=[1,2,3,4,5]
				arr.map(function(value){})    		 	
    		   반복제어문 : break
    		   
    		4. 함수 : 기능처리 (이벤트 : 사용자가 행위를 했을떄
    									=> 사용자 요청에 대한 처리
    									=> 브라우저에서만 작동)
    							=> 키보드 , 마우스
    								onclick / onmouseover
    								onchange(select) / onmouseout
    								onkeydown / onkeyup...
    			=> 함수 생성 방법
    				선언적 함수
    				=> 리턴형 서술이 없다
    				=> 매개변수에 변수명 설정 (name) => (let name)(X) 
    				function 함수명 (매개변수)
    				{
    					function 함수명() => X
    				}
    				익명의 함수 (****)
    				let 함수명 = function(){}
    				let 함수명 =()=>{}
    				익명의 함수 (*****)	  
    				
 				------------------------------------
 							리턴형		매개변수
 				------------------------------------
 							o				o
 						function func(name)
 						{
 							return name
 						}
 						let name=func("홍길동")
 				------------------------------------
 							o				x
 						function func()
 						{
 							return ""
 						}
 						let msg=func()
 				------------------------------------
 							x			o
 						function func(name)
 						{
 						}
 						func("홍길동")
 				------------------------------------
 							x			x
 						function func()
 						{
 						}
 						func()
 				------------------------------------
 				권장 : => {화살표함수 이용}
 					 ---- function / return 제거 : 람다식 (함수포인터)
 					 function func(){}
 					 let func=function(){}
 					 let func=()=>{} ***
 					 
 			5. 배열 / 객체
 					----- {}(JSON) => 서버에서 값 전송
 							=> 자바 : VO
 							=> 객체
 							let a={aa:,bb:}
 							 => a.aa a['aa']
 							 => a.bb a['bb']
 					----- 값 추가 : push() , 자르기 : slice()
 					----- 값 제거 : pop();
 			6. 객체 문서 모델
 				=> HTML 태그를 선택해서 제어
 				-----------------
 				이벤트 처리
 				속성값 변경
 				css 적용
 				
 				**html 파일 => 전체를 가지고 있는 객체 : document
 				태그 1개
 					= document.getElementById(아이디명)
 					= document.querySelector(CSS의 Selector)
 											--------------
 											화면 디자인
 											태그 선택
 											크롤링
 				태그 여러개
 					= document.getElementByClassName(클래스명)
 					= document.getElementByTagName(태그명)
 					= document.querySelectorAll(class명,태그명) 					
 				
 				=> Jquery
 					$('태그,아이디명,클래스명')
 				=> Vue => <a ref="id"> : 양뱡향
 					$refs.id
 				=> React => target.id : 단방향
 					Next
 				
 			7. 이벤트 등록
 			8. 내장객체
 			   내장객체
 			   브라우저 내장 객체
 			   ----------------------- 라이브러리화 : JQuery
 			   
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 

		Jquery : $(function){})
		Vue : mounted(){}
		React : componentDidMount(){}
				=> 고전
				useEffect() => hooks => 16 
 -->
<script type="text/javascript">
window.onload=function(){
/* 	// id
	let h1=document.getElementById("h1")
	console.log("h1= "+typeof h1)
	// 태그는 자바 => class
	// 속성은 자바 => 멤버변수
	h1.style.backgroundColor="yellow"
	// <h1 style="background-color:yellow"> - => 다음문자 대문자 */
	
	//let h1=document.querySelector("h1")
	//h1.style.backgroundColor='pink'   // 여러개일경우 한개만적용
	let h1=document.querySelectorAll("h1")
	h1[0].style.backgroundColor='yellow'
	h1[1].style.backgroundColor='pink'
	
	// h2 => 글자색상을 red로 출력
	let h2=document.querySelector("h2")
	h2.style.color='red'
	
}
</script>
</head>
<body>
	<h1> Hello JavaScript-1</h1>
	<h2> Hello JavaScript-2</h2>
	<h1 id="h1"> Hello JavaScript-3</h1>
</body>
</html>