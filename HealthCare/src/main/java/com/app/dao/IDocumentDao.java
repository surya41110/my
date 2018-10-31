package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDocumentDao {
	public Integer saveDaocumrnt(Document doc);
	public List<Object[]> getDocumentsAndNames(); 
	public Document getDocumentByid(Integer docId);
}
