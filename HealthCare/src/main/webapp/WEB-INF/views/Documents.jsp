<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
<style type="text/css">
div {
	text-align: center;
}

table {
	border: 1px solid black;
	border-collapse: collapse;
	width: 70%;
	background-color: #ededed;
	text-align: center;
	
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

input[type=submit] {
	background-color: #F28770;
	border: none;
	color: white;
	padding: 12px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

input[type=file] {
	width: 50%;
	background-color: #f1f1f1;
	border: none;
	color: black;
	padding: 12px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

h1 {
	text-align: center;
}
fieldset { 
    display: block;
    margin-left: 200px;
    margin-right: 200px;
    padding-top: 0.35em;
    padding-bottom: 1em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 2px groove (internal value);
}
</style>
</head>
<body>
	<h1>My Document</h1>
	<div>
	<fieldset>
		<form action="upload" method="post" enctype="multipart/form-data">

			<pre>
<b>File ::</b>		<input type="file" name="file">
		<br><br>
 		     <input type="submit" value="Upload">
</pre>
		</form>
		<p>${message}</p>
</fieldset>
		<table align="center">
			<tr>
				<th>File Id</th>
				<th>FIle Name</th>
				<th>Download</th>
			</tr>
			<c:forEach items="${docs}" var="docs">
				<tr>
					<td><c:out value="${docs[0]}" /></td>
					<td><c:out value="${docs[1]}" /></td>
					<td><a href="download?docId=${docs[0]}">Download</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>