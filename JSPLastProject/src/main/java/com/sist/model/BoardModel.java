package com.sist.model;

import java.io.PrintWriter;
import java.util.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.sist.commons.*;
import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class BoardModel {
	@RequestMapping("board/board_list.do")
	public String board_list(HttpServletRequest request,HttpServletResponse response)
	{
		String page=request.getParameter("page");
		if(page==null) {
			page="1";
		}
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();

		map.put("start", (curpage*10)-9);
		map.put("end", (curpage*10));
		List<BoardVO> list=BoardDAO.boardListData(map);
		int totalpage=BoardDAO.boardTotalPage();
		

		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		
		request.setAttribute("main_jsp","../board/board_list.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/board_insert.do")
	public String board_insert(HttpServletRequest request,HttpServletResponse response) {
		
		
		request.setAttribute("main_jsp", "../board/board_insert.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/board_insert_ok.do")
	public String board_insert_ok(HttpServletRequest request,HttpServletResponse response) {
		
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");

		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		BoardDAO.boardInsert(vo);
		return "redirect:../board/board_list.do";
	}
	
	@RequestMapping("board/board_detail.do")
	public String board_detail(HttpServletRequest request,HttpServletResponse response) {
		
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		BoardVO vo=BoardDAO.boardDetailData(Integer.parseInt(no));
		System.out.println(no+" "+page);
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		request.setAttribute("main_jsp", "../board/board_detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/board_pwd_ajax.do")
	public void board_pwd_ajax(HttpServletRequest request,HttpServletResponse response) {
		
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		String db_pwd=BoardDAO.boardGetPassword(Integer.parseInt(no));
		int res=0;
		if(db_pwd.equals(pwd)) {
			res=1;
		}
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.write(String.valueOf(res));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@RequestMapping("board/board_delete_ajax.do")
	public void board_delete_ajax(HttpServletRequest request,HttpServletResponse response) {
		
		String no=request.getParameter("no");
		PrintWriter out=null;
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			out=response.getWriter();
			BoardDAO.boardDelete(Integer.parseInt(no));
			out.write("yes");
		} catch (Exception e) {
			// TODO: handle exception
			out.write("no");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("board/board_update.do")
	public String board_update(HttpServletRequest request,HttpServletResponse response) {

		// public String board_update(int no,int page,Model model)
		
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		BoardVO vo=BoardDAO.boardUpdateData(Integer.parseInt(no));
		
		
		request.setAttribute("vo", vo);
		request.setAttribute("page", page);
		
		request.setAttribute("main_jsp", "../board/board_update.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/board_update_ok.do")
	public String board_update_ok(HttpServletRequest request,HttpServletResponse response) {
		
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		String no=request.getParameter("no");
		String page=request.getParameter("page");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setNo(Integer.parseInt(no));
		
		int res=0;
		String db_pwd=BoardDAO.boardGetPassword(Integer.parseInt(no));
		if(db_pwd.equals(pwd))
		{
			BoardDAO.boardUpdate(vo);
			res=1;
		}else {
			res=0;
		}
		request.setAttribute("res", res);
		request.setAttribute("page", page);
		request.setAttribute("no", no);
		
		return "../board/board_update_ok.jsp";
		
	}
}
