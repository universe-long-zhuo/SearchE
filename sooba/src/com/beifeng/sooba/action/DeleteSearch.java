package com.beifeng.sooba.action;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.beifeng.sooba.search.DocumentEntity;
import com.beifeng.sooba.search.GetSearcheResult;
import com.beifeng.sooba.util.PageNumBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteSearch  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {

  	
		HttpServletRequest request = ServletActionContext.getRequest();
		String page=request.getParameter("page");
		
		if(fieldname==null){
			fieldname=request.getParameter("sk");//tomcat默认采用ISO-8859-1方式获取URI中的参数
			System.out.println(fieldname);
			
//			fieldname=new String(fieldname.getBytes("ISO-8859-1"),"utf-8"); //转换为utf-8

			System.out.println("-------1 ----- DeleteSearch ------ ");
	    }
		System.out.println(this.fieldname+" ------ "+"---DeleteSearch");
		
		if(page==null)page="1";
		int currentNum=Integer.valueOf(page);
//		System.out.println("------ ---"+currentNum+"-------------");
		GetSearcheResult gsr=new GetSearcheResult();
		List<DocumentEntity> list=gsr.getResult(this.fieldname,currentNum,200);
		int recordCount=gsr.getScoreDocs(fieldname, 200).length;
//		System.out.println("------ ---"+list.size()+"-------------");
		PageNumBean pageBean=null;
		System.out.println("------ "+recordCount);
		pageBean=(PageNumBean)request.getAttribute("pageNumBean");
		if(pageBean==null){
			pageBean=new PageNumBean(1,recordCount,gsr.eachePageNum,5);
			request.setAttribute("pageNumBean", pageBean);
		}
		    
		Integer downPageNum =currentNum+1;
		if(downPageNum>pageBean.getPageCount())downPageNum=null;
		Integer upPageNum =currentNum-1;
		if(upPageNum==0)upPageNum=null;
		pageBean.setUpPageNum(upPageNum);
		pageBean.setDownPageNum(downPageNum);
		pageBean.setCurrentNum(currentNum);
		request.setAttribute("pageNumBean", pageBean);
		request.setAttribute("sk",this.fieldname);
		request.setAttribute("sk1",URLEncoder.encode(fieldname,"UTF-8"));
		ActionContext.getContext().getSession().put("pageDelUrl","DeleteAction.action?page=");
		ActionContext.getContext().getSession().put("rsize",recordCount);
		ActionContext.getContext().getSession().put("rlist",list);

		
		return SUCCESS;
	}


	private String fieldname;

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

}
