package com.sist.vo;

import lombok.Data;

/*
 * TNO           NUMBER       
TIME NOT NULL VARCHAR2(20)
 */
@Data
public class TimeVO {
	private int tno;
	private String time;
}
