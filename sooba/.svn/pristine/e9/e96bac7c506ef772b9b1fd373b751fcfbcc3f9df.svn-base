package com.test;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beifeng.sooba.db.DocRecord;
import com.beifeng.sooba.db.DocRecordDaoImpl;

public class TestDocDAO {
	
	private String path="applicationContext.xml";
	private ApplicationContext ctx;
	private DocRecordDaoImpl docDao;
    @Before
    public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(path);
		docDao=(DocRecordDaoImpl)ctx.getBean("docDao");
	}
    
	@After
	public void tearDown() throws Exception {
		ctx=null;
		docDao=null;
	}
	
	@Test
	@Ignore
	public void testCreateUser(){
		DocRecord user=new DocRecord();
		user.setFilename("总德尔来说");
		user.setDoctype("pdf");
		user.setLastmodify(new Date().getTime());
		docDao.createDoc(user);
	}
	
	@Test
	@Ignore
	public void testDele(){
		docDao.delDocById(2);
	}
	
	@Test
//	@Ignore
	public void testGet(){
		DocRecord user=docDao.getDocById(1);
		System.out.println(user.getFilename());
	}

}
