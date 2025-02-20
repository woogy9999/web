package com.sist.main;


import java.lang.reflect.Method;
import java.util.*;

import com.sist.ann.RequestMapping;

public class MainClass2 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("com.sist.model.BoardModel");
		list.add("com.sist.model.FoodModel");
		list.add("com.sist.model.GoodsModel");
		Scanner scan=new Scanner(System.in);
		System.out.println("URL 입력");
		String url=scan.next();
		//////////// getRequestURI()
		try {
			
			for(String cls:list) {
			Class clsName=Class.forName(cls);
			Object obj=clsName.getDeclaredConstructor().newInstance();
			
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods) {
				//System.out.println(m.getName());
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				
				if(rm.value().equals(url))
				{
					m.invoke(obj, null);
				}
			}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
