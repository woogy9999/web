package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*; //

/*
 *     POOL
 *     => 메모리 주소 : java://comp/env
 *     ------------------------------
 *      conn(주소)
 *      => 사용중 true
 *     ------------------------------
 *      conn(주소)
 *      => 사용중 true
 *     ------------------------------
 *      conn(주소) => 오라클 연결
 *      => false => true => 반환 => false
 *      
 *     
 */

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	// 연결되어 있는 POOL안에 => Connection주소를 얻어온다
	
	public void getConnection() {
	
		// 메모리 저장 => 탐색기와 비슷 => JNDI
		try {
			
			// 1. 탐색기 연다
			Context init=new InitialContext();
			// 2. C드라이버에 접근
			Context c=(Context)init.lookup("java://comp/env");
			// 3. 해당 => Connection의 정보
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
			
		} catch (Exception e) {
			
		}
	}
	
	public void disConnection() {
		
		try {
			
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
			// 자동으로 반환
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	// 기능
	public List<EmpBean> empListData(){
		
		List<EmpBean> list=new ArrayList<EmpBean>();
		
		try {
			getConnection(); // 미리생성된 connection주소를 얻어온다
			String sql="SELECT empno,ename,job,hiredate,sal "
					+ "FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				
				EmpBean vo=new EmpBean();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection(); // 사용후 반환
		}
		
		
		return list;
	}
}
