<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0301 20221129</title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p>c:set 태그로 지정한 변수 memberId를 삭제한다.</p>
	
	<c:set var="memberId" value="${member.userId }"/>
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${memberId }</td>
		</tr>
	</table>
	
	<c:remove var="memberId"/>
	
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${memberId }</td>
		</tr>
	</table>
	
	
</body>
</html>