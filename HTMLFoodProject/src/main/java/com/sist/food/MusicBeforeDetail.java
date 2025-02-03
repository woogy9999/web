package com.sist.food;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MusicBeforeDetail")
public class MusicBeforeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mno=request.getParameter("mno");
		Cookie cookie=new Cookie("Music_"+mno, mno); // (키,키값)
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);	}

}
