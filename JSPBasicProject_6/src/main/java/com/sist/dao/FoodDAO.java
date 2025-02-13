package com.sist.dao;

import java.util.*;
import java.sql.*;

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
			String sql = "SELECT fno,name,poster,num " + "FROM (SELECT fno,name,poster,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk)*/fno,name,poster " + "FROM food_menupan))"
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
		FoodVO vo = new FoodVO();

		try {
			getConnection();
			String sql = "UPDATE food_menupan SET " + "hit=hit+1 " + "WHERE fno=" + fno;

			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			sql = "SELECT name,type,phone,address,theme,poster, " + "image,time,parking,content,price,score,hit "
					+ "FROM food_menupan " + "WHERE fno=" + fno;

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

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
		} finally {
			disConnection();
		}

		return vo;

	}

	// cookie 데이터
	public FoodVO foodCookieData(int fno) {
		FoodVO vo = new FoodVO();
		try {
			getConnection();
			String sql = "SELECT fno,name,poster " + "FROM food_menupan " + "WHERE fno=" + fno;

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setPoster("https://www.menupan.com" + rs.getString(3));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return vo;

	}

	// 음식 종류별 검색
	public List<FoodVO> foodTypeFind(int page, String type) {
		List<FoodVO> list = new ArrayList<FoodVO>();

		try {
			getConnection();
			String sql = "";
			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			if (!type.equals("기타")) {

				sql = "SELECT fno,name,poster,num " + "FROM (SELECT fno,name,poster,rownum as num "
						+ "FROM (SELECT fno,name,poster " + "FROM food_menupan " + "WHERE type LIKE '%'||?||'%')) "
						+ "WHERE num BETWEEN ? AND ?";

				ps = conn.prepareStatement(sql);
				ps.setString(1, type);
				ps.setInt(2, start);
				ps.setInt(3, end);

			} else {
				sql = "SELECT fno,name,poster,num " + "FROM (SELECT fno,name,poster,rownum as num "
						+ "FROM (SELECT fno,name,poster " + "FROM food_menupan "
						+ "WHERE NOT REGEXP_LIKE(type,'한식|양식|중식|일식|카페'))) " + "WHERE num BETWEEN ? AND ?";

				ps = conn.prepareStatement(sql);
				ps.setInt(1, start);
				ps.setInt(2, end);
			}

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

	public int foodTypeTotalPage(String type) {
		int total = 0;
		try {
			getConnection();
			String sql = "";
			if (!type.equals("기타")) {
				sql = "SELECT CEIL(COUNT(*)/12.0) " + "FROM food_menupan " + "WHERE type LIKE '%'||?||'%'";
				ps = conn.prepareStatement(sql);
				ps.setString(1, type);

			} else {
				sql = "SELECT CEIL(COUNT(*)/12.0) " + "FROM food_menupan "
						+ "WHERE NOT REGEXP_LIKE(type,'한식|양식|중식|일식|카페')";
				ps = conn.prepareStatement(sql);

			}
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

	public List<FoodVO> foodFind(int page, String col, String fd) {

		List<FoodVO> list = new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql = "SELECT fno,name,poster,address,type,num "
					+ "FROM (SELECT fno,name,poster,address,type,rownum as num "
					+ "FROM (SELECT fno,name,poster,address,type " + "FROM food_menupan " + "WHERE " + col
					+ " LIKE '%'||?||'%')) " + "WHERE num BETWEEN ? AND ?";

			ps = conn.prepareStatement(sql);
			int rowSize = 20;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;

			ps.setString(1, fd);
			ps.setInt(2, start);
			ps.setInt(3, end);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster("https://www.menupan.com" + rs.getString(3));
				vo.setAddress(rs.getString(4));
				vo.setType(rs.getString(5));
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

	public int foodFindTotalPage(String col, String fd) {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/20.0) " + "FROM food_menupan " + "WHERE " + col + " LIKE '%'||?||'%'";
			ps = conn.prepareStatement(sql);
			ps.setString(1, fd);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return total;

	}

	// 로그인 처리
	public MemberVO memberLogin(String id, String pwd) {
		MemberVO vo = new MemberVO();
		try {
			getConnection();
			String sql = "SELECT COUNT(*) FROM member " + "WHERE id=?";

			ps = conn.prepareStatement(sql);

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();
			int count = rs.getInt(1);
			rs.close();

			if (count == 0) {

				vo.setMsg("NOID");

			} else {
				sql = "SELECT id,name,sex,pwd " + "FROM member " + "WHERE id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				rs.next();

				vo.setId(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setSex(rs.getString(3));
				String db_pwd = rs.getString(4);
				if (db_pwd.equals(pwd)) {

					vo.setMsg("OK");

				} else {
					vo.setMsg("NOPWD");
				}
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return vo;
	}

	public List<FoodVO> foodHitTop10() {

		List<FoodVO> list = new ArrayList<FoodVO>();

		try {

			getConnection();
			String sql = "SELECT fno,name,poster,hit,rownum " + "FROM (SELECT fno,name,poster,hit "
					+ "FROM food_menupan ORDER BY hit DESC) " + "WHERE rownum<=10";

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster("https://www.menupan.com" + rs.getString(3));
				vo.setHit(rs.getInt(4));
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
}
