package com.test;

import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.beifeng.sooba.db.admin.User;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestAdmin {
	
	SqlMapClient sqlMap;
	@Before
	public void setUp() throws Exception {
		Reader reader = Resources.getResourceAsReader ("sql-map-config.xml");
		sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	}
    @After
    public void tearDown(){
    	sqlMap = null;
    }
    @Test
    public void testGet() throws SQLException{
    	Map map=new HashMap();
    	map.put("username", "admin");
    	map.put("userpwd", "admin");
    	User user=(User)sqlMap.queryForObject("getByNameAndPwd", map);
	    System.out.println(user.getUsername());
    	
    }
    

}
