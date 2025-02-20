package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.BoardVO;

public class BoardDAO {
	private static SqlSessionFactory ssf;
	static {
		
		try {
				Reader reader=Resources.getResourceAsReader("Config.xml");
				ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static List<BoardVO> boardListData(Map map){
		SqlSession session=ssf.openSession();
		List<BoardVO> list=session.selectList("boardListData",map);
		// 여러개 selectList 한개 selectone
		session.close();
		return list;
	}
	public static int boardTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("boardTotalPage");
		// 여러개 selectList 한개 selectone
		session.close();
		return total;
		
	}
	
	/*
	 * 	
  	<!-- 데이터 추가 (글쓰기) -->
  	<insert id="boardInsert" parameterType="BoardVO">
  	<!--  Mybatis의 sequence: 자동 증가 번호 -->
  		<selectKey keyProperty="no" resultType="int" order="BEFORE">
  			SELECT NVL(MAX(no)+1,1) as no FROM board
  		</selectKey>
  			INSERT INTO board VALUES(#{NO},#{name},#{subject},#{content},#{pwd},SYSDATE,0)
  	</insert>
	 * 
	 */
	
	public static void boardInsert(BoardVO vo) {
		SqlSession session=ssf.openSession();
		session.insert("boardInsert",vo);
		session.commit();
		session.close();
	}
	
	// 상세보기
	   public static BoardVO boardDetailData(int no)
	   {
		   SqlSession session=ssf.openSession();
		   // 조회수 증가 
		   session.update("hitIncrement",no);
		   session.commit();
		   // 데이터 가지고 오기
		   BoardVO vo=session.selectOne("boardDetailData",no);
		   // 반환 
		   session.close();
		   return vo;
	   }
	/*
	 *   	<!-- 조회수 증가 -->
  	<update id="hitIncrement" parameterType="int">
  		UPDATE board SET
  		hit=hit+1
  		<include refid="where-no"/>
  	
  	</update>
	 */
	
}
