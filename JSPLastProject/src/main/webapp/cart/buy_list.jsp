<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${count==0 }">
<table class="table">
	<tr>
	 <td class="text-center">
	 	<h3>구매 내역이 없습니다.</h3>
	 </td>
	</tr>
</table>
</c:if>
<c:if test="${count!=0 }">
	<table class="table">
	   <tr>
	    <th class="text-center">번호</th>
	    <th class="text-center"></th>
	    <th class="text-center">상품명</th>
	    <th class="text-center">수량</th>
	    <th class="text-center">금액</th>
	    <th class="text-center">총금액</th>
	    <th class="text-center"></th>
	   </tr>
	   <c:forEach var="vo" items="${list }">
	     <tr>
	      <td class="text-center">${vo.cno }</td>
	      <td class="text-center">
	      <img src="${vo.gvo.goods_poster }" style="width:30px;height: 30px">
	      </td>
	      <td class="text-center">${vo.gvo.goods_name }</td>
	      <td class="text-center">${vo.account }</td>
	      <td class="text-center">${vo.gvo.goods_price }</td>
	      <td class="text-center">${vo.price * vo.account }</td>
	      <td class="text-center">
	       <input type="button" value="구매내역" class="btn-sm btn-success" >
	      </td>
	     </tr>
	   </c:forEach>
	  </table>
	  </c:if>
</body>
</html>