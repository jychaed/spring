<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Redirect Attribute Form</title>
</head>
<body>
	<h3>Register Form</h3>
	<form action="/redirectattribute/register" method="post">
		userId : <input type="text" name="userId" value="hongkd"/><br/>
		password : <input type="text" name="password" value="1234"/><br/>
		<input type="submit" value="register"/><br/>
	</form>
</body>
</html>