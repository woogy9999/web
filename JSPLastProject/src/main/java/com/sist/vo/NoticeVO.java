package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
 * NO      NOT NULL NUMBER         
TYPE             NUMBER         
NAME             VARCHAR2(52)   
SUBJECT NOT NULL VARCHAR2(2000) 
CONTENT NOT NULL CLOB           
REGDATE          DATE           
HIT              NUMBER         

 */
@Data
public class NoticeVO {
	private int no,hit,type;
	private String name,subject,content,dbday,types;
	private Date regdate;
}
