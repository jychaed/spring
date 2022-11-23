<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD READ</title>
</head>
<body>
<h3>BOARD READ 페이지입니다.</h3>

<form action="/board/get" method="get">
	<button type="submit" name="modify">Modify</button>
	<button type="submit" name="remove">Remove</button>
</form>

<a href="/board/get?list" >LIST</a> <!-- list 키!--> 


</body>
</html>