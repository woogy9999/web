package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.commons.*;
import com.sist.vo.*;


public class QnABoardDAO {
	private static SqlSessionFactory ssf;
	static {
		ssf=CreateSqlSessionFactory.getSsf();
		
	}
	
	/*
	 * 	
	<select id="qnaRowCount" resultType="int">
		SELECT COUNT(*) FROM qnaBoard
	</select>
	<!-- 문의 -->
	<insert id="qnaInsert" parameterType="QnABoardVO">
	
	<select id="qnaListData" resultType="QnABoardVO" parameterType="hashmap">
	 */
	
	
	public static List<QnABoardVO> qnaListData(Map map) {
		SqlSession session=ssf.openSession();
		List<QnABoardVO> list=session.selectList("qnaListData",map); //여러줄
		session.close();
		return list;
	}
	public static int qnaRowCount() {
		SqlSession session=ssf.openSession();
		int count=session.selectOne("qnaRowCount"); //여러줄
		session.close();
		return count;
	}
	public static void qnaInsert(QnABoardVO vo)
	{
		SqlSession session=ssf.openSession(true);
		session.insert("qnaInsert",vo);
		session.close();
				
	}
	/*
	 * <select id="qnaAdminListData" resultType="QnABoardVO" parameterType="hashmap">
		SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,group_tab,group_id,group_step,anok,num
		FROM (SELECT no,subject,name,regdate,hit,group_tab,group_id,group_step,anok,rownum as num
		FROM (SELECT no,subject,name,regdate,hit,group_tab,group_id,group_step,anok
		FROM qnaBoard WHERE group_step=0 ORDER BY group_id DESC))
		WHERE num BETWEEN #{start} AND #{end}
	</select>
	
	<select id="qnaAdminRowCount" resultType="int">
		SELECT COUNT(*) FROM qnaBoard
		 WHERE group_step=0
	</select>
	 */
	public static List<QnABoardVO> qnaAdminListData(Map map) {
		SqlSession session=ssf.openSession();
		List<QnABoardVO> list=session.selectList("qnaAdminListData",map); //여러줄
		session.close();
		return list;
	}
	public static int qnaAdminRowCount() {
		SqlSession session=ssf.openSession();
		int count=session.selectOne("qnaAdminRowCount"); //여러줄
		session.close();
		return count;
	}
	
	/*
	 * 	<select id="qnaAdminDetailData" resultType="QnABoardVO" parameterType="int">

			SELECT no,name,subject,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,content
			FROM qnaBoard
			WHERE group_id=#{group_id}
		</select>
		<update id="qnaAdminAnOKChange" parameterType="int">
			UPDATE qnaBoard SET
			anok='y'
			WHERE group_id=#{group_id}
		</update>
		<insert id="qnaAdminInsert" parameterType="QnABoardVO">
			INSERT INTO qnaBoard(no,id,name,subject,content,pwd,group_id,anok)
			VALUES ((SELECT NVL(MAX(no)+1,1) FROM qnaBoard),#{id},
			'관리자',#{subject},#{content},#{pwd},#{group_id},1,1,'y')
		</insert>
		
	 */
	public static QnABoardVO qnaAdminDetailData(int group_id) {
		SqlSession session=ssf.openSession();
		QnABoardVO vo=session.selectOne("qnaAdminDetailData",group_id); //여러줄
		session.close();
		return vo;
	}
	public static void qnaAdminInsert(QnABoardVO vo) {
		SqlSession session=null;
		try {
			session=ssf.openSession();
			session.update("qnaAdminAnOKChange",vo.getGroup_id());
			session.insert("qnaAdminInsert",vo);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
		}finally {
			if(session!=null)
				session.close();
		}
	}
}
