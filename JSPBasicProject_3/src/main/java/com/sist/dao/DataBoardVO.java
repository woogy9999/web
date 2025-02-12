package com.sist.dao;
/*
 * -------- -------- -------------- 
NO       NOT NULL NUMBER         
NAME     NOT NULL VARCHAR2(51)   
SUBJECT  NOT NULL VARCHAR2(2000) 
CONTENT  NOT NULL CLOB           
PWD      NOT NULL VARCHAR2(10)   
REGDATE           DATE           
HIT               NUMBER         
FILENAME          VARCHAR2(260)  
FILESIZE          NUMBER    
 */
import java.util.*;
import java.util.Date;

// JSP => Bean => 데이터를 모아서 관리
// Spring => VO
// Mybatis => DTO
// 자료실 한개에 대한 정보만 가지고 있다

	/*
	 *  1. 목록
	 *  	DataBoardVO 여러개 => List<DataBoardVO>
	 *  	=> 검색
	 *  2. 상세보기
	 *  	DataBoardVo
	 *  	SELECT
	 *  	INSERT / UPDATE / DELETE => void
	 */

public class DataBoardVO {
	private int no,hit,filesize;
	private String name,subject,content,pwd,filename,dbday;
	private Date regdate;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDbday() {
		return dbday;
	}
	public void setDbday(String dbday) {
		this.dbday = dbday;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
