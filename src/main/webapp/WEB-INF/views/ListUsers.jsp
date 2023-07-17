<%@page import="com.entity.UserEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Users</title>
</head>
<body>
	<h2>List Users</h2>


	<%
	List<UserEntity> users = (List<UserEntity>) request.getAttribute("users");
	%>
	<table border="1" height="50%" width="50%">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		
		<%for(UserEntity u :users) {%>	
		
			<tr>
				<td> <%=u.getUserId() %></td>
				<td><%=u.getFirstName() %></td>
				<tD><%=u.getEmail() %></tD>
				<td><%=u.getPassword() %></td>
			</tr>
		<%} %>
	</table>

</body>
</html>