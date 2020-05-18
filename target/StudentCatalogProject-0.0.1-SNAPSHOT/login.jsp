<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Catalog</title>
</head>
<body>
	<form method="post" action="LoginCheck">
		<div align="center" style="font-family: monospace;">
			<h1>Student Catalog</h1>
			<table align="center">
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>

			</table>
			<input style="background: #2ecc71; margin: 10px; color: white;"
				type="submit" value="Login">
		</div>
	</form>


</body>
</html>