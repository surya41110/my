package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl implements IDocumentDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveDaocumrnt(Document doc) {
		 
		return (Integer) ht.save(doc);
	}

	@Override
	public Document getDocumentByid(Integer docId) {
		return ht.get(Document.class, docId);
	}

	@Override
	public List<Object[]> getDocumentsAndNames() {
		String hql="select fileId, fileName from "+Document.class.getName();
		List<Object[]> data=(List<Object[]>) ht.find(hql);
		return data;
	}

}
