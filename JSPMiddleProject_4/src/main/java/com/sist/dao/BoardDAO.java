package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.*;
import com.sist.vo.*;
public class BoardDAO {
	private static SqlSessionFactory ssf;
	// XML의 데이터를 저장 => SqlSessionFactory
	static {
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	// 기능 설정
	/*
	 * 	<select id="boardListData" resultType="BoardVO" parameterType="hashmap">
  	 SELECT no,subject,name,regdate,hit,num 
  	 FROM (SELECT no,subject,name,regdate,hit,num,rownum as num 
  	 FROM (SELECT no,subject,name,regdate,hit 
  	 FROM board ORDER BY no DESC))
  	 WHERE num BETWEEN #{start} and #{end}
  	</select>
	 */
	public static List<BoardVO> boardListData(Map map){
		SqlSession session=ssf.openSession();
		List<BoardVO> list=session.selectList("boardListData",map);
		session.close(); // POOL로 반환
		return list;
	}
	public static int boardTotalPage(){
		SqlSession session=ssf.openSession();
		int total=session.selectOne("boardTotalPage");
		session.close(); // POOL로 반환
		return total;
	}
	public static void boardInsert(BoardVO vo) {
		SqlSession session=ssf.openSession();
		session.insert("boardInsert",vo);
		session.commit();
		session.close();
	}
	// insert/update/delete/select => 관리 => SqlSession
	// SqlSession은 SqlSessionFactory가 생성
	// SqlSession session=ssf.openSession()
}
