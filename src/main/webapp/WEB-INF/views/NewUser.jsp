<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
</head>
<body>

<h2>Add User</h2>

<form action="saveuser" method="post">
	FirstName : <input type="text" name="firstName"><br><br>  
	Email: <input type="text" name="email"/><br><br>
	Password : <input type="password" name="password" /><br><br>
	
	<input type="submit" value="Save User"/>

</form>
</body>
</html>