package com.sist.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.CreateSqlSessionFactory;
import com.sist.commons.*;
import com.sist.vo.*;
import java.util.*;
public class JjimDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	/*
	 * <select id="jjimCheckCount" resultType="int" parameterType="JjimVO">
		SELECT COUNT(*) FROM all_jjim
		WHERE id=#{id} AND rno=#{rno} AND type=#{type}
	</select>
	 */
	/*
	 * SqlSession session=null;
		try {
			session=ssf.openSession();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	 */
	public static int jjimCheckCount(JjimVO vo) {
		SqlSession session=null;
		int count=0;
		try {
			session=ssf.openSession();
			count=session.selectOne("jjimCheckCount",vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return count;
	}
	/*
	 * 
	<insert id="jjimInsert" parameterType="JjimVO">
		INSERT INTO all_jjim VALUES(
			aj_jno_seq.nextval,#{rno},#{type},#{id},SYSDATE		
		)
	</insert>
	 */
	
	public static void jjimInsert(JjimVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.insert("jjimInsert",vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	}
	/*
	 * 
	 * 	<select id="jjimFoodListData" resultMap="jjimMap" parameterType="string">
		SELECT jno,type,rno,name,poster,fno
		FROM all_jjim aj,project_food pf
		WHERE aj.rno=pf.fno
		AND id=#{id} AND type=1
		ORDER BY jno DESC
	</select>
	 */
	
	public static List<JjimVO> jjimFoodListData(String id){
		SqlSession session=null;
		List<JjimVO> list=null;
		try {
			session=ssf.openSession();
			list=session.selectList("jjimFoodListData",id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	/*
	 * 
	<delete id="jjim_Delete" parameterType="int">
		DELETE FROM all_jjim
		WHERE jno=#{jno}
	</delete>
	 */
	
	public static void jjim_Delete(int jno) {
		SqlSession session=null;
		try {
			session=ssf.openSession(true);
			session.delete("jjim_Delete",jno);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
	}
}
