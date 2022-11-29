<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/Home0204 20221129</title>
</head>
<body>
	<h3>7장 JSP</h3>
	<p>member 객체의 userId 프로퍼티 값을 설정한다.</p>
	
	<c:set target="${member }" property="userId" value="hongkildong"/>
	<table border="1">
		<tr>
			<td>member.userId</td>
			<td>${member.userId }</td>
		</tr>
	</table>
</body>
</html>