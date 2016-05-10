package com.test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beifeng.sooba.parserpdf.XpdfParser;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestParser {
	
	XpdfParser xp=null;
	@Before
	public void setUp() throws Exception {
		xp=new XpdfParser();
	}
    @After
    public void tearDown(){
    	xp = null;
    }
	
	
	@Test
//	@Ignore
	public void testGetTxtcont() throws Exception{
		
		String path="D:\\datadir\\datadir\\pdfdir";
		File file=new File(path);
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++)
		{
			String str=xp.getPDFFileContent(files[i].getCanonicalPath());
			System.out.println(i+"--"+str);
		}
//		xp.xpdfParser(getSoure, fileName);
	}
	
	@Test
	@Ignore
	public void testcontent() throws Exception{
		
		String path="D:\\datadir\\pdftxtdir";
		File file=new File(path);
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++)
		{
			String str=xp.getTxtContents(files[i].getCanonicalPath());
			System.out.println(i+"---"+files[i].getCanonicalPath()+"--"+str);
		}
	}
	@Test
	@Ignore
	public void testPar() throws IOException{
		
		String path="D:\\datadir\\datadir\\pdfdir";
		File file=new File(path);
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++)
		{
			String strtmp=files[i].getCanonicalPath();
			int beginIndex=strtmp.indexOf("pdfdir")+7;
			int endIndex =strtmp.indexOf(".pdf");	
			String str=xp.xpdfParser(strtmp, strtmp.substring(beginIndex,endIndex));
			System.out.println(i+"----"+str);
		}
	}
}
