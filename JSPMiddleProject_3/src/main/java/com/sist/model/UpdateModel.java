package com.sist.model;

import jakarta.servlet.http.HttpServletRequest;

public class UpdateModel {
	public void excute(HttpServletRequest request) {
		request.setAttribute("msg", "게시판 수정");
	}
}
