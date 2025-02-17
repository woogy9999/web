package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodVO;

import java.io.*;

public class FoodDAO {
	   private static SqlSessionFactory ssf;
	// XML 파싱
	// 1. dom => xml용 트리형태로 저장후 처리
	// 2. sax= 
	
	static
	{
		try {
			// XML 파일 읽기 => Config.xml => mapper
			Reader reder=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reder);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/*
	 * 
	 * 
	 * <select id="foodListData" resultSets="FoodVO">
 		SELECT fno,name,poster,num
 		FROM (SELECT fno,name,poster,rownum as num
 		FROM (SELECT fno,name,poster
 		FROM food_menupan ORDER BY fno ASC))
 		WHERE num BETWEEN #{start} AND #{end}
 	</select>
 	<!--  
 	
 	private int fno,hit;
	private double score;
	private String name,type,phone,address,theme,poster,image,time,parking,content,price;
	 -->
 	<select id="foodTotalPage" resultType="int">
 		SELECT CEIL(COUNT(*)/12.0) FROM food_menupan
 	</select>
 	*/
	public static List<FoodVO> foodListData(Map map){
		return ssf.openSession().selectList("foodListData",map);
		
	}
	public static int foodTotalPage() {
		return ssf.openSession().selectOne("foodTotalPaga");
	}
	/*
 	<update id="hitIncrement" parameterType="int">
		UPDATE food_menupan SET 
		hit=hit+1 
		<include refid="where-fno"/>
	
	</update>
 	<select id="foodDetailData" resultType="FoodVO" parameterType="int">
 	 SELECT name,type,phone,address,theme,poster,image,time,parking,content,price,score,hit 
	 FROM food_menupan 
	<include refid="where-fno"/>
 	
 	</select>
 	
	 */
	public static FoodVO foodDetailData(int fno) {
		ssf.openSession().update("hitIncrement",fno);
		return ssf.openSession().selectOne("foodDetailData",fno);
	}
}
