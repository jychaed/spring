<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm06</title>
</head>
<body>
	<h2>Spring Form</h2>
	<p>6) 폼 객체의 속성명은 직접 지정하지 않으면 폼 객체의 클래스명의 맨 처음 문자를 소문자로 변환하여 처리한다.</p>
	<form:form modelAttribute="member" method="post" action="/formtag/register"> <!-- public String registerForm06(Member user) { 동일! :::Member == modelAttribute="member"!!!! -->
		<table>
			<tr>
				<td>유저ID</td>
				<td>
					<form:input path="userId"/>
					<font color="red">
						<form:errors path="userId"/>
					</font>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<form:input path="userName"/>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
	
</body>
</html>