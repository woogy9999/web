package com.sist.mybatis;
/*
 * 		public List<EmpVO> getEmpListData()
 * 		{
 *  		return getSession().selectList("SELECT~");
 * 		}
 * 
 */
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.*;
public class EmpDAO {
	private static SqlSessionFactory ssf;
	static {
		try {
			
			Reader reader=Resources.getResourceAsReader("config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			
		} catch (Exception e) {
			// TODO: handle exception 
			e.printStackTrace();  
		}
		 
	}
	
	public static List<EmpVO> empListData(){
		
		return ssf.openSession().selectList("empListData");
	}
	
}	
