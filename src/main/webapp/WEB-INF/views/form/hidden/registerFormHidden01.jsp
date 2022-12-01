<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/formtag/hidden</title>
</head>
<body>
	<h2>Spring Form</h2>
	<p>객체를 생성하여 값을 성정한 후 화면에 전달한다.</p>
	<form:form modelAttribute="member" method="post" action="/formtag/hidden/result">
		<form:hidden path="userId"/>
		<table>
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