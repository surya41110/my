package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;

@Service
public class DocumentServiceImpl implements IDocumentService {
	
	@Autowired
	private IDocumentDao dao;

	@Override
	@Transactional
	public Integer saveDocument(Document doc) {
		return dao.saveDaocumrnt(doc);
	}

	@Override
	@Transactional(readOnly=true)
	public Document getDocumentByid(Integer docId) {
		return dao.getDocumentByid(docId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Object[]> getDocumentsAndNames() {
		return dao.getDocumentsAndNames();
	}

}
