package com.shwl.navigation;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
 
 
public class TestJsoup {
 
	 /**
	  * 
	  * @param url 访问路径
	  * @return
	  */
     public  Document getDocument (String url){
         try {
        	 //5000是设置连接超时时间，单位ms
             return Jsoup.connect(url).timeout(5000).get();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
     }
 
 
 
     public static void main(String[] args) {
// 
//         TestJsoup t = new TestJsoup();
//         Document doc = t.getDocument("http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&moreType=provincebuyBulletinMore&channelCode=sjcg2&rp=25&page=1");
//         Elements elements =doc.select("[class=info]");
//         Elements elements2 =doc.select("[class=time curr]");
//         String time =elements2.get(0).text();
//         System.out.println(time);
//         Elements elements3 =doc.select("[class=title]");
//         String title =elements3.get(0).text();
//         System.out.println(title);
//         Elements elements4 =doc.select("#ffe0906a620e4c5ab1c43ac001e62c86");
//         String href =elements4.get(0).text();
//         System.out.println(href);
         //         // 获取目标HTML代码
//         Elements elements1 = doc.select("[class=t clearfix]");
//         //今天
//         Elements elements2 = elements1.select("[class=sky skyid lv2 on]");
//         String today = elements2.get(0).text();
//         System.out.println("今日天气： "+today);
//         //几号
//         Elements elements3 = elements1.select("h1");
//         String number = elements3.get(0).text();
//         System.out.println("日期： "+number);
// 
//         // 天气
//         Elements elements4 = elements1.select("[class=wea]");
//         String rain = elements4.get(0).text();
//         System.out.println("天气： "+rain);
// 
//         // 最高温度
//         Elements elements5 = elements1.select("span");
//         String highTemperature = elements5.get(0).text()+"°C";
//         System.out.println("最高温："+highTemperature);
// 
//         // 最低温度
//         Elements elements6 = elements1.select(".tem i");
//         String lowTemperature = elements6.get(0).text();
//         System.out.println("最低温："+lowTemperature);
// 
//         // 风力
//         Elements elements7 = elements1.select(".win i");
//         String wind = elements7.get(2).text();
//         System.out.println("风力："+wind);
         try {
			Document doc = Jsoup.connect("http://www.ccgp-sichuan.gov.cn/view/staticpags/shiji_jzxcscg/2c9240b57be0e862017be256329500e0.html").get();
				/*
				 * 
				 * 
				 * */
			
			//			String title1 = doc.title();  http://www.ccgp-sichuan.gov.cn/view/staticpagsnew/jggg/2021-09-14/1b6c2627-b44f-4627-afe3-6bef5aead4f4.html
	
			Elements elements1 = doc.select(".table");
//			System.out.println(elements1.toString());
//            Elements title = elements1.select("div.title");
//            Elements time = doc.getElementsByClass("time curr");
//            Elements span = doc.getElementsByTag("span");
            Elements links = elements1.select("a[href]");  
            for (Element link : links) 
            {
                 System.out.println("link : "+link.attr("href"));  
            }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jsoup/jsoup-quick-start.html
//            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
//            for (Element image : images) 
//            {
//                System.out.println("src : " + "http://www.ccgp-sichuan.gov.cn/"+image.attr("src"));
//                System.out.println("height : " + image.attr("height"));
//                System.out.println("width : " + image.attr("width"));
//                System.out.println("alt : " + image.attr("alt"));
//            }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/jsoup/jsoup-quick-start.html
	         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         }
    

}