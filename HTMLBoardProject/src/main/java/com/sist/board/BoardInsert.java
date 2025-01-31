package com.sist.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@WebServlet("/BoardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// request : 사용자가 보내준 데이터를 가지고 있다
		// response : 사용자 브라우저 정보 => 화면 변경
		request.setCharacterEncoding("UTF-8"); // 한글이 전송된 경우
		// => 2byte형식 전송값을 받는다 ( 디코딩 ) 
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		System.out.println("이름 : "+name);
		System.out.println("제목 : "+subject);
		System.out.println("내용 : "+content);
		System.out.println("비번 : "+pwd);
		
		//오라클 연동 
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setContent(content);
		vo.setSubject(subject);
		vo.setPwd(pwd);
		
		BoardDAO dao=BoardDAO.newInstance();
		dao.boardInsert(vo);
		
		response.sendRedirect("BoardList"); // 화면 이동
		// 흐름 => 요청 => 어떤 파일로 이동?
		
	}

}
