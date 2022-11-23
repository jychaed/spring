<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD REGISTER</title>
</head>
<body>
<h3>BOARD REGISTER 페이지입니다.</h3>

<form method="post" action="/board/post" >
	<button type="submit" name="register">Register</button>
</form>

<a href="/board/get?list" >LIST</a>

</body>
</html>