package com.sist.model;

import jakarta.servlet.http.HttpServletRequest;

public class ListModel {
	public void excute(HttpServletRequest request) {
		request.setAttribute("msg", "게시판 목록");
	}
}
