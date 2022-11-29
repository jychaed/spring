<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home02 20221129</title>
</head>
<body>
	<!-- taglib 지시자 예제 -->
	<h1>Member Info</h1>
	<p>member.userId : <c:out value="${member.userId }"/> </p>
	<p>member.password : ${member.password } </p>
	<p>member.userName : ${member.userName } </p>
	<p>member.email : ${member.email } </p>
	<p>member.dateOfBirth : ${member.dateOfBirth } </p>
</body>
</html>