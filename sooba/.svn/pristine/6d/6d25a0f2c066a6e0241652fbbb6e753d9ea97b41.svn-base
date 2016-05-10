package com.beifeng.sooba.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.SessionMap;

import com.beifeng.sooba.db.admin.AdminDao;
import com.beifeng.sooba.db.admin.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private String username;
	private String userpwd;
	public AdminDao adminDao;
	@Override
	public String execute() throws Exception {
		ActionContext ctx=ActionContext.getContext();
		SessionMap session=(SessionMap)ctx.getSession();
		System.out.println(username+"--"+userpwd);
		User user=(User)adminDao.getAdmin(username, userpwd);
		System.out.println(user.getUsername());
		if(user!=null){
			session.put("user", user);
			return SUCCESS;
		}
		
		else return ERROR;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}

}
