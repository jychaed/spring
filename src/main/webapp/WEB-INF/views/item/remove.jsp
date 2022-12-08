<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEM REMOVE</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#btnList").on("click", function() {
		location.href = "/item/list";
	});
});
</script>
<body>
	<h2>REMOVE</h2>
	<form:form modelAttribute="item" action="/item/remove" method="post" >
		<input type="hidden" name="itemId" value="${item.itemId }"/>
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="itemName" id="itemName" value="${item.itemName }" disabled="disabled"/> </td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" id="price" value="${item.price }" disabled="disabled"/>&nbsp;원</td>
			</tr>
			<tr>
				<td>현재 파일</td>
				<td>
					<img src="/item/display?itemId=${item.itemId }" width="210" height="240"/> <!-- 여기경로를 이어줘서 item/display 에 itemId가지고 컨트롤러로 넘어가  -->
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name="description" disabled="disabled">${item.description }</textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="btnRemove">Remove</button>
			<button type="button" id="btnList">List</button>
		</div>
		
	</form:form>
</body>
</html>