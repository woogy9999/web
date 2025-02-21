package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.*;
import com.sist.vo.*;

public class FoodDAO {
	private static SqlSessionFactory ssf;
	static
	{
		
		ssf=CreateSqlSessionFactory.getSsf();
		
	}
	public static List<FoodVO> foodTop12(String column){
		
		SqlSession session=null;
		List<FoodVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodTop12",column);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
		
//		SqlSession session=ssf.openSession();
//		// conn/ps 역할임
//		List<FoodVO> list=session.selectList("foodTop12",column);
//		session.close(); // 반환 (DBCP) => 재사용
//		return list;
		
	}

	public static List<FoodVO> foodListData(Map map){
		SqlSession session=null;
		List<FoodVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("foodListData",map);
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}
//	<select id="foodListData" resultType="FoodVO" parameterType="hashmap">
//		SELECT fno,poster,name,num 
//		FROM (SELECT fno,poster,name,rownum as num 
//		FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk)*/fno,poster,name
//		FROM food_menupan))
//		WHERE num BETWEEN #{start} AND #{end}
//	</select>
	
	public static int foodTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("foodTotalPage");
		session.close();
		return total;
	}
//	
// 	<select id="foodTotalPage" resultType="int">
//		SELECT CEIL(COUNT(*)/20.0) FROM food_menupan
//	</select>
	
	public static FoodVO foodDetailData(int fno) {
		SqlSession session=ssf.openSession();
		session.update("hitIncrement",fno);
		session.commit();
		FoodVO vo=session.selectOne("foodDetailData",fno);
		session.close();
		return vo;
	}
	/*
 	<select id="foodDetailData" resultType="FoodVO" parameterType="int">
 		SELECT * FROM food_menupan
 		WHERE fno=#{fno}
 	</select>
	 */
}
