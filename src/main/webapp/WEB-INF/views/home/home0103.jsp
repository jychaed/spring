<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0103 20221129</title>
</head>
<body>
	<table border="1">
		
		<tr>
			<td>\${member.address.postCode }</td>
			<td>${member.address.postCode }</td>
		</tr>
		<tr>
			<td>\${member.address.location }</td>
			<td>${member.address.location }</td>
		</tr>
		
	</table>
</body>
</html>