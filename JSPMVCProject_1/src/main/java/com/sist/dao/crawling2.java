package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] url = { 
				"https://www.saramin.co.kr/zf_user/career-information/senior-view?doc_idx=21911"
				};

		for (int i = 0; i < url.length; i++) {
			try {
				Document doc = Jsoup.connect(url[i]).get();
				Elements title = doc.select("#content > div > div.area_interview_thebody > div.subtit_type01 > div.content_interview.interview_type04");
				
				for (int j = 0; j < title.size(); j++) {
					try {
						System.out.println(title.get(j).text());
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