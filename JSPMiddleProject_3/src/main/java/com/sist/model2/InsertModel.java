package com.sist.model2;

import jakarta.servlet.http.HttpServletRequest;

public class InsertModel implements Model {

	@Override
	public String excute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "답변형 게시판 데이터 추가");
		return "board/insert.jsp";
	}

}
