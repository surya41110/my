package com.app.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Employee;

public class EmployeeExcelView extends AbstractXlsView {

	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=employee.xls");
		Sheet sheet = workbook.createSheet("Emps");
		List<Employee> emps=(List<Employee>) model.get("emps");
		setHeader(sheet);
		setBody( sheet, emps);
	}

	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Gender");
		row.createCell(3).setCellValue("Address");
		row.createCell(4).setCellValue("Country");
		row.createCell(5).setCellValue("Languages");

	}

	private void setBody(Sheet sheet, List<Employee> emps) {
		int rowNum = 1;
		for (Employee e : emps) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getEmpId());
			row.createCell(1).setCellValue(e.getEmpName());
			row.createCell(2).setCellValue(e.getEmpGen());
			row.createCell(3).setCellValue(e.getEmpAddr());
			row.createCell(4).setCellValue(e.getEmpCntry());
			row.createCell(5).setCellValue(e.getEmpLangs().toString());
		}
	}

}
