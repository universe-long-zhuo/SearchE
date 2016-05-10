package com.test.index;

import java.io.IOException;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Ignore;
import org.junit.Test;

import com.beifeng.sooba.search.index.DelDocumentFromIndex;

public class TestForIndex {
	
	@Test
	@Ignore
	public void test1() throws IOException{
	
	Analyzer analyzer=new PaodingAnalyzer();
	String indexDir="d:/luceneindex";
	Directory dir=FSDirectory.getDirectory(indexDir);
	IndexSearcher searcher=new IndexSearcher(dir);
	ScoreDoc [] hits=null;
	Term term=new Term("contents","Êý¾Ý");
	TermQuery query=new TermQuery(term);
	TopDocs topDocs=searcher.search(query, 100);
	hits=topDocs.scoreDocs;
	for(int i=0;i<hits.length;i++){
		Document doc=searcher.doc(hits[i].doc);
//	    System.out.print(hits[i].score+" ");
		System.out.print(doc.get("id")+" ");
		System.out.print(doc.get("type")+" ");
		System.out.println(doc.get("fileName")+" ");
	
	}
	searcher.close();
	dir.close();
	
}
   @Test
//   @Ignore
   public void testdel(){
	  String [] strs={"47"};
	  int flag=DelDocumentFromIndex.delDocumnentById("id",strs);
	  System.out.println(flag);
	  
   }

}
