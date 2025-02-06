package com.sist.dao;

import java.util.*;
import java.sql.*;
import com.sist.vo.*;

public class MusicDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static MusicDAO dao;

	public MusicDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static MusicDAO newInstance() {
		if (dao == null) {
			dao = new MusicDAO();
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

	public List<MusicVO> MusicListData(int page) {
		List<MusicVO> list = new ArrayList<MusicVO>();

		try {
			getConnection();
			String sql = "SELECT mno,title,poster,num " + "FROM (SELECT mno,title,poster,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(genie_music gm_mno_pk)*/mno,title,poster " + "FROM genie_music)) "
					+ "WHERE num BETWEEN ? AND ?";

			ps = conn.prepareStatement(sql);

			int rowsize = 12;
			int start = (rowsize * page) - (rowsize - 1); // 24 -11 = 13
			int end = (rowsize * page); // 24

			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MusicVO vo = new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster("https:" + rs.getString(3));
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
	public int MusicTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*)/12.0) " + "FROM genie_music";
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
	public MusicVO musicDetailData(int mno) {
		MusicVO vo = new MusicVO();

		try {
			getConnection();
			String sql = "UPDATE genie_music SET " 
			+ "hit=hit+1 " 
			+ "WHERE mno=" + mno;
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			sql = "SELECT cno,idcrement,hit,title,singer,album,poster,state,key " 
			+ "FROM genie_music " 
			+ "WHERE mno="+ mno;

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.next();

			vo.setCno(rs.getInt("cno"));
			vo.setIdcrement(rs.getInt("idcrement"));
			vo.setHit(rs.getInt("hit"));
			vo.setTitle(rs.getString("title"));
			vo.setSinger(rs.getString("singer"));
			vo.setAlbum(rs.getString("album"));
			vo.setPoster(rs.getString("poster"));
			vo.setState(rs.getString("state"));
			vo.setKey(rs.getString("key"));

			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}

		return vo;
	}

	// cookie 데이터~

	public MusicVO musicCookieData(int mno) {
		MusicVO vo = new MusicVO();
		try {
			getConnection();

			String sql = "SELECT mno,title,poster " + "FROM genie_music " + "WHERE mno=" + mno;

			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setMno(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster("https:" + rs.getString(3));

			rs.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
		return vo;
	}

	// 음악 종류별 검색
	public List<MusicVO> musicTypeFind(int page, int cno) {
		List<MusicVO> list = new ArrayList<MusicVO>();

		try {
			getConnection();
			String sql = "";
			int rowSize = 12;
			int start = (rowSize * page) - (rowSize - 1);
			int end = rowSize * page;
			sql = "SELECT mno,title,poster,num " 
					+ "FROM (SELECT mno,title,poster,rownum as num "
					+ "FROM (SELECT mno,title,poster "
					+ "FROM genie_music " 
					+ "WHERE cno ="+cno+")) " 
					+ "WHERE num BETWEEN ? AND ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MusicVO vo = new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster("http:" + rs.getString(3));
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

	public int musicTypeTotalPage(int cno) {
		int total=0;
		try {
			getConnection();
			String sql="";
				sql="SELECT CEIL(COUNT(*)/12.0) "
						+ "FROM genie_music "
						+ "WHERE cno="+cno;
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
			rs.next();
			
			total=rs.getInt(1);
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		
		return total;
	}
	
	public List<MusicVO> musicFind(int page, String col, String fd) {
		List<MusicVO> list = new ArrayList<MusicVO>();

		
		try {
			getConnection();
			String sql="SELECT mno,cno,idcrement,hit,title,singer,album,poster,state,key,num "
					+ "FROM (SELECT mno,cno,idcrement,hit,title,singer,album,poster,state,key,row as num "
					+ "FROM (SELECT mno,cno,idcrement,hit,title,singer,album,poster,state,key "
					+ "FROM genie_music " 
					+ "WHERE "+col+" LIKE '%'||?||'%')) "
					+ "WHERE num BETWEEN ? AND ?";
					
			
			ps=conn.prepareStatement(sql);
			int rowSize=20;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setString(1, fd);
			ps.setInt(2, start);
			ps.setInt(3, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MusicVO vo=new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setCno(rs.getInt("cno"));
				vo.setIdcrement(rs.getInt("idcrement"));
				vo.setHit(rs.getInt("hit"));
				vo.setTitle(rs.getString("title"));
				vo.setSinger(rs.getString("singer"));
				vo.setAlbum(rs.getString("album"));
				vo.setPoster("https:"+rs.getString("poster"));
				vo.setState(rs.getString("state"));
				vo.setKey(rs.getString("key"));
				list.add(vo);
				
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	public int musicFindTotalpage(String col,String fd) {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/20.0) "
					+ "FROM genie_music "
					+ "WHERE "+col+" LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, fd);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
		
	}
	
}
