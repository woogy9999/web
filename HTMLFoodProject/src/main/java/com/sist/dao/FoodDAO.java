package com.sist.dao;

import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class FoodDAO {
	// 연결 => 오라클 연결
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static FoodDAO dao;

	public FoodDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static FoodDAO newInstance() {
		if (dao == null) {
			dao = new FoodDAO();
		}
		return dao;
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void disConnection() {
		try {

			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// 목록 출력
	public List<FoodVO> foodListData(int page) {
		List<FoodVO> list = new ArrayList<FoodVO>();

		try {
			getConnection();
			String sql = "SELECT fno,name,poster,num " 
					+ "FROM (SELECT fno,name,poster,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk)*/fno,name,poster " 
					+ "FROM food_menupan))"
					+ "WHERE num BETWEEN ? AND ?";

			ps = conn.prepareStatement(sql);

			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;

			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));				
				vo.setName(rs.getString(2));
				vo.setPoster("https://www.menupan.com" + rs.getString(3));
				list.add(vo);

			}

			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}

		return list;
	}

	// 총페이지
	public int foodTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/12.0) " + "FROM food_menupan";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}

		return total;
	}
	// 상세보기
	public FoodVO foodDetailData(int fno) {
		FoodVO vo=new FoodVO();
		
		try {
			getConnection();
			String sql="UPDATE food_menupan SET "
					+ "hit=hit+1 "
					+ "WHERE fno="+fno;
			
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			
			sql="SELECT name,type,phone,address,theme,poster, "
					+ "image,time,parking,content,price,score,hit "
					+ "FROM food_menupan "
					+ "WHERE fno="+fno;
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			
			vo.setName(rs.getString("name"));
			vo.setType(rs.getString("type"));
			vo.setPhone(rs.getString("phone"));
			vo.setAddress(rs.getString("address"));
			vo.setTheme(rs.getString("theme"));
			vo.setPoster(rs.getString("poster"));
			vo.setImage(rs.getString("image"));
			vo.setTime(rs.getString("time"));
			vo.setParking(rs.getString("parking"));
			vo.setContent(rs.getString("content"));
			vo.setPrice(rs.getString("price"));
			vo.setScore(rs.getDouble("score"));
			vo.setHit(rs.getInt("hit"));
			
		
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return vo;
		
		
	}
	//cookie 데이터
	public FoodVO foodCookieData(int fno) {
		FoodVO vo=new FoodVO();
		try {
			getConnection();
			String sql="SELECT fno,name,poster "
					+ "FROM food_menupan "
					+ "WHERE fno="+fno;
			
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setPoster("https://www.menupan.com"+rs.getString(3));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
		
	}
}
