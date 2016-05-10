package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beifeng.sooba.db.admin.AdminDaoImpl;
import com.beifeng.sooba.db.admin.User;

public class TestAdminDao {

	
	private String path="applicationContext.xml";
	private ApplicationContext ctx;
	private AdminDaoImpl adminDao;
    @Before
    public void setUp() throws Exception {
		ctx=new ClassPathXmlApplicationContext(path);
		adminDao=(AdminDaoImpl)ctx.getBean("adminDao");
	}
    
	@After
	public void tearDown() throws Exception {
		ctx=null;
		adminDao=null;
	}
	
	@Test
	public void testget(){
		User user=(User)adminDao.getAdmin("admin", "admin");
		System.out.println(user.getUsername());
	}
}
