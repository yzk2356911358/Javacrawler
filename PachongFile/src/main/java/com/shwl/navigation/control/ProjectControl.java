package com.shwl.navigation.control;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shwl.navigation.dao.ProjectDao;
import com.shwl.navigation.dao.Project_file_linkdao;
import com.shwl.navigation.model.Project;
import com.shwl.navigation.model.Projectfilelink;
import com.shwl.navigation.util.DownloadURLFile;
import com.shwl.navigation.util.FileLinkUtil;

@Controller("")
public class ProjectControl {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private Project_file_linkdao file_linkdao;
	@RequestMapping("addproject")
	public String index( Model model) {
		projectDao.truncateTable();
		 FileLinkUtil fileLinkUtil = new FileLinkUtil();
         DownloadURLFile downloadURLFile  = new DownloadURLFile();
		Document doc;
		try {
			doc = Jsoup.connect("http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&moreType=provincebuyBulletinMore&channelCode=sjcg2&rp=25&page=1").get();
			Elements elements1 = doc.select(".info");
	        Elements time = doc.getElementsByClass("time curr");
	        Elements links = elements1.select("a[href]");  
          String data=time.select("span").text();
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-"); 
          for (Element link : links) 
          {
          		String href=link.attr("href").toString();
          		if(!href.equals("javascript:;"))
          		{
          			Project temp =new Project();
          			if(href.contains("http://202.61.88.152:9080"))
          			{
          				temp.setLink(link.attr("href"));
          			}
          			else {
          				temp.setLink("http://www.ccgp-sichuan.gov.cn"+link.attr("href"));
          			}
              		temp.setData(sdf.format(d)+data.substring(0, 2));
              		temp.setTitle(link.attr("title"));
;              		projectDao.save(temp);
          		}
          }
          for(int i=2;i<=4;i++)
          {
        	  doc = Jsoup.connect("http://www.ccgp-sichuan.gov.cn/CmsNewsController.do?method=recommendBulletinList&rp=25&page="+i+"&moreType=provincebuyBulletinMore&channelCode=sjcg2").get();
  			 elements1 = doc.select(".info");
  	         time = doc.getElementsByClass("time curr");
  	         links = elements1.select("a[href]");  
             data=time.select("span").text();
             d = new Date();
             sdf = new SimpleDateFormat("yyyy-MM-");  
            for (Element link : links) 
            {
            		String href=link.attr("href").toString();
            		if(!href.equals("javascript:;"))
            		{
            			Project temp =new Project();
            			if(href.contains("http://202.61.88.152:9080"))
            			{
            				temp.setLink(link.attr("href"));
            			}
            			else {
            				temp.setLink("http://www.ccgp-sichuan.gov.cn"+link.attr("href"));
            			}
                		temp.setData(sdf.format(d)+data.substring(0, 2));
                		temp.setTitle(link.attr("title"));
//                		for(String s:fileLinkUtil.getfilelink(temp.getLink()))
//                  		{
////                  			downloadURLFile.downloadFromUrl(s, dir+"t");
//                  			Projectfilelink projectfilelink  = new  Projectfilelink();
//                  			projectfilelink.setLink(s);
//                  			projectfilelink.setPname(temp.getTitle());
//                  			file_linkdao.save(projectfilelink);
//                  		}
                		projectDao.save(temp);
            		}
            }
          }
		} catch (IOException e) {
			e.printStackTrace();
		}
		file_linkdao.truncateTable();
		for(Project temp: projectDao.findAll())
		{
		for(String s:fileLinkUtil.getfilelink(temp.getLink()))
		{
			Projectfilelink projectfilelink  = new  Projectfilelink();
			projectfilelink.setLink(s);
			projectfilelink.setPname(temp.getTitle());
			file_linkdao.save(projectfilelink);
		}
		}
		//文件下载
		//排序
		Sort ageSort = Sort.by("id");
		String dirname="";
		int i=0;
		for(Projectfilelink temp : file_linkdao.findAll(ageSort))
		{
			if(i==0)
			{
//				File file = new File("D:\\work\\project\\filedown\\四川采购\\"+temp.getPname()+"\\");
				File file = new File("D:/work/project/filedown/四川采购/"+temp.getPname()+"/");
				if(!file.exists()){//如果文件夹不存在
					file.mkdir();//创建文件夹
				}
				System.out.println("Path:"+file.getPath()+"结束");
//				downloadURLFile.downloadFromUrl(temp.getLink(), file.getPath());
				downloadURLFile.downloadFromUrl(temp.getLink(), "D:/work/project/filedown/四川采购/"+temp.getPname()+"/");
				dirname=temp.getPname();
				i=2;
				continue;
			}
			if(1!=0)
			{
				if(dirname==temp.getPname()||dirname.equals(temp.getPname()))
				{
//					File file = new File("D:\\work\\project\\filedown\\四川采购\\"+temp.getPname()+"\\");
					File file = new File("D:/work/project/filedown/四川采购/"+temp.getPname()+"/");
//					downloadURLFile.downloadFromUrl(temp.getLink(), file.getPath());
					downloadURLFile.downloadFromUrl(temp.getLink(), "D:/work/project/filedown/四川采购/"+temp.getPname()+"/");
					dirname=temp.getPname();
					System.out.println("Path:"+file.getPath()+"结束");
					i=2;
					continue;
				}
				else {
					File file = new File("D:/work/project/filedown/四川采购/"+temp.getPname()+"/");
					if(!file.exists()){//如果文件夹不存在
						file.mkdir();//创建文件夹
					}
					downloadURLFile.downloadFromUrl(temp.getLink(), "D:/work/project/filedown/四川采购/"+temp.getPname()+"/");
					dirname=temp.getPname();
					System.out.println("Path:"+file.getPath()+"结束");
					i=2;
					continue;
				}
			}
			
		}
		
		model.addAttribute("projectlist", projectDao.findAll(ageSort));
		return "sccgpage";
	}
}
