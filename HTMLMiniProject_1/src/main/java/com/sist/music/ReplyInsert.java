package com.sist.music;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.sist.dao.*;
import com.sist.vo.*;
import jakarta.servlet.http.HttpSession;
// 
@WebServlet("/ReplyInsert")
public class ReplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mno=request.getParameter("mno");
		String rno=request.getParameter("rno");
		
		// => 삭제에 필요한 변수 / 화면 이동 변수
		ReplyDAO dao=ReplyDAO.newInstance();
		dao.replyDelete(Integer.parseInt(rno));
		
		response.sendRedirect("MainServlet?mode=6&mno="+mno);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 보내준 데이터 받기 
		// <input name="mno">
		// ?mno=10
		String mno=request.getParameter("mno");
		String msg=request.getParameter("msg");
		
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		
		ReplyVO vo=new ReplyVO();
		vo.setFno(Integer.parseInt(mno)); 
		vo.setMsg(msg);
		vo.setId(id);
		vo.setName(name);
		
	    ReplyDAO dao=ReplyDAO.newInstance();
	    dao.replyInsert(vo);
	    
	    // 화면 출력 => FoodDetail
	    
	    response.sendRedirect("MainServlet?mode=6&mno="+mno);
	    //                                 ------ ---------
	    //                                 MainServlet  FoodDetail
		
	}

}