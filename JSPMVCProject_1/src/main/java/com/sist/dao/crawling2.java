package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] url = { 
				"https://www.jobplanet.co.kr/companies/348308/reviews/%EC%97%90%EC%8A%A4%ED%81%90%EC%A0%9C%EC%95%BD"
				};

		for (int i = 0; i < url.length; i++) {
			try {
				Document doc = Jsoup.connect(url[i]).get();
				Elements title = doc.select("tr");
				
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