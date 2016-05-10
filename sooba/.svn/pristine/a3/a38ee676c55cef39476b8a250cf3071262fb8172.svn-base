package com.beifeng.sooba.search.index;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Test;

import com.beifeng.sooba.db.DocRecord;
import com.beifeng.sooba.db.DocRecordDaoImpl;
import com.beifeng.sooba.util.Constant;
import com.beifeng.sooba.util.StringUtil;

public class ParserWordAndToIndex {

	private DocRecordDaoImpl docDao;

	String indexDir = Constant.indexDir;

	@Test
	public void addIndex() throws IOException {
		String temppath = Constant.getRootRealPath("doc");
		// File fileTxt=new File(temppath);
		// if(!fileTxt.exists())System.out.println("-----drectory not
		// found!-------");
		File[] files = new File(temppath).listFiles();
		// System.out.println(files.length+"------------"+Constant.getRootRealPath("doc"));
		Analyzer analyzer = new PaodingAnalyzer();
		Directory dir = FSDirectory.getDirectory(indexDir);
		IndexWriter writer = new IndexWriter(dir, analyzer, false,
				IndexWriter.MaxFieldLength.UNLIMITED);
		long ldate = docDao.getTop1(".doc");
		String strtmp = "";
		try {

			for (int i = 0; i < files.length; i++) {
				 System.out.println(files[i].lastModified()+"------1--------");
				 System.out.println(ldate+"------2--------");
				if (files[i].lastModified()>ldate) {
					 System.out.println("--doc----3--------");

					DocRecord drec = new DocRecord();
				
					// docDao.createDoc(drec);
					strtmp = files[i].getAbsolutePath();
					int beginIndex = strtmp.indexOf("pdfdir") + 7;
					int endIndex = strtmp.indexOf(".doc");
					FileInputStream fis = new FileInputStream(files[i]
							.getAbsolutePath());
					WordExtractor wordExtractor = new WordExtractor(fis);

					Document document = new Document();

					drec.setFilename(StringUtil.gbkToAscii(files[i].getName()));
					drec.setDoctype(".doc");
					drec.setLastmodify(files[i].lastModified());
//					System.out.println(files[i].getName());

					int index = files[i].getName().indexOf(".doc");
					int id = docDao.createDoc(drec);
					document.add(new Field("id", "" + id, Field.Store.YES,
							Field.Index.ANALYZED));
					document.add(new Field("type", "doc", Field.Store.YES,
							Field.Index.ANALYZED));
					document.add(new Field("fileName", files[i].getName()
							.substring(0, index), Field.Store.YES,
							Field.Index.ANALYZED));
					document.add(new Field("contents", wordExtractor.getText(),
							Field.Store.YES, Field.Index.ANALYZED));
					writer.addDocument(document);

				}

				// System.out.println("----"+files[i].getName().substring(0,index));

			}
			writer.optimize();
			writer.close();
			dir.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public DocRecordDaoImpl getDocDao() {
		return docDao;
	}

	public void setDocDao(DocRecordDaoImpl docDao) {
		this.docDao = docDao;
	}

}
