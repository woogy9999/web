package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;
import com.sist.commons.*;

public class RecipeDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
		
	}
	/*
	 * 
	    <select id="recipeTodayChef" resultType="ChefVO">
			SELECT * FROM (SELECT * FROM chef ORDER BY DBMS_RANDOM.RANDOM)
			WHERE rownum&lt;=1
		</select>
		<!-- 레시피 7개 -->
			<select id="recipeData7" resultType="RecipeVO">
				SELECT no,title,poster,chef,hit,likecount,replycount,rownum
				FROM (SELECT * FROM recipe ORDER BY hit DESC)
				WHERE rownum&lt;=7
			</select>
			
			
			<select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
				SELECT no,title,poster,chef,hit,likecount,replycount,num 
				FROM (SELECT no,title,poster,chef,hit,likecount,replycount,rownum as num 
				FROM (SELECT + INDEX_ASC(recipe recipe_no_pk)no,title,poster,chef,hit,likecount,replycount
				FROM recipe))
				WHERE num BETWEEN #{start} AND #{end}
			</select>
			 
			<select id="recipeTotalPage" resultType="int"> 
				SELECT CEIL(COUNT(*)/12.0) FROM recipe
			</select>
	 */
	public static ChefVO recipeTodayChef() {
			ChefVO vo=null;
			SqlSession session=null;
			try {
				session=ssf.openSession();
				vo=session.selectOne("recipeTodayChef");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				if(session!=null)
					session.close();
			}
			return vo;
	}
	
	public static List<RecipeVO> recipeData7() {
		List<RecipeVO> list=null;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			list=session.selectList("recipeData7");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static List<RecipeVO> recipeListData(Map map) {
		SqlSession session=null;
		List<RecipeVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("recipeListData",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int recipeTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("recipeTotalPage");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
	
	/*
	 * 
	 * 	<select id="recipeChefListData" resultType="ChefVO" parameterType="hashmap">
	  SELECT no,chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,num
	  FROM (SELECT no,chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,rownum as num
	  FROM (SELECT no,chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2
	  FROM chef ORDER BY no ASC))
	  WHERE num BETWEEN #{start} AND #{end}
	</select>
	<select id="recipeChefTotalPage" resultType="int"> 
		SELECT CEIL(COUNT(*)/30.0) FROM chef
	</select>

	 */
	
	public static List<ChefVO> recipeChefListData(Map map) {
		SqlSession session=null;
		List<ChefVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("recipeChefListData",map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int recipeChefTotalPage() {
		int total=0;
		SqlSession session=null;
		try {
			session=ssf.openSession();
			total=session.selectOne("recipeChefTotalPage");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
}
