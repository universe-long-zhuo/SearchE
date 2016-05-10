package com.beifeng.sooba.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class Constant {
	public  static String basedir="\\";
	
//	public  static String basedir="D:\\";
	
	public  static String CONTEXT="\\sooba";
	
	public  static String  indexDir="d:\\datadir\\luceneindex";
	
	public static String PDFdir=basedir+"datadir\\pdfdir\\";
	
	public static String PDFTxtdir="d:\\datadir\\pdftxtdir\\";

	public static String ConvertorPATH="C:\\forjava\\xpdf\\pdftotext";

	public static String Docdir=basedir+"datadir\\worddir\\";
	

	
	public static String getRootRealPath(String str){
//		System.out.println(basedir+"----"+indexDir);
		HttpServletRequest request = ServletActionContext.getRequest();

		basedir=request.getRealPath("datadir");
		
//		System.out.println(basedir+"----"+indexDir);
		
			    if("pdf".equals(str))
			    	
		return request.getRealPath(PDFdir);
	    else return request.getRealPath(Docdir);      
	}
	
	   

}
