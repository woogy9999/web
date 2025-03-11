package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.CreateSqlSessionFactory;
import com.sist.vo.*;

public class BoardDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	public static List<BoardVO> boardListData(Map map){
		SqlSession session=ssf.openSession();
		List<BoardVO> list=session.selectList("boardListData",map);
		
		session.close();
		return list;
	}
	
	public static int boardTotalPage() {
		SqlSession session=ssf.openSession();
		int total=session.selectOne("boardTotalPage");
		session.close();
		return total;
	}
	  
	
	public static BoardVO boardDetailData(int no) {
		SqlSession session=ssf.openSession();
		session.update("boardHitIncrement",no);
		BoardVO vo=null;
		session.commit();
		try {
			vo=session.selectOne("boardDetailData",no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	public static void boardInsert(BoardVO vo) {
		SqlSession session=ssf.openSession(true);
		session.insert("boardInsert",vo);
		session.close();
	}
	
	/*
	 * <update id="boardUpdate" parameterType="BoardVO">
			UPDATE project_board SET
			name=#{name},subject=#{subject},content=#{content}
			WHERE no=#{no}
		</update>
		
		<!--  삭제  -->
		<select id="boardGetPassword" resultType="BoardVO" parameterType="int">
		 SELECT pwd FROM project_board
		 WHERE no=#{no}
		</select>
		<delete id="boardDelete" parameterType="int">
		  DELETE FROM project_board
		  WHERE no=#{no}
		</delete>
	 */
	public static BoardVO boardUpdateData(int no)
	{
		SqlSession session=ssf.openSession();
		BoardVO vo=session.selectOne("boardDetailData",no);
		session.close();
		return vo;
	}
	public static void boardUpdate(BoardVO vo) {
		SqlSession session=ssf.openSession(true);
		session.update("boardUpdate",vo);
		session.close();
	}
	public static String boardGetPassword(int no) {
		SqlSession session=ssf.openSession();
		String pwd=session.selectOne("boardGetPassword",no);
		session.close();
		return pwd;
	}
	public static void boardDelete(int no) {
		SqlSession session=ssf.openSession(true);
		session.delete("boardDelete",no);
		session.close();
	}
}
