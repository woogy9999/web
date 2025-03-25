package com.sist.main;

import java.util.Arrays;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReserveDAO dao=ReserveDAO.newInstance();
		/*
		 * List<Integer> list=dao.foodGetfno(); for(int i:list) {
		 * System.out.println("i="+i); dao.foodRdaysUpdate(i, getRdays()); }
		 */
		for(int i=1; i<=31; i++) {
			dao.dayTimeInsert(i, i, getTimes());
		}
		System.out.println("예약 시간 저장 완료");
		
	}
	public static String getRdays()
	{
		String result="";
		int[] com=new int[(int)(Math.random()*10)+11];
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++)
		{
			bCheck=true;
			while(bCheck) {
				su=(int)((Math.random()*31)+1);
				bCheck=false;
				for(int j=0;j<i;j++) {
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		Arrays.sort(com);
		//System.out.println(Arrays.toString(com));
		
		for(int i:com)
		{
			result+=i+",";
		}
		result=result.substring(0,result.lastIndexOf(","));
		
		return result;
	}
	// 시간 넣어주는거임
	public static String getTimes()
	{
		String result="";
		int[] com=new int[(int)(Math.random()*6)+5];
		int su=0;
		boolean bCheck=false;
		for(int i=0; i<com.length; i++)
		{
			bCheck=true;
			while(bCheck) {
				su=(int)((Math.random()*15)+1);
				bCheck=false;
				for(int j=0;j<i;j++) {
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
		Arrays.sort(com);
		//System.out.println(Arrays.toString(com));
		for(int i:com)
		{
			result+=i+",";
		}
		result=result.substring(0,result.lastIndexOf(","));
		return result;
	}
}
