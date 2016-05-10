package com.test.search;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.beifeng.sooba.search.AdvanceGetSearcheResult;
import com.beifeng.sooba.search.DocumentEntity;
import com.beifeng.sooba.search.GetSearcheResult;

public class TestAdvanceSearcheResult {
	
	AdvanceGetSearcheResult gsr=null;
	@Before
	public void setUp() throws Exception {
		
		gsr=new AdvanceGetSearcheResult(10,"doc","term","”Ô“Â",20);
	}
    @After
    public void tearDown(){
    	gsr = null;
    }
    
    @Test
    public void test1() throws Exception{
    	
    	
     List<DocumentEntity> list=	gsr.getResult(1);
     for(DocumentEntity docEntity:list){
    	 System.out.print(docEntity.getId()+" ");
    	 System.out.print(docEntity.getType()+" ");
    	 System.out.println(docEntity.getFilename());
    	 System.out.println(docEntity.getOriginalFileName());
     }
    	
    }

}
