//package com.shwl.navigation;
//
//
//import java.io.File;
//import java.net.URL;
//
//import org.apache.commons.io.FileUtils;
//
//public class DownloadURLFile {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		String res = downloadFromUrl("http://118.121.27.19:8012/contentUpload/2021-09-13/20210913_2618.pdfs","D:\\work\\project\\filedown\\");
//		System.out.println(res);
//	}
//
//
//	public static String downloadFromUrl(String url,String dir) {
//
//		try {
//			URL httpurl = new URL(url);
//			String fileName = getFileNameFromUrl(url);
//			System.out.println(fileName);
//			File f = new File(dir + fileName);
//			FileUtils.copyURLToFile(httpurl, f);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "Fault!";
//		} 
//		return "Successful!";
//	}
//
//	public static String getFileNameFromUrl(String url){
//		String name = new Long(System.currentTimeMillis()).toString() + ".X";
//		int index = url.lastIndexOf("/");
//		if(index > 0){
//			name = url.substring(index + 1);
//			if(name.trim().length()>0){
//				return name;
//			}
//		}
//		return name;
//	}
//	
//}
//
