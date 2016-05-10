package com.test.search;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import com.beifeng.sooba.util.Constant;

public class TestSearch {
	@Test
	public void test1() throws Exception{

		
		Directory dir=FSDirectory.getDirectory(Constant.indexDir);
		IndexSearcher searcher=new IndexSearcher(dir);
		searcher.maxDoc();
		ScoreDoc [] hits=null;
		Term term=new Term("contents","Êý¾Ý");
		TermQuery query=new TermQuery(term);
//		PrefixQuery query=new PrefixQuery(term);
//		WildcardQuery query=new WildcardQuery(term);
		
		Term term2=new Term("type","doc");
		TermQuery query2=new TermQuery(term2);
		BooleanQuery booleanQuery=new BooleanQuery();
		booleanQuery.add(query, BooleanClause.Occur.MUST);
		booleanQuery.add(query2, BooleanClause.Occur.MUST);
		TopDocs topDocs=searcher.search(booleanQuery, 100);
		hits=topDocs.scoreDocs;
		for(int i=0;i<hits.length;i++){
			Document doc=searcher.doc(hits[i].doc);
		    System.out.print(hits[i].score+"---"+doc.get("id")+" ");
		    System.out.print(doc.get("type")+" ");
			System.out.println(doc.get("fileName")+" ");
//			System.out.println(doc.get("contents")+" ");
		}
		searcher.close();
		dir.close();
		
	}

}
