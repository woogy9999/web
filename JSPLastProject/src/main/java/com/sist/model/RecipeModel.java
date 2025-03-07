package com.sist.model;
import java.util.*;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RecipeModel {
		
	
	@RequestMapping("recipe/recipe_list.do") // 주소가 얘면 메소드를 호출하라는 뜻
	public String recipe_list(HttpServletRequest request,HttpServletResponse response) {
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (12*curpage)-11); // 얘가 mapper에 값을 넘겨주는거임
		map.put("end", 12*curpage);
		
		List<RecipeVO> list=RecipeDAO.recipeListData(map);
		int totalpage=RecipeDAO.recipeTotalPage();
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

		request.setAttribute("main_jsp", "../recipe/recipe_list.jsp");
						   // ----얘가 받음
		return "../main/main.jsp";  // 얘 위에다가 ../recipe/recipe_list.jsp얘를 올려주는거임
	}
	
	@RequestMapping("recipe/chef_list.do") 
	public String chef_list(HttpServletRequest request,HttpServletResponse response) {
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		map.put("start", (12*curpage)-11); // 얘가 mapper에 값을 넘겨주는거임
		map.put("end", 12*curpage);
		
		List<ChefVO> list=RecipeDAO.recipeChefListData(map);
		int totalpage=RecipeDAO.recipeChefTotalPage();
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		
		request.setAttribute("main_jsp", "../recipe/chef_list.jsp");
		return "../main/main.jsp";
	}
	
	
	
}
