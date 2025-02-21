package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.sist.dao.*;
import java.util.*;
import com.sist.vo.*;

@Controller
public class FoodModel {
	@RequestMapping("food/list.do")
	public String food_list(HttpServletRequest request,HttpServletResponse response) {
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		// DB연동
		Map map=new HashMap();
		map.put("start", (20*curpage)-19);
		map.put("end", 20*curpage);
		List<FoodVO> list=FoodDAO.foodListData(map); 
		int totalpage=FoodDAO.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		// 결과값 전송 => request.setAttribute()
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// include파일 지정
		request.setAttribute("main_jsp", "../food/list.jsp");
		
		return "../main/main.jsp";
		
	}
	@RequestMapping("food/detail_before.do")
	public String food_detail_before(HttpServletRequest request,HttpServletResponse response) {
		
		String fno=request.getParameter("fno");
		// 쿠키저장
		// 1. cookie 생성
		Cookie cookie=new Cookie("food_"+fno,fno);
		// 2. path 설정
		cookie.setPath("/");
		// 3. 저장 기간
		cookie.setMaxAge(60*60*24);
		// 4. 브라우저로 전송
		response.addCookie(cookie);
		// 상세보기
		return "redirect:../food/detail.do?fno="+fno;
	}
	
	@RequestMapping("food/detail.do")
	public String food_detail(HttpServletRequest request,HttpServletResponse response) {
			String fno=request.getParameter("fno");
			FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(fno));
			//	서울 종로구 평창동 281-1 녹원가든
			String addr1=vo.getAddress();
//			addr1 = addr1.trim(); // 앞뒤 공백 제거, addr1은 이제 "서울 종로구 평창동 281-1 녹원가든"
//			addr1 = addr1.substring(addr1.indexOf(" ") + 1); // 첫 번째 공백을 넘겨서 "종로구 평창동 281-1 녹원가든"
//			addr1 = addr1.substring(addr1.indexOf(" ") + 1); // 두 번째 공백을 넘겨서 "평창동 281-1 녹원가든"
//			String addr2 = addr1.trim(); // 이제 addr2는 "평창동 281-1 녹원가든"
//			String addr3 = addr2.substring(0, addr2.indexOf(" ")); // "평창동"만 추출
//			System.out.println(addr3.trim()); // 출력: 평창동

			StringTokenizer st=new StringTokenizer(addr1);
			String s1=st.nextToken();
			String s2=st.nextToken();
			String addr3=st.nextToken();
			System.out.println(addr3);
			request.setAttribute("addr", addr3.trim());
			request.setAttribute("vo", vo);
			
			// include
			request.setAttribute("main_jsp", "../food/detail.jsp");
			return"../main/main.jsp";
	}
	
}
