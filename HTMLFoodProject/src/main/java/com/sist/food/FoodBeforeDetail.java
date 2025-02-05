package com.sist.food;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// doget dopost영역

@WebServlet("/FoodBeforeDetail")
public class FoodBeforeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fno=request.getParameter("fno");
		Cookie cookie=new Cookie("food_"+fno, fno); // (키,키값)
		cookie.setPath("/"); // 저장 위치 지정
		cookie.setMaxAge(60*60*24); // 저장 기간 => 1일
		response.addCookie(cookie); // 부라우저 전송
		// 쿠키 => 브라우저에 저장 (클라이언트에 저장)
		// 보안에 취약 / 저장 => 문자열만 저장이 가능
		// 최신 방문 / 로그인 여부
		// => 서버에 저장(세션)
		// => Map방식 (키,값) => 키는 중복이 불가능
		// 상세보기로 이동 => 서버에서 화면 이동 response.sendRedirect
		response.sendRedirect("FoodDetail?fno="+fno);
		//---------------------- Get
		/*
		 * 
		 *		사이트
		 *		-----
		 *		목록 => 인라인뷰 (페이징)
		 *		상세보기 (찜하기,좋아요,예약,결제) => 댓글
		 */
		
		
	}

}
