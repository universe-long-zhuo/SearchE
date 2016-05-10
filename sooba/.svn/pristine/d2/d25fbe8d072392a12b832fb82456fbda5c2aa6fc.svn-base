package com.beifeng.sooba.search.index;

import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.beifeng.sooba.db.DocRecordDaoImpl;
import com.beifeng.sooba.parserpdf.XpdfParser;
import com.beifeng.sooba.util.Constant;

public class InitIndex {
	
    private DocRecordDaoImpl docDao;

	
	public void setDocDao(DocRecordDaoImpl docDao) {
		this.docDao = docDao;
	}
    
	
	
	public void init() throws IOException{
		System.out.println("-----------2--------");
		XpdfParser xpdf=new XpdfParser();
		
		System.out.println("-----------3---------");
//		Constant.getRootRealPath("pdf");
		Analyzer analyzer=new StandardAnalyzer();
		String indexDir=Constant.indexDir;
		Directory dir=FSDirectory.getDirectory(indexDir);
		
		//true 表示创建或覆盖当前索引；false表示对当前索引进行追加
		//Default value is 128
		IndexWriter writer=new IndexWriter(dir,analyzer,true,IndexWriter.MaxFieldLength.LIMITED);
		
	
			Document document=new Document();
//			document.add(new Field("xx_-1","1",Field.Store.YES,Field.Index.ANALYZED));
		    writer.addDocument(document);
		
		
		writer.optimize();
	
		writer.close();
		
		docDao.delAllDoc();
	}

}
