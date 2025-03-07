package com.sist.model;

import com.sist.controller.Controller;

import com.sist.controller.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

@Controller
public class MainModel {
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request, HttpServletResponse response) {

		FoodVO vo=FoodDAO.foodMainHouseData();
		List<FoodVO> fList=FoodDAO.foodMainHouseData8();
		// chefList => recipeList => newsList => cookieList
		request.setAttribute("fvo", vo);
		request.setAttribute("fList", fList);
		
		ChefVO cvo=RecipeDAO.recipeTodayChef();
		List<RecipeVO> rList=RecipeDAO.recipeData7();
		
		request.setAttribute("cvo", cvo);
		request.setAttribute("rList", rList);
		
		List<FoodVO> cList=new ArrayList<FoodVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null)
		{

			for(int i=cookies.length-1; i>=0; i--) {
				//Cookie cookie=new Cookie("food_"+fno,fno);
				if(cookies[i].getName().startsWith("food_")) // getName이 키값 가져옴
				{
					String fno=cookies[i].getValue(); // getValue가 값 가져오는거
					FoodVO fvo=FoodDAO.foodCookieData(Integer.parseInt(fno));
					
					cList.add(fvo);
					
				}
			}
		}
		request.setAttribute("cList", cList);
		
		// JSP로 값을 전송
		// request 한번쓰는거 / session 계속 쓰는거.
		request.setAttribute("main_jsp", "../main/home.jsp");
		// 화면 변경
		// include =. 파일에서 request로 공유할 수 있다.
		return "../main/main.jsp";
	}
}
