package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Employee;
import com.app.model.User;

public class UserExcelView extends AbstractXlsView {

	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=user.xls");
		Sheet sheet = workbook.createSheet("User");
		List<User> user=(List<User>) model.get("user");
		setHeader(sheet);
		setBody( sheet, user);
	}

	private void setHeader(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Email");
		row.createCell(3).setCellValue("Contact");
		row.createCell(4).setCellValue("Password");
		row.createCell(5).setCellValue("Address");

	}

	private void setBody(Sheet sheet, List<User> user) {
		int rowNum = 1;
		for (User e : user) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(e.getUserId());
			row.createCell(1).setCellValue(e.getUserName());
			row.createCell(2).setCellValue(e.getUserEmail());
			row.createCell(3).setCellValue(e.getUserContact());
			row.createCell(4).setCellValue(e.getUserPwd());
			row.createCell(5).setCellValue(e.getUserAddr().toString());
		}
	}

}
