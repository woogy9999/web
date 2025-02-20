package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] url = { 
				"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/1"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/2"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/3"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/4"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/5"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/6"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/7"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/8"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/9"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/10"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/11"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/12"
				,"https://www.saramin.co.kr/zf_user/career-information/senior-list/page/13"
				
				};

		for (int i = 0; i < url.length; i++) {
			try {
				Document doc = Jsoup.connect(url[i]).get();
				Elements title = doc.select("a.inlist_box p.sub_title");
				Elements singer = doc.select("a.inlist_box p.title");
				Elements album = doc.select("div.txt_detail p.company_name");
				Elements cname = doc.select("em.inpart");
				Elements name = doc.select("em.inname");
				Elements poster = doc.select("div.img_view span.img img");
				Elements date = doc.select("p.day_line span.day");
				Elements vcount = doc.select("span.view_count");
				for (int j = 0; j < title.size(); j++) {
					try {
						System.out.println(title.get(j).text());
						System.out.println(singer.get(j).text());
						System.out.println(album.get(j).text());
						System.out.println(cname.get(j).text());
						System.out.println(name.get(j).text());
						System.out.println(poster.get(j).attr("src"));
						System.out.println(date.get(j).text());
						System.out.println(vcount.get(j).text());
	
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