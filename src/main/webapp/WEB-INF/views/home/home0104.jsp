<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home0104 20221129</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>member.cardList</td>
			<td>
				<c:forEach items="${member.cardList }" var="card">
					${card.no } ${card.validMonth }<br/>
				</c:forEach>	
			</td>
		</tr>
		<tr>
			<td>\${member.cardList[0].no }</td>
			<td>${member.cardList[0].no }</td>
		</tr>
		<tr>
			<td>\${member.cardList[0].validMonth }</td>
			<td>${member.cardList[0].validMonth }</td>
		</tr>
		<tr>
			<td>\${member.cardList[1].no }</td>
			<td>${member.cardList[1].no }</td>
		</tr>
		<tr>
			<td>\${member.cardList[1].validMonth }</td>
			<td>${member.cardList[1].validMonth }</td>
		</tr>
		
	</table>
</body>
</html>