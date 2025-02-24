package com.sist.dao;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//zf_user/career-information/senior-view?doc_idx=23335&page=3
        ArrayList<String> urlList = new ArrayList<>();
        ArrayList<String> number=new ArrayList<String>();
        ArrayList<String> poster1=new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            urlList.add("https://www.saramin.co.kr/zf_user/career-information/senior-list/page/" + i);
            
        }
		for (int i = 0; i < urlList.size(); i++) {
			try {
				Document doc = Jsoup.connect(urlList.get(i)).get();
				Elements title = doc.select("p.title");
				Elements url = doc.select("a.inlist_box");
				Elements poster = doc.select("span.img img");
				
				for (int j = 0; j < title.size(); j++) {
					try {
						String str;
						str=url.get(j).attr("href");
						str=str.substring(str.indexOf("=")+1);
						str=str.substring(0,str.indexOf("&"));
						number.add(str);
//						System.out.println(str);
//						System.out.println(title.get(j).text());
						poster1.add(poster.get(j).attr("src"));
//						System.out.println("=================="+i);
					} catch (Exception ex) {
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}	
		// 페이지별로 문자 잘랐으면 상세페이지에서 값 가져오기.
		System.out.println("★★★★★★★여기부터 ★★★★★★");
		
		ArrayList<String> urlList2 = new ArrayList<>(); 
        String getnumber;
        for (int i = 0; i < number.size(); i++) {
        	getnumber=number.get(i);
        	urlList2.add("https://www.saramin.co.kr/zf_user/career-information/senior-view?doc_idx=" + getnumber);
        }
		
        for (int i = 0; i < urlList2.size(); i++) {
			try {
				Document doc2 = Jsoup.connect(urlList2.get(i)).get();
				Elements title = doc2.select("p.title");
//				Elements company = doc2.select("span.in_name");
//				Elements company_part = doc2.select("p.company_part");
//				Elements day = doc2.select("span.day");
//				Elements view_count = doc2.select("span.view_count");
//				Elements tag_line = doc2.select("div.tag_line");
//				Elements mark_img = doc2.select("div.mark_img img");
				Elements inter_title = doc2.select("p.top_title");
				Elements inter_image = doc2.select("div.subtit_type01");
				
				
				for (int j = 0; j < title.size(); j++) {
					try {
						System.out.println(title.get(j).text());
//						System.out.println(company.get(j).text());
//						System.out.println(company_part.get(j).text());
//						System.out.println(day.get(j).text());
//						System.out.println(view_count.get(j).text());
//						System.out.println(tag_line.get(j).text());
//						System.out.println(mark_img.get(j).attr("src"));
//						System.out.println(poster1.get(i));
//						System.out.println("인터뷰페이지");
						
						System.out.println(inter_title.get(j).text().replace("따옴표", ""));
						System.out.println(inter_image.get(j).text());
						System.out.println("=================="+i);
						
					} catch (Exception ex) {
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}

}