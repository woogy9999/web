package com.sist.controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.sist.model.DeleteModel;
import com.sist.model.InsertModel;
import com.sist.model.ListModel;
import com.sist.model.UpdateModel;

/*

		1. MVC => MVP / MVVM(VueJS)
			=> 양방향 통신이 안된다 (단방향 통신만 가능)
			=> 약자 ( Model - View - Controller )
					   |
				데이터베이스처리 DAO
				데이터를 모아준다 VO
				처리내용 전송 Model
				
		=> 장점
			구성요소가 명확히 나눠져 있다 => 역할 분담이 좋다 back front
			데이터 흐름이 단방향 => 분석이 쉽다
			재사용이 좋다
			리팩토링 비용이 낮아진다
			------ 변수/메소드 => 가독성
		=> 단점
			컨트롤러가 복잡해지고 코드 중복이 발생
			뷰와 모델을 수동으로 처리
			양방향 통신으로 변경하면 추가 작업이 필요
			컨트롤러에 의존하는 경향이 많다
			------------ 분산 (MSA)
			-------------------------------JSP
			=> RestFul /MVC / Cookie vs Session
			---------- GET / POST / PUT / DELETE
			
			
		= 역할
			1. Controller
				사용자 요청 받기
				요청 처리 Model클래스 호출 => 어떻게 찾을 것인지
				요청 처리된 데이터를 View로 전송
			2. Model
				요청 처리 담당(비지니스로직)
			3. View
				전송 데이터를 출력
			   request		request	   request		request
			View => Controller => Model => Controller => View
			
			
					 
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Servlet은 화면 출력은 없다 => 자바와 JSP연결
		// 1. 사용자 주문을 받는다
		String cmd = request.getParameter("cmd");
		if(cmd==null)
			cmd="list";
		// 2. 주방에 요청 => 해당 Model을 찾는다
		// 2-1. 테이블 지정
		String jsp="";
		if (cmd.equals("list")) {
			ListModel model=new ListModel();
			model.excute(request);
			jsp="list.jsp";
		} else if (cmd.equals("insert")) {
			InsertModel model=new InsertModel();
			model.excute(request);
			jsp="insert.jsp";
		} else if (cmd.equals("update")){
			UpdateModel model=new UpdateModel();
			model.excute(request);
			jsp="update.jsp";
		} else if (cmd.equals("delete")){
			DeleteModel model=new DeleteModel();
			model.excute(request);
			jsp="delete.jsp";
		}
// 3. 주방에서 음식을 가지고 온다 => request에 담는다
// 4. 테이블에 올려준다 => jsp찾아서 보내준다
		RequestDispatcher rd=request.getRequestDispatcher("board/"+jsp);
		rd.forward(request, response);
	}

}
