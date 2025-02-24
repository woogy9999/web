package com.sist.dao;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<String> urlList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            urlList.add("https://www.saramin.co.kr/zf_user/career-information/senior-list/page/" + i);
        }
        
		for (int i = 0; i < urlList.size(); i++) {
			try {
				Document doc = Jsoup.connect(urlList.get(i)).get();
				Elements title = doc.select("p.title");
				Elements url = doc.select("a.inlist_box");
				
				//<a href=\"/zf_user/career-information/senior-view?doc_idx=24176&amp;page=1\
				for (int j = 0; j < title.size(); j++) {
					try {
						System.out.println(title.get(j).text());
						System.out.println(url.get(j).attr("href"));
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