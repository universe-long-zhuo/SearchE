package com.beifeng.sooba.db.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class AdminDaoImpl  extends SqlMapClientDaoSupport implements AdminDao{
	
	public User getAdmin(String name,String pwd){
		Map map=new HashMap();
    	map.put("username", name);
    	map.put("userpwd", pwd);
		return (User)getSqlMapClientTemplate().queryForObject("getByNameAndPwd", map);
	
	}

}
