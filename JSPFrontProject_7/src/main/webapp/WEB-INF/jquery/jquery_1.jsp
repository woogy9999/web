<!-- 

		1) 데이터베이스 => 테이블 => 크롤링
		2) git => 조별 Repository => Pull
		3) => mainpage / join / login
						-------------- ajax : 검색 , 예약, 결재 
									   ----- 7.5/2.5
		1. 라이브러리 로드
			<script src= 
		2. jquery는 자바스크립트 라이브러리
			1) 변수 설정 => var / let / const : 서버에서 데이터 읽기
			2) 데이터형 : number / string / date / boolean / object:{},[]
			3) 연산자 => 자바스크립트 이용 
			4) 제어문
			5) 서버에서 데이터 전송을 받는 경우 => Ajax
				=> 검색 : List=> []
				=> VO : {키:값,키:값} => JSON
			6) 객체모델 / 문서 모델 => 태그제어 ***
				자바스크립트 : document.querySeletor(CSS)
				Jquery : $(CSS) => selector
				--------------------------- 태그 선택 / 내장 객체
			7) 자바스크립트에서 지원하는 라이브러리 
				Array / String / Number / Date / Math
								 ------			-----
								 				| ceil, round
								 | 형변환 , toLocaleString()
								 | parseInt
				| push() : 데이터추가 , slice() : 잘라서 새로운 배열
				| pop() : 데이터 삭제 , ... 배열 복사
						| trim() , indexOf() , substring() , substr()
						| split() , replace() , 
			8) 브라우저 객체 
			   window => open() , close() , scrollbar()
			   location => href : 화면 이동
			   history => back , go(-1)
			   document => write(), queryselector()
			   ------------------ jquery에서 자바스크립트 이용
			   jquery
			   ------- selector => 태그 제어 (읽기 / 쓰기) => 출력
			   					=> Ajax
			   	1) selector
			   	   태그명 : $('태그명')
			   	   아이디명 : $('#아이디명')
			   	   클래스명
			   	   
			   = <input type=text> => $('input').val()
			   					   => $('input').val(값)
			   = append() => 추가를 계속할때 사용
			
			3) 읽기 / 쓰기 시점 => 이벤트
				버튼 / 이미지 => click
					=> $('태그').click(function(){}) : 고전적 이벤트
					=> ${'태그').on('click',function(){}) : 리스너 이용
				=> onchange : select
				   onkeydown / onkeyup
				   onmouseout / onmouseover
				   ------------------------ hover
				   
			5) Ajax
				=> 비동기적인 자바스크립트 & XML
		
			한페이지에서 송신 / 수신이 가능 => 페이지 변경이 없다
					  --------- 유지보수
			=> Ajax를 이용한 로그인 처리 : PR
			

 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
let httpRequest=null
function getXMLHttpRequest() // 브라우저에서 HttpXMLRequest객체 읽기
{
	// 브라우저마다 객체명이 다르다
	if(window.XMLHttpRequest) // null 이 아니면
	{
		return new XMLHttpRequest()	
	
	}
	else{
	
		return null
	}
}
// 전송 => 수신
function sendRequest(url,params,callback,method)
{
	// callback => 시스템에 의해 자동 호출되는 함수 => 결과값을 받아서 출력	
		// XMLHttpRequest : 서버에 요청 => 결과값을 읽어오는 역할
		// $.ajax({})
		
		// => Vue / React
		// axios.get(url,{params}).then(function(){})
		// axios.post(url,{params}).then(function(){})
		
		httpRequest=getXMLHttpRequest()
		// 2. method방식 지정
		let httpMethod=method?method:'GET'
		if(httpMethod!='GET' && httpMethod!='POST')
		{
				httpMethod='GET'
		}
		// Param처리 => ?id=admin
		let httpParams=(params===null||params==="")?null:params
		// URL 처리
		let httpUrl=url
		// get방식이고 전송할 데이터가 있는 경우
		if(httpMethod==='GET' && httpParams!=null)
		{
			httpUrl=httpUrl+"?"+httpParams
		}
		// 서버 연결 => open 함수는 이미 제작됨
		httpRequest.open(httpMethod,httpUrl,true)
		// true => 비동기 , false => 동기
		// 한글 처리 
		httpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded')
		// 자동호출되는 함수 지정
		httpRequest.onreadystatechange=callback
		// 데이터 전송
		httpRequest.send(httpMethod==='POST'?httpParams:null)
		// 데이터 읽기 : responseText / responseXML(JSON)
}
function send(){
	sendRequest('sub.jsp',null,ok,'POST') // 요청
}
function ok()
{
	
	if(httpRequest.readyState==4)
		{
			if(httpRequest.status===200)
				{
				 // status => 정상수행 (200)
				 let div=document.querySelector("#print")
				 div.innerHTML=httpRequest.responseText
				}
		}
}
</script>
</head>
<body>
	<button onclick="send()">전송</button>
	<div id="print"></div>
</body>
</html>