package com.test.parser;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beifeng.sooba.parserpdf.XpdfParser;

public class TestParserPDF {
	
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
	public void testGetPDFContent() throws Exception{
		
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
	public void testGetTexContent() throws Exception{
		
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
	public void testParser() throws IOException{
		
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
