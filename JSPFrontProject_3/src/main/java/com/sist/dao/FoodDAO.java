package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;

public class FoodDAO { 
	
	private static SqlSessionFactory ssf;
	static
	{
		//XML을 읽어서 필요한 데이터 추출
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	/*
	 * <select id="foodFindData" resultType="FoodVO" parameterType="hashmap">
	 SELECT fno,poster,name,num 
	 FROM (SELECT fno,poster,name,rownum as num 
	 FROM (SELECT + INDEX_ASC(food_menupan fm_fno_pk)fno,poster,name 
	 FROM food_menupan WHERE address LIKE '%'||#{address}||'%'))
	 WHERE num BETWEEN #{start} AND #{end}
	</select>
	<!-- 총페이지 -->
	<select id="foodFindTotalPage" resultType="FoodVO" parameterType="string">
		SELECT CEIL(COUNT(*)/12.0) FROM food_menupan
		WHERE address LIKE '%'||#{address}||'%'
	</select>
	<!-- 상세보기 -->
	<select id="foodFindDetailData" resultType="FoodVO" parameterType="int">
	 SELECT * FROM food_menupan
	 WHERE fno=#{fno}
	</select>
	 */
	public static List<FoodVO> foodFindData(Map map){
		SqlSession session=ssf.openSession();
		List<FoodVO> list=session.selectList("foodFindData",map);
		session.close();
		return list;
	}
	
	public static int foodFindTotalPage(String address) {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("foodFindTotalPage",address);
		session.close();
		return total;
		
	}
	public static FoodVO foodFindDetailData(int fno) {
		SqlSession session=ssf.openSession();
		FoodVO vo=session.selectOne("foodFindDetailData",fno);
		session.close();
		return vo;
	}
}
