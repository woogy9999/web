package com.sist.model;

import jakarta.servlet.http.HttpServletRequest;
import com.sist.dao.*;
import com.sist.vo.*;
public class DetailModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String no=request.getParameter("no");
		BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		return "board/detail.jsp";
	}
}
