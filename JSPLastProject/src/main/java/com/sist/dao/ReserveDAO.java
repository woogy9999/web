package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.CreateSqlSessionFactory;
import com.sist.vo.*;
import java.util.*;
public class ReserveDAO {
	private static SqlSessionFactory ssf;
	static {

		try {
			ssf = CreateSqlSessionFactory.getSsf();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*
	 * <select id="reserveFoodData" resultType="FoodVO" parameterType="hashmap">
		SELECT fno,poster,name,rownum
		FROM (SELECT fno,poster,name 
		FROM project_food ORDER BY hit DESC)
		WHERE type LIKE '%'||#{type}||'%'
		AND rownum&lt;=50
	
	</select>
	 */
	
	public static List<FoodVO> reserveFoodData(Map map){
		SqlSession session=null;
		List<FoodVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("reserveFoodData",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
}
