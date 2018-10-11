<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<form:form action="insert" method="POST" modelAttribute="employee">
		<pre>
			Name       :<form:input path="empName" />
			Gender     :<form:radiobutton path="empGen" value="M" />Male  <form:radiobutton
				path="empGen" value="F" />Female
			Address    :<form:textarea path="empAddr" />
			Country    :<form:select path="empCntry">
							<form:option value="">--select--</form:option>
							<form:option value="IND">India</form:option>
							<form:option value="ENG">England</form:option>
						</form:select>
			Languages  :
						English <form:checkbox path="empLangs" value="ENG" />  Telugu<form:checkbox path="empLangs" value="TEL" />
						
						Hindi <form:checkbox path="empLangs" value="HIN" />  Tamil<form:checkbox path="empLangs" value="TAM" />
						
						<input type="submit" value="Register">
		</pre>
		
	</form:form>
${message}
</body>
</html>