package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeePdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//to enable download
		response.addHeader("Content-Disposition", "attachment;filename=employee.pdf");
		List<Employee> emps=(List<Employee>) model.get("emps");
		
		
		PdfPTable table=new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Name");
		table.addCell("Gender");
		table.addCell("Address");
		table.addCell("Country");
		table.addCell("Languages");
		
		for(Employee e:emps){
			table.addCell(e.getEmpId().toString());
			table.addCell(e.getEmpName());
			table.addCell(e.getEmpGen());
			table.addCell(e.getEmpAddr());
			table.addCell(e.getEmpCntry());
			table.addCell(e.getEmpLangs().toString());
		}
		document.add(table);
		document.add(new Paragraph(new Date().toString()));
	}

	

}
