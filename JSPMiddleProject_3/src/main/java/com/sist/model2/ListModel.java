package com.sist.model2;

import jakarta.servlet.http.HttpServletRequest;

public class ListModel implements Model {

	@Override
	public String excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "답변형 게시판");
		return "board/list.jsp";  // 얘가 "답변형 게시판"을 받아서 출력하는거임
	}

}
