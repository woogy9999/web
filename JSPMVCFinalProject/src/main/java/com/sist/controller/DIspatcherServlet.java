package com.sist.controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.*;

@WebServlet("*.do")
public class DIspatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try {
			
			// RealPath
			URL url=this.getClass().getClassLoader().getResource(".");
			
			// 파일로 변경
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", File.separator);
			// => window : \\ , mac, linux : /
			// => AWS => 우분투
			path=path.substring(0,path.lastIndexOf(File.separator));
			
			path=path+File.separator+"application.xml";
			
			// 패키지 명칭
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// XML 파싱기
			DocumentBuilder db=dbf.newDocumentBuilder();
			// XML 파싱 시작 => 태그나 속성에 있는 데이터 추출
			Document doc=db.parse(new File(path));
			// 최상위 태그 => 데이터베이스 (테이블 역할)
			Element beans=doc.getDocumentElement();
			NodeList list=beans.getElementsByTagName("context:component-scan");
			String pack="";
			for(int i=0; i<list.getLength(); i++) {
				Element elem=(Element)list.item(i);
				pack=elem.getAttribute("basePackage");
			}
			System.out.println(pack);
			clsList=com.sist.controller.FileReader.componentScan(file.getPath(), pack);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 사용자 요청시에 Model연결 => 결과값을 JSP 전송
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 사용자 요청 정보를 받는다
		//http://localhost/JSPMVCLastProject/main/main.do
		String uri=request.getRequestURI();
		uri=uri.substring(request.getContextPath().length()+1); // contextpath는 / 전까지
		System.out.println(uri);
		
		try {
			for(String cls:clsList) {
				Class clsName=Class.forName(cls);
				// 클래스의 모든 정보 읽기
				// 클래스 위에 @Controller가 있었는지 확인
				if(clsName.isAnnotationPresent(Controller.class)==false) {
					continue;
				}
				// 있는 경우에 메모리 할당
				Object obj=clsName.getDeclaredConstructor().newInstance();
				// 해당 메소드를 찾기 시작
				Method[] methods=clsName.getDeclaredMethods();
				
				for(Method m:methods) {
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					
					if(rm.value().equals(uri))
					{	// food_list() 
						String jsp=(String)m.invoke(obj, request);
						
						if(jsp==null) { // void  / 리턴형 없을때
							
							return;
							
						}else if(jsp.startsWith("redirect:")) {
							// sendRedirect => _ok
							jsp=jsp.substring(jsp.indexOf(":")+1);
							response.sendRedirect(jsp);
						}else {
							// forward => request를 JSP로 전송
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);;
							
							
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
