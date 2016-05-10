package com.beifeng.sooba.db;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class DocRecordDaoImpl extends SqlMapClientDaoSupport implements DocRecordDao{

	public int createDoc(DocRecord docrec) {
 		this.getSqlMapClientTemplate().insert("doccreate", docrec);
//		System.out.println("this is test"+docrec.getId());
		return docrec.getId();
	}

	public int delDocById(int id) {
		return this.getSqlMapClientTemplate().delete("deleteDoc", id);
	}

	public DocRecord getDocByFileName(String strName) {
			return (DocRecord)getSqlMapClientTemplate().queryForObject("getDocByName", strName);
	}

	public DocRecord getDocById(int id) {
		return (DocRecord)getSqlMapClientTemplate().queryForObject("getDocById", id);
	}

	public long getTop1(String doctype) {
		DocRecord dr=(DocRecord)getSqlMapClientTemplate().queryForObject("getDocTop1",doctype);
		if(dr==null)return 0;
		else return dr.getLastmodify();
	}

	public int delAllDoc() {
		
		return  this.getSqlMapClientTemplate().delete("deleteAllDoc");
	}
	

}
