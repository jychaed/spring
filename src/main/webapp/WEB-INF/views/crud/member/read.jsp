<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#btnRemove").on("click", function() {
		if(confirm("정말로 삭제?")) {
			$("#delForm").submit();
		}
			$("#delForm").reset();
	});
	
	$("#btnList").on("click", function() {
		location.href="/crud/member/list";
	});
	
});

</script>
<body>
	<h2>READ</h2>
		<table>
			<tr>
				<td>userId</td>
				<td>${member.userId }</td>
			</tr>
			<tr>
				<td>userName</td>
				<td>${member.userName }</td>
			</tr>
			<tr>
				<td>auth - 1</td>
				<td>${member.authList[0].auth }</td>
			</tr>
			<tr>
				<td>auth - 2</td>
				<td>${member.authList[1].auth }</td>
			</tr>
			<tr>
				<td>auth - 3</td>
				<td>${member.authList[2].auth }</td>
			</tr>
		</table>
		<form action="/crud/member/remove" id="delForm" method="post">
			<input type="hidden" name="userNo" value="${member.userNo }"/>
		</form>
		<div>
			<a href="/crud/member/modify?userNo=${member.userNo }">
				<button type="button" id="btnModify">Modify</button>
			</a>
			<button type="button" id="btnRemove">Remove</button>
			<button type="button" id="btnList">List</button>
		</div>
</body>
</html>