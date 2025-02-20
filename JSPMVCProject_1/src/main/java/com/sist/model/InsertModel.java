package com.sist.model;

import jakarta.servlet.http.HttpServletRequest;
public class InsertModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 데이터를 받는다
		
		return "board/insert.jsp";
	}

}
