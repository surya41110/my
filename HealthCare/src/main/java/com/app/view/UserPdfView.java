package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Employee;
import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//to enable download
		response.addHeader("Content-Disposition", "attachment;filename=user.pdf");
		List<User> user=(List<User>) model.get("user");
		
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Name");
		table.addCell("Email");
		table.addCell("Contact");
		table.addCell("Password");
		table.addCell("Address");
		
		for(User e:user){
			table.addCell(e.getUserId().toString());
			table.addCell(e.getUserName());
			table.addCell(e.getUserEmail());
			table.addCell(e.getUserContact());
			table.addCell(e.getUserPwd());
			table.addCell(e.getUserAddr().toString());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

	

}
