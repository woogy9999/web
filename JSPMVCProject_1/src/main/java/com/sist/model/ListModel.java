package com.sist.model;

import jakarta.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

public class ListModel implements Model{

	@Override
	public String handlerRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 1. 사용자 요청 => page
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		// 현재 페이지 지정
		int curpage=Integer.parseInt(page);
		
		Map map=new HashMap();
		map.put("start", (10*curpage)-9);
		map.put("end", 10*curpage);
		List<BoardVO> list=BoardDAO.boardListData(map);
		
		int totalpage=BoardDAO.boardTotalPage();
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		request.setAttribute("today", today);
		return "board/list.jsp";
	}

}
