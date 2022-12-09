<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEM3 LIST</title>
</head>
<body>
	<h2>List</h2>
	<a href="/item3/register">상품등록</a>
	<hr/>
	<table border="1">
		<tr>
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">편집</th>
			<th align="center" width="80">제거</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr>
				<td align="center">${item.itemId }</td>
				<td align="left">${item.itemName }</td>
				<td align="right">${item.price }</td>
				<td align="center"><a href="/item3/modify?itemId=${item.itemId }">상품편집</a></td>
				<td align="center"><a href="/item3/remove?itemId=${item.itemId }">상품제거</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>