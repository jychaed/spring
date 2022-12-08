<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item REGISTER</title>
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
	<h2>REGISTER 20221208</h2>
	<form:form modelAttribute="item" action="/item/register" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="itemName" id="itemName"/>
				</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>
					<input type="text" name="price" id="price"/>
				</td>
			</tr>
			<tr>
				<td>파일</td>
				<td>
					<input type="file" name="picture" id="picture"/>
				</td>
			</tr>
			<tr>
				<td>개요</td>
				<td>
					<textarea rows="10" cols="30" name="description"></textarea>
				</td>
			</tr>
		</table>
		<div>
			<button type="submit" id="btnRegister">Register</button>
			<button type="button" id="btnList">List</button>
		</div>
	</form:form>
</body>
</html>