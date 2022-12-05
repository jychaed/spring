<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var member = $("#member");
	
	$("#btnRegister").on("click", function() {
		if($("#userId").val() == null || $("#userId").val() == "") {
			alert("아이디를 입력하세요");
			return false;
		}
		if($("#userPw").val() == null || $("#userPw").val() == "") {
			alert("비밀번호를 입력하세요");
			return false;
		}
		if($("#userName").val() == null || $("#userName").val() == "") {
			alert("이름을 입력하세요");
			return false;
		}
		member.submit();
	});
	$("#btnList").on("click", function() {
		location.href="/crud/member/list";
	}); 
})

</script>
<body>
	<h2>REGISTER</h2>
	<form:form modelAttribute="member" action="/crud/member/register" method="post">
		<table>
			<tr>
				<td>userId</td>
				<td><input type="text" id="userId" name="userId"/></td>
			</tr>
			<tr>
				<td>userPw</td>
				<td><input type="text" id="userPw" name="userPw"/></td>
			</tr>
			<tr>
				<td>userName</td>
				<td><input type="text" id="userName" name="userName"/></td>
			</tr>
		</table>
	</form:form>
	<div>
		<button type="submit" id="btnRegister">Register</button>
		<button type="submit" id="btnList">List</button>
	</div>
	
</body>
</html>