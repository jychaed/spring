<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0102 20221129</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>\${member.hobbyArray }</td>
			<td>
				<c:forEach items="${member.hobbyArray }" var="hobby">
					${hobby }<br/>
				</c:forEach>			
			</td> 
		</tr>
		<tr>
			<td>\${member.hobbyArray[0] }</td>
			<td>${member.hobbyArray[0] }</td>
		</tr>
		<tr>
			<td>\${member.hobbyArray[1] }</td>
			<td>${member.hobbyArray[1] }</td>
		</tr>
		
		<tr>
			<td>\${member.hobbyList }</td>
			<td>
				<c:forEach items="${member.hobbyList }" var="hobby">
					${hobby }<br/>
				</c:forEach>			
			</td> 
		</tr>
		<tr>
			<td>\${member.hobbyList[0] }</td>
			<td>${member.hobbyList[0] }</td>
		</tr>
		<tr>
			<td>\${member.hobbyList[1] }</td>
			<td>${member.hobbyList[1] }</td>
		</tr>
	</table>
</body>
</html>