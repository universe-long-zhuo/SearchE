package com.test;

import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.beifeng.sooba.db.DocRecord;
import com.beifeng.sooba.util.StringUtil;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestDocRecord {
	SqlMapClient sqlMap;
	@Before
	public void setUp() throws Exception {
		Reader reader = Resources.getResourceAsReader ("sql-map-config.xml");
		sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);
	}

	@Test
	@Ignore
	public void testInsert() throws SQLException{
		DocRecord docrec=new DocRecord();
		docrec.setFilename("ÕÅÈý");
		docrec.setDoctype("pdf");
		docrec.setLastmodify(new Date().getTime());
		sqlMap.insert("doccreate", docrec);
		System.out.println(docrec.getId());
		
	}
    @Test
    @Ignore
	public void testget()throws SQLException{
    	DocRecord docrec=(DocRecord)sqlMap.queryForObject("getDocById", 1);
    	StringUtil str;
    	System.out.println(StringUtil.asciiToGbk(docrec.getFilename()));
	}
    @Test
    @Ignore
    public void testDel()throws SQLException{
    	int res=sqlMap.delete("deleteDoc", 2);
    	System.out.println(res);
    }
    
    @Test
    @Ignore
    public void testTop1()throws SQLException{
    	int res=sqlMap.delete("deleteDoc", 2);
    	System.out.println(res);
    }
}
