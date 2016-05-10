package com.beifeng.sooba.search.index;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import com.beifeng.sooba.db.DocRecord;
import com.beifeng.sooba.db.DocRecordDaoImpl;
import com.beifeng.sooba.parserpdf.XpdfParser;
import com.beifeng.sooba.util.Constant;
import com.beifeng.sooba.util.DelTempDir;
import com.beifeng.sooba.util.StringUtil;

public class PDFIndex {

	private DocRecordDaoImpl docDao;

	
	public void setDocDao(DocRecordDaoImpl docDao) {
		this.docDao = docDao;
	}
    

	
	@Test
	public void createPDFIndex() throws Exception {
		
		XpdfParser xpdfp=new XpdfParser();
		
		String dataDir = Constant.getRootRealPath("pdf");
//		String dataDir = Constant.PDFdir;
		System.out.println("path"+dataDir);
		
		String indexDir = Constant.indexDir;
        String txtContents="";
		File[] files = new File(dataDir).listFiles();
		System.out.println(files.length);
		Analyzer analyzer = new PaodingAnalyzer();
		Directory dir = FSDirectory.getDirectory(indexDir);
		IndexWriter writer = new IndexWriter(dir, analyzer, false,
				IndexWriter.MaxFieldLength.UNLIMITED);
		long ldate = docDao.getTop1(".pdf");
//		System.out.println("============1==============");
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName()+"============2=============="+ldate);
			if (files[i].lastModified()> ldate) {
				
		
	
			    txtContents=xpdfp.getPDFFileContent(files[i].getCanonicalPath());
			    System.out.println(i+"============3=============="+txtContents);   
				DocRecord drec = new DocRecord();
				drec.setDoctype(".pdf");
				drec.setLastmodify(files[i].lastModified());
				drec.setFilename(StringUtil.gbkToAscii(files[i].getName()));
                
				Document document = new Document();
				int id = docDao.createDoc(drec);
				int index = files[i].getName().indexOf(".pdf");
				System.out.println(files[i].getName()+"---"+index);
				
				document.add(new Field("id", "" + id, Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("type", "pdf", Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("fileName", files[i].getName()
						.substring(0, index), Field.Store.YES,
						Field.Index.ANALYZED));
				document.add(new Field("contents", txtContents,
						Field.Store.YES, Field.Index.ANALYZED));
				writer.addDocument(document);

		
			}
		
		}
		System.out.println("------end------1-");
		File file = new File(Constant.PDFTxtdir);
//		if (file.exists()){
//			System.out.println("------1.1-----");
//			DelTempDir.delAllFile(file);
//		}
		
		System.out.println("------end------2-");
		writer.optimize();
		writer.close();
		
		dir.close();
	}

}
