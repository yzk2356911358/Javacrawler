package com.shwl.navigation.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FileLinkUtil {
public List<String> getfilelink(String link)
{
	List<String> strings = new ArrayList<>();
	try {
		
		Document doc = Jsoup.connect(link).get();
		Elements elements1 = doc.select(".table");
		 Elements links = elements1.select("a[href]");  
         for (Element temp : links) 
         {
        	 if(temp.attr("href").contains("http"))
   			{
        		 strings.add(temp.attr("href"));
   			}
   			else {
   			 strings.add("http://www.ccgp-sichuan.gov.cn"+temp.attr("href"));
   			}
         }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return strings;
	
}
//public static void main(String[] args) {
////	new FileLinkUtil().getfilelink("http://www.ccgp-sichuan.gov.cn/view/staticpags/shiji_jzxcscg/2c9240b57be0e862017be256329500e0.html");
//	DownloadURLFile downloadURLFile = new DownloadURLFile();
//	for(String s: new FileLinkUtil().getfilelink("http://www.ccgp-sichuan.gov.cn/view/staticpags/shiji_jzxcscg/2c9240b57be0e862017be256329500e0.html"))
//	{
//		downloadURLFile.downloadFromUrl(s, "D:\\work\\project\\filedown\\四川采购\\");
//		System.out.println(s);
//	}
//}
}
