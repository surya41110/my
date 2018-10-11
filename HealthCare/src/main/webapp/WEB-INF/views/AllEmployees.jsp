<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employees</title>
</head>
<body>
	<h1 style="color: red; text-align: center;">All Employees</h1>
	<table bgcolor="#D3D3D3" border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Country</th>
			<th>Languages</th>
		</tr>
		<c:forEach items="${listEmps}" var="emp">
			<tr>
				<td align="center"><b><i>${emp.empId}</i></b></td>
				<td align="center"><b><i>${emp.empName}</i></b></td>
				<td align="center"><b><i>${emp.empGen}</i></b></td>
				<td align="center"><b><i>${emp.empAddr}</i></b></td>
				<td align="center"><b><i>${emp.empCntry}</i></b></td>
				<td align="center"><b><i>${emp.empLangs}</i></b></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>