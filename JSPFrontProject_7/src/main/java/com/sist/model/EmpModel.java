package com.sist.model;

import java.io.PrintWriter;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sist.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;

@Controller
public class EmpModel {
	@RequestMapping("emp/list.do")
	public String emp_list(HttpServletRequest request, HttpServletResponse response) {
		return "../emp/list.jsp";
	}

	@RequestMapping("emp/list_ajax.do")
	public String emp_list_ajax(HttpServletRequest request, HttpServletResponse response) {

		List<EmpVO> list = EmpDAO.empListData();
		request.setAttribute("list", list);

		return "../emp/list_ajax.jsp";
	}

	// 핵심
	@RequestMapping("emp/list_json.do")
	public void emp_list_json(HttpServletRequest request, HttpServletResponse response) {
		List<EmpVO> list = EmpDAO.empListData();
		try {

			JSONArray arr = new JSONArray(); // [] => {}
			for (EmpVO vo : list) {
				JSONObject obj = new JSONObject();
				// {empno:100,ename:'',job:"",hiredate:'',sal:30000}
				obj.put("empno", vo.getEmpno());
				obj.put("ename", vo.getEname());
				obj.put("job", vo.getJob());
				obj.put("hiredate", vo.getDbday());
				obj.put("sal", vo.getSal());

				arr.add(obj);
			}
			response.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(arr.toJSONString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@RequestMapping("food/list.do")
	public String food_list(HttpServletRequest request, HttpServletResponse response) {
		return "../food/list.jsp";
	}

	@RequestMapping("food/list_ajax.do")
	public String food_list1(HttpServletRequest request, HttpServletResponse response) {
		
		return "../food/list_ajax.jsp";
	}
	
	@RequestMapping("food/list_ajax.do")
	public void food_list_ajax(HttpServletRequest request, HttpServletResponse response) {
		String type=request.getParameter("type");
		
		List<FoodVO> list=EmpDAO.foodTypeListData(type);
		JSONArray arr=new JSONArray();
		
		for(FoodVO vo:list) {
			JSONObject obj=new JSONObject();
			
			obj.put("fno", vo.getFno());
			
			arr.add(obj);
		}
		try {
			response.setContentType("text/plain;charset=UTF-8");
			
			PrintWriter out=response.getWriter();
			
			out.write(arr.toJSONString());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
