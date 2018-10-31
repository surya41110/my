<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" >
<style type="text/css">
div {
	width: 450px;
	border: 20px solid #008080;
	padding: 15px;
	margin: 40px;
	height: 600px;
	text-decoration: blink;
}

textarea {
	width: 70%;
	height: 40px;
	padding: 12px 20px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #f8f8f8;
	resize: none;
}

select {
	width: 70%;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	background-color: #f1f1f1;
}

input[type=submit] {
	background-color: #008080;
	border: none;
	color: white;
	padding: 12px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

input[type=text] {
	width: 70%;
	background-color: #f1f1f1;
	border: none;
	color: black;
	padding: 12px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body>
	<div>
	<a href="/HealthCare"><h4 style="text-align: center;">Register Employee</h4></a>
		<form:form action="insert" method="POST" modelAttribute="employee">
			<pre>
				<b>
Name       : <form:input path="empName" />

Gender     : <form:radiobutton path="empGen" value="M" />Male  <form:radiobutton
						path="empGen" value="F" />Female
						
Address    : <form:textarea path="empAddr" />

Country    : <form:select path="empCntry">
				<form:option value="">--select--</form:option>
				<form:option value="IND">India</form:option>
				<form:option value="ENG">England</form:option>
			  </form:select>
			  
Languages  : English <form:checkbox path="empLangs" value="ENG" />  Telugu <form:checkbox
						path="empLangs" value="TEL" />
	     Hindi   <form:checkbox path="empLangs" value="HIN" />  Tamil  <form:checkbox
						path="empLangs" value="TAM" />
						
			<input type="submit" value="Register">
		
			</pre>
			</b>
		</form:form>
		<%-- ${message} --%>
		<p>
			<a href="get?id=${empId}"><span class="w3-tag w3-teal">${message}</span></a>
		</p>
	</div>
</body>
</html>