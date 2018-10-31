package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
	private IDocumentService service;

	@RequestMapping("/show")
	public String showDocument() {
		return "Documents";
	}

	@RequestMapping("/upload")
	public String uploadDocument(@RequestParam MultipartFile file, ModelMap map) throws IOException {
		if (file != null) {
			Document doc = new Document();
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			Integer count=service.saveDocument(doc);
			map.addAttribute("message", "Document Uploaded with Id:: "+count);
			List<Object[]> docs=service.getDocumentsAndNames();
			map.addAttribute("docs", docs);
		}
		return "Documents";
	}
	
	
	@RequestMapping("/download")
	public String downloadDocument(@RequestParam Integer docId,HttpServletResponse res){
		Document doc=service.getDocumentByid(docId);
		res.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		try {
			FileCopyUtils.copy(doc.getFileData(), res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Documents";
	}
}
