package com.sist.dao;

import java.util.*;
import java.sql.*;
import com.sist.vo.*;

import com.sist.vo.MusicVO;

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
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<MusicVO> MusicListData(int page){
		List<MusicVO> list=new ArrayList<MusicVO>();
		
		try {
			getConnection();
			String sql="SELECT mno,title,poster,num "
					+ "FROM (SELECT mno,title,poster,rownum as num "
					+ "FROM (SELECT /*+ INDEX_ASC(genie_music gm_mno_pk)*/mno,title,poster "
					+ "FROM genie_music)) "
					+ "WHERE num BETWEEN ? AND ?";
					
		//			private int mno,cno,idcrement,hit;
		//	private String title,singer,album,poster,state,key;
			
			ps=conn.prepareStatement(sql);

			int rowsize =12;
			int start=(rowsize*page)-(rowsize-1); // 24 -11 = 13
			int end=(rowsize*page); // 24
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				MusicVO vo=new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster("https:"+rs.getString(3));
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
}
