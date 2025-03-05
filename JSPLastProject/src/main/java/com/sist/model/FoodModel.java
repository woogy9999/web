package com.sist.model;

import java.util.*;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.vo.*;
import com.sist.dao.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// JSP => Model => DAO => Model => JSP
//		|Controller        |Controller
@Controller
public class FoodModel {

	@RequestMapping("food/food_list.do")
	public String food_list(HttpServletRequest request,HttpServletResponse response) {
		
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (curpage*20)-19);
		map.put("end", (curpage*20));
		List<FoodVO> list=FoodDAO.foodListData(map);
		int totalpage=FoodDAO.foodTotalPage();
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
				endPage=totalpage;
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		request.setAttribute("main_jsp", "../food/food_list.jsp");
		return "../main/main.jsp";
	}
}
