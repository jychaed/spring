<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home1101 20221129 </title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p>c:redirect 사용예</p>
	<p> 지정한 페이지로 리다이렉트시킨다.</p>
	<c:redirect url="http://localhost/board/list"/>
	<h2>redirect 이후의 코드는 실행되지 않는다.</h2>
	<br/>
	<hr/>
</body>
</html>