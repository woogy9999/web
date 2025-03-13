<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ****** Breadcumb Area Start ****** -->
	<div class="breadcumb-area"
		style="background-image: url(../img/bg-img/breadcumb.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="bradcumb-title text-center">
						<h2>수정하기</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="breadcumb-nav">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home" aria-hidden="true"></i> Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">자유
								게시판</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- ****** Breadcumb Area End ****** -->

	<!-- ****** Archive Area Start ****** -->
	<section class="archive-area section_padding_80">
		<div class="container">
			<div class="row" style="width: 800px; margin: 0px auto">
				<form method="post" action="../board/board_update_ok.do">
				<table class="table">
					<tr>
					 <th class="text-center" width=15%>이름</th>
					 <td width=85%>
					 	<input type=text name=name id=name size=20 class="form-control-sm" required value="${vo.name}">
					 	<input type=hidden name="no" value="${vo.no }">
					 	<input type=hidden name=page value="${page }">
					 </td>
					</tr>
					
					<tr>
					 <th class="text-center" width=15%>제목</th>
					 <td width=85%>
					 	<input type=text name=subject id=subject size=50 class="form-control-sm" required value="${vo.subject}">
					 </td>
					</tr>
					
					<tr>
					 <th class="text-center" width=15%>내용</th>
					 <td width=85%>
					 	<textarea rows="10" cols="52" name=content required>${vo.content}</textarea>
					 </td>
					</tr>
					
					
					<tr>
					 <th class="text-center" width=15%>비밀번호</th>
					 <td width=85%>
					 	<input type=password name=pwd id=pwd size=20 class="form-control-sm" required>
					 </td>
					</tr>
					
					<tr>
						<td colspan="2" class="text-center">
						 <input type=submit value="수정" class="btn-outline-primary btn-sm">
						 <input type=button value="취소" class="btn-outline-danger btn-sm" onclick="javascript:history.back()">
						</td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</section>