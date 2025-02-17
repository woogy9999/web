package com.sist.model;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;

public class FoodModel {
	public void foodListData(HttpServletRequest request) {
		// request에 값을 추가 => setAttribute()
		String page = request.getParameter("page");
		if (page == null)
			page = "1"; // 초기값 지정 => 오류
		// 현재페이지 설정
		int curpage = Integer.parseInt(page);
		// 현재 페이지에 대한 데이터 얻기
		Map map=new HashMap();
		map.put("start", (12*curpage)-11);
		map.put("end", (12*curpage));
		
		List<FoodVO> list = FoodDAO.foodListData(map);
		// 총페이지 읽기
		int totalpage = FoodDAO.foodTotalPage();
		
		// 블럭별 페이지
		final int BLOCK = 10;
		int startPage = ((curpage - 1) / BLOCK * BLOCK) + 1;
		int endPage = ((curpage - 1) / BLOCK * BLOCK) + BLOCK;

		if (endPage > totalpage) {
		endPage = totalpage;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
	}
	public void foodDetailData(HttpServletRequest request) {
		String fno=request.getParameter("fno");
		FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(fno));
		
		request.setAttribute("vo", vo);
		
	}
}
