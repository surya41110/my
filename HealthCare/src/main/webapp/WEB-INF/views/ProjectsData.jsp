<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 70%;
	background-color: #ededed;
}

td {
	border: 1px solid black;
	border-collapse: collapse;
	width: 10%;
	height: 30px;
	font-weight: bold;
	font-style: italic;
	text-align: center;
}

th {
	border: 1px solid black;
	border-collapse: collapse;
	width: 10%;
	height: 40px;
	color: red;
}

a {
	color: black;
}

#msg {
	width: 50%;
	height: 25px;
	color: red;
	margin-top: 30px;
	margin: 70px 330px;
	font-size: 17px;
	font-weight: normal;
	background-color: #ededed;
}

#inTable {
	width: 100%;
	height: 100%;
	text-align: center;
}

a:link {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
	color: red;
}
</style>
</head>
<body>
	<a href="/HealthCare"><h1 style="color: red; text-align: center;">All
			Projects</h1></a>
	<table align="center">
		<tr>
			<td>ID</td>
			<td>Code</td>
			<td>Name</td>
			<td>Dept</td>
			<td>Note</td>
			<td colspan="2">Options</td>
		</tr>
		<c:forEach items="${projs}" var="proj">
			<tr>
				<td>${proj.projId}</td>
				<td>${proj.projCode}</td>
				<td>${proj.projName}</td>
				<td>${proj.projDept}</td>
				<td>${proj.projNote}</td>
				<td><a href="edit?projId=${proj.projId}">Edit</a></td>
				<td><a href="delete?projId=${proj.projId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	
	
	<br>
	<center><a href="pdf">Import As Pdf</a></center>
		<br>
	<center><a href="excel">Import As Excel</a></center>
</body>
</html>