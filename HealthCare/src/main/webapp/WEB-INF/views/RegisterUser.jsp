<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet">
<style type="text/css">
div {
	width: 450px;
	border: 20px solid #008080;
	padding: 15px;
	margin: 40px;
	height: 600px;
	text-decoration: blink;
	font-weight: bold;
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

input[type=submit] {
	background-color: #008080;
	border: none;
	color: white;
	padding: 12px 20px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
}

textarea {
	width: 80%;
	height: 40px;
	padding: 12px 20px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #f8f8f8;
	resize: none;
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
		<a href="/HealthCare"><h4 style="text-align: center;">Register
				User</h4></a>
		<pre>
		<form:form action="insert" method="POST" modelAttribute="user">
UserName :: <form:input path="userName" />
Email    :: <form:input path="userEmail" />
Contact  :: <form:input path="userContact" />
Password :: <form:input path="userPwd" />
Address  :: <form:textarea path="userAddr" />
		
		<input type="submit" value="Register"> 
		</form:form>
		</pre>
		<a href=""><span class="w3-tag w3-teal">${message}</span></a>
	</div>
</body>
</html>