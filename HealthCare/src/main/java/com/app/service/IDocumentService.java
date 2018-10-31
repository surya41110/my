package com.app.service;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	public Integer saveDocument(Document doc);
	public Document getDocumentByid(Integer docId);
	public List<Object[]> getDocumentsAndNames();

}
