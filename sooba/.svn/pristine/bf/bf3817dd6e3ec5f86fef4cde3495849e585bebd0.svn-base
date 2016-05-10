package com.beifeng.sooba.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.beifeng.sooba.parserpdf.XpdfParser;
import com.beifeng.sooba.search.index.InitIndex;
import com.beifeng.sooba.search.index.PDFIndex;
import com.beifeng.sooba.search.index.ParserWordAndToIndex;
import com.opensymphony.xwork2.ActionSupport;

public class FileIndexAction extends ActionSupport{
	
	private PDFIndex pdfi;
	private ParserWordAndToIndex pwat;
	private InitIndex init;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String flag=request.getParameter("flag");
//		File file =new File("datadir/worddir");
		
	
		if("pdf".equals(flag)){
			
			pdfi.createPDFIndex();	
		}
		else if("doc".equals(flag))
		{
			
			pwat.addIndex();
		}else
		{
			
			System.out.println("------------1----------");
			
			init.init();
		}

//		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
//		System.out.println(basePath+"---"+file.isDirectory()+"---"+request.getContextPath()+"--"+file.getCanonicalPath());
		return this.SUCCESS;
		
	}

	public ParserWordAndToIndex getPwat() {
		return pwat;
	}

	public void setPwat(ParserWordAndToIndex pwat) {
		this.pwat = pwat;
	}

	public PDFIndex getPdfi() {
		return pdfi;
	}

	public void setPdfi(PDFIndex pdfi) {
		this.pdfi = pdfi;
	}

	public void setInit(InitIndex init) {
		this.init = init;
	}


	
	

}
