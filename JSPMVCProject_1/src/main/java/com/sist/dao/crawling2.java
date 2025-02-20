package com.sist.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class crawling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] url = { 
				"https://www.jobplanet.co.kr/job"
				};

		for (int i = 0; i < url.length; i++) {
			try {
				Document doc = Jsoup.connect(url[i]).get();
				Elements title = doc.select("body > div.body_wrap.group\\/layout.min-w-\\[1060px\\].bg-white.is-fixed-header > main > div.sc-3b1d4a4b-0.gQfLNu.contents_wrap.relative.z-10.mx-auto.min-h-\\[600px\\].w-\\[1286px\\].overflow-x-visible.bg-white.is-banner > div > div.mx-auto.min-h-\\[800px\\] > div.grid.gap-\\[56px_36px\\].mt-\\[16px\\].w-full > div:nth-child(2) > div > a > div.group.mt-\\[16px\\].group-\\[\\.small\\]\\:mt-\\[14px\\].medium > div > h2");
				
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