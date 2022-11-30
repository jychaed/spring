<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerForm05</title>
</head>
<body>
	<h2>Spring Form</h2>
	<p>5) 컨트롤러 메소드의 매개변수로 자바빈즈 객체가 전달이 되면 기본적으로 다시 화면으로 전달된다.</p>
	<form:form modelAttribute="member" method="post" action="/formtag/register">
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