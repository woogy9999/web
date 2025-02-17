package com.sist.dao;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.GoodsVO;

import java.io.*;

// 2.XX => iBatis 3.XX => MyBatis 
// open source      google에서 인수 
public class GoodsDAO {
	private static SqlSessionFactory ssf;
	// 관리자 => 연결 => SQL문장 처리 => XML파일을 파싱 요청
	static {
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			
			try {
			    ssf = new SqlSessionFactoryBuilder().build(reader);
			    if (ssf == null) {
			        System.out.println("SqlSessionFactory is null");
			    } else {
			        System.out.println("SqlSessionFactory is created successfully");
			    }
			} catch (Exception e) {
			    e.printStackTrace();  // 예외 발생 시 처리
			    System.out.println("Failed to create SqlSessionFactory");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// 기능 처리
	public static List<GoodsVO> goodsListData(Map map) {
		return ssf.openSession().selectList("goodsListData", map);
	}

	public static int goodsTotalPage() {
		return ssf.openSession().selectOne("goodsTotalPage");
	}

}