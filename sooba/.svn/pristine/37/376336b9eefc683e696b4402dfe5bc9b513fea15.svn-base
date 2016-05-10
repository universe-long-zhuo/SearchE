package com.test.search;


import java.io.IOException;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.beifeng.sooba.util.Constant;

public class TestPageSearcher {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
	
		Directory dir=FSDirectory.getDirectory(Constant.indexDir);
		IndexSearcher searcher=new IndexSearcher(dir);
		ScoreDoc [] hits=null;
		PaodingAnalyzer analyzer = new PaodingAnalyzer();
		String field = "contents";
		String queryStr="数据";

//		Term term=new Term("contents","*数据*");
//		WildcardQuery query=new WildcardQuery(term);

		
		Term term=new Term("contents","数据");
		QueryParser parser = new QueryParser(field, analyzer);
		Query query = parser.parse(queryStr);

		
		TopDocs topDocs=searcher.search(query, 126);
		
		int pageNumber=2;     //第pageNumbe最小的页码数是1；
		int eachePageNum=10;  //每页显示的个数
		
		
		hits=topDocs.scoreDocs;
		
		System.out.println(hits.length);
		int totalNumber=pageNumber*eachePageNum;
		if(totalNumber>hits.length)totalNumber=hits.length;
		for(int i=(pageNumber-1)*eachePageNum;i<totalNumber;i++){
			Document doc=searcher.doc(hits[i].doc);
		    System.out.print(doc.get("id")+" "+" ");
		    System.out.println(doc.get("fileName")+" ");
//			System.out.println(doc.get("contents")+" ");
		}
		searcher.close();
		dir.close();
		
	}


}

