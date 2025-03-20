package com.sist.dao;

import java.util.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.sist.commons.*;
import com.sist.vo.*;

public class CartDAO {

	private static SqlSessionFactory ssf;
	static {
		ssf = CreateSqlSessionFactory.getSsf();

	}

	/*
	  <insert id="cartInsert" parameterType="CartVO"> INSERT INTO cart VALUES(
	  cart_cno_seq.nextval,#{gno},#{id},#{account}, #{price},'n',SYSDATE )
	  </insert>
	  
	  <resultMap type="CartVO" id="cartMap"> 
	  <result property="gvo.goods_name" column="goods_name" /> 
	  <result property="gvo.goods_poster" column="goods_poster" /> 
	  <result property="gvo.goods_price" column="goods_price" /> 
	  </resultMap>
	  
	  <select id="cartListData" resultMap="cartMap" parameterType="string"> 
	  SELECT cno,goods_name,goods_poster,goods_price,account,price 
	  FROM cart c,goods_all g
	  WHERE c.gno=g.no AND id=#{id} AND isbuy='n' </select>
	  
	  <!-- 같은거 선택했을때 수량증가 --> 
	  <update id="cartUpdate" parameterType="hashmap">
	  UPDATE cart SET account=account+#{account} 
	  WHERE gno=#{gno} AND id=#{id}
	  </update> 
	  
	  <!-- 장바구니 취소 -->	  
	  <delete id="cartCancel" parameterType="int"> 
	  DELETE FROM cart 
	  WHERE cno=#{cno} </delete>
	 */
	public static void cartInsert(CartVO vo) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			int count = session.selectOne("cartCount", vo);
			if (count == 0) {
				session.insert("cartInsert", vo);
			} else {
				session.update("cartUpdate", vo);
			}
			session.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public static List<CartVO> cartListData(String id) {
		List<CartVO> list = new ArrayList<CartVO>();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			list = session.selectList("cartListData", id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}
/*
 * <select id="buyListData" resultMap="cartMap"
		parameterType="string">
		SELECT
		cno,goods_name,goods_poster,goods_price,account,price
		FROM cart
		c,goods_all g
		WHERE c.gno=g.no
		AND id=#{id} AND isbuy='y'
		ORDER BY cno DESC
	</select>
 */
	
	public static List<CartVO> buyListData(String id) {
		List<CartVO> list = new ArrayList<CartVO>();
		SqlSession session = null;
		try {
			session = ssf.openSession();
			list = session.selectList("buyListData", id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public static void cartCancel(int cno) {
		SqlSession session = null;
		try {
			session = ssf.openSession(true);
			session.delete("cartCancel", cno);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
	/*
	 * <insert id="buyInsert" parameterType="CartVO">
		INSERT INTO cart VALUES(
		cart_cno_seq.nextval,#{gno},#{id},#{account},
		#{price},'y',SYSDATE
		)
	</insert>
	 */
	public static void buyInsert(CartVO vo) {
		SqlSession session = null;
		try {
			session = ssf.openSession();
			session.insert("buyInsert", vo);
			session.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
