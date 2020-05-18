<%@page import="com.fanniemae.studentcatalog.model.Role"%>
<%@page import="com.fanniemae.studentcatalog.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.fanniemae.studentcatalog.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Catalog</title>
</head>
<%
	UserDao userDao = new UserDao();
	List<User> userList = userDao.listByRole(Role.STUDENT.code());
	User user = (User) session.getAttribute("user");
%>
<body>
	<form method="post" action="AddUser">
		<div align="center" style="font-family: monospace;">
			<h1 style="text-align: center;">Student Catalog</h1>
			<p style="text-align: center;">
				Welcome
				<%=user.getFirstName() + " " + user.getLastName()%></p>

			<%
				if (user.getRole().equals(Role.PROFESSOR.code()) || user.getRole().equals(Role.ADMINISTRATOR.code())) {
			%>

			<div>
				<label>First Name</label> <input name="firstName" type="text" /> <label>Last
					Name</label> <input name="lastName" type="text"> <label>SSN</label>
				<input name="SSN" type="text" /> <label>Role</label> <select
					id="role" name="role" style="font-family: monospace;">
					<option value="STD">Student</option>
					<option value="PRO">Professor</option>
					<option value="ADM">Administrator</option>
				</select>
			</div>
			<%
				if (user.getRole().equals(Role.ADMINISTRATOR.code())) {
			%>
			<div style="margin-top: 10px;">
				<label>Username</label> <input name="username" type="text" /> <label>Password</label>
				<input name="password" type="password" />
			</div>
			<%
				}
			%>
			<div>
				<input style="background: #2ecc71; margin: 10px; color: white;"
					type="submit" value="Save">
			</div>
			<%
				}
			%>

			<table align="center" cellpadding="5" cellspacing="5" border="1">
				<tr>
				</tr>
				<tr bgcolor=#2ecc71 align="center">
					<td><font color="#fff">First Name</font></td>
					<td><font color="#fff">Last Name</font></td>
					<%
						if (user.getRole().equals(Role.PROFESSOR.code()) || user.getRole().equals(Role.ADMINISTRATOR.code())) {
					%>
					<td><font color="#fff">SSN</font></td>
					<%
						}
					%>
				</tr>


				<%
					for (User u : userList) {
				%>
				<tr bgcolor="#EAF5F8">
					<td><%=u.getFirstName()%></td>
					<td><%=u.getLastName()%></td>
					<%
						if (user.getRole().equals(Role.PROFESSOR.code()) || user.getRole().equals(Role.ADMINISTRATOR.code())) {
					%>
					<td><%=u.getSsn()%></td>
					<%
						}
					%>
				</tr>
				<%
					}
				%>

			</table>
		</div>
	</form>
</body>
</html>